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
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

import com.github.lgooddatepicker.components.DatePicker;

import DAO.BangChamCongDAO;
import DAO.NhanVienDAO;
import entities.BangChamCong;
import entities.NhanVien;
import table.JTableUnEdit;
import javax.swing.JTextField;

public class PnChamCong extends JPanel {

	/**
	 * Create the panel.
	 */
	private JTable table;
	private JLabel lbDateTime;
	private JTextField txtMaNV;

	public PnChamCong() {
		setBounds(0, 0, 560, 600);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblNewLabel = new JLabel("Chấm công");
		lblNewLabel.setForeground(Color.ORANGE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel.add(lblNewLabel);

		JPanel panel_3 = new JPanel();
		add(panel_3);
		
		lbDateTime = new JLabel("");
		panel_3.add(lbDateTime);

		JPanel panel_1 = new JPanel();
		add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, BorderLayout.CENTER);

		table = new JTable(new JTableUnEdit(new Object[] { "Mã", "Tên", "TG bắt đầu", "TG kết thúc" }, 0));
		scrollPane.setViewportView(table);

		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		add(panel_2);

		JButton btnKetThuc = new JButton("Kết thúc");
		btnKetThuc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnKetThucClicked();
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("Mã nhân viên");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_2.add(lblNewLabel_1);
		
		txtMaNV = new JTextField();
		txtMaNV.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_2.add(txtMaNV);
		txtMaNV.setColumns(10);

		JButton btnBatDau = new JButton("Bắt đầu");
		btnBatDau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnBatDauClicked();
			}
		});
		btnBatDau.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_2.add(btnBatDau);
		btnKetThuc.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_2.add(btnKetThuc);
		
		loadTable();
		
		setTiming();
	}

	
	private void btnBatDauClicked() {
		try {
			if (txtMaNV.getText().compareTo("") == 0)
				throw new Exception("Vui lòng nhập mã nhân viên để chấm công!");
			NhanVien nhanVien = NhanVienDAO.layThongTinNhanVien(txtMaNV.getText());
			if (nhanVien == null)
				throw new Exception("Không tìm thấy mã nhân viên");
			BangChamCong bcc = BangChamCongDAO.layThongTinBCCTheoMaNV(txtMaNV.getText());
			if (bcc != null)
				if (bcc.getKetThuc() == null)
					throw new Exception("Nhân viên này chưa kết thúc ca làm!");
			SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			Date batDau = format.parse(lbDateTime.getText());
			BangChamCong bangChamCong = new BangChamCong();
			bangChamCong.setBatDau(batDau);
			bangChamCong.setNhanVien(nhanVien);
			BangChamCongDAO.themBCC(bangChamCong);
			
			JTableUnEdit model = (JTableUnEdit) table.getModel();
			model.addRow(new Object[] {
				nhanVien.getMaNV(),
				nhanVien.getTenNV(),
				bangChamCong.getBatDau(),
			});
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, e.getMessage());
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
	
	private void loadTable() {
		JTableUnEdit model = (JTableUnEdit) table.getModel();
		model.setRowCount(0);
		List<BangChamCong> list = BangChamCongDAO.layDanhSachBangChamCong();
		for (BangChamCong bcc : list) {
			model.addRow(new Object[] {
				bcc.getNhanVien().getMaNV(),
				bcc.getNhanVien().getTenNV(),
				bcc.getBatDau(),
				bcc.getKetThuc()
			});
		}
	}
	private void btnKetThucClicked() {
		try {
			if (txtMaNV.getText().compareTo("") == 0)
				throw new Exception("Vui lòng nhập mã nhân viên để chấm công!");
			NhanVien nhanVien = NhanVienDAO.layThongTinNhanVien(txtMaNV.getText());
			if (nhanVien == null)
				throw new Exception("Không tìm thấy mã nhân viên");
			BangChamCong bcc = BangChamCongDAO.layThongTinBCCTheoMaNV(txtMaNV.getText());
			if (bcc != null)
				if (bcc.getBatDau() == null)
					throw new Exception("Nhân viên này chưa bắt đầu ca làm!");
				else if (bcc.getKetThuc() != null)
					throw new Exception("Nhân viên này chưa có ca làm nào để kết thúc!");
			SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			Date ketThuc = format.parse(lbDateTime.getText());
			bcc.setKetThuc(ketThuc);
			BangChamCongDAO.suaBCC(bcc);
			
			loadTable();
			
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}
}
