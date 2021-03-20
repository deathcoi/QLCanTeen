package view;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;


import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class PnThanhToan extends JPanel {

	private CardLayout cardLeft;
	private CardLayout cardRight;
	
	private JPanel pnLeft;
	private JPanel pnRight;
	private JTable table;
	private JTextField txtKhachHang;
	private JTextField txtTienMat;
	/**
	 * Create the panel.
	 */
	public PnThanhToan(CardLayout cardLeft, CardLayout cardRight, JPanel pnLeft, JPanel pnRight) {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		this.cardLeft = cardLeft;
		this.cardRight = cardRight;
		this.pnLeft = pnLeft;
		this.pnRight = pnRight;
		setBackground(Color.WHITE);
		setBounds(0, 0, 400, 600);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 550, 400, 50);
		add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		JPanel pnThanhToanBtn = new JPanel();
		pnThanhToanBtn.setBackground(new Color(153, 0, 0));
		pnThanhToanBtn.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(pnThanhToanBtn);
		pnThanhToanBtn.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Thanh toán");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		pnThanhToanBtn.add(lblNewLabel, BorderLayout.CENTER);
		
		JPanel pnHuyBtn = new JPanel();
		pnHuyBtn.setBackground(new Color(153, 0, 0));
		pnHuyBtn.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(pnHuyBtn);
		pnHuyBtn.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("Hủy");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		pnHuyBtn.add(lblNewLabel_1, BorderLayout.CENTER);
		
		JLabel lblNewLabel_2 = new JLabel("Canteen Hutech");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(130, 10, 149, 33);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("Khu Công Nghệ Cao, Long Mỹ Thạnh, Quận 9, TP.Hồ Chí Minh");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(20, 40, 365, 27);
		add(lblNewLabel_1_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(60, 70, 280, 1);
		add(separator);
		
		JLabel lblNewLabel_10 = new JLabel("Nhân viên:");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_10.setBounds(10, 80, 78, 22);
		add(lblNewLabel_10);
		
		JLabel lbNhanVien = new JLabel("");
		lbNhanVien.setHorizontalAlignment(SwingConstants.CENTER);
		lbNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbNhanVien.setBounds(80, 80, 80, 20);
		add(lbNhanVien);
		
		JLabel lbDateTime = new JLabel("");
		lbDateTime.setHorizontalAlignment(SwingConstants.CENTER);
		lbDateTime.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbDateTime.setBounds(240, 80, 150, 20);
		add(lbDateTime);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBounds(10, 150, 380, 325);
		add(scrollPane);
		
		table = new JTable();
		table.setBackground(Color.WHITE);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_10_1 = new JLabel("Khách hàng:");
		lblNewLabel_10_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_10_1.setBounds(10, 105, 78, 22);
		add(lblNewLabel_10_1);
		
		txtKhachHang = new JTextField();
		txtKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtKhachHang.setBounds(95, 105, 139, 22);
		add(txtKhachHang);
		txtKhachHang.setColumns(10);
		
		JButton btnKiemTra = new JButton("Kiểm tra");
		btnKiemTra.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnKiemTra.setBounds(263, 105, 97, 22);
		add(btnKiemTra);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(60, 140, 280, 1);
		add(separator_2);
		
		JLabel lblNewLabel_10_2 = new JLabel("Tổng cộng");
		lblNewLabel_10_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_10_2.setBounds(120, 480, 78, 22);
		add(lblNewLabel_10_2);
		
		JLabel lblNewLabel_10_2_1 = new JLabel("Tiền mặt:");
		lblNewLabel_10_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_10_2_1.setBounds(120, 500, 89, 22);
		add(lblNewLabel_10_2_1);
		
		JLabel lblNewLabel_10_2_2 = new JLabel("Tiền thừa:");
		lblNewLabel_10_2_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_10_2_2.setBounds(120, 520, 97, 22);
		add(lblNewLabel_10_2_2);
		
		txtTienMat = new JTextField();
		txtTienMat.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTienMat.setColumns(10);
		txtTienMat.setBounds(220, 500, 150, 22);
		add(txtTienMat);
		txtTienMat.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		
		JLabel lbTongCong = new JLabel("");
		lbTongCong.setHorizontalAlignment(SwingConstants.CENTER);
		lbTongCong.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbTongCong.setBounds(220, 480, 150, 22);
		add(lbTongCong);
		
		JLabel lbTienThua = new JLabel("");
		lbTienThua.setHorizontalAlignment(SwingConstants.CENTER);
		lbTienThua.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbTienThua.setBounds(220, 520, 150, 22);
		add(lbTienThua);
	}
	
	private void cardChange() {
		cardLeft.show(pnLeft, "pnMenuKhongChucNang");
		cardRight.show(pnRight, "panel_2");
	}
}
