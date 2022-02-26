package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.lgooddatepicker.components.DatePicker;

import DAO.BangChamCongDAO;
import DAO.NhanVienDAO;
import constant.HttpConstant;
import entities.BangChamCong;
import entities.NhanVien;
import service.IpushMethodService;
import service.impl.PushMethodService;
import table.JTableUnEdit;


public class PnTinhLuong extends JPanel {
	private static final long serialVersionUID = 1L;

	private JTable table;
	private int status;
	
	private DatePicker datePickerTuNgay;
	private DatePicker datePickerDenNgay;
	private JTextField txtMaNV;
	private JTextField txtTienMotGio;
	public PnTinhLuong() {
		setBounds(0, 0, 560, 600);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 204, 204));
		add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("Tính lương");
		lblNewLabel.setForeground(Color.YELLOW);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		panel.add(lblNewLabel);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(51, 204, 204));
		datePickerTuNgay = new DatePicker();
		datePickerTuNgay.getComponentDateTextField().setFont(new Font("Tahoma", Font.PLAIN, 14));
		datePickerTuNgay.getComponentDateTextField().setEditable(false);
		datePickerDenNgay = new DatePicker();
		datePickerDenNgay.getComponentDateTextField().setFont(new Font("Tahoma", Font.PLAIN, 14));
		datePickerDenNgay.getComponentDateTextField().setEditable(false);
		panel_3.add(datePickerTuNgay);
		
		JLabel lblNewLabel_1 = new JLabel("   ~~   ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_3.add(lblNewLabel_1);
		panel_3.add(datePickerDenNgay);
		add(panel_3);
		
		JPanel panel_1 = new JPanel();
		add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable(new JTableUnEdit(new Object[] {"Mã", "Tên", "TG bắt đầu", "TG kết thúc"}, 0));
		scrollPane.setViewportView(table);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(51, 204, 204));
		FlowLayout flowLayout_1 = (FlowLayout) panel_4.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		add(panel_4);
		
		JLabel lblNewLabel_2_1 = new JLabel("Số tiền một giờ");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_4.add(lblNewLabel_2_1);
		
		txtTienMotGio = new JTextField();
		txtTienMotGio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTienMotGio.setColumns(10);
		panel_4.add(txtTienMotGio);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(51, 204, 204));
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		add(panel_2);
		
		JButton btnXem = new JButton("   Xem   ");
		btnXem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnXemClicked();
			}
		});
		
		JButton btnTinhTien = new JButton("Tính lương");
		btnTinhTien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					btnTinhTienClicked();
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		JLabel lblNewLabel_2 = new JLabel("Mã nhân viên   ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_2.add(lblNewLabel_2);
		
		txtMaNV = new JTextField();
		txtMaNV.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_2.add(txtMaNV);
		txtMaNV.setColumns(10);
		btnTinhTien.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_2.add(btnTinhTien);
		btnXem.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_2.add(btnXem);
	}
	
	private void btnXemClicked() {
		IpushMethodService service = new PushMethodService();
		ObjectMapper mapper = new ObjectMapper();
		try {
			JTableUnEdit model = (JTableUnEdit) table.getModel();
			model.setRowCount(0);
			if (datePickerTuNgay.getComponentDateTextField().getText().isBlank() == true || datePickerDenNgay.getComponentDateTextField().getText().isBlank() == true) {
				List<BangChamCong> list = BangChamCongDAO.layDanhSachBangChamCong();
				
				for (BangChamCong h : list) {
					model.addRow(new Object[] {
						h.getNhanVien().getMaNV(),
						h.getNhanVien().getTenNV(),
						h.getBatDau(),
						h.getKetThuc()
					});
				}
				status = 0;
			} else if (!txtMaNV.getText().isBlank()) {
				NhanVien nhanVien = NhanVienDAO.layThongTinNhanVien(txtMaNV.getText());
				if (nhanVien == null)
					throw new Exception("Không tìm thấy nhân viên");
				SimpleDateFormat formatter = new SimpleDateFormat("MMMMM dd, yyyy HH:mm:ss");
				Date tuNgay = formatter.parse(datePickerTuNgay.getComponentDateTextField().getText() + " 23:59:59");
				Date denNgay = formatter.parse(datePickerDenNgay.getComponentDateTextField().getText() + " 23:59:59");

				List<BangChamCong> list = BangChamCongDAO.layDanhSachBangChamCongTheoNgay(tuNgay, denNgay);
						for (BangChamCong h : list) {
					model.addRow(new Object[] {
							h.getNhanVien().getMaNV(),
							h.getNhanVien().getTenNV(),
							h.getBatDau(),
							h.getKetThuc()
					});
				}
				status = 1;
			} else {
				SimpleDateFormat formatter = new SimpleDateFormat("MMMMM dd, yyyy HH:mm:ss");
				Date tuNgay = formatter.parse(datePickerTuNgay.getComponentDateTextField().getText() + " 23:59:59");
				Date denNgay = formatter.parse(datePickerDenNgay.getComponentDateTextField().getText() + " 23:59:59");
				
				List<BangChamCong> list = BangChamCongDAO.layDanhSachBangChamCongTheoNgay(tuNgay, denNgay);
						for (BangChamCong h : list) {
					model.addRow(new Object[] {
							h.getNhanVien().getMaNV(),
							h.getNhanVien().getTenNV(),
							h.getBatDau(),
							h.getKetThuc()
					});
				}
				status = 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, e.getMessage());
			status = 0;
		}
	}
	
	private void btnTinhTienClicked() throws ParseException {
		try {
			if (txtMaNV.getText().isBlank())
				throw new Exception("Vui lòng nhập mã nhân viên để tính lương!");
			if (table.getRowCount() == 0 || status == 0)
				throw new Exception("Vui lòng nhập mã nhân viên, chọn ngày và bấm xem!");
			if (txtTienMotGio.getText().isBlank())
				throw new Exception("Vui lòng nhập số tiền để tính!");
			if (!isNumber(txtTienMotGio.getText()))
				throw new Exception("Tiền không hợp lệ!");
			Double hour = 0d;
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			for (int i = 0; i < table.getRowCount(); i++) {
				Date date1 = format.parse(table.getValueAt(i, 2).toString());
				Date date2 = format.parse(table.getValueAt(i, 3).toString());
				hour += getDateDiff(date1, date2, TimeUnit.HOURS);
			}
			Double tien = Double.parseDouble(txtTienMotGio.getText());
			tien = tien * hour;
			JOptionPane.showMessageDialog(this, "Tổng giờ làm: " + hour + "\nTiền lương của nhân viên: " + tien);
			
		} catch (ParseException e) {
			SimpleDateFormat format = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
			Double hour = 0d;
			for (int i = 0; i < table.getRowCount(); i++) {
				Date date1 = format.parse(table.getValueAt(i, 2).toString());
				Date date2 = format.parse(table.getValueAt(i, 3).toString());
				hour += getDateDiff(date1, date2, TimeUnit.HOURS);
			}
			Double tien = Double.parseDouble(txtTienMotGio.getText());
			tien = tien * hour;
			JOptionPane.showMessageDialog(this, "Tổng giờ làm: " + hour + "\nTiền lương của nhân viên: " + tien);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
			e.printStackTrace();
		}
	}
	public static double getDateDiff(Date date1, Date date2, TimeUnit timeUnit) {
	    long diffInMillies = date2.getTime() - date1.getTime();
	    return timeUnit.convert(diffInMillies,TimeUnit.MILLISECONDS);
	}
	@SuppressWarnings("unused")
	private boolean isNumber(String txt) {
		try {
			Double d = Double.parseDouble(txt);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
