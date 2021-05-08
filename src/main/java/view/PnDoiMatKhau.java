package view;

import javax.swing.JPanel;
import javax.swing.JTextPane;

import DAO.LoaiMonAnDAO;
import DAO.MonAnDAO;
import DAO.NguyenLieuDAO;
import DAO.TaiKhoanKHDAO;
import entities.LoaiMonAn;
import entities.MonAn;
import entities.NguyenLieu;
import entities.TaiKhoanKH;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PnDoiMatKhau extends JPanel {
	private JTextField txtMKHT;
	private JTextField txtMKM;
	private JTextField txtNLMK;
	
	private JFrame mainFrame;
	private JLabel lbKhachHang;

	public JLabel getLbKhachHang() {
		return lbKhachHang;
	}
	public void setLbKhachHang(JLabel lbKhachHang) {
		this.lbKhachHang = lbKhachHang;
	}
	/**
	 * Create the panel.
	 */
	public PnDoiMatKhau() {
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
		
		txtMKHT = new JTextField();
		txtMKHT.setBounds(230, 240, 176, 25);
		add(txtMKHT);
		txtMKHT.setColumns(10);
		
		txtMKM = new JTextField();
		txtMKM.setColumns(10);
		txtMKM.setBounds(230, 285, 176, 25);
		add(txtMKM);
		
		txtNLMK = new JTextField();
		txtNLMK.setColumns(10);
		txtNLMK.setBounds(230, 330, 176, 25);
		add(txtNLMK);
		
		JButton btnXacNhan = new JButton("Xác nhận");
		btnXacNhan.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnXacNhan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnXacNhanClicked();
			}
		});
		btnXacNhan.setBounds(150, 375, 100, 40);
		add(btnXacNhan);
		
		JButton btnThoat = new JButton("Thoát");
		btnThoat.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnThoat.setBounds(270, 375, 100, 40);
		add(btnThoat);
		
	}
	private void btnXacNhanClicked() {
			try {
				TaiKhoanKH khachhang = TaiKhoanKHDAO.layThongTinTK(txtMKHT.getText());
				if(khachhang == null)
					throw  new Exception("sai mat khau");
				JOptionPane.showMessageDialog(this,"sua thanh cong");
			} catch (Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(this, e.getMessage());
			}
	}
}
