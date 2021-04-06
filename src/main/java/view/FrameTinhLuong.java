package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entities.NhanVien;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class FrameTinhLuong extends JFrame {

	private JPanel contentPane;
	private NhanVien nhanVien;
	private Double time;
	private JTextField textField;

	public FrameTinhLuong(NhanVien nhanVien, Double time) {
		this.nhanVien = nhanVien;
		this.time = time;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lbNhanVien = new JLabel("");
		lbNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(lbNhanVien);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("Số tiền 1 giờ");
		panel_2.add(lblNewLabel);
		
		textField = new JTextField();
		panel_2.add(textField);
		textField.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3);
		
		JButton btnNewButton = new JButton("Tính tiền");
		panel_3.add(btnNewButton);
		
		JButton btnThoat = new JButton("Thoát");
		panel_3.add(btnThoat);
	}

}
