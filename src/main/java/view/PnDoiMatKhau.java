package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import com.fasterxml.jackson.databind.ObjectMapper;

import DAO.TaiKhoanKHDAO;
import constant.HttpConstant;
import entities.KhachHang;
import entities.NhanVien;
import entities.TaiKhoanKH;
import entities.TaiKhoanNV;
import service.IpushMethodService;
import service.impl.PushMethodService;


public class PnDoiMatKhau extends JPanel {
	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("unused")
	private JFrame mainFrame;
	private JLabel lbKhachHang;
	private  Object user;
	private JPasswordField txtMKHT;
	private JPasswordField txtMKM;
	private JPasswordField txtMKNL;
	
	private Image image;
	private Image scaledImage;
	
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
		try {
			image = ImageIO.read(new File("picture/main.png"));
			scaledImage = image.getScaledInstance(this.getWidth(),this.getHeight(),Image.SCALE_SMOOTH);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		JLabel lblNewLabel = new JLabel("Đổi mật khẩu");
		lblNewLabel.setForeground(Color.YELLOW);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(170, 95, 200, 40);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mật khẩu hiện tại :");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(44, 240, 169, 25);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Mật khẩu mới :");
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(44, 285, 169, 25);
		add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Nhập lại mật khẩu :");
		lblNewLabel_1_2.setForeground(Color.BLACK);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_2.setBounds(44, 330, 169, 25);
		add(lblNewLabel_1_2);
		
		JButton btnXacNhan = new JButton("Xác nhận");
		btnXacNhan.setContentAreaFilled(false);
		btnXacNhan.setIcon(new ImageIcon("picture\\accept.png"));
		btnXacNhan.setForeground(Color.BLACK);
		btnXacNhan.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnXacNhan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnXacNhanClicked();
			}
		});
		btnXacNhan.setBounds(411, 277, 139, 40);
		add(btnXacNhan);
		
		
		txtMKHT = new JPasswordField();
		txtMKHT.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMKHT.setBounds(218, 240, 184, 25);
		add(txtMKHT);
		
		txtMKM = new JPasswordField();
		txtMKM.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMKM.setBounds(218, 285, 184, 25);
		add(txtMKM);
		
		txtMKNL = new JPasswordField();
		txtMKNL.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMKNL.setBounds(218, 330, 184, 25);
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
					
					ObjectMapper mapper = new ObjectMapper();
					IpushMethodService method = new PushMethodService();
					
					NhanVien nv = (NhanVien) user;
					
					String httpStringNV = "http://localhost:8080/APISpring/api/taikhoannv/" + nv.getMaNV();
					TaiKhoanNV taiKhoanNV = mapper.readValue(
							method.pushMethod(HttpConstant.HTTPREQUESTGET, httpStringNV, nv.getMaNV()),
							TaiKhoanNV.class);
					String pass = new String(txtMKHT.getPassword());
					String passM = new String(txtMKM.getPassword());
					String passNL = new String(txtMKNL.getPassword());
					if(pass.compareTo(taiKhoanNV.getMatKhau()) == 0) {
						if(passM.compareTo(pass) == 0)
							throw new Exception("Không nhập trùng mật khẩu cũ!!!");
						else
							if(passNL.compareTo(passM) != 0)
								throw new Exception("Mật khẩu nhập lại không trùng khớp!!!");
							else
							{
								taiKhoanNV.setMatKhau(passM);
								method.pushMethod(HttpConstant.HTTPREQUESTPUT, "http://localhost:8080/APISpring/api/taikhoannv", taiKhoanNV);
							}
					}
					else
						throw  new Exception("Sai mật khẩu!!!");
				}
					
				JOptionPane.showMessageDialog(this,"Sửa thành công");
				txtMKHT.setText("");
				txtMKM.setText("");
				txtMKNL.setText("");
			} catch (Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(this, e.getMessage());
			}
	}
	
	 protected void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        g.drawImage(scaledImage, 0, 0, this);       
	 }
}
