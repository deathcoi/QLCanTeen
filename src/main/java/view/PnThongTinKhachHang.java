package view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class PnThongTinKhachHang extends JPanel {
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Create the panel.
	 */
	public PnThongTinKhachHang() {
		setBounds(0, 0, 560, 500);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 560, 260);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Loại khách:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 10, 80, 20);
		panel.add(lblNewLabel);
		
		JRadioButton rdBtnGiangVien = new JRadioButton("Giảng Viên");
		rdBtnGiangVien.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdBtnGiangVien.setBounds(249, 10, 109, 20);
		panel.add(rdBtnGiangVien);
		
		JRadioButton rdBtnSinhVien = new JRadioButton("Sinh Viên");
		rdBtnSinhVien.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdBtnSinhVien.setBounds(120, 10, 109, 20);
		panel.add(rdBtnSinhVien);
		
		JLabel lblMKh = new JLabel("Mã KH:");
		lblMKh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMKh.setBounds(10, 50, 80, 20);
		panel.add(lblMKh);
		
		JLabel lblTnKh = new JLabel("Tên KH:");
		lblTnKh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTnKh.setBounds(10, 90, 80, 20);
		panel.add(lblTnKh);
		
		JLabel lblSinThoi = new JLabel("Số điện thoại:");
		lblSinThoi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSinThoi.setBounds(10, 210, 100, 20);
		panel.add(lblSinThoi);
		
		JLabel lblNgySinh = new JLabel("Năm sinh:");
		lblNgySinh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNgySinh.setBounds(10, 170, 80, 20);
		panel.add(lblNgySinh);
		
		JRadioButton rbBtnNVVP = new JRadioButton("Nhân viên văn phòng");
		rbBtnNVVP.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rbBtnNVVP.setBounds(374, 10, 180, 20);
		panel.add(rbBtnNVVP);
		
		JLabel lblNewLabel_1_1 = new JLabel("Giới tính:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(10, 130, 80, 20);
		panel.add(lblNewLabel_1_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setBounds(120, 50, 109, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_1.setColumns(10);
		textField_1.setBounds(120, 90, 300, 20);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_2.setColumns(10);
		textField_2.setBounds(120, 170, 109, 20);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_3.setColumns(10);
		textField_3.setBounds(120, 210, 109, 20);
		panel.add(textField_3);
		
		JRadioButton rdBtnNam = new JRadioButton("Nam");
		rdBtnNam.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdBtnNam.setBounds(120, 130, 109, 20);
		panel.add(rdBtnNam);
		
		JRadioButton rdBtnNu = new JRadioButton("Nữ");
		rdBtnNu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdBtnNu.setBounds(249, 130, 109, 20);
		panel.add(rdBtnNu);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 260, 560, 200);
		add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_1 = new JLabel("Tìm thấy:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblNewLabel_1.setBounds(410, 470, 66, 20);
		add(lblNewLabel_1);
		
		textField_4 = new JTextField();
		textField_4.setBounds(478, 470, 50, 20);
		add(textField_4);
		textField_4.setColumns(10);
	}
}
