package view;

import javax.swing.JPanel;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.border.LineBorder;
import entities.NhanVien;

public class PnNhanVien extends JPanel {
	private JFrame mainFrame;

	private CardLayout cardLayout; // card dang nhap
	private JPanel cardPanel; // pn dang nhap

	private CardLayout cardLeft; // card left
	private JPanel pnLeft; // pn left

	private JPanel pnSwitch; // pn right
	private CardLayout cardRight; // card right
	private JTextField txtTimKiem;

	private NhanVien nhanVien;

	private JLabel lbDateTime;
	
	private JLabel lbNhanVien;
	
	private PnThanhToan pnThanhToan;
	
	private PnMenu pnMenu;
	
	private PnMenuKhongChucNang pnMenuKhongChucNang;

	public PnNhanVien(CardLayout cardLayout, JPanel cardPanel, JFrame mainFrame) {
		setName("pnNhanVien");
		setBorder(new LineBorder(new Color(0, 0, 0)));
		this.cardLayout = cardLayout;
		this.cardPanel = cardPanel;
		this.mainFrame = mainFrame;
		//this.nhanVien = nhanVien;

		setBounds(0, 0, 1024, 600);

		setLayout(null);

		pnLeft = new JPanel();
		pnLeft.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnLeft.setBounds(64, 100, 560, 500);
		add(pnLeft);
		cardLeft = new CardLayout(0, 0);
		pnLeft.setLayout(cardLeft);

		pnSwitch = new JPanel();
		pnSwitch.setBounds(624, 0, 400, 600);
		add(pnSwitch);
		cardRight = new CardLayout(0, 0);
		pnSwitch.setLayout(cardRight);

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
		// add(panel_2);
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

		lbNhanVien = new JLabel("");
		lbNhanVien.setHorizontalAlignment(SwingConstants.CENTER);
		lbNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbNhanVien.setBounds(98, 65, 118, 20);
		panel_4.add(lbNhanVien);

		lbDateTime = new JLabel("");
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
		pnHoaDonBtn.setName("pnHoaDonBtn");
		pnHoaDonBtn.setForeground(Color.WHITE);
		pnHoaDonBtn.setBackground(new Color(153, 0, 0));
		panel_6.add(pnHoaDonBtn);
		pnHoaDonBtn.setLayout(new BorderLayout(0, 0));
		pnHoaDonBtn.addMouseListener(new PanelButtonHoaDonMouseAdapter(pnHoaDonBtn, pnLeft, pnSwitch));

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

		JPanel pnKhachHangBtn = new JPanel();
		pnKhachHangBtn.setName("pnKhachHangBtn");
		pnKhachHangBtn.setForeground(Color.WHITE);
		pnKhachHangBtn.setBackground(new Color(153, 0, 0));
		panel_6.add(pnKhachHangBtn);
		pnKhachHangBtn.setLayout(new BorderLayout(0, 0));
		pnKhachHangBtn.addMouseListener(new PanelButtonMouseAdapter(pnKhachHangBtn));

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
		pnTinhLuongBtn.setName("pnTinhLuongBtn");
		pnTinhLuongBtn.setForeground(Color.WHITE);
		pnTinhLuongBtn.setBackground(new Color(153, 0, 0));
		panel_6.add(pnTinhLuongBtn);
		pnTinhLuongBtn.setLayout(new BorderLayout(0, 0));
		pnTinhLuongBtn.addMouseListener(new PanelButtonMouseAdapter(pnTinhLuongBtn));

		JLabel lbTinhLuong = new JLabel("    Chấm công    ");

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
		pnLichSuHoaDonBtn.setName("pnLichSuHoaDonBtn");
		pnLichSuHoaDonBtn.setForeground(Color.WHITE);
		pnLichSuHoaDonBtn.setBackground(new Color(153, 0, 0));
		panel_7.add(pnLichSuHoaDonBtn);
		pnLichSuHoaDonBtn.setLayout(new BorderLayout(0, 0));
		pnLichSuHoaDonBtn.addMouseListener(new PanelButtonMouseAdapter(pnLichSuHoaDonBtn));

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

		JPanel pnThongKeBtn = new JPanel();
		pnThongKeBtn.setName("pnThongKeBtn");
		pnThongKeBtn.setForeground(Color.WHITE);
		pnThongKeBtn.setBackground(new Color(153, 0, 0));
		panel_7.add(pnThongKeBtn);
		pnThongKeBtn.setLayout(new BorderLayout(0, 0));
		pnThongKeBtn.addMouseListener(new PanelButtonMouseAdapter(pnThongKeBtn));

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

		JPanel pnChinhSuaMonAnBtn = new JPanel();
		pnChinhSuaMonAnBtn.setName("pnNhapNguyenLieuBtn");
		pnChinhSuaMonAnBtn.setForeground(Color.WHITE);
		pnChinhSuaMonAnBtn.setBackground(new Color(153, 0, 0));
		panel_7.add(pnChinhSuaMonAnBtn);
		pnChinhSuaMonAnBtn.setLayout(new BorderLayout(0, 0));
		pnChinhSuaMonAnBtn.addMouseListener(new PanelButtonMouseAdapter(pnChinhSuaMonAnBtn));

		JLabel lbChinhSuaMonAn = new JLabel("Chỉnh sửa món ăn");

		lbChinhSuaMonAn.setForeground(Color.WHITE);
		lbChinhSuaMonAn.setHorizontalAlignment(SwingConstants.CENTER);
		lbChinhSuaMonAn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		pnChinhSuaMonAnBtn.add(lbChinhSuaMonAn, BorderLayout.CENTER);

		JSeparator separator_13 = new JSeparator();
		pnChinhSuaMonAnBtn.add(separator_13, BorderLayout.SOUTH);

		JSeparator separator_26 = new JSeparator();
		separator_26.setOrientation(SwingConstants.VERTICAL);
		pnChinhSuaMonAnBtn.add(separator_26, BorderLayout.EAST);

		JPanel panel_13 = new JPanel();
		panel_13.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_13.setBounds(0, 0, 64, 600);
		add(panel_13);
		panel_13.setLayout(new BoxLayout(panel_13, BoxLayout.Y_AXIS));

		JPanel panel = new JPanel();
		panel_13.add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel panel_3 = new JPanel();
		panel_13.add(panel_3);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("picture/setting.png"));
		panel_3.add(lblNewLabel);

