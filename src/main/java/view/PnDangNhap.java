package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Font;
import javax.swing.SwingConstants;

import DAO.TaiKhoanKHDAO;
import DAO.TaiKhoanNVDAO;
import entities.TaiKhoanKH;
import entities.TaiKhoanNV;

import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PnDangNhap extends JPanel {
	private JTextField txtTaiKhoan;
	private JPasswordField txtMatKhau;
	private CardLayout cardLayout;
	private JPanel cardPanel;

	/**
	 * Create the panel.
	 */
	public PnDangNhap(CardLayout cardLayout, JPanel cardPanel) {
		this.cardLayout = cardLayout;
		this.cardPanel = cardPanel;

		setBounds(0, 0, 800, 600);
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("QUẢN LÝ CĂN TIN HUTECH");
		lblNewLabel.setForeground(Color.ORANGE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(10, 10, 780, 96);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Tên đăng nhập");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(58, 225, 159, 39);
		panel.add(lblNewLabel_1);

		txtTaiKhoan = new JTextField();
		txtTaiKhoan.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER)
					btnDangNhapClicked();
			}
		});
		txtTaiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtTaiKhoan.setBounds(227, 225, 383, 39);
		panel.add(txtTaiKhoan);
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
		txtMatKhau.setBounds(227, 316, 383, 39);
		panel.add(txtMatKhau);

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
		btnThoat.setBounds(434, 439, 164, 45);
		panel.add(btnThoat);

		JButton btnDangNhap = new JButton("Đăng nhập");
		btnDangNhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDangNhapClicked();
			}
		});
		btnDangNhap.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnDangNhap.setBounds(231, 439, 164, 45);
		panel.add(btnDangNhap);
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
				if (txtTaiKhoan.getText().compareTo("admin") == 0) {
					JOptionPane.showMessageDialog(this, "Đăng nhập thành công, chào " + taiKhoanNV.getNhanVien().getTenNV());
					cardLayout.show(cardPanel, "pnQuanLy");
				}
				else {
					cardLayout.show(cardPanel, "pnNhanVien");
					JOptionPane.showMessageDialog(this, "Đăng nhập thành công, chào " + taiKhoanNV.getNhanVien().getTenNV());
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
