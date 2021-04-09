package view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.hibernate.Session;
import org.hibernate.query.Query;

import DAO.KhachHangDAO;
import DAO.NguyenLieuDAO;
import Utils.HibernateUtil;
import entities.KhachHang;
import entities.NguyenLieu;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PnThongTinKhachHang extends JPanel {
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
	/**
	 * Create the panel.
	 */
	public PnThongTinKhachHang() {
		setBounds(0, 0, 560, 600);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 560, 260);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Loại khách:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 10, 80, 20);
		panel.add(lblNewLabel);
		
		rdBtnGiangVien = new JRadioButton("Giảng Viên");
		rdBtnGiangVien.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdBtnGiangVien.setBounds(249, 10, 109, 20);
		panel.add(rdBtnGiangVien);
		
		rdBtnSinhVien = new JRadioButton("Sinh Viên");
		rdBtnSinhVien.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdBtnSinhVien.setBounds(120, 10, 109, 20);
		panel.add(rdBtnSinhVien);
		
		JLabel lblMKh = new JLabel("Mã KH:");
		lblMKh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMKh.setBounds(10, 50, 80, 20);
		panel.add(lblMKh);
		
		JLabel lblTnKh = new JLabel("Tên KH:");
		lblTnKh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTnKh.setBounds(10, 90, 80, 20);
		panel.add(lblTnKh);
		
		JLabel lblSinThoi = new JLabel("Số điện thoại:");
		lblSinThoi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSinThoi.setBounds(10, 210, 100, 20);
		panel.add(lblSinThoi);
		
		JLabel lblNgySinh = new JLabel("Năm sinh:");
		lblNgySinh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNgySinh.setBounds(10, 170, 80, 20);
		panel.add(lblNgySinh);
		
		rdBtnNVVP = new JRadioButton("Nhân viên văn phòng");
		rdBtnNVVP.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdBtnNVVP.setBounds(374, 10, 180, 20);
		panel.add(rdBtnNVVP);
		
		JLabel lblNewLabel_1_1 = new JLabel("Giới tính:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(10, 130, 80, 20);
		panel.add(lblNewLabel_1_1);
		
		txtMaKH = new JTextField();
		txtMaKH.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMaKH.setBounds(120, 50, 109, 20);
		panel.add(txtMaKH);
		txtMaKH.setColumns(10);
		
		txtTenKH = new JTextField();
		txtTenKH.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTenKH.setColumns(10);
		txtTenKH.setBounds(120, 90, 300, 20);
		panel.add(txtTenKH);
		
		txtNamSinh = new JTextField();
		txtNamSinh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNamSinh.setColumns(10);
		txtNamSinh.setBounds(120, 170, 109, 20);
		panel.add(txtNamSinh);
		
		txtSdt = new JTextField();
		txtSdt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSdt.setColumns(10);
		txtSdt.setBounds(120, 210, 109, 20);
		panel.add(txtSdt);
		
		rdBtnNam = new JRadioButton("Nam");
		rdBtnNam.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdBtnNam.setBounds(120, 130, 109, 20);
		panel.add(rdBtnNam);
		
		rdBtnNu = new JRadioButton("Nữ");
		rdBtnNu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdBtnNu.setBounds(249, 130, 109, 20);
		panel.add(rdBtnNu);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 260, 560, 290);
		add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Tahoma", Font.PLAIN, 11));
		panel_1.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable(new DefaultTableModel(new Object[] {"Mã", "Tên", "Loại", "Giới tính", "SĐT", "Năm sinh", "Tiền"}, 0));
		table.setFont(new Font("Tahoma", Font.PLAIN, 11));
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_1 = new JLabel("Tìm thấy:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblNewLabel_1.setBounds(400, 560, 66, 20);
		add(lblNewLabel_1);
		
		txtTimThay = new JTextField();
		txtTimThay.setEditable(false);
		txtTimThay.setBounds(470, 560, 50, 20);
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
		btnTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTimKiem.setBounds(460, 225, 89, 25);
		panel.add(btnTimKiem);
	}
	
	private List<KhachHang> loadData(){
		List<KhachHang> list = KhachHangDAO.layThongTinKhachHang();		
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
