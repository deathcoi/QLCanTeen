package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.lgooddatepicker.components.DatePicker;

import constant.HttpConstant;
import entities.HoaDon;
import service.IpushMethodService;
import service.impl.PushMethodService;
import table.JTableUnEdit;

public class PnLichSuHoaDon extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JTable table;

	private DatePicker datePickerTuNgay;
	private DatePicker datePickerDenNgay;
	public PnLichSuHoaDon() {
		setBounds(0, 0, 560, 600);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 204, 204));
		add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("Lịch sử hóa đơn");
		lblNewLabel.setForeground(Color.YELLOW);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		panel.add(lblNewLabel);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(51, 204, 204));
		datePickerTuNgay = new DatePicker();
		datePickerTuNgay.getComponentDateTextField().setEditable(false);
		datePickerDenNgay = new DatePicker();
		datePickerDenNgay.getComponentDateTextField().setEditable(false);
		panel_3.add(datePickerTuNgay);
		
		JLabel lblNewLabel_1 = new JLabel("   ~~   ");
		panel_3.add(lblNewLabel_1);
		panel_3.add(datePickerDenNgay);
		add(panel_3);
		
		JPanel panel_1 = new JPanel();
		add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable(new JTableUnEdit(new Object[] {"Mã hóa đơn", "Nhân viên", "Khách hàng", "Ngày lập", "Tổng tiền"}, 0));
		scrollPane.setViewportView(table);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(51, 204, 204));
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		add(panel_2);
		
		JButton btnXem = new JButton("   Xem   ");
		btnXem.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				btnXemClicked();
				
			}
		});
		
		JButton btnXemChiTiet = new JButton("Xem chi tiết");
		btnXemChiTiet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnXemChiTietClicked();
			}
		});
		btnXemChiTiet.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_2.add(btnXemChiTiet);
		btnXem.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_2.add(btnXem);
	}
	
	private void btnXemClicked() {
		try {
			ObjectMapper mapper = new ObjectMapper();
			IpushMethodService service = new PushMethodService();
			
			JTableUnEdit model = (JTableUnEdit) table.getModel();
			model.setRowCount(0);
			if (datePickerTuNgay.getComponentDateTextField().getText().isBlank() == true || datePickerDenNgay.getComponentDateTextField().getText().isBlank() == true) {
				List<HoaDon> list = mapper.readValue(service.pushMethod(HttpConstant.HTTPREQUESTGET, "http://localhost:8080/APISpring/api/hoadon", null), new TypeReference<List<HoaDon>>() {});
				for (HoaDon h : list) {
					model.addRow(new Object[] {
							h.getMaHD(),
							h.getNhanVien().getTenNV(),
							(h.getKhachHang() != null ? h.getKhachHang().getTenKH() : "null"),
							h.getNgayLap(),
							h.getTongTien()
					});
				}
			} else {
				SimpleDateFormat formatter = new SimpleDateFormat("MMMMM dd, yyyy HH:mm:ss");
				Date tuNgay = formatter.parse(datePickerTuNgay.getComponentDateTextField().getText() + " 00:00:00");
				Date denNgay = formatter.parse(datePickerDenNgay.getComponentDateTextField().getText() + " 23:59:59");
				//JOptionPane.showMessageDialog(this, tuNgay.toString());
				//formatter.format(date)
				
				String url = "http://localhost:8080/APISpring/api/hoadon/date/" + mapper.writeValueAsString(tuNgay) + "/" + mapper.writeValueAsString(denNgay);
				
				List<HoaDon> list = mapper.readValue(service.pushMethod(HttpConstant.HTTPREQUESTGET, url, null), new TypeReference<List<HoaDon>>() {});
				for (HoaDon h : list) {
					model.addRow(new Object[] {
							h.getMaHD(),
							h.getNhanVien().getTenNV(),
							(h.getKhachHang() != null ? h.getKhachHang().getTenKH() : "null"),
							h.getNgayLap(),
							h.getTongTien()
					});
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void btnXemChiTietClicked() {
		try {
			ObjectMapper mapper = new ObjectMapper();
			IpushMethodService service = new PushMethodService();
			
			if (table.getSelectedRow() != -1) {
				String url = "http://localhost:8080/APISpring/api/hoadon/id/" + (String) table.getValueAt(table.getSelectedRow(), 0);
				HoaDon hoaDon = mapper.readValue(service.pushMethod(HttpConstant.HTTPREQUESTGET, url, null), HoaDon.class);

				FrameCTHoaDon frameCTHoaDon = new FrameCTHoaDon(hoaDon); 
				frameCTHoaDon.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn một dòng để xem chi tiết!");
			}
		} catch (Exception e) {
			e.printStackTrace();	
		}
		
	}
}
