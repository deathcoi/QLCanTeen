package view;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import DAO.TaiKhoanKHDAO;
import DAO.TaiKhoanNVDAO;
import entities.KhachHang;
import entities.NhanVien;
import entities.TaiKhoanKH;
import entities.TaiKhoanNV;

public class PnDoiMatKhau extends JPanel {
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private JFrame mainFrame;
	private JLabel lbKhachHang;
	private  Object user;
	private JPasswordField txtMKHT;
	private JPasswordField txtMKM;
	private JPasswordField txtMKNL;

	public JLabel getLbKhachHang() {
		return lbKhachHang;
	}
	public void setLbKhachHang(JLabel lbKhachHang) {
		this.lbKhachHang = lbKhachHang;
	}
	
	
	public Object getUser() {
		return user;
	}
	public void setUser(Object user) {
		this.user = user;
	}
	/**
	 * Create the panel.
	 */
	public PnDoiMatKhau(Object user) {
		
		this.user = user;
		
		
		setBounds(0, 0, 560, 600);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Đổi mật khẩu");
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 25));
		lblNewLabel.setBounds(200, 180, 170, 40);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mật khẩu hiện tại :");
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(80, 240, 130, 25);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Mật khẩu mới :");
		lblNewLabel_1_1.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(80, 285, 130, 25);
		add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Nhập lại mật khẩu :");
		lblNewLabel_1_2.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(80, 330, 140, 25);
		add(lblNewLabel_1_2);
		
		JButton btnXacNhan = new JButton("Xác nhận");
		btnXacNhan.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnXacNhan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnXacNhanClicked();
			}
		});
		btnXacNhan.setBounds(270, 376, 100, 40);
		add(btnXacNhan);
		
		txtMKHT = new JPasswordField();
		txtMKHT.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMKHT.setBounds(210, 240, 162, 25);
		add(txtMKHT);
		
		txtMKM = new JPasswordField();
		txtMKM.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMKM.setBounds(210, 285, 162, 25);
		add(txtMKM);
		
		txtMKNL = new JPasswordField();
		txtMKNL.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMKNL.setBounds(210, 330, 162, 25);
		add(txtMKNL);
		
	}
	private void btnXacNhanClicked() {
			try {
				if(txtMKHT.getPassword().length == 0 || txtMKM.getPassword().length == 0 || txtMKNL.getPassword().length == 0)
					throw  new Exception("Không để ô trống!!!");
				if(user instanceof KhachHang) {
					KhachHang kh = (KhachHang) user;
					TaiKhoanKH khachHang = TaiKhoanKHDAO.layThongTinTK(kh.getMaKH());
					String pass = new String(txtMKHT.getPassword());
					String passM = new String(txtMKM.getPassword());
					String passNL = new String(txtMKNL.getPassword());
					if(pass.compareTo(khachHang.getMatKhau()) == 0) {
						if(passM.compareTo(pass) == 0)
							throw new Exception("Không nhập trùng mật khẩu cũ!!!");
						else
							if(passNL.compareTo(passM) != 0)
								throw new Exception("Mật khẩu nhập lại không trùng khớp!!!");
							else
							{
								khachHang.setMatKhau(passM);
								TaiKhoanKHDAO.DoiMatKhau(khachHang);
							}
					}
					else
						throw  new Exception("Sai mật khẩu!!!");
				}
				else {
					NhanVien nv = (NhanVien) user;
					TaiKhoanNV nhanVien = TaiKhoanNVDAO.layThongTinTK(nv.getMaNV());
					String pass = new String(txtMKHT.getPassword());
					String passM = new String(txtMKM.getPassword());
					String passNL = new String(txtMKNL.getPassword());
					if(pass.compareTo(nhanVien.getMatKhau()) == 0) {
						if(passM.compareTo(pass) == 0)
							throw new Exception("Không nhập trùng mật khẩu cũ!!!");
						else
							if(passNL.compareTo(passM) != 0)
								throw new Exception("Mật khẩu nhập lại không trùng khớp!!!");
							else
							{
								nhanVien.setMatKhau(passM);
								TaiKhoanNVDAO.DoiMatKhau(nhanVien);
							}
					}
					else
						throw  new Exception("Sai mật khẩu!!!");
				}
					
				JOptionPane.showMessageDialog(this,"Sửa thành công");
			} catch (Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(this, e.getMessage());
			}
	}
	
}