		JPanel panel_8 = new JPanel();
		panel_13.add(panel_8);
		panel_8.setLayout(new BorderLayout(0, 0));

		JPanel panel_9 = new JPanel();
		panel_13.add(panel_9);
		panel_9.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("picture/help.png"));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_9.add(lblNewLabel_2, BorderLayout.CENTER);

		JPanel panel_10 = new JPanel();
		panel_13.add(panel_10);
		panel_10.setLayout(new BorderLayout(0, 0));

		JPanel panel_11 = new JPanel();
		panel_13.add(panel_11);
		panel_11.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setIcon(new ImageIcon("picture/Calculator.png"));
		panel_11.add(lblNewLabel_3, BorderLayout.CENTER);

		JPanel panel_12 = new JPanel();
		panel_13.add(panel_12);
		panel_12.setLayout(new BorderLayout(0, 0));

		pnSwitch.add(panel_2, "panel_2");

		pnThanhToan = new PnThanhToan(cardLeft, cardRight, pnLeft, pnSwitch, this);
		pnSwitch.add(pnThanhToan, "pnThanhToan");

		pnMenuKhongChucNang = new PnMenuKhongChucNang();
		pnLeft.add(pnMenuKhongChucNang, "pnMenuKhongChucNang");

		pnMenu = new PnMenu((PnThanhToan) pnThanhToan);
		pnLeft.add(pnMenu, "pnMenu");
		
		JPanel pnLichSuHoaDon = new PnLichSuHoaDon();
		pnLeft.add(pnLichSuHoaDon, "pnLichSuHoaDon");
		
		JPanel pnThongTinKhachHang = new PnThongTinKhachHang();
		pnLeft.add(pnThongTinKhachHang, "pnThongTinKhachHang");
		
		JPanel pnChinhSuaMonAn = new PnChinhSuaMonAn(this);
		pnLeft.add(pnChinhSuaMonAn, "pnChinhSuaMonAn");
		
		JPanel pnThongKe = new PnThongKe();
		pnLeft.add(pnThongKe, "pnThongKe");
		
		JPanel pnChamCong = new PnChamCong();
		pnLeft.add(pnChamCong, "pnChamCong");

		setTiming();
	}

	private class PanelButtonMouseAdapter extends MouseAdapter {
		JPanel panel;

		public PanelButtonMouseAdapter(JPanel panel) {
			this.panel = panel;
		}

		@Override
		public void mousePressed(MouseEvent e) {
			panel.setBackground(Color.CYAN);
			if (panel.getName().compareTo("pnLichSuHoaDonBtn") == 0) {
				cardLeft.show(pnLeft, "pnLichSuHoaDon");
			}
			if (panel.getName().compareTo("pnKhachHangBtn") == 0) {
				cardLeft.show(pnLeft, "pnThongTinKhachHang");
			}
			if (panel.getName().compareTo("pnChinhSuaMonAnBtn") == 0) {
				cardLeft.show(pnLeft, "pnChinhSuaMonAn");
			}
			if (panel.getName().compareTo("pnThongKeBtn") == 0) {
				cardLeft.show(pnLeft, "pnThongKe");
			}
			if (panel.getName().compareTo("pnTinhLuongBtn") == 0) {
				cardLeft.show(pnLeft, "pnChamCong");
			}
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
			cardLeft.show(cardPanel, "pnMenu");
			cardRight.show(pnSwitch, "pnThanhToan");
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
	
	private void setTiming() {
		Timer timer = new Timer(1000, new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Date date = new Date();
				SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
				lbDateTime.setText(formatter.format(date));
			}
		});
		timer.start();
	}
	
	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}
	
	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public JLabel getLbNhanVien() {
		return lbNhanVien;
	}

	public void setLbNhanVien(JLabel lbNhanVien) {
		this.lbNhanVien = lbNhanVien;
	}

	public PnThanhToan getPnThanhToan() {
		return pnThanhToan;
	}

	public void setPnThanhToan(PnThanhToan pnThanhToan) {
		this.pnThanhToan = pnThanhToan;
	}

	public JPanel getPnSwitch() {
		return pnSwitch;
	}

	public void setPnSwitch(JPanel pnSwitch) {
		this.pnSwitch = pnSwitch;
	}

	public CardLayout getCardSwitch() {
		return cardRight;
	}

	public void setCardSwitch(CardLayout cardRight) {
		this.cardRight = cardRight;
	}



	public CardLayout getCardLeft() {
		return cardLeft;
	}

	public void setCardLeft(CardLayout cardLeft) {
		this.cardLeft = cardLeft;
	}

	public JPanel getPnLeft() {
		return pnLeft;
	}

	public void setPnLeft(JPanel pnLeft) {
		this.pnLeft = pnLeft;
	}

	public PnMenu getPnMenu() {
		return pnMenu;
	}

	public void setPnMenu(PnMenu pnMenu) {
		this.pnMenu = pnMenu;
	}

	public PnMenuKhongChucNang getPnMenuKhongChucNang() {
		return pnMenuKhongChucNang;
	}

	public void setPnMenuKhongChucNang(PnMenuKhongChucNang pnMenuKhongChucNang) {
		this.pnMenuKhongChucNang = pnMenuKhongChucNang;
	}
	
}
