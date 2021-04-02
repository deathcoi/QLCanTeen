package view;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import DAO.NhanVienDAO;
import entities.NhanVien;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class PnChinhSuaNhanVien extends JPanel {

	private JTable table_1;
	private JTextField txtMaNV;
	private JTextField txtTenNV;
	private JTextField txtNamSinh;
	private JTextField txtSdt;
	
	public PnChinhSuaNhanVien() {
		setBounds(0, 0, 560, 500);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 560, 180);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mã nhân viên:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 10, 110, 20);
		panel_1.add(lblNewLabel);
		
		txtMaNV = new JTextField();
		txtMaNV.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMaNV.setHorizontalAlignment(SwingConstants.LEFT);
		txtMaNV.setBounds(120, 10, 100, 20);
		panel_1.add(txtMaNV);
		txtMaNV.setColumns(10);
		
		JLabel lblTnNguynLiu = new JLabel("Tên nhân viên");
		lblTnNguynLiu.setHorizontalAlignment(SwingConstants.LEFT);
		lblTnNguynLiu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTnNguynLiu.setBounds(10, 45, 110, 20);
		panel_1.add(lblTnNguynLiu);
		
		JLabel lblSLng = new JLabel("Giới tính:");
		lblSLng.setHorizontalAlignment(SwingConstants.LEFT);
		lblSLng.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSLng.setBounds(10, 80, 110, 20);
		panel_1.add(lblSLng);
		
		txtTenNV = new JTextField();
		txtTenNV.setHorizontalAlignment(SwingConstants.LEFT);
		txtTenNV.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTenNV.setColumns(10);
		txtTenNV.setBounds(120, 45, 200, 20);
		panel_1.add(txtTenNV);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnThemClicked();
			}
		});
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnThem.setBounds(390, 25, 90, 25);
		panel_1.add(btnThem);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSua.setBounds(390, 115, 90, 25);
		panel_1.add(btnSua);
		
		JLabel lblNmSinh = new JLabel("Năm sinh:");
		lblNmSinh.setHorizontalAlignment(SwingConstants.LEFT);
		lblNmSinh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNmSinh.setBounds(10, 115, 110, 20);
		panel_1.add(lblNmSinh);
		
		JLabel lblSinThoi = new JLabel("Số điện thoại:");
		lblSinThoi.setHorizontalAlignment(SwingConstants.LEFT);
		lblSinThoi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSinThoi.setBounds(10, 150, 110, 20);
		panel_1.add(lblSinThoi);
		
		txtNamSinh = new JTextField();
		txtNamSinh.setHorizontalAlignment(SwingConstants.LEFT);
		txtNamSinh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNamSinh.setColumns(10);
		txtNamSinh.setBounds(120, 115, 100, 20);
		panel_1.add(txtNamSinh);
		
		txtSdt = new JTextField();
		txtSdt.setHorizontalAlignment(SwingConstants.LEFT);
		txtSdt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSdt.setColumns(10);
		txtSdt.setBounds(120, 150, 100, 20);
		panel_1.add(txtSdt);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnXoa.setBounds(390, 70, 90, 25);
		panel_1.add(btnXoa);
		
		JRadioButton rdBtnNam = new JRadioButton("Nam");
		rdBtnNam.setBounds(120, 80, 70, 20);
		panel_1.add(rdBtnNam);
		
		JRadioButton rdBtnNu = new JRadioButton("Nữ");
		rdBtnNu.setBounds(191, 80, 70, 20);
		panel_1.add(rdBtnNu);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 180, 560, 320);
		panel.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_2.add(scrollPane, BorderLayout.CENTER);
		
		table_1 = new JTable(new DefaultTableModel(new Object[] {"Mã nhân viên", "Tên nhân viên", "Giới tính", "Năm sinh", "SĐT"}, 0));
		loadTable();
		scrollPane.setViewportView(table_1);
		table_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		ButtonGroup btnGroupGioiTinh = new ButtonGroup();
		btnGroupGioiTinh.add(rdBtnNam);
		btnGroupGioiTinh.add(rdBtnNu);
	}
	
	private void btnThemClicked() {
		try {
			NhanVien nhanVien = new NhanVien();
			nhanVien.setMaNV(txtMaNV.getText());
			nhanVien.setTenNV(txtTenNV.getText());
			
			NhanVienDAO.themNhanVien(nhanVien);
			
			loadTable();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void loadTable() {
		DefaultTableModel model = (DefaultTableModel) table_1.getModel();
		model.setRowCount(0);
		List<NhanVien> list = NhanVienDAO.layDanhSachNhanVien();
		for (NhanVien n : list) {
			model.addRow(new Object[] {
				n.getMaNV(),
				n.getTenNV(),
				n.getGioiTinh(),
				n.getNamSinh(),
				n.getSdt()
			});
		}
	}
}
