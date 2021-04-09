package view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import DAO.LoaiMonAnDAO;
import DAO.MonAnDAO;
import DAO.NguyenLieuDAO;
import entities.LoaiMonAn;
import entities.MonAn;
import entities.NguyenLieu;

public class PnChinhSuaMonAn extends JPanel {

	private JTable table_1;
	private JTextField txtMaMA;
	private JTextField txtTenMA;
	private JComboBox cmbMaLoai;
	private JComboBox cmbMaNL;
	
	private PnQuanLy pnQuanLy = null;
	private PnNhanVien pnNhanVien = null;
	public PnChinhSuaMonAn(JPanel pnQuanLy) {
		if (pnQuanLy instanceof PnQuanLy)
			this.pnQuanLy = (PnQuanLy) pnQuanLy;
		else {
			this.pnNhanVien = (PnNhanVien) pnQuanLy;
		}
		setBounds(0, 0, 560, 500);

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 560, 600);
		add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 560, 150);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mã món ăn:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 10, 110, 20);
		panel_1.add(lblNewLabel);
		
		txtMaMA = new JTextField();
		txtMaMA.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMaMA.setHorizontalAlignment(SwingConstants.LEFT);
		txtMaMA.setBounds(120, 10, 100, 20);
		panel_1.add(txtMaMA);
		txtMaMA.setColumns(10);
		
		JLabel lblTnNguynLiu = new JLabel("Mã loại:");
		lblTnNguynLiu.setHorizontalAlignment(SwingConstants.LEFT);
		lblTnNguynLiu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTnNguynLiu.setBounds(10, 45, 110, 20);
		panel_1.add(lblTnNguynLiu);
		
		JLabel lblSLng = new JLabel("Mã nguyên liệu:");
		lblSLng.setHorizontalAlignment(SwingConstants.LEFT);
		lblSLng.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSLng.setBounds(10, 80, 110, 20);
		panel_1.add(lblSLng);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnThemClicked();
			}
		});
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnThem.setBounds(390, 9, 90, 25);
		panel_1.add(btnThem);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSuaClicked();
			}
		});
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSua.setBounds(390, 114, 90, 25);
		panel_1.add(btnSua);
		
		JLabel lblTnMnn = new JLabel("Tên món ăn:");
		lblTnMnn.setHorizontalAlignment(SwingConstants.LEFT);
		lblTnMnn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTnMnn.setBounds(10, 115, 110, 20);
		panel_1.add(lblTnMnn);
		
		txtTenMA = new JTextField();
		txtTenMA.setHorizontalAlignment(SwingConstants.LEFT);
		txtTenMA.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTenMA.setColumns(10);
		txtTenMA.setBounds(120, 115, 200, 20);
		panel_1.add(txtTenMA);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnXoaClicked();
			}
		});
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnXoa.setBounds(390, 79, 90, 25);
		panel_1.add(btnXoa);
		
		String[] maLoais = getCmbMaLoai();
		cmbMaLoai = new JComboBox(maLoais);
		cmbMaLoai.setBounds(120, 42, 204, 27);
		panel_1.add(cmbMaLoai);
		
		String[] maNguyenLieus = getCmbMaNL();
		cmbMaNL = new JComboBox(maNguyenLieus);
		cmbMaNL.setBounds(120, 79, 200, 27);
		panel_1.add(cmbMaNL);
		
		JButton btnThemLoaiMonAn = new JButton("Thêm loại món ăn ");
		btnThemLoaiMonAn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnThemLoaiMonAnClicked();
			}
		});
		btnThemLoaiMonAn.setBounds(388, 43, 147, 29);
		panel_1.add(btnThemLoaiMonAn);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 150, 560, 350);
		panel.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_2.add(scrollPane, BorderLayout.CENTER);
		
		table_1 = new JTable(new DefaultTableModel(new Object[] {"Mã món ăn ","Mã loại" ,"Mã nguyên liệu", "Tên món ăn "}, 0));
		scrollPane.setViewportView(table_1);
		table_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		loadTable();
	}
	private void btnThemClicked() {
		try {
			MonAn monan = new MonAn();
			monan.setMaMA(txtMaMA.getText());
			String mlma = cmbMaLoai.getSelectedItem().toString().split("-")[0];	
			LoaiMonAn l = LoaiMonAnDAO.layThongTin(mlma);
			monan.setLoaiMonAn(l);
			String mlnl = cmbMaNL.getSelectedItem().toString().split("-")[0];
			NguyenLieu n = NguyenLieuDAO.layThongTinNguyenLieu(mlnl);
			monan.setNguyenLieu(n);
			monan.setTenMA(txtTenMA.getText());
			MonAnDAO.themMonAn(monan);
			loadTable();
			
			refreshPn();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void loadTable() {
		DefaultTableModel model = (DefaultTableModel) table_1.getModel();
		model.setRowCount(0);
		List<MonAn> list =MonAnDAO.layDanhSachMonAn();
		for (MonAn n : list) {
			model.addRow(new Object[] {
				n.getMaMA(),
				n.getLoaiMonAn().getMaLoai(),
				n.getNguyenLieu().getMaNguyenLieu(),
				n.getTenMA()
				
			});
		}
	}
	private String[] getCmbMaLoai() {
		List<LoaiMonAn> monAn = LoaiMonAnDAO.layDanhSachLoaiMonAn();
		String[] list = new String[monAn.size()];
		for(int i = 0 ; i<list.length; i++)
		{
			list[i]= monAn.get(i).getMaLoai() + "-" + monAn.get(i).getTenLoai();
			
		}
		return list;
	}
	private String[] getCmbMaNL() {
		List<NguyenLieu> nguyenLieu = NguyenLieuDAO.layDanhSachNguyenLieu();
		String[] list = new String[nguyenLieu.size()];
		for(int i = 0 ; i<list.length; i++)
		{
			list[i]= nguyenLieu.get(i).getMaNguyenLieu() + "-" + nguyenLieu.get(i).getTenNguyenLieu();
		}
		return list;
	}
	private void btnXoaClicked() {
		try {
			MonAn monan = MonAnDAO.layThongTinMonAn(txtMaMA.getText());
			if(monan == null)
				throw new Exception("khong tim thay mon an");
			MonAnDAO.xoaMonAn(monan);
			loadTable();
			
			refreshPn();
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, e.getMessage());
			
		}
	}
	private void btnSuaClicked() {
		try {
			MonAn monan = MonAnDAO.layThongTinMonAn(txtMaMA.getText());
			if(monan == null)
				throw new Exception("khong tim thay mon an");
			String mlma = cmbMaLoai.getSelectedItem().toString().split("-")[0];	
			LoaiMonAn l = LoaiMonAnDAO.layThongTin(mlma);
			monan.setLoaiMonAn(l);
			String mlnl = cmbMaNL.getSelectedItem().toString().split("-")[0];
			NguyenLieu n = NguyenLieuDAO.layThongTinNguyenLieu(mlnl);
			monan.setNguyenLieu(n);
			monan.setTenMA(txtTenMA.getText());
			MonAnDAO.suaMonAn(monan);
			loadTable();
			JOptionPane.showMessageDialog(this,"sua thanh cong");
			
			refreshPn();
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}
	
	void refreshPn() {
		if (pnQuanLy != null) {
			PnMenu pnMenu = pnQuanLy.getPnMenu();
			PnMenuKhongChucNang pnMenuKhongChucNang = pnQuanLy.getPnMenuKhongChucNang();
			PnChinhSuaMonAn pnChinhSuaMonAn = this;
			
			pnQuanLy.getPnCardLeft().remove(pnMenu);
			pnQuanLy.getPnCardLeft().remove(pnMenuKhongChucNang);
			pnQuanLy.getPnCardLeft().remove(pnChinhSuaMonAn);
			
			pnMenu = new PnMenu(pnQuanLy.getPnThanhToan());
			pnMenuKhongChucNang = new PnMenuKhongChucNang();
			pnChinhSuaMonAn = new PnChinhSuaMonAn(pnQuanLy);
			
			pnQuanLy.getPnCardLeft().add(pnMenu, "pnMenu");
			pnQuanLy.getPnCardLeft().add(pnMenuKhongChucNang, "pnMenuKhongChucNang");
			pnQuanLy.getPnCardLeft().add(pnChinhSuaMonAn, "pnChinhSuaMonAn");
			
			pnQuanLy.validate();
			pnQuanLy.repaint();
		} else {
			PnMenu pnMenu = pnNhanVien.getPnMenu();
			PnMenuKhongChucNang pnMenuKhongChucNang = pnNhanVien.getPnMenuKhongChucNang();
			PnChinhSuaMonAn pnChinhSuaMonAn = this;
			
			pnNhanVien.getPnLeft().remove(pnMenu);
			pnNhanVien.getPnLeft().remove(pnMenuKhongChucNang);
			pnNhanVien.getPnLeft().remove(pnChinhSuaMonAn);
			
			pnMenu = new PnMenu(pnNhanVien.getPnThanhToan());
			pnMenuKhongChucNang = new PnMenuKhongChucNang();
			pnChinhSuaMonAn = new PnChinhSuaMonAn(pnQuanLy);
			
			pnNhanVien.getPnLeft().add(pnMenu, "pnMenu");
			pnNhanVien.getPnLeft().add(pnMenuKhongChucNang, "pnMenuKhongChucNang");
			pnNhanVien.getPnLeft().add(pnChinhSuaMonAn, "pnChinhSuaMonAn");
			
			pnNhanVien.validate();
			pnNhanVien.repaint();
		}
		

	}
	
	private void btnThemLoaiMonAnClicked() {
		FrameLoaiMonAn frm = new FrameLoaiMonAn(this);
		frm.setVisible(true);
	}
}
