package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.border.LineBorder;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import com.fasterxml.jackson.databind.ObjectMapper;

import DAO.CTHoaDonDAO;
import DAO.HoaDonDAO;
import constant.HttpConstant;
import entities.CTHoaDon;
import entities.HoaDon;
import entities.KhachHang;
import entities.MonAn;
import entities.NguyenLieu;
import entities.NhanVien;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;
import service.IpushMethodService;
import service.impl.PushMethodService;
import table.JTableButtonModel;
import table.JTableButtonRenderer;

public class PnThanhToan extends JPanel {

	private static final long serialVersionUID = 1L;

	private CardLayout cardLeft;
	private CardLayout cardRight;

	private JPanel pnLeft;
	private JPanel pnRight;

	protected JTable table;

	private JTextField txtKhachHang;
	private JTextField txtTienMat;
	
	private JLabel lbNhanVien;
	
	private JLabel lbDateTime;
	
	private JLabel lbTongCong;
	
	private JLabel lbTienThua;
	
	private NhanVien nhanVien;
	
	private KhachHang khachHang;
	
	private JPanel pnQLOrNV;

	
	public JLabel getLbTongCong() {
		return lbTongCong;
	}

	public void setLbTongCong(JLabel lbTongCong) {
		this.lbTongCong = lbTongCong;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	/**
	 * Create the panel.
	 */
	public PnThanhToan(CardLayout cardLeft, CardLayout cardRight, JPanel pnLeft, JPanel pnRight, JPanel pnQLOrNV) {
		this.pnQLOrNV = pnQLOrNV;
		setBorder(new LineBorder(new Color(0, 0, 0)));
		this.cardLeft = cardLeft;
		this.cardRight = cardRight;
		this.pnLeft = pnLeft;
		this.pnRight = pnRight;
		//this.pnCall = pnCall;
		setBackground(Color.WHITE);
		setBounds(0, 0, 400, 600);
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 550, 400, 50);
		add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

		JPanel pnThanhToanBtn = new JPanel();
		pnThanhToanBtn.addMouseListener(new PanelButtonMouseAdapter(pnThanhToanBtn));
		pnThanhToanBtn.setName("pnThanhToanBtn");
		pnThanhToanBtn.setBackground(new Color(153, 153, 204));
		pnThanhToanBtn.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(pnThanhToanBtn);
		pnThanhToanBtn.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel = new JLabel("Thanh toán");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		pnThanhToanBtn.add(lblNewLabel, BorderLayout.CENTER);

		JPanel pnHuyBtn = new JPanel();
		pnHuyBtn.setName("pnHuyBtn");
		pnHuyBtn.addMouseListener(new PanelButtonMouseAdapter(pnHuyBtn));
		pnHuyBtn.setBackground(new Color(153, 153, 204));
		pnHuyBtn.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(pnHuyBtn);
		pnHuyBtn.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel_1 = new JLabel("Hủy");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		pnHuyBtn.add(lblNewLabel_1, BorderLayout.CENTER);

		JLabel lblNewLabel_2 = new JLabel("Canteen Hutech");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(120, 10, 168, 33);
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
		lblNewLabel_10.setBounds(10, 80, 94, 22);
		add(lblNewLabel_10);

		lbNhanVien = new JLabel("");
		lbNhanVien.setHorizontalAlignment(SwingConstants.LEFT);
		lbNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbNhanVien.setBounds(80, 80, 116, 20);
		add(lbNhanVien);

		lbDateTime = new JLabel("");
		lbDateTime.setHorizontalAlignment(SwingConstants.RIGHT);
		lbDateTime.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbDateTime.setBounds(240, 80, 150, 20);
		add(lbDateTime);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Tahoma", Font.PLAIN, 10));
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBounds(10, 150, 380, 325);
		add(scrollPane);

		// table = new JTable();
		TableCellRenderer tableRenderer;
		table = new JTable(new JTableButtonModel(new Object[] { "Tên", "Số lượng", "Thành tiền", "", "" }, 0));
		tableRenderer = table.getDefaultRenderer(JButton.class);
		table.setDefaultRenderer(JButton.class, new JTableButtonRenderer(tableRenderer));
		table.addMouseListener(new JTableButtonMouseListener(table));
		table.setBackground(Color.WHITE);
		scrollPane.setViewportView(table);

		JLabel lblNewLabel_10_1 = new JLabel("Khách hàng:");
		lblNewLabel_10_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_10_1.setBounds(10, 105, 89, 22);
		add(lblNewLabel_10_1);

		txtKhachHang = new JTextField();
		txtKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtKhachHang.setBounds(102, 105, 139, 22);
		add(txtKhachHang);
		txtKhachHang.setColumns(10);

		JButton btnKiemTra = new JButton("Kiểm tra");
		btnKiemTra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnKiemTraClicked();
			}
		});
		btnKiemTra.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnKiemTra.setBounds(263, 105, 97, 22);
		add(btnKiemTra);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(60, 140, 280, 1);
		add(separator_2);

		JLabel lblNewLabel_10_2 = new JLabel("Tổng cộng");
		lblNewLabel_10_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_10_2.setBounds(80, 483, 78, 22);
		add(lblNewLabel_10_2);

		JLabel lblNewLabel_10_2_1 = new JLabel("Tiền mặt:");
		lblNewLabel_10_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_10_2_1.setBounds(80, 503, 78, 22);
		add(lblNewLabel_10_2_1);

		JLabel lblNewLabel_10_2_2 = new JLabel("Tiền thừa:");
		lblNewLabel_10_2_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_10_2_2.setBounds(80, 523, 78, 22);
		add(lblNewLabel_10_2_2);

		txtTienMat = new JTextField();
		txtTienMat.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				txtTienMatEnter(e);
			}
		});

		txtTienMat.setHorizontalAlignment(SwingConstants.LEFT);
		txtTienMat.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTienMat.setColumns(10);
		txtTienMat.setBounds(168, 505, 150, 22);
		add(txtTienMat);
		txtTienMat.setBorder(javax.swing.BorderFactory.createEmptyBorder());

		lbTongCong = new JLabel("");
		lbTongCong.setHorizontalAlignment(SwingConstants.LEFT);
		lbTongCong.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbTongCong.setBounds(168, 485, 150, 22);
		add(lbTongCong);

		lbTienThua = new JLabel("");
		lbTienThua.setHorizontalAlignment(SwingConstants.LEFT);
		lbTienThua.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbTienThua.setBounds(168, 525, 150, 22);
		add(lbTienThua);
		
		JPanel pnRefresh = new JPanel();
		pnRefresh.setName("pnRefresh");
		pnRefresh.addMouseListener(new PanelButtonMouseAdapter(pnRefresh));
		pnRefresh.setBounds(10, 485, 60, 60);
		add(pnRefresh);
		pnRefresh.setLayout(new BorderLayout(0, 0));
		
		JLabel lbRefresh = new JLabel("");
		lbRefresh.setIcon(new ImageIcon("picture/refresh.png"));
		pnRefresh.add(lbRefresh, BorderLayout.CENTER);
		
		setTiming();
		
	}

	private void cardChange() {
		cardLeft.show(pnLeft, "pnMenuKhongChucNang");
		cardRight.show(pnRight, "panel_2");
		//PnThanhToan pn = (PnThanhToan) pnCardRight;
		//JLabel lbJLabel = pn.getLbNhanVien();
		
		//NhanVien nhanVien = 
		//lbJLabel.setText();
	}

	private class PanelButtonMouseAdapter extends MouseAdapter {
		JPanel panel; // panel nhận sự kiện click

		public PanelButtonMouseAdapter(JPanel panel) {
			this.panel = panel;
		}

		@Override
		public void mousePressed(MouseEvent e) {
			if (panel.getName().compareTo("pnHuyBtn") == 0) {
				cardChange();
				renew();
			}
			if (panel.getName().compareTo("pnThanhToanBtn") == 0)
				pnThanhToanBtnClicked();
			if (panel.getName().compareTo("pnRefresh") == 0)
				renew();
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
			panel.setBackground(new Color(153, 153, 204));
			if (panel.getName().compareTo("pnRefresh") == 0)
				panel.setBackground(Color.WHITE);
		}
	}

	class JTableButtonMouseListener implements MouseListener {
		private JTable __table;

		private void __forwardEventToButton(MouseEvent e) {
			TableColumnModel columnModel = __table.getColumnModel();
			int column = columnModel.getColumnIndexAtX(e.getX());
			int row = e.getY() / __table.getRowHeight();
			Object value;
			JButton button;
			MouseEvent buttonEvent;

			if (row >= __table.getRowCount() || row < 0 || column >= __table.getColumnCount() || column < 0)
				return;

			value = __table.getValueAt(row, column);

			if (!(value instanceof JButton))
				return;

			button = (JButton) value;

			buttonEvent = (MouseEvent) SwingUtilities.convertMouseEvent(__table, e, button);
			button.dispatchEvent(buttonEvent);
			// This is necessary so that when a button is pressed and released
			// it gets rendered properly. Otherwise, the button may still appear
			// pressed down when it has been released.
			__table.repaint();
		}

		public JTableButtonMouseListener(JTable table) {
			__table = table;
		}

		public void mouseClicked(MouseEvent e) {
			__forwardEventToButton(e);
			plusMinus(e);
		}

		public void mouseEntered(MouseEvent e) {
			__forwardEventToButton(e);
		}

		public void mouseExited(MouseEvent e) {
			__forwardEventToButton(e);
		}

		public void mousePressed(MouseEvent e) {
			__forwardEventToButton(e);
		}

		public void mouseReleased(MouseEvent e) {
			__forwardEventToButton(e);
		}
		
		private void plusMinus(MouseEvent e) {
			TableColumnModel columnModel = __table.getColumnModel();
			int column = columnModel.getColumnIndexAtX(e.getX());
			int row = e.getY() / __table.getRowHeight();
			Object value;
			JButton button;

			if (row >= __table.getRowCount() || row < 0 || column >= __table.getColumnCount() || column < 0)
				return;

			value = __table.getValueAt(row, column);

			if (!(value instanceof JButton))
				return;

			button = (JButton) value;
			if (button.getText().compareTo("+") == 0) {
				int sl = Integer.parseInt(__table.getValueAt(row, 1).toString());
				Long giaTienTong = Long.parseLong(__table.getValueAt(row, 2).toString());
				Long giaTien = giaTienTong / sl;
				sl++;
				giaTienTong = giaTien * sl;
				__table.setValueAt(giaTienTong, row, 2);
				__table.setValueAt(sl, row, 1);
			} else {
				int sl = Integer.parseInt(__table.getValueAt(row, 1).toString());
				if (sl == 1) {
					JTableButtonModel model = (JTableButtonModel) __table.getModel();
					model.removeRow(row);
				}
				else {
					Long giaTienTong = Long.parseLong(__table.getValueAt(row, 2).toString());
					Long giaTien = giaTienTong / sl;
					sl--;
					giaTienTong = giaTien * sl;
					__table.setValueAt(giaTienTong, row, 2);
					__table.setValueAt(sl, row, 1);
				}
			}
			__table.repaint();
			tinhTong();
		}
		
	}
	
	private void tinhTong() {
		Long tong = (long) 0;
		for (int i = 0; i < table.getRowCount(); i++) {
			Long gia = Long.parseLong(table.getValueAt(i, 2).toString());
			tong += gia;
		}
		lbTongCong.setText(tong.toString());
	}
	
	@SuppressWarnings("unused")
	private void kiemTraTxt(JTextField txt) throws Exception {
		try {
			if (txt.getText().isBlank())
				throw new Exception("Vui lòng nhập đầy đủ thông tin");
			Double d = Double.parseDouble(txt.getText());
		} catch (NumberFormatException nfe) {
			throw new Exception("Vui lòng nhập số!");
		}
	}
	
	private void btnKiemTraClicked() {
		ObjectMapper mapper = new ObjectMapper();
		IpushMethodService service = new PushMethodService();
		
		KhachHang kh = null;
		try {
			kiemTraTxt(txtKhachHang);
			String httpStringKH = "http://localhost:8080/APISpring/api/khachhang/sdt/" + txtKhachHang.getText();
			kh = mapper.readValue(service.pushMethod(HttpConstant.HTTPREQUESTGET, httpStringKH, txtKhachHang.getText()), KhachHang.class);
			if (kh == null) {
				JOptionPane.showMessageDialog(this, "Không tìm thấy thông tin!");
				txtKhachHang.setText("");
			}
			else {
				txtKhachHang.setText(kh.getTenKH());
				khachHang = kh;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public JLabel getLbNhanVien() {
		return lbNhanVien;
	}

	public void setLbNhanVien(JLabel lbNhanVien) {
		this.lbNhanVien = lbNhanVien;
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
	
	@SuppressWarnings("unused")
	private void kiemTraChu(JTextField txt) throws Exception {
		try {
			if (txt.getText().isBlank() == false) {
				Double d = Double.parseDouble(txt.getText());
			}
		} catch (Exception e) {
			throw new Exception("Vui lòng nhập số!");
		}
	}
	
	private void pnThanhToanBtnClicked() {
		ObjectMapper mapper = new ObjectMapper();
		IpushMethodService service = new PushMethodService();
		
		try {
			kiemTraChu(txtTienMat);
			JTableButtonModel model = (JTableButtonModel) table.getModel();
			if (model.getRowCount() == 0)
				throw new Exception("Vui lòng chọn món ăn!");

			HoaDon hoaDon = HoaDonDAO.taoHoaDonMoi();
			hoaDon.setNhanVien(nhanVien);
			hoaDon.setNgayLap(new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(lbDateTime.getText()));
			hoaDon.setTongTien(Long.parseLong(lbTongCong.getText()));
			
			//nếu không có khách hàng thì tính tiền mặt, nếu có text khách hàng thì làm
//			if (txtKhachHang.getText().isBlank() == false) {
//				if (khachHang == null) {
//					//nếu khách hàng ban đầu chưa có thì set khách hàng
//					String httpStringKH = "http://localhost:8080/APISpring/api/khachhang/" + txtKhachHang.getText();
//					khachHang = mapper.readValue(service.pushMethod(HttpConstant.HTTPREQUESTGET, httpStringKH, txtKhachHang.getText()), KhachHang.class);
//					if (khachHang != null) {
//						//nếu đã có khách hàng thì set khách hàng
//						hoaDon.setKhachHang(khachHang);
//					}
//				} else {
//					//nếu đã có khách hàng thì set khách hàng
//					hoaDon.setKhachHang(khachHang);
//				}
//			}
			
			//nếu khách hàng dùng acc
			if (khachHang != null) {
				hoaDon.setKhachHang(khachHang);
				Long tien = Long.parseLong(lbTongCong.getText());
				if (khachHang.getTien() <= tien){
					throw new Exception("Tài khoản của khách hàng " + khachHang.getTenKH() + " không đủ tiền");
				} else {
					Long tien2 = khachHang.getTien() - tien;
					khachHang.setTien(tien2);
					service.pushMethod(HttpConstant.HTTPREQUESTPUT, "http://localhost:8080/APISpring/api/khachhang/", khachHang);
				}
			}
			
			HoaDonDAO.themHoaDon(hoaDon);
			List<Map<String, ?>> dataSource = new ArrayList<Map<String, ?>>();
			
			for (int i = 0; i < model.getRowCount(); i++) {
				String httpMA = "http://localhost:8080/APISpring/api/monan/name/" + URLEncoder.encode(model.getValueAt(i, 0).toString(), "UTF-8");
				MonAn monAn = mapper.readValue(service.pushMethod(HttpConstant.HTTPREQUESTGET, httpMA, null), MonAn.class);
				
				NguyenLieu nguyenLieu = monAn.getNguyenLieu();
				if (nguyenLieu.getSoLuong() - Integer.parseInt(model.getValueAt(i, 1).toString()) < 0)
					throw new Exception("Món " + monAn.getTenMA() + " đã hết!");
				
				nguyenLieu.setSoLuong(nguyenLieu.getSoLuong() - Integer.parseInt(model.getValueAt(i, 1).toString()));
				service.pushMethod(HttpConstant.HTTPREQUESTPUT, "http://localhost:8080/APISpring/api/nguyenlieu", nguyenLieu);
				
				CTHoaDon ctHoaDon = new CTHoaDon();
				ctHoaDon.setHoaDon(hoaDon);
				ctHoaDon.setMonAn(monAn);
				ctHoaDon.setSoLuong(Integer.parseInt(model.getValueAt(i, 1).toString()));
				CTHoaDonDAO.themHoaDon(ctHoaDon);
				
				Map<String, Object> field = new HashMap<String, Object>(); // xu li report
				
				field.put("monAn", ctHoaDon.getMonAn().getTenMA());
				field.put("soTien", ctHoaDon.getMonAn().getLoaiMonAn().getGiaTien());
				field.put("soLuong", ctHoaDon.getSoLuong());
				
				dataSource.add(field);

			}
			Map<String, Object> param = new HashMap<String, Object>();
			
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			Date date = formatter.parse(lbDateTime.getText());
			
			param.put("maHD", hoaDon.getMaHD());
			param.put("nhanVien", nhanVien.getTenNV());
			param.put("khachHang", (khachHang == null ? "" : khachHang.getTenKH()));
			param.put("ngay", date);
			param.put("tongTien", Long.parseLong(lbTongCong.getText()));
			param.put("tienMat", (txtTienMat.getText().isBlank() == false ? Long.parseLong(txtTienMat.getText()) : null));
			param.put("tienThua", (lbTienThua.getText().isBlank() == false ? Long.parseLong(lbTienThua.getText()) : null));	
			
			model.setRowCount(0);	//khi da xong moi thu thi xoa bang
			
			JRDataSource jrDataSource = new JRBeanCollectionDataSource(dataSource);
			String sourceName = "src/main/java/view/RpThanhToan.jrxml";
			JasperReport report = JasperCompileManager.compileReport(sourceName);
			JasperPrint filledReport = JasperFillManager.fillReport(report, param, jrDataSource);
			
			/*FrameThanhToan frameThanhToan = new FrameThanhToan();
			JPanel pnRp = frameThanhToan.getContentPane();
			
			pnRp.add(new JRViewer(filledReport));
			frameThanhToan.setContentPane(pnRp);
			frameThanhToan.setVisible(true);
			frameThanhToan.pack();*/
			JasperViewer jViewer = new JasperViewer(filledReport, false);
			jViewer.setVisible(true);
			
			khachHang = null; //reset khach hang
			txtKhachHang.setText("");
			
			PnMenu mn = new PnMenu(this);
			if (pnQLOrNV instanceof PnNhanVien) {
				PnNhanVien pn = (PnNhanVien) pnQLOrNV;
				JPanel pnLeftFromTheOutside = pn.getPnLeft();
				pnLeftFromTheOutside.remove(mn);
				pnLeftFromTheOutside.add(mn, "pnMenu");
				CardLayout cl = pn.getCardLeft();
				cl.show(pnLeftFromTheOutside, "pnMenu");
			} else {
				PnQuanLy pn = (PnQuanLy) pnQLOrNV;
				JPanel pnLeftFromTheOutside = pn.getPnCardLeft();
				pnLeftFromTheOutside.remove(mn);
				pnLeftFromTheOutside.add(mn, "pnMenu");
				CardLayout cl = pn.getCardLeft();
				cl.show(pnLeftFromTheOutside, "pnMenu");
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
			e.printStackTrace();
		}
	}
	
	private void renew() {
		JTableButtonModel model = (JTableButtonModel) table.getModel();
		model.setRowCount(0);
		
		lbTongCong.setText("");
		txtTienMat.setText("");
		lbTienThua.setText("");
		txtKhachHang.setText("");
		
		khachHang = null;
	}
	
	private void txtTienMatEnter(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (txtTienMat.getText().isBlank() == false) {
				Long tong = Long.parseLong(lbTongCong.getText());
				Long tien = Long.parseLong(txtTienMat.getText());
				Long tienThua = tien - tong;
				lbTienThua.setText(tienThua.toString());
			}
		}
	}
}
