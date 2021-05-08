package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import DAO.TaiKhoanKHDAO;
import entities.TaiKhoanKH;

public class PnDoiMatKhau extends JPanel {
	private JTextField txtMKHT;
	private JTextField txtMKM;
	private JTextField txtNLMK;

	/**
	 * Create the panel.
	 */
	public PnDoiMatKhau() {
		setBounds(0, 0, 560, 450);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Đổi mật khẩu");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
		lblNewLabel.setBounds(234, 57, 176, 37);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mật khẩu hiện tại :");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(57, 110, 146, 16);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Mật khẩu mới :");
		lblNewLabel_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(57, 159, 146, 16);
		add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Nhập lại mật khẩu :");
		lblNewLabel_1_2.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(57, 203, 211, 16);
		add(lblNewLabel_1_2);
		
		txtMKHT = new JTextField();
		txtMKHT.setBounds(234, 106, 176, 26);
		add(txtMKHT);
		txtMKHT.setColumns(10);
		
		txtMKM = new JTextField();
		txtMKM.setColumns(10);
		txtMKM.setBounds(234, 155, 176, 26);
		add(txtMKM);
		
		txtNLMK = new JTextField();
		txtNLMK.setColumns(10);
		txtNLMK.setBounds(234, 199, 176, 26);
		add(txtNLMK);
		
		JButton btnXacNhan = new JButton("Xác nhận");
		btnXacNhan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnXacNhanClicked();
			}
		});
		btnXacNhan.setBounds(234, 252, 117, 49);
		add(btnXacNhan);
		
		JButton btnThoat = new JButton("Thoát");
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnThoat.setBounds(362, 252, 117, 49);
		add(btnThoat);
		
	}
	private void btnXacNhanClicked() {
		
			try {
				TaiKhoanKH khachhang = TaiKhoanKHDAO.layThongTinTK(txtMKHT.getText());
				if(khachhang == null)
					throw  new Exception(" sai mat khau");
				JOptionPane.showMessageDialog(this,"sua thanh cong");
			
			} catch (Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(this, e.getMessage());
			}
	}
}
