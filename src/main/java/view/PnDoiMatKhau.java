package view;

import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

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
		btnXacNhan.setBounds(234, 252, 117, 49);
		add(btnXacNhan);
		
		JButton btnThoat = new JButton("Thoát");
		btnThoat.setBounds(362, 252, 117, 49);
		add(btnThoat);
		
		
	}
}
