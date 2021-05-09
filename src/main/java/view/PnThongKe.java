package view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.github.lgooddatepicker.components.DatePicker;

import DAO.HoaDonDAO;
import entities.HoaDon;
import entities.NhanVien;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

public class PnThongKe extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private DatePicker datePickerTuNgay;
	private DatePicker datePickerDenNgay;
	private Image image;
	private Image scaledImage;

	private NhanVien nhanVien;

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien (NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}
	
	public PnThongKe() {
		setBounds(0, 0, 560, 600);
		setLayout(null);
		try {
			image = ImageIO.read(new File("picture\\main.png"));
			scaledImage = image.getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 560, 43);
		panel.setBackground(new Color(51, 204, 204));
		add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("Thống kê");
		lblNewLabel.setForeground(Color.YELLOW);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		panel.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 43, 560, 43);
		panel_2.setBackground(new Color(51, 204, 204));
		datePickerTuNgay = new DatePicker();
		datePickerTuNgay.getComponentToggleCalendarButton().setFont(new Font("Tahoma", Font.PLAIN, 14));
		datePickerTuNgay.getComponentDateTextField().setFont(new Font("Tahoma", Font.PLAIN, 14));
		datePickerTuNgay.getComponentDateTextField().setEditable(false);
		datePickerDenNgay = new DatePicker();
		datePickerDenNgay.getComponentToggleCalendarButton().setFont(new Font("Tahoma", Font.PLAIN, 14));
		datePickerDenNgay.getComponentDateTextField().setFont(new Font("Tahoma", Font.PLAIN, 14));
		datePickerDenNgay.getComponentDateTextField().setEditable(false);
		panel_2.add(datePickerTuNgay);
		
		JLabel lblNewLabel_1 = new JLabel("   ~~   ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_2.add(lblNewLabel_1);
		panel_2.add(datePickerDenNgay);
		add(panel_2);
		
		JButton btnXacNhan = new JButton("Xác nhận");
		btnXacNhan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnXacNhanClicked();
			}
		});
		btnXacNhan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_2.add(btnXacNhan);
		
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(scaledImage, 0, 0, this);
	}

	private void btnXacNhanClicked() {
		try {
			List<Map<String, ?>> dataSource = new ArrayList<Map<String, ?>>();

			SimpleDateFormat formatter = new SimpleDateFormat("MMMMM dd, yyyy HH:mm:ss");
			Date tuNgay = formatter.parse(datePickerTuNgay.getComponentDateTextField().getText() + " 23:59:59");
			Date denNgay = formatter.parse(datePickerDenNgay.getComponentDateTextField().getText() + " 23:59:59");
			List<HoaDon> list = HoaDonDAO.layDanhSacHoaDonTheoNgay(tuNgay, denNgay);
			for (HoaDon hoaDon : list) {	
				Map<String, Object> field = new HashMap<String, Object>();
				field.put("maHD", hoaDon.getMaHD());
				field.put("ngayLap", hoaDon.getNgayLap());
				field.put("tongTien", hoaDon.getTongTien());
					
				dataSource.add(field);
			}
			Map<String, Object> param = new HashMap<String, Object>();
			
			Date date = new Date();
			SimpleDateFormat formatter2 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			String tuNgayString = formatter2.format(tuNgay);
			tuNgay = formatter2.parse(tuNgayString);
			
			String denNgayString = formatter2.format(denNgay);
			denNgay = formatter2.parse(denNgayString);
			
			param.put("nhanVien", nhanVien.getTenNV());
			param.put("ngayLapBangThongKe", date);
			param.put("tuNgay", tuNgay);
			param.put("denNgay", denNgay);
			
			JRDataSource jrDataSource = new JRBeanCollectionDataSource(dataSource);
			String sourceName = "src/main/java/view/RpThongKe.jrxml";
			JasperReport report = JasperCompileManager.compileReport(sourceName);
			JasperPrint filledReport = JasperFillManager.fillReport(report, param, jrDataSource);
			
			JasperViewer jViewer = new JasperViewer(filledReport, false);
			jViewer.setVisible(true);
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
			e.printStackTrace();
		}
	}
}
