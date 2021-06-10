package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import constant.HttpConstant;
import entities.KhachHang;
import service.IpushMethodService;
import service.impl.PushMethodService;

public class PnThongTinKhachHang extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JTable table;
	private JTextField txtMaKH;
	private JTextField txtTenKH;
	private JTextField txtNamSinh;
	private JTextField txtSdt;
	private JTextField txtTimThay;
	private JRadioButton rdBtnSinhVien;
	private JRadioButton rdBtnGiangVien;
	private JRadioButton rdBtnNVVP;
	private JRadioButton rdBtnNam;
	private JRadioButton rdBtnNu;
	
	private ButtonGroup btnGroupLoai;
	private ButtonGroup btnGroupGioiTinh;
	private JLabel lblNewLabel_2;
	/**
	 * Create the panel.
	 */
	public PnThongTinKhachHang() {
		setBackground(new Color(51, 204, 204));
		setBounds(0, 0, 560, 600);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 204, 204));
		panel.setBounds(0, 0, 560, 300);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Loại khách:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 55, 120, 25);
		panel.add(lblNewLabel);
		
		rdBtnGiangVien = new JRadioButton("Giảng Viên");
		rdBtnGiangVien.setContentAreaFilled(false);
		rdBtnGiangVien.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdBtnGiangVien.setBounds(250, 55, 109, 25);
		panel.add(rdBtnGiangVien);
		
		rdBtnSinhVien = new JRadioButton("Sinh Viên");
		rdBtnSinhVien.setContentAreaFilled(false);
		rdBtnSinhVien.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdBtnSinhVien.setBounds(130, 55, 109, 25);
		panel.add(rdBtnSinhVien);
		
		JLabel lblMKh = new JLabel("Mã KH:");
		lblMKh.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMKh.setBounds(10, 90, 120, 25);
		panel.add(lblMKh);
		
		JLabel lblTnKh = new JLabel("Tên KH:");
		lblTnKh.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTnKh.setBounds(10, 125, 120, 25);
		panel.add(lblTnKh);
		
		JLabel lblSinThoi = new JLabel("Số điện thoại:");
		lblSinThoi.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSinThoi.setBounds(10, 230, 120, 25);
		panel.add(lblSinThoi);
		
		JLabel lblNgySinh = new JLabel("Năm sinh:");
		lblNgySinh.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNgySinh.setBounds(10, 195, 120, 25);
		panel.add(lblNgySinh);
		
		rdBtnNVVP = new JRadioButton("Nhân viên văn phòng");
		rdBtnNVVP.setContentAreaFilled(false);
		rdBtnNVVP.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdBtnNVVP.setBounds(370, 55, 180, 25);
		panel.add(rdBtnNVVP);
		
		JLabel lblNewLabel_1_1 = new JLabel("Giới tính:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(10, 160, 120, 25);
		panel.add(lblNewLabel_1_1);
		
		txtMaKH = new JTextField();
		txtMaKH.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMaKH.setBounds(130, 90, 109, 25);
		panel.add(txtMaKH);
		txtMaKH.setColumns(10);
		
		txtTenKH = new JTextField();
		txtTenKH.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTenKH.setColumns(10);
		txtTenKH.setBounds(130, 125, 300, 25);
		panel.add(txtTenKH);
		
		txtNamSinh = new JTextField();
		txtNamSinh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNamSinh.setColumns(10);
		txtNamSinh.setBounds(130, 195, 109, 25);
		panel.add(txtNamSinh);
		
		txtSdt = new JTextField();
		txtSdt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSdt.setColumns(10);
		txtSdt.setBounds(130, 230, 109, 25);
		panel.add(txtSdt);
		
		rdBtnNam = new JRadioButton("Nam");
		rdBtnNam.setContentAreaFilled(false);
		rdBtnNam.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdBtnNam.setBounds(130, 160, 67, 25);
		panel.add(rdBtnNam);
		
		rdBtnNu = new JRadioButton("Nữ");
		rdBtnNu.setContentAreaFilled(false);
		rdBtnNu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdBtnNu.setBounds(250, 160, 109, 25);
		panel.add(rdBtnNu);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 300, 560, 250);
		add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Tahoma", Font.PLAIN, 11));
		panel_1.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable(new DefaultTableModel(new Object[] {"Mã", "Tên", "Loại", "Giới tính", "SĐT", "Năm sinh", "Tiền"}, 0));
		table.setFont(new Font("Tahoma", Font.PLAIN, 11));
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_1 = new JLabel("Tìm thấy:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_1.setBounds(379, 560, 87, 20);
		add(lblNewLabel_1);
		
		txtTimThay = new JTextField();
		txtTimThay.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTimThay.setEditable(false);
		txtTimThay.setBounds(470, 560, 50, 25);
		add(txtTimThay);
		txtTimThay.setColumns(10);
		
		btnGroupLoai = new ButtonGroup();
		btnGroupLoai.add(rdBtnGiangVien);
		btnGroupLoai.add(rdBtnSinhVien);
		btnGroupLoai.add(rdBtnNVVP);
		
		btnGroupGioiTinh = new ButtonGroup();
		btnGroupGioiTinh.add(rdBtnNam);
		btnGroupGioiTinh.add(rdBtnNu);
		
		JButton btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timKhachHang();
			}
		});
		btnTimKiem.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnTimKiem.setBounds(401, 254, 134, 35);
		panel.add(btnTimKiem);
		
		lblNewLabel_2 = new JLabel("Thông tin khách hàng");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_2.setForeground(Color.YELLOW);
		lblNewLabel_2.setBounds(140, 10, 280, 40);
		panel.add(lblNewLabel_2);
	}
	
	private List<KhachHang> loadData(){
		ObjectMapper mapper = new ObjectMapper();
		IpushMethodService method = new PushMethodService();
		
		List<KhachHang> list = null;
		try {
			list = mapper.readValue(method.pushMethod(HttpConstant.HTTPREQUESTGET, "http://localhost:8080/APISpring/api/khachhang", null), new TypeReference<List<KhachHang>>() {
			});
		} catch(Exception ex) {
			list = null;
		}
		Iterator<KhachHang> iterator = list.iterator();
		//tim theo ma
		String rdBtnLoai = "";
		if (rdBtnSinhVien.isSelected()) {
			rdBtnLoai = rdBtnSinhVien.getText();
		}
		else if (rdBtnGiangVien.isSelected()) {
			rdBtnLoai = rdBtnGiangVien.getText();
		}
		else if (rdBtnNVVP.isSelected()) {
			rdBtnLoai = rdBtnNVVP.getText();
		}
		
		if (rdBtnLoai.compareTo("") != 0) {
			while(iterator.hasNext()) {
				KhachHang h = iterator.next();
				if (h.getLoaiKhachHang().getTenLoaiKH().compareTo(rdBtnLoai) != 0)
					iterator.remove();
			}
		}
		//tim theo ma
		iterator = list.iterator();
		if (txtMaKH.getText().compareTo("") != 0) {
			while(iterator.hasNext()) {
				KhachHang h = iterator.next();
				if (h.getMaKH().toLowerCase().contains(txtMaKH.getText())!= true)
					iterator.remove();
			}
		}
		//tim theo ten
		iterator = list.iterator();
		if (txtTenKH.getText().compareTo("") != 0) {
			while(iterator.hasNext()) {
				KhachHang h = iterator.next();
				if (h.getTenKH().toLowerCase().contains(txtTenKH.getText()) != true)
					iterator.remove();
			}
		}
		//tim theo gt
		iterator = list.iterator();//reset iterator
		String rdBtnGT = "";
		if (rdBtnNam.isSelected()) {
			rdBtnGT = rdBtnNam.getText();
		}
		if (rdBtnNu.isSelected()) {
			rdBtnGT = rdBtnNu.getText();
		}
		
		if (rdBtnGT.compareTo("") != 0) {
			while(iterator.hasNext()) {
				KhachHang h = iterator.next();
				if (h.getGioiTinh().compareTo(rdBtnGT) != 0)
					iterator.remove();
			}
		}
		//tim theo nam sinh
		iterator = list.iterator(); 
		
		if (txtNamSinh.getText().compareTo("") != 0) {
			while(iterator.hasNext()) {
				KhachHang h = iterator.next();
				if (h.getNamSinh() != Integer.parseInt(txtNamSinh.getText()))
					iterator.remove();
			}
		}
		//tim theo sdt
		iterator = list.iterator(); 
		
		if(txtSdt.getText().compareTo("") != 0) {
			while(iterator.hasNext()) {
				KhachHang h = iterator.next();
				if (h.getSdt() != Long.parseLong(txtSdt.getText()))
					iterator.remove();
			}
		}
		return list;
	}
	
	private void timKhachHang() {
		List<KhachHang> list = loadData();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		for (KhachHang h : list) {
			model.addRow(new Object[] {
				h.getMaKH(),
				h.getTenKH(),
				h.getLoaiKhachHang().getTenLoaiKH(),
				h.getGioiTinh(),
				h.getSdt(),
				h.getNamSinh(),
				h.getTien()
			});
		}
		txtTimThay.setText(list.size()+"");
		txtMaKH.setText("");
		txtTenKH.setText("");
		txtNamSinh.setText("");
		txtSdt.setText("");
		btnGroupGioiTinh.clearSelection();
		btnGroupLoai.clearSelection();
	}
}
