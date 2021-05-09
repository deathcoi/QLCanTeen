package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.LineBorder;

import entities.KhachHang;

public class PnKhachHang extends JPanel {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	private JFrame mainFrame;
	
	private KhachHang khachHang;
	/**
	 * Create the panel.
	 */
	private CardLayout cardLayout; //card để đăng nhập/ đăng xuất
	private JPanel cardPanel; //pn đăng nhập/đăng xuất
	
	private CardLayout cardLeft; //card ở giữa
	private JPanel pnCardLeft; //pn ở giữa
	
	private JPanel pnCardRight; //pn bên phải
	private CardLayout cardRight; //card bên phải
	private JLabel lbKhachHang;
	private PnDoiMatKhau pnDoiMatKhau;
	private PnThongTinTaiKhoan pnThongTinTaiKhoan;
	
	//private JLabel lbNhanVien;
	
	private JLabel lbDateTime;
	
	public JLabel getLbKhachHang() {
		return lbKhachHang;
	}
	public void setLbKhachHang(JLabel lbKhachHang) {
		this.lbKhachHang = lbKhachHang;
	}
	public KhachHang getKhachHang() {
		return khachHang;
	}
	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}
	public PnKhachHang(CardLayout cardLayout, JPanel cardPanel, JFrame mainFrame) {
		setName("pnKhachHang");
		setBorder(new LineBorder(new Color(0, 0, 0)));
		this.cardLayout = cardLayout;
		this.cardPanel = cardPanel;
		this.mainFrame = mainFrame;
		
		
		setBounds(0, 0, 1024, 600);

		setLayout(null);
		

		pnCardLeft = new JPanel();
		pnCardLeft.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnCardLeft.setBounds(64, 0, 560, 600);
		add(pnCardLeft);
		cardLeft = new CardLayout(0, 0);
		pnCardLeft.setLayout(cardLeft);
		
		pnCardRight = new JPanel();
		pnCardRight.setBounds(624, 0, 400, 600);
		add(pnCardRight);
		cardRight = new CardLayout(0, 0);
		pnCardRight.setLayout(cardRight);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
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
		
		lbDateTime = new JLabel("");
		lbDateTime.setHorizontalAlignment(SwingConstants.RIGHT);
		lbDateTime.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbDateTime.setBounds(226, 61, 149, 20);
		panel_4.add(lbDateTime);
		
		lbKhachHang = new JLabel("");
		lbKhachHang.setHorizontalAlignment(SwingConstants.LEFT);
		lbKhachHang.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lbKhachHang.setBounds(20, 61, 149, 20);
		panel_4.add(lbKhachHang);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(10, 110, 380, 490);
		panel_2.add(panel_5);
		panel_5.setLayout(new BoxLayout(panel_5, BoxLayout.Y_AXIS));
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_6.setBackground(new Color(153, 153, 204));
		panel_6.addMouseListener(new PanelButtonMouseAdapter(panel_6));
		panel_5.add(panel_6);
		panel_6.setLayout(new BorderLayout(0, 0));
		panel_6.setName("pnNapTien");
		
		JLabel lblNewLabel_4 = new JLabel("Nạp tiền");
		lblNewLabel_4.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel_6.add(lblNewLabel_4, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBackground(new Color(153, 153, 204));
		panel_5.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		panel_1.addMouseListener(new PanelButtonMouseAdapter(panel_1));
		panel_1.setName("pnMenu");
		
		JLabel lblNewLabel = new JLabel("Menu");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 30));
		panel_1.add(lblNewLabel, BorderLayout.CENTER);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_5.add(panel_7);
		panel_7.setBackground(new Color(153, 153, 204));
		panel_7.addMouseListener(new PanelButtonMouseAdapter(panel_7));
		panel_7.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("Thông tin tài khoản");
		lblNewLabel_2.setFont(new Font("Dialog", Font.PLAIN, 30));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_7.add(lblNewLabel_2);
		panel_7.setName("pnThongTinTaiKhoan");
		
		JPanel panel_13 = new JPanel();
		panel_13.setBackground(new Color(255, 255, 153));
		panel_13.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_13.setBounds(0, 0, 64, 600);
		add(panel_13);
		panel_13.setLayout(new BoxLayout(panel_13, BoxLayout.Y_AXIS));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 153));
		panel_13.add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel panel_3 = new JPanel();
		panel_13.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorder(null);
		menuBar.setBackground(new Color(255, 255, 153));
		JMenu menuSetting = new JMenu();
		menuSetting.setSelectedIcon(new ImageIcon("picture/setting.png"));
		menuSetting.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuSetting.setHorizontalAlignment(SwingConstants.CENTER);
		menuSetting.setHorizontalTextPosition(SwingConstants.CENTER);
		menuSetting.setIcon(new ImageIcon("picture/setting.png"));
		JMenuItem menuDoiMatKhau = new JMenuItem("Đổi mật khẩu");
		menuDoiMatKhau.setIcon(new ImageIcon("picture\\changePassword.png"));
		menuDoiMatKhau.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				doiMatKhauClicked();
			}
		});
		menuDoiMatKhau.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		JMenuItem menuDangXuat = new JMenuItem("Đăng xuất");
		menuDangXuat.setIcon(new ImageIcon("picture\\logOut.png"));
		menuDangXuat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				dangXuatClicked();
			}
		});
		menuDangXuat.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuSetting.add(menuDoiMatKhau);
		menuSetting.add(menuDangXuat);
		menuBar.add(menuSetting);
		panel_3.add(menuBar, BorderLayout.CENTER);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(255, 255, 153));
		panel_13.add(panel_8);
		panel_8.setLayout(new BorderLayout(0, 0));

		JPanel panel_9 = new JPanel();
		panel_13.add(panel_9);
		panel_9.setLayout(new BorderLayout(0, 0));
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("");
		mntmNewMenuItem_1.setBorder(null);
		mntmNewMenuItem_1.setOpaque(true);
		mntmNewMenuItem_1.setBackground(new Color(255, 255, 153));
		mntmNewMenuItem_1.setIcon(new ImageIcon("picture/help.png"));
		panel_9.add(mntmNewMenuItem_1, BorderLayout.CENTER);

		JPanel panel_10 = new JPanel();
		panel_10.setBackground(new Color(255, 255, 153));
		panel_13.add(panel_10);
		panel_10.setLayout(new BorderLayout(0, 0));

		JPanel panel_11 = new JPanel();
		panel_11.addMouseListener(new PanelButtonMouseAdapter(panel_11));
		panel_11.setName("panel_11");
		panel_13.add(panel_11);
		panel_11.setLayout(new BorderLayout(0, 0));
		
		JMenuItem mntmNewMenuItem = new JMenuItem("");
		mntmNewMenuItem.setBorder(null);
		mntmNewMenuItem.setOpaque(true);
		mntmNewMenuItem.setBackground(new Color(255, 255, 153));
		mntmNewMenuItem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				btnClicked();
			}
		});
		mntmNewMenuItem.setIcon(new ImageIcon("picture/Calculator.png"));
		mntmNewMenuItem.setHorizontalAlignment(SwingConstants.CENTER);
		panel_11.add(mntmNewMenuItem, BorderLayout.CENTER);

		JPanel panel_12 = new JPanel();
		panel_12.setBackground(new Color(255, 255, 153));
		panel_13.add(panel_12);
		panel_12.setLayout(new BorderLayout(0, 0));
		
		pnCardRight.add(panel_2, "panel_2");
		
		
		JPanel pnMenuKhongChucNang = new PnMenuKhongChucNang();
		pnCardLeft.add(pnMenuKhongChucNang, "pnMenuKhongChucNang");
		
		pnDoiMatKhau = new PnDoiMatKhau(khachHang);
		pnCardLeft.add(pnDoiMatKhau, "pnDoiMatKhau");
		
		pnThongTinTaiKhoan = new PnThongTinTaiKhoan();
		pnCardLeft.add(pnThongTinTaiKhoan, "pnThongTinTaiKhoan");
		
		setTiming();
		
	}
	
	private void doiMatKhauClicked() {
		pnDoiMatKhau.setUser(khachHang);
		cardLeft.show(pnCardLeft, "pnDoiMatKhau");
	}
	
	private void dangXuatClicked() {
		cardLayout.show(cardPanel, "pnDangNhap");
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
	
	private class PanelButtonMouseAdapter extends MouseAdapter {
		JPanel panel;
		
		public PanelButtonMouseAdapter(JPanel panel ) {
			this.panel = panel;
		}

		@Override
		public void mousePressed(MouseEvent e) {
			panel.setBackground(Color.CYAN);
			if (khachHang == null)
				JOptionPane.showMessageDialog(null, "null khachHang");
			if (panel.getName().compareTo("pnNapTien") == 0) {
				FrameNapTien frm = new FrameNapTien(khachHang);
				frm.setVisible(true);
			} else {
				if(panel.getName().compareTo("pnMenu") == 0)
					cardLeft.show(pnCardLeft, "pnMenuKhongChucNang");
				else {
					pnThongTinTaiKhoan.setKhachHang(khachHang);
					pnThongTinTaiKhoan.dienThongTin();
					cardLeft.show(pnCardLeft, "pnThongTinTaiKhoan");
				}
					
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
			panel.setBackground(new Color(153, 153, 204));
		}
	}
	private void btnClicked() { 
		Runtime rTime = Runtime.getRuntime();
		try {
			rTime.exec("open -a Calculator");		
		}catch(Exception e) {
			try {
				rTime.exec("calc");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
