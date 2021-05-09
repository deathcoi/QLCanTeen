package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import com.fasterxml.jackson.databind.ObjectMapper;

import DAO.TaiKhoanKHDAO;
import constant.HttpConstant;
import entities.TaiKhoanKH;
import entities.TaiKhoanNV;
import main.Main;
import service.IpushMethodService;
import service.impl.PushMethodService;

public class PnDangNhap extends JPanel {
	private static final long serialVersionUID = 1L;

	private Main mainFrame;
	
	private JTextField txtTaiKhoan;
	private JPasswordField txtMatKhau;
	private CardLayout cardLayout;
	private JPanel cardPanel;
	
	private Image image;
	private Image scaledImage;
	/**
	 * Create the panel.
	 */
	public PnDangNhap(CardLayout cardLayout, JPanel cardPanel, Main mainFrame) {
		this.cardLayout = cardLayout;
		this.cardPanel = cardPanel;
		this.mainFrame = mainFrame;

		setBounds(0, 0, 1024, 600);
		
		
		try {
			image = ImageIO.read(new File("picture/main.png"));
			scaledImage = image.getScaledInstance(this.getWidth(),this.getHeight(),Image.SCALE_SMOOTH);
		} catch (IOException e) {
			e.printStackTrace();
		}
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setOpaque(false);
		add(panel, BorderLayout.EAST);

		JLabel lblNewLabel = new JLabel("QUẢN LÝ CĂN TIN HUTECH");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));

		lblNewLabel.setBounds(10, 10, 780, 96);
		panel.add(lblNewLabel);


		JLabel lblNewLabel_1 = new JLabel("Tên đăng nhập");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));

		txtTaiKhoan = new JTextField();
		txtTaiKhoan.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER)
					btnDangNhapClicked();
			}
		});
		txtTaiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtTaiKhoan.setColumns(10);

		txtMatKhau = new JPasswordField();
		txtMatKhau.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER)
					btnDangNhapClicked();
			}
		});
		txtMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JLabel lblNewLabel_1_1 = new JLabel("Mật khẩu");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));

		lblNewLabel_1_1.setBounds(58, 313, 159, 39);
		panel.add(lblNewLabel_1_1);

		JButton btnThoat = new JButton("Thoát");
		btnThoat.setOpaque(false);
		btnThoat.setContentAreaFilled(false);
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnThoat.setFont(new Font("Tahoma", Font.BOLD, 18));

		JButton btnDangNhap = new JButton("Đăng nhập");
		btnDangNhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDangNhapClicked();
			}
		});
		btnDangNhap.setOpaque(false);
		btnDangNhap.setContentAreaFilled(false);
		btnDangNhap.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel lblNewLabel_2 = new JLabel("Đăng nhập");
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 25));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(209)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(45)
									.addComponent(btnDangNhap, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
									.addGap(56)
									.addComponent(btnThoat, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
									.addGroup(gl_panel.createSequentialGroup()
										.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(txtMatKhau))
									.addGroup(gl_panel.createSequentialGroup()
										.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(txtTaiKhoan, GroupLayout.PREFERRED_SIZE, 292, GroupLayout.PREFERRED_SIZE))))
							.addGap(336))
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 1004, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(468)
							.addComponent(lblNewLabel_2)))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_2)
					.addGap(56)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtTaiKhoan, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
					.addGap(49)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtMatKhau, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
					.addGap(91)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnDangNhap, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnThoat, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(165, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
	}

	private void btnDangNhapClicked() {
		try {
			ObjectMapper mapper = new ObjectMapper();
			IpushMethodService service = new PushMethodService();
			
			
			String pass = new String(txtMatKhau.getPassword());
			if (txtTaiKhoan.getText().compareTo("") == 0 || pass.compareTo("") == 0)
				throw new Exception("Vui lòng nhập đầy đủ thông tin");
			
			String httpStringNV = "http://localhost:8080/APISpring/api/taikhoannv/" + txtTaiKhoan.getText();
			TaiKhoanNV taiKhoanNV = null;
				try {
					taiKhoanNV = mapper.readValue(service.pushMethod(HttpConstant.HTTPREQUESTGET, httpStringNV, txtTaiKhoan.getText()), TaiKhoanNV.class);
				} catch (Exception e) {
					taiKhoanNV = null;
				}	
			TaiKhoanKH taiKhoanKH = TaiKhoanKHDAO.layThongTinTK(txtTaiKhoan.getText());
			
			
			if (taiKhoanNV == null && taiKhoanKH == null)
				throw new Exception("Tài khoản không tồn tại");
			if (taiKhoanNV != null) {
				if (pass.compareTo(taiKhoanNV.getMatKhau()) != 0)
					throw new Exception("Sai mật khẩu");
				//NhanVien nhanVien = NhanVienDAO.layThongTinNhanVien(taiKhoanNV.getNhanVien().getMaNV());
				if (txtTaiKhoan.getText().compareTo("admin") == 0) {
					JOptionPane.showMessageDialog(this, "Đăng nhập thành công, chào " + taiKhoanNV.getNhanVien().getTenNV());
					cardLayout.show(cardPanel, "pnQuanLy");
					
					mainFrame.pnQuanLy.setNhanVien(taiKhoanNV.getNhanVien()); //set nhan vien
					//JOptionPane.showMessageDialog(this, taiKhoanNV.getNhanVien().getTenNV()); 
	
					JLabel lbNhanVienQuanLy = mainFrame.pnQuanLy.getLbNhanVien(); // set label
					lbNhanVienQuanLy.setText(taiKhoanNV.getNhanVien().getTenNV());
					
					PnThanhToan pnThanhToan = mainFrame.pnQuanLy.getPnThanhToan();
					JLabel lbNhanVienThanhToan = pnThanhToan.getLbNhanVien();
					lbNhanVienThanhToan.setText(taiKhoanNV.getNhanVien().getTenNV()); //set label
					
					//set nhan vien cho thanh toan
					PnThanhToan thanhToan = mainFrame.pnQuanLy.getPnThanhToan();
					thanhToan.setNhanVien(taiKhoanNV.getNhanVien());
				}
				else {
					JOptionPane.showMessageDialog(this, "Đăng nhập thành công, chào " + taiKhoanNV.getNhanVien().getTenNV());
					cardLayout.show(cardPanel, "pnNhanVien");
					mainFrame.pnNhanVien.setNhanVien(taiKhoanNV.getNhanVien());
					//JOptionPane.showMessageDialog(this, taiKhoanNV.getNhanVien().getTenNV());
					
					JLabel lbNhanVien = mainFrame.pnNhanVien.getLbNhanVien();
					lbNhanVien.setText(taiKhoanNV.getNhanVien().getTenNV());
					
					PnThanhToan pnThanhToan = mainFrame.pnNhanVien.getPnThanhToan();
					JLabel lbNhanVienThanhToan = pnThanhToan.getLbNhanVien();
					lbNhanVienThanhToan.setText(taiKhoanNV.getNhanVien().getTenNV());
					
					//set nhan vien cho thanh toan
					PnThanhToan thanhToan = mainFrame.pnNhanVien.getPnThanhToan();
					thanhToan.setNhanVien(taiKhoanNV.getNhanVien());
				}
			} else {
				if (pass.compareTo(taiKhoanKH.getMatKhau()) != 0)
					throw new Exception("Sai mật khẩu");
				else {
					JOptionPane.showMessageDialog(this, "Đăng nhập thành công, chào " + taiKhoanKH.getKhachHang().getTenKH());
					cardLayout.show(cardPanel, "pnKhachHang");
					mainFrame.pnKhachHang.setKhachHang(taiKhoanKH.getKhachHang());
					
					JLabel lbKhachHang = mainFrame.pnKhachHang.getLbKhachHang();
					lbKhachHang.setText("Xin chào " + taiKhoanKH.getKhachHang().getTenKH());
				}	
			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, e.getMessage());
		}finally {
			txtTaiKhoan.setText("");
			txtMatKhau.setText("");
		}
	}
	 protected void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        g.drawImage(scaledImage, 0, 0, this); // see javadoc for more info on the parameters            
	 }
}
