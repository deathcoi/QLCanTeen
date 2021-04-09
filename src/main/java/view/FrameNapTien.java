package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.KhachHangDAO;
import entities.KhachHang;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrameNapTien extends JFrame {

	private JPanel contentPane;
	private JTextField txtMaThe;
	private JTextField txtSoTien;
	private KhachHang khachHang;
	private JComboBox cmbLoaiThe;

	/**
	 * Create the frame.
	 */
	/**
	 * 
	 */
	public FrameNapTien(KhachHang khachHang) {
		this.khachHang = khachHang;
		setBackground(new Color(30, 144, 255));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 670, 464);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(135, 206, 250));
		panel.setBounds(50, 29, 562, 158);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("1.Nạp tiền qua thẻ cào");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.ITALIC, 15));
		lblNewLabel.setBounds(6, 6, 181, 16);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Loại thẻ :");
		lblNewLabel_1.setBounds(6, 29, 61, 16);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Mã thẻ :");
		lblNewLabel_2.setBounds(6, 86, 61, 16);
		panel.add(lblNewLabel_2);

		String LoaiThe[] = {" ", "Viettel", "Mobifone", "Vinaphone" };
		cmbLoaiThe = new JComboBox(LoaiThe);
		cmbLoaiThe.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		        indexchange();
		    }
		});
		cmbLoaiThe.setBounds(79, 25, 232, 27);
		panel.add(cmbLoaiThe);

		txtMaThe = new JTextField();
		txtMaThe.setBounds(81, 81, 269, 26);
		panel.add(txtMaThe);
		txtMaThe.setColumns(10);

		JButton btnNapThe = new JButton("Nạp thẻ");
		btnNapThe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNapTheClicked();
			}
		});
		btnNapThe.setBounds(400, 67, 117, 57);
		panel.add(btnNapThe);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(135, 206, 250));
		panel_1.setBounds(50, 207, 562, 193);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_4 = new JLabel("2.Nạp tiền qua ATM/InternetBanking");
		lblNewLabel_4.setFont(new Font("Lucida Grande", Font.ITALIC, 15));
		lblNewLabel_4.setForeground(Color.RED);
		lblNewLabel_4.setBounds(6, 6, 321, 16);
		panel_1.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Số tiền :");
		lblNewLabel_5.setBounds(6, 37, 61, 16);
		panel_1.add(lblNewLabel_5);

		txtSoTien = new JTextField();
		txtSoTien.setBounds(160, 34, 255, 26);
		panel_1.add(txtSoTien);
		txtSoTien.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("Ngân hàng thụ hưởng:");
		lblNewLabel_6.setBounds(6, 81, 168, 16);
		panel_1.add(lblNewLabel_6);

		String NganHang[] = { "VietComBank", "AriBank", "CB Bank", "VietinBank", "BIDV" };
		JComboBox cmbNganHangThuHuong = new JComboBox(NganHang);
		cmbNganHangThuHuong.setBounds(160, 72, 255, 27);
		panel_1.add(cmbNganHangThuHuong);

		JButton btnNapTien = new JButton("Nạp tiền");
		btnNapTien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNapTienClicked();

			}
		});
		btnNapTien.setBounds(226, 130, 117, 57);
		panel_1.add(btnNapTien);

		JButton btnThoat = new JButton("Thoát");
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnThoatClicked();
			}
		});
		btnThoat.setBounds(389, 130, 117, 57);
		panel_1.add(btnThoat);
	}

	private void btnNapTienClicked() {
		try {
			if (!isNumber(txtSoTien))
				throw new Exception("Vui long nhap so tien");
			Long tien = khachHang.getTien();
			tien += Long.parseLong(txtSoTien.getText());
			khachHang.setTien(tien);
			KhachHangDAO.suaKhachHang(khachHang);
			JOptionPane.showMessageDialog(this, "So tien hien tai: " + tien);
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}

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

	private void btnNapTheClicked() {
		JComboBox cmbLoaiThe = new JComboBox();
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
	
	void indexchange(){
		if(cmbLoaiThe.getSelectedIndex() != - 1) {
			if(cmbLoaiThe.getSelectedIndex()== 1)
				txtMaThe.setText("vt");
			if(cmbLoaiThe.getSelectedIndex()== 2)
				txtMaThe.setText("mb");
			if(cmbLoaiThe.getSelectedIndex()== 3)
				txtMaThe.setText("vn");
		}
	}
}
