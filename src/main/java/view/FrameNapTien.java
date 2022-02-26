package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import DAO.KhachHangDAO;
import constant.HttpConstant;
import entities.KhachHang;
import service.IpushMethodService;
import service.impl.PushMethodService;

public class FrameNapTien extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtMaThe;
	private JTextField txtSoTien;
	private KhachHang khachHang;
	@SuppressWarnings("rawtypes")
	private JComboBox cmbLoaiThe;
	@SuppressWarnings("rawtypes")
	private JComboBox cmbNganHangThuHuong;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public FrameNapTien(KhachHang khachHang) {
		this.khachHang = khachHang;
		setBackground(new Color(30, 144, 255));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 670, 464);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(new Color(51, 204, 204));
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("1.Nạp tiền qua thẻ cào");
		lblNewLabel.setForeground(Color.YELLOW);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 10, 200, 25);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Loại thẻ :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(10, 76, 100, 25);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Mã thẻ :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(10, 116, 100, 25);
		panel.add(lblNewLabel_2);

		String LoaiThe[] = { "Viettel", "Mobifone", "Vinaphone" };
		cmbLoaiThe = new JComboBox(LoaiThe);
		cmbLoaiThe.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cmbLoaiThe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				indexchange();
			}
		});
		cmbLoaiThe.setBounds(195, 76, 250, 25);
		panel.add(cmbLoaiThe);

		txtMaThe = new JTextField();
		txtMaThe.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMaThe.setBounds(195, 116, 250, 25);
		panel.add(txtMaThe);
		txtMaThe.setColumns(10);

		JButton btnNapThe = new JButton("Nạp thẻ");
		btnNapThe.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNapThe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNapTheClicked();
			}
		});
		btnNapThe.setBounds(480, 80, 117, 57);
		panel.add(btnNapThe);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBackground(new Color(51, 204, 204));
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_4 = new JLabel("2.Nạp tiền qua ATM/InternetBanking");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_4.setForeground(Color.YELLOW);
		lblNewLabel_4.setBounds(10, 10, 320, 25);
		panel_1.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Số tiền :");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_5.setBounds(10, 120, 100, 25);
		panel_1.add(lblNewLabel_5);

		txtSoTien = new JTextField();
		txtSoTien.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSoTien.setBounds(195, 120, 255, 25);
		panel_1.add(txtSoTien);
		txtSoTien.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("Ngân hàng thụ hưởng:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_6.setBounds(10, 80, 190, 25);
		panel_1.add(lblNewLabel_6);

		String NganHang[] = { "VietComBank", "AgriBank", "CB Bank", "VietinBank", "BIDV" };
		cmbNganHangThuHuong = new JComboBox(NganHang);
		cmbNganHangThuHuong.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cmbNganHangThuHuong.setBounds(195, 80, 255, 25);
		panel_1.add(cmbNganHangThuHuong);

		JButton btnNapTien = new JButton("Nạp tiền");
		btnNapTien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNapTienClicked();

			}
		});
		btnNapTien.setBounds(480, 50, 117, 57);
		panel_1.add(btnNapTien);

		JButton btnThoat = new JButton("Thoát");
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnThoatClicked();
			}
		});
		btnThoat.setBounds(480, 130, 117, 57);
		panel_1.add(btnThoat);
	}

	private void btnNapTienClicked() {
		try {
			IpushMethodService service = new PushMethodService();

			if (!isNumber(txtSoTien))
				throw new Exception("Vui long nhap so tien");
			Long tien = khachHang.getTien();
			tien += Long.parseLong(txtSoTien.getText());
			khachHang.setTien(tien);

			KhachHangDAO.suaKhachHang(khachHang);

			JOptionPane.showMessageDialog(this, "So tien hien tai: " + tien);
			cmbLoaiThe.setSelectedIndex(0);
			txtMaThe.setText("");
			cmbNganHangThuHuong.setSelectedIndex(0);
			txtSoTien.setText("");
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}

	@SuppressWarnings("unused")
	private boolean isNumber(JTextField txt) {
		try {
			Double d = Double.parseDouble(txt.getText());
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	private void btnThoatClicked() {
		dispose();
	}

	@SuppressWarnings("rawtypes")
	private void btnNapTheClicked() {
		IpushMethodService service = new PushMethodService();
		cmbLoaiThe = new JComboBox();
		try {

			if (txtMaThe.getText().isBlank() == true || txtMaThe.getText().isBlank() == true)
				throw new Exception("Vui long` nhap  du  thong  tin");
			Long tien = khachHang.getTien();
			if (txtMaThe.getText().toLowerCase().contains("vt") == true) {
				// viettel
				if (txtMaThe.getText().length() == 10) // 10k
				{
					tien += 10000;
				} else if (txtMaThe.getText().length() == 11) {
					tien += 20000;
				} else if (txtMaThe.getText().length() == 12) {
					tien += 50000;
				} else if (txtMaThe.getText().length() == 13) {
					tien += 100000;
				} else if (txtMaThe.getText().length() == 14) {
					tien += 200000;
				} else if (txtMaThe.getText().toLowerCase().contains("mb") == true) {
					// mobile
					if (txtMaThe.getText().length() == 10) // 10k
					{
						tien += 10000;
					} else if (txtMaThe.getText().length() == 11) {
						tien += 20000;
					} else if (txtMaThe.getText().length() == 12) {
						tien += 50000;
					} else if (txtMaThe.getText().length() == 13) {
						tien += 100000;
					} else if (txtMaThe.getText().length() == 14) {
						tien += 200000;
					}
				} else if (txtMaThe.getText().toLowerCase().contains("vn") == true) {
					// viettel
					if (txtMaThe.getText().length() == 10) {
						tien += 10000;
					} else if (txtMaThe.getText().length() == 11) {
						tien += 20000;
					} else if (txtMaThe.getText().length() == 12) {
						tien += 50000;
					} else if (txtMaThe.getText().length() == 13) {
						tien += 100000;
					} else if (txtMaThe.getText().length() == 14) {
						tien += 200000;
					}
				}
				khachHang.setTien(tien);
				KhachHangDAO.suaKhachHang(khachHang);
				JOptionPane.showMessageDialog(this, "So tien hien tai: " + tien);
			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}

	void indexchange() {
		if (cmbLoaiThe.getSelectedIndex() == 0)
			txtMaThe.setText("vt");
		if (cmbLoaiThe.getSelectedIndex() == 1)
			txtMaThe.setText("mb");
		if (cmbLoaiThe.getSelectedIndex() == 2)
			txtMaThe.setText("vn");
	}
}
