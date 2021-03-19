package view;

import javax.swing.JPanel;

import java.awt.CardLayout;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import java.awt.Font;
import javax.swing.JTree;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import java.awt.Color;
import javax.swing.JDesktopPane;
import javax.swing.BoxLayout;
import javax.swing.UIManager;
import java.awt.Component;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JSeparator;
import javax.swing.JProgressBar;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.ImageIcon;
import java.awt.Dimension;

public class PnQuanLy extends JPanel {

	/**
	 * Create the panel.
	 */
	private CardLayout cardLayout;
	private JPanel cardPanel;
	private JTextField txtTimKiem;
	public PnQuanLy(CardLayout cardLayout, JPanel cardPanel) {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		this.cardLayout = cardLayout;
		this.cardPanel = cardPanel;
		
		setBounds(0, 0, 1024, 600);
		setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(64, 0, 560, 100);
		add(panel_1);
		panel_1.setLayout(null);
		
		txtTimKiem = new JTextField();
		txtTimKiem.setBackground(new Color(255, 255, 204));
		txtTimKiem.setBounds(10, 60, 540, 30);
		panel_1.add(txtTimKiem);
		txtTimKiem.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(624, 0, 400, 600);
		add(panel_2);
		panel_2.setLayout(null);
		
		panel_2.add(null, new Jpanel_MouseClicked());
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel_4.setForeground(Color.WHITE);
		panel_4.setBounds(10, 10, 380, 90);
		panel_2.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Canteen Hutech");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(130, 0, 149, 37);
		panel_4.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Khu Công Nghệ Cao, Long Mỹ Thạnh, Quận 9, TP.Hồ Chí Minh");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(10, 27, 365, 27);
		panel_4.add(lblNewLabel_1);
		
		JSeparator separator_10 = new JSeparator();
		separator_10.setBounds(40, 53, 290, 1);
		panel_4.add(separator_10);
		
		JLabel lblNewLabel_10 = new JLabel("Nhân viên:");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_10.setBounds(10, 65, 78, 14);
		panel_4.add(lblNewLabel_10);
		
		JLabel lbNhanVien = new JLabel("");
		lbNhanVien.setHorizontalAlignment(SwingConstants.CENTER);
		lbNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbNhanVien.setBounds(87, 64, 80, 20);
		panel_4.add(lbNhanVien);
		
		JLabel lbDateTime = new JLabel("");
		lbDateTime.setHorizontalAlignment(SwingConstants.CENTER);
		lbDateTime.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbDateTime.setBounds(226, 65, 149, 20);
		panel_4.add(lbDateTime);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(10, 110, 380, 490);
		panel_2.add(panel_5);
		panel_5.setLayout(new BoxLayout(panel_5, BoxLayout.X_AXIS));
		
		JPanel panel_6 = new JPanel();
		panel_5.add(panel_6);
		panel_6.setLayout(new BoxLayout(panel_6, BoxLayout.Y_AXIS));
		
		JPanel panel_8 = new JPanel();
		panel_8.setForeground(Color.WHITE);
		panel_8.setBackground(new Color(153, 0, 0));
		panel_6.add(panel_8);
		panel_8.setLayout(new BorderLayout(0, 0));
		
		JLabel lbHoaDon = new JLabel("Hóa đơn");

		lbHoaDon.setForeground(Color.WHITE);
		lbHoaDon.setHorizontalAlignment(SwingConstants.CENTER);
		lbHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_8.add(lbHoaDon, BorderLayout.CENTER);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		panel_8.add(separator, BorderLayout.EAST);
		
		JSeparator separator_5 = new JSeparator();
		panel_8.add(separator_5, BorderLayout.SOUTH);
		
		JSeparator separator_20 = new JSeparator();
		separator_20.setOrientation(SwingConstants.VERTICAL);
		panel_8.add(separator_20, BorderLayout.WEST);
		
		JSeparator separator_21 = new JSeparator();
		panel_8.add(separator_21, BorderLayout.NORTH);
		
		JPanel panel_9 = new JPanel();

		panel_9.setForeground(Color.WHITE);
		panel_9.setBackground(new Color(153, 0, 0));
		panel_6.add(panel_9);
		panel_9.setLayout(new BorderLayout(0, 0));
		
		JLabel lbChinhSuaNhanVien = new JLabel("Chỉnh sửa nhân viên");

		lbChinhSuaNhanVien.setForeground(Color.WHITE);
		lbChinhSuaNhanVien.setHorizontalAlignment(SwingConstants.CENTER);
		lbChinhSuaNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_9.add(lbChinhSuaNhanVien, BorderLayout.CENTER);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		panel_9.add(separator_1, BorderLayout.EAST);
		
		JSeparator separator_7 = new JSeparator();
		panel_9.add(separator_7, BorderLayout.SOUTH);
		
		JSeparator separator_19 = new JSeparator();
		separator_19.setOrientation(SwingConstants.VERTICAL);
		panel_9.add(separator_19, BorderLayout.WEST);
		
		JPanel panel_8_1 = new JPanel();
		panel_8_1.setForeground(Color.WHITE);
		panel_8_1.setBackground(new Color(153, 0, 0));
		panel_6.add(panel_8_1);
		panel_8_1.setLayout(new BorderLayout(0, 0));
		
		JLabel lbKhachHang = new JLabel("Khách hàng");
		lbKhachHang.setForeground(Color.WHITE);
		lbKhachHang.setHorizontalAlignment(SwingConstants.CENTER);
		lbKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_8_1.add(lbKhachHang, BorderLayout.CENTER);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		panel_8_1.add(separator_2, BorderLayout.EAST);
		
		JSeparator separator_9 = new JSeparator();
		panel_8_1.add(separator_9, BorderLayout.SOUTH);
		
		JSeparator separator_18 = new JSeparator();
		separator_18.setOrientation(SwingConstants.VERTICAL);
		panel_8_1.add(separator_18, BorderLayout.WEST);
		
		JPanel panel_9_1 = new JPanel();
		panel_9_1.setForeground(Color.WHITE);
		panel_9_1.setBackground(new Color(153, 0, 0));
		panel_6.add(panel_9_1);
		panel_9_1.setLayout(new BorderLayout(0, 0));
		
		JLabel lbTinhLuong = new JLabel("Tính lương");

		lbTinhLuong.setForeground(Color.WHITE);
		lbTinhLuong.setHorizontalAlignment(SwingConstants.CENTER);
		lbTinhLuong.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_9_1.add(lbTinhLuong, BorderLayout.CENTER);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setOrientation(SwingConstants.VERTICAL);
		panel_9_1.add(separator_3, BorderLayout.EAST);
		
		JSeparator separator_12 = new JSeparator();
		panel_9_1.add(separator_12, BorderLayout.SOUTH);
		
		JSeparator separator_17 = new JSeparator();
		separator_17.setOrientation(SwingConstants.VERTICAL);
		panel_9_1.add(separator_17, BorderLayout.WEST);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 0, 0));
		panel_6.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("<<");
		lblNewLabel_2.setPreferredSize(new Dimension(16, 5));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBackground(new Color(153, 0, 0));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(lblNewLabel_2, BorderLayout.CENTER);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setOrientation(SwingConstants.VERTICAL);
		panel.add(separator_4, BorderLayout.EAST);
		
		JSeparator separator_14 = new JSeparator();
		panel.add(separator_14, BorderLayout.SOUTH);
		
		JSeparator separator_16 = new JSeparator();
		separator_16.setOrientation(SwingConstants.VERTICAL);
		panel.add(separator_16, BorderLayout.WEST);
		
		JPanel panel_7 = new JPanel();
		panel_5.add(panel_7);
		panel_7.setLayout(new BoxLayout(panel_7, BoxLayout.Y_AXIS));
		
		JPanel panel_10 = new JPanel();

		panel_10.setForeground(Color.WHITE);
		panel_10.setBackground(new Color(153, 0, 0));
		panel_7.add(panel_10);
		panel_10.setLayout(new BorderLayout(0, 0));
		
		JLabel lbLichSuHoaDon = new JLabel("Lịch sử hóa đơn");

		lbLichSuHoaDon.setForeground(Color.WHITE);
		lbLichSuHoaDon.setHorizontalAlignment(SwingConstants.CENTER);
		lbLichSuHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_10.add(lbLichSuHoaDon, BorderLayout.CENTER);
		
		JSeparator separator_6 = new JSeparator();
		panel_10.add(separator_6, BorderLayout.SOUTH);
		
		JSeparator separator_22 = new JSeparator();
		panel_10.add(separator_22, BorderLayout.NORTH);
		
		JSeparator separator_23 = new JSeparator();
		separator_23.setOrientation(SwingConstants.VERTICAL);
		panel_10.add(separator_23, BorderLayout.EAST);
		
		JPanel panel_11 = new JPanel();

		panel_11.setForeground(Color.WHITE);
		panel_11.setBackground(new Color(153, 0, 0));
		panel_7.add(panel_11);
		panel_11.setLayout(new BorderLayout(0, 0));
		
		JLabel lbChinhSuaMonAn = new JLabel("Chỉnh sửa món ăn");

		lbChinhSuaMonAn.setForeground(Color.WHITE);
		lbChinhSuaMonAn.setHorizontalAlignment(SwingConstants.CENTER);
		lbChinhSuaMonAn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_11.add(lbChinhSuaMonAn, BorderLayout.CENTER);
		
		JSeparator separator_8 = new JSeparator();
		panel_11.add(separator_8, BorderLayout.SOUTH);
		
		JSeparator separator_24 = new JSeparator();
		separator_24.setOrientation(SwingConstants.VERTICAL);
		panel_11.add(separator_24, BorderLayout.EAST);
		
		JPanel panel_8_2 = new JPanel();

		panel_8_2.setForeground(Color.WHITE);
		panel_8_2.setBackground(new Color(153, 0, 0));
		panel_7.add(panel_8_2);
		panel_8_2.setLayout(new BorderLayout(0, 0));
		
		JLabel lbThongKe = new JLabel("Thống kê");

		lbThongKe.setForeground(Color.WHITE);
		lbThongKe.setHorizontalAlignment(SwingConstants.CENTER);
		lbThongKe.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_8_2.add(lbThongKe, BorderLayout.CENTER);
		
		JSeparator separator_11 = new JSeparator();
		panel_8_2.add(separator_11, BorderLayout.SOUTH);
		
		JSeparator separator_25 = new JSeparator();
		separator_25.setOrientation(SwingConstants.VERTICAL);
		panel_8_2.add(separator_25, BorderLayout.EAST);
		
		JPanel panel_9_2 = new JPanel();

		panel_9_2.setForeground(Color.WHITE);
		panel_9_2.setBackground(new Color(153, 0, 0));
		panel_7.add(panel_9_2);
		panel_9_2.setLayout(new BorderLayout(0, 0));
		
		JLabel lbNhapNguyenLieu = new JLabel("Nhập nguyên liệu");

		lbNhapNguyenLieu.setForeground(Color.WHITE);
		lbNhapNguyenLieu.setHorizontalAlignment(SwingConstants.CENTER);
		lbNhapNguyenLieu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_9_2.add(lbNhapNguyenLieu, BorderLayout.CENTER);
		
		JSeparator separator_13 = new JSeparator();
		panel_9_2.add(separator_13, BorderLayout.SOUTH);
		
		JSeparator separator_26 = new JSeparator();
		separator_26.setOrientation(SwingConstants.VERTICAL);
		panel_9_2.add(separator_26, BorderLayout.EAST);
		
		JPanel panel_12 = new JPanel();
		panel_12.setBackground(new Color(153, 0, 0));
		panel_7.add(panel_12);
		panel_12.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_3 = new JLabel(">>");
		lblNewLabel_3.setPreferredSize(new Dimension(16, 5));
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBackground(new Color(153, 0, 0));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_12.add(lblNewLabel_3, BorderLayout.CENTER);
		
		JSeparator separator_15 = new JSeparator();
		panel_12.add(separator_15, BorderLayout.SOUTH);
		
		JSeparator separator_27 = new JSeparator();
		separator_27.setOrientation(SwingConstants.VERTICAL);
		panel_12.add(separator_27, BorderLayout.EAST);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBounds(64, 100, 560, 500);
		add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_13 = new JPanel();
		panel_13.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_13.setBounds(0, 0, 64, 600);
		add(panel_13);
		panel_13.setLayout(null);

	}
	private class Jpanel_MouseClicked{
		
	}
}
