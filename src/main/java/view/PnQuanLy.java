package view;

import javax.swing.JPanel;

import java.awt.CardLayout;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JToolBar;
import javax.swing.JComboBox;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
	
	private CardLayout cardLayoutThis;
	private JPanel cardPanelThis;
	
	private JPanel pnSwitch;
	private CardLayout cardSwitch;
	private JTextField txtTimKiem;
	public PnQuanLy(CardLayout cardLayout, JPanel cardPanel) {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		this.cardLayout = cardLayout;
		this.cardPanel = cardPanel;
		
		
		setBounds(0, 0, 1024, 600);

		setLayout(null);
		

		cardPanelThis = new JPanel();
		cardPanelThis.setBorder(new LineBorder(new Color(0, 0, 0)));
		cardPanelThis.setBounds(64, 100, 560, 500);
		add(cardPanelThis);
		cardLayoutThis = new CardLayout(0, 0);
		cardPanelThis.setLayout(cardLayoutThis);
		
		pnSwitch = new JPanel();
		pnSwitch.setBounds(624, 0, 400, 600);
		add(pnSwitch);
		cardSwitch = new CardLayout(0, 0);
		pnSwitch.setLayout(cardSwitch);
		
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
		//add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel_4.setForeground(Color.WHITE);
		panel_4.setBounds(10, 10, 380, 90);
		panel_2.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel1 = new JLabel("Canteen Hutech");
		lblNewLabel1.setForeground(Color.RED);
		lblNewLabel1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel1.setBounds(130, 0, 149, 37);
		panel_4.add(lblNewLabel1);
		
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
		
		JPanel pnHoaDonBtn = new JPanel();
		pnHoaDonBtn.setForeground(Color.WHITE);
		pnHoaDonBtn.setBackground(new Color(153, 0, 0));
		panel_6.add(pnHoaDonBtn);
		pnHoaDonBtn.setLayout(new BorderLayout(0, 0));
		pnHoaDonBtn.addMouseListener(new PanelButtonHoaDonMouseAdapter(pnHoaDonBtn, cardPanelThis, pnSwitch));
		
		JLabel lbHoaDon = new JLabel("Hóa đơn");

		lbHoaDon.setForeground(Color.WHITE);
		lbHoaDon.setHorizontalAlignment(SwingConstants.CENTER);
		lbHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 18));
		pnHoaDonBtn.add(lbHoaDon, BorderLayout.CENTER);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		pnHoaDonBtn.add(separator, BorderLayout.EAST);
		
		JSeparator separator_5 = new JSeparator();
		pnHoaDonBtn.add(separator_5, BorderLayout.SOUTH);
		
		JSeparator separator_20 = new JSeparator();
		separator_20.setOrientation(SwingConstants.VERTICAL);
		pnHoaDonBtn.add(separator_20, BorderLayout.WEST);
		
		JSeparator separator_21 = new JSeparator();
		pnHoaDonBtn.add(separator_21, BorderLayout.NORTH);
		
		JPanel pnChinhSuaNhanVienBtn = new JPanel();

		pnChinhSuaNhanVienBtn.setForeground(Color.WHITE);
		pnChinhSuaNhanVienBtn.setBackground(new Color(153, 0, 0));
		panel_6.add(pnChinhSuaNhanVienBtn);
		pnChinhSuaNhanVienBtn.setLayout(new BorderLayout(0, 0));
		pnChinhSuaNhanVienBtn.addMouseListener(new PanelButtonMouseAdapter(pnChinhSuaNhanVienBtn, cardPanelThis));
		
		JLabel lbChinhSuaNhanVien = new JLabel("Chỉnh sửa nhân viên");

		lbChinhSuaNhanVien.setForeground(Color.WHITE);
		lbChinhSuaNhanVien.setHorizontalAlignment(SwingConstants.CENTER);
		lbChinhSuaNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 18));
		pnChinhSuaNhanVienBtn.add(lbChinhSuaNhanVien, BorderLayout.CENTER);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		pnChinhSuaNhanVienBtn.add(separator_1, BorderLayout.EAST);
		
		JSeparator separator_7 = new JSeparator();
		pnChinhSuaNhanVienBtn.add(separator_7, BorderLayout.SOUTH);
		
		JSeparator separator_19 = new JSeparator();
		separator_19.setOrientation(SwingConstants.VERTICAL);
		pnChinhSuaNhanVienBtn.add(separator_19, BorderLayout.WEST);
		
		JPanel pnKhachHangBtn = new JPanel();
		pnKhachHangBtn.setForeground(Color.WHITE);
		pnKhachHangBtn.setBackground(new Color(153, 0, 0));
		panel_6.add(pnKhachHangBtn);
		pnKhachHangBtn.setLayout(new BorderLayout(0, 0));
		pnKhachHangBtn.addMouseListener(new PanelButtonMouseAdapter(pnKhachHangBtn, cardPanelThis));
		
		JLabel lbKhachHang = new JLabel("Khách hàng");
		lbKhachHang.setForeground(Color.WHITE);
		lbKhachHang.setHorizontalAlignment(SwingConstants.CENTER);
		lbKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 18));
		pnKhachHangBtn.add(lbKhachHang, BorderLayout.CENTER);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		pnKhachHangBtn.add(separator_2, BorderLayout.EAST);
		
		JSeparator separator_9 = new JSeparator();
		pnKhachHangBtn.add(separator_9, BorderLayout.SOUTH);
		
		JSeparator separator_18 = new JSeparator();
		separator_18.setOrientation(SwingConstants.VERTICAL);
		pnKhachHangBtn.add(separator_18, BorderLayout.WEST);
		
		JPanel pnTinhLuongBtn = new JPanel();
		pnTinhLuongBtn.setForeground(Color.WHITE);
		pnTinhLuongBtn.setBackground(new Color(153, 0, 0));
		panel_6.add(pnTinhLuongBtn);
		pnTinhLuongBtn.setLayout(new BorderLayout(0, 0));
		pnTinhLuongBtn.addMouseListener(new PanelButtonMouseAdapter(pnTinhLuongBtn, cardPanelThis));
		
		JLabel lbTinhLuong = new JLabel("Tính lương");

		lbTinhLuong.setForeground(Color.WHITE);
		lbTinhLuong.setHorizontalAlignment(SwingConstants.CENTER);
		lbTinhLuong.setFont(new Font("Tahoma", Font.PLAIN, 18));
		pnTinhLuongBtn.add(lbTinhLuong, BorderLayout.CENTER);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setOrientation(SwingConstants.VERTICAL);
		pnTinhLuongBtn.add(separator_3, BorderLayout.EAST);
		
		JSeparator separator_12 = new JSeparator();
		pnTinhLuongBtn.add(separator_12, BorderLayout.SOUTH);
		
		JSeparator separator_17 = new JSeparator();
		separator_17.setOrientation(SwingConstants.VERTICAL);
		pnTinhLuongBtn.add(separator_17, BorderLayout.WEST);
		
		JPanel panel_7 = new JPanel();
		panel_5.add(panel_7);
		panel_7.setLayout(new BoxLayout(panel_7, BoxLayout.Y_AXIS));
		
		JPanel pnLichSuHoaDonBtn = new JPanel();

		pnLichSuHoaDonBtn.setForeground(Color.WHITE);
		pnLichSuHoaDonBtn.setBackground(new Color(153, 0, 0));
		panel_7.add(pnLichSuHoaDonBtn);
		pnLichSuHoaDonBtn.setLayout(new BorderLayout(0, 0));
		pnLichSuHoaDonBtn.addMouseListener(new PanelButtonMouseAdapter(pnLichSuHoaDonBtn, cardPanelThis));
		
		JLabel lbLichSuHoaDon = new JLabel("Lịch sử hóa đơn");

		lbLichSuHoaDon.setForeground(Color.WHITE);
		lbLichSuHoaDon.setHorizontalAlignment(SwingConstants.CENTER);
		lbLichSuHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 18));
		pnLichSuHoaDonBtn.add(lbLichSuHoaDon, BorderLayout.CENTER);
		
		JSeparator separator_6 = new JSeparator();
		pnLichSuHoaDonBtn.add(separator_6, BorderLayout.SOUTH);
		
		JSeparator separator_22 = new JSeparator();
		pnLichSuHoaDonBtn.add(separator_22, BorderLayout.NORTH);
		
		JSeparator separator_23 = new JSeparator();
		separator_23.setOrientation(SwingConstants.VERTICAL);
		pnLichSuHoaDonBtn.add(separator_23, BorderLayout.EAST);
		
		JPanel pnChinhSuaMonAnBtn = new JPanel();

		pnChinhSuaMonAnBtn.setForeground(Color.WHITE);
		pnChinhSuaMonAnBtn.setBackground(new Color(153, 0, 0));
		panel_7.add(pnChinhSuaMonAnBtn);
		pnChinhSuaMonAnBtn.setLayout(new BorderLayout(0, 0));
		pnChinhSuaMonAnBtn.addMouseListener(new PanelButtonMouseAdapter(pnChinhSuaMonAnBtn, cardPanelThis));
		
		JLabel lbChinhSuaMonAn = new JLabel("Chỉnh sửa món ăn");

		lbChinhSuaMonAn.setForeground(Color.WHITE);
		lbChinhSuaMonAn.setHorizontalAlignment(SwingConstants.CENTER);
		lbChinhSuaMonAn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		pnChinhSuaMonAnBtn.add(lbChinhSuaMonAn, BorderLayout.CENTER);
		
		JSeparator separator_8 = new JSeparator();
		pnChinhSuaMonAnBtn.add(separator_8, BorderLayout.SOUTH);
		
		JSeparator separator_24 = new JSeparator();
		separator_24.setOrientation(SwingConstants.VERTICAL);
		pnChinhSuaMonAnBtn.add(separator_24, BorderLayout.EAST);
		
		JPanel pnThongKeBtn = new JPanel();

		pnThongKeBtn.setForeground(Color.WHITE);
		pnThongKeBtn.setBackground(new Color(153, 0, 0));
		panel_7.add(pnThongKeBtn);
		pnThongKeBtn.setLayout(new BorderLayout(0, 0));
		pnThongKeBtn.addMouseListener(new PanelButtonMouseAdapter(pnThongKeBtn, cardPanelThis));
		
		JLabel lbThongKe = new JLabel("Thống kê");

		lbThongKe.setForeground(Color.WHITE);
		lbThongKe.setHorizontalAlignment(SwingConstants.CENTER);
		lbThongKe.setFont(new Font("Tahoma", Font.PLAIN, 18));
		pnThongKeBtn.add(lbThongKe, BorderLayout.CENTER);
		
		JSeparator separator_11 = new JSeparator();
		pnThongKeBtn.add(separator_11, BorderLayout.SOUTH);
		
		JSeparator separator_25 = new JSeparator();
		separator_25.setOrientation(SwingConstants.VERTICAL);
		pnThongKeBtn.add(separator_25, BorderLayout.EAST);
		
		JPanel pnNhapNguyenLieuBtn = new JPanel();

		pnNhapNguyenLieuBtn.setForeground(Color.WHITE);
		pnNhapNguyenLieuBtn.setBackground(new Color(153, 0, 0));
		panel_7.add(pnNhapNguyenLieuBtn);
		pnNhapNguyenLieuBtn.setLayout(new BorderLayout(0, 0));
		pnNhapNguyenLieuBtn.addMouseListener(new PanelButtonMouseAdapter(pnNhapNguyenLieuBtn, cardPanelThis));
		
		JLabel lbNhapNguyenLieu = new JLabel("Nhập nguyên liệu");

		lbNhapNguyenLieu.setForeground(Color.WHITE);
		lbNhapNguyenLieu.setHorizontalAlignment(SwingConstants.CENTER);
		lbNhapNguyenLieu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		pnNhapNguyenLieuBtn.add(lbNhapNguyenLieu, BorderLayout.CENTER);
		
		JSeparator separator_13 = new JSeparator();
		pnNhapNguyenLieuBtn.add(separator_13, BorderLayout.SOUTH);
		
		JSeparator separator_26 = new JSeparator();
		separator_26.setOrientation(SwingConstants.VERTICAL);
		pnNhapNguyenLieuBtn.add(separator_26, BorderLayout.EAST);
		
		
		
		JPanel panel_13 = new JPanel();
		panel_13.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_13.setBounds(0, 0, 64, 600);
		add(panel_13);
		panel_13.setLayout(null);
		
		
		
		pnSwitch.add(panel_2, "panel_2");
		
		JPanel pnThanhToan = new PnThanhToan(cardLayoutThis, cardSwitch, cardPanelThis, pnSwitch);
		pnSwitch.add(pnThanhToan, "pnThanhToan");
		
		JPanel pnMenuKhongChucNang = new PnMenuKhongChucNang();
		cardPanelThis.add(pnMenuKhongChucNang, "pnMenuKhongChucNang");
		
		JPanel pnMenu = new PnMenu();
		cardPanelThis.add(pnMenu, "pnMenu");

	}
	
	private class PanelButtonMouseAdapter extends MouseAdapter {
		JPanel panel;
		JPanel cardPanel;
		
		public PanelButtonMouseAdapter(JPanel panel, JPanel cardPanel) {
			this.panel = panel;
			this.cardPanel = cardPanel;
		}

		@Override
		public void mousePressed(MouseEvent e) {
			panel.setBackground(Color.CYAN);
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			panel.setBackground(Color.BLUE);
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			panel.setBackground(Color.BLUE);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			panel.setBackground(new Color(153, 0, 0));
		}
	}
	
	private class PanelButtonHoaDonMouseAdapter extends MouseAdapter {
		JPanel panel;
		JPanel cardPanel;
		JPanel pnSwitch;
		
		public PanelButtonHoaDonMouseAdapter(JPanel panel, JPanel cardPanel, JPanel pnSwitch) {
			this.panel = panel;
			this.cardPanel = cardPanel;
			this.pnSwitch = pnSwitch;
		}

		@Override
		public void mousePressed(MouseEvent e) {
			panel.setBackground(Color.CYAN);
			cardLayoutThis.show(cardPanel, "pnMenu");
			cardSwitch.show(pnSwitch, "pnThanhToan");
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			panel.setBackground(Color.BLUE);
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			panel.setBackground(Color.BLUE);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			panel.setBackground(new Color(153, 0, 0));
		}
	}
}
