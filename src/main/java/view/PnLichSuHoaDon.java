package view;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.github.lgooddatepicker.components.DatePicker;

import DAO.CTHoaDonDAO;
import DAO.HoaDonDAO;
import entities.CTHoaDon;
import entities.HoaDon;
import java.awt.ComponentOrientation;

public class PnLichSuHoaDon extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 * 
	 */
	private DatePicker datePickerTuNgay;
	private DatePicker datePickerDenNgay;
	public PnLichSuHoaDon() {
		setBounds(0, 0, 560, 500);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("Lịch sử hóa đơn");
		lblNewLabel.setForeground(Color.ORANGE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel.add(lblNewLabel);
		
		JPanel panel_3 = new JPanel();
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
		btnXemChiTiet.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_2.add(btnXemChiTiet);
		btnXem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_2.add(btnXem);
	}
	
	private void btnXemClicked() {
		try {
			JTableUnEdit model = (JTableUnEdit) table.getModel();
			model.setRowCount(0);
			if (datePickerTuNgay.getComponentDateTextField().getText().isBlank() == true || datePickerDenNgay.getComponentDateTextField().getText().isBlank() == true) {
				List<HoaDon> list = HoaDonDAO.layDanhSacHoaDon();
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
				Date tuNgay = formatter.parse(datePickerTuNgay.getComponentDateTextField().getText() + " 23:59:59");
				Date denNgay = formatter.parse(datePickerDenNgay.getComponentDateTextField().getText() + " 23:59:59");
				//JOptionPane.showMessageDialog(this, tuNgay.toString());
				//formatter.format(date)
				List<HoaDon> list = HoaDonDAO.layDanhSacHoaDonTheoNgay(tuNgay, denNgay);
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
	
	private class JTableUnEdit extends DefaultTableModel {
		public JTableUnEdit(Object[] objects, int i) {
			super(objects, i);
		}

		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}
	}
	
	private void btnXemChiTietClicked() {
		// model = (DefaultTableModel) table.getModel();
		if (table.getSelectedRow() != -1) {
			HoaDon hoaDon = HoaDonDAO.layThongTinHoaDon((String) table.getValueAt(table.getSelectedRow(), 0));
			FrameCTHoaDon frameCTHoaDon = new FrameCTHoaDon(hoaDon); 
			frameCTHoaDon.setVisible(true);
		} else {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn một dòng để xem chi tiết!");
		}
	}
}
