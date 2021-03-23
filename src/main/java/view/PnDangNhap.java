package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Font;
import javax.swing.SwingConstants;

import DAO.NhanVienDAO;
import DAO.TaiKhoanKHDAO;
import DAO.TaiKhoanNVDAO;
import entities.NhanVien;
import entities.TaiKhoanKH;
import entities.TaiKhoanNV;
import main.Main;

import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class PnDangNhap extends JPanel {
	private Main mainFrame;
	
	private JTextField txtTaiKhoan;
	private JPasswordField txtMatKhau;
	private CardLayout cardLayout;
	private JPanel cardPanel;

	/**
	 * Create the panel.
	 */
	public PnDangNhap(CardLayout cardLayout, JPanel cardPanel, Main mainFrame) {
		this.cardLayout = cardLayout;
		this.cardPanel = cardPanel;
		this.mainFrame = mainFrame;

		setBounds(0, 0, 1024, 600);
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);

		JLabel lblNewLabel = new JLabel("QUẢN LÝ CĂN TIN HUTECH");
		lblNewLabel.setForeground(Color.ORANGE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));

		lblNewLabel.setBounds(10, 10, 780, 96);
		panel.add(lblNewLabel);


		JLabel lblNewLabel_1 = new JLabel("Tên đăng nhập");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));

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
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));

		lblNewLabel_1_1.setBounds(58, 313, 159, 39);
		panel.add(lblNewLabel_1_1);

		JButton btnThoat = new JButton("Thoát");
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnThoat.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnDangNhap = new JButton("Đăng nhập");
		btnDangNhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDangNhapClicked();
			}
		});
		btnDangNhap.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(10)
							.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 1004, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addGap(209)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
									.addGap(131)
									.addComponent(btnDangNhap, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnThoat, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE))
								.addGroup(Alignment.LEADING, gl_panel.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_panel.createSequentialGroup()
										.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(txtTaiKhoan, GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE))
									.addGroup(gl_panel.createSequentialGroup()
										.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(txtMatKhau, GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE))))
							.addGap(245)))
					.addGap(10))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(10)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
					.addGap(66)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtTaiKhoan, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
					.addGap(49)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtMatKhau, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
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
			String pass = new String(txtMatKhau.getPassword());
			if (txtTaiKhoan.getText().compareTo("") == 0 || pass.compareTo("") == 0)
				throw new Exception("Vui lòng nhập đầy đủ thông tin");
			TaiKhoanNV taiKhoanNV = TaiKhoanNVDAO.layThongTinTK(txtTaiKhoan.getText());
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
					//mainFrame.pnQuanLy.setNhanVien(taiKhoanNV.getNhanVien());
					JLabel lbNhanVienQuanLy = mainFrame.pnQuanLy.getLbNhanVien();
					lbNhanVienQuanLy.setText(taiKhoanNV.getNhanVien().getTenNV());
					
					PnThanhToan pnThanhToan = mainFrame.pnQuanLy.getPnThanhToan();
					JLabel lbNhanVienThanhToan = pnThanhToan.getLbNhanVien();
					lbNhanVienThanhToan.setText(taiKhoanNV.getNhanVien().getTenNV());
				}
				else {
					cardLayout.show(cardPanel, "pnNhanVien");
					JOptionPane.showMessageDialog(this, "Đăng nhập thành công, chào " + taiKhoanNV.getNhanVien().getTenNV());
					mainFrame.pnNhanVien.setNhanVien(taiKhoanNV.getNhanVien());
					JLabel lbNhanVien = mainFrame.pnNhanVien.getLbNhanVien();
					lbNhanVien.setText(taiKhoanNV.getNhanVien().getTenNV());
					
					PnThanhToan pnThanhToan = mainFrame.pnNhanVien.getPnThanhToan();
					JLabel lbNhanVienThanhToan = pnThanhToan.getLbNhanVien();
					lbNhanVienThanhToan.setText(taiKhoanNV.getNhanVien().getTenNV());
				}
			} else {
				if (pass.compareTo(taiKhoanKH.getMatKhau()) != 0)
					throw new Exception("Sai mật khẩu");
				else {
					cardLayout.show(cardPanel, "pnKhachHang");
					JOptionPane.showMessageDialog(this, "Đăng nhập thành công, chào " + taiKhoanKH.getKhachHang().getTenKH());
				}	
			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, e.getMessage());
		}

	}
}
