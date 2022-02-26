package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URLEncoder;
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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import DAO.LoaiMonAnDAO;
import DAO.MonAnDAO;
import DAO.NguyenLieuDAO;
import constant.HttpConstant;
import entities.LoaiMonAn;
import entities.MonAn;
import entities.NguyenLieu;
import service.IpushMethodService;
import service.impl.PushMethodService;

public class PnChinhSuaMonAn extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table_1;
	private JTextField txtMaMA;
	private JTextField txtTenMA;
	@SuppressWarnings("rawtypes")
	private JComboBox cmbMaLoai;
	@SuppressWarnings("rawtypes")
	private JComboBox cmbMaNL;

	private PnQuanLy pnQuanLy = null;
	private PnNhanVien pnNhanVien = null;

	@SuppressWarnings({ "unchecked", "rawtypes" })
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
		panel_1.setBackground(new Color(51, 204, 204));
		panel_1.setBounds(0, 0, 560, 190);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("Mã món ăn:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 49, 130, 25);
		panel_1.add(lblNewLabel);

		txtMaMA = new JTextField();
		txtMaMA.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMaMA.setHorizontalAlignment(SwingConstants.LEFT);
		txtMaMA.setBounds(140, 49, 200, 25);
		panel_1.add(txtMaMA);
		txtMaMA.setColumns(10);

		JLabel lblTnNguynLiu = new JLabel("Mã loại:");
		lblTnNguynLiu.setHorizontalAlignment(SwingConstants.LEFT);
		lblTnNguynLiu.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTnNguynLiu.setBounds(10, 84, 130, 25);
		panel_1.add(lblTnNguynLiu);

		JLabel lblSLng = new JLabel("Mã nguyên liệu:");
		lblSLng.setHorizontalAlignment(SwingConstants.LEFT);
		lblSLng.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSLng.setBounds(10, 119, 130, 25);
		panel_1.add(lblSLng);

		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnThemClicked();
			}
		});
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnThem.setBounds(360, 44, 90, 30);
		panel_1.add(btnThem);

		JButton btnSua = new JButton("Sửa");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSuaClicked();
			}
		});
		btnSua.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSua.setBounds(360, 149, 90, 30);
		panel_1.add(btnSua);

		JLabel lblTnMnn = new JLabel("Tên món ăn:");
		lblTnMnn.setHorizontalAlignment(SwingConstants.LEFT);
		lblTnMnn.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTnMnn.setBounds(10, 154, 130, 25);
		panel_1.add(lblTnMnn);

		txtTenMA = new JTextField();
		txtTenMA.setHorizontalAlignment(SwingConstants.LEFT);
		txtTenMA.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTenMA.setColumns(10);
		txtTenMA.setBounds(140, 154, 200, 25);
		panel_1.add(txtTenMA);

		JButton btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnXoaClicked();
			}
		});
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnXoa.setBounds(360, 114, 90, 30);
		panel_1.add(btnXoa);

		String[] maLoais = getCmbMaLoai();
		cmbMaLoai = new JComboBox(maLoais);
		cmbMaLoai.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cmbMaLoai.setBounds(140, 84, 200, 25);
		panel_1.add(cmbMaLoai);

		String[] maNguyenLieus = getCmbMaNL();
		cmbMaNL = new JComboBox(maNguyenLieus);
		cmbMaNL.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cmbMaNL.setBounds(140, 119, 200, 25);
		panel_1.add(cmbMaNL);

		JButton btnThemLoaiMonAn = new JButton("Thêm loại món ăn ");
		btnThemLoaiMonAn.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnThemLoaiMonAn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnThemLoaiMonAnClicked();
			}
		});
		btnThemLoaiMonAn.setBounds(360, 79, 190, 30);
		panel_1.add(btnThemLoaiMonAn);

		JLabel lblChnhSaMn = new JLabel("Chỉnh sửa món ăn");
		lblChnhSaMn.setForeground(Color.YELLOW);
		lblChnhSaMn.setHorizontalAlignment(SwingConstants.LEFT);
		lblChnhSaMn.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblChnhSaMn.setBounds(189, 8, 239, 30);
		panel_1.add(lblChnhSaMn);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 190, 560, 310);
		panel.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel_2.add(scrollPane, BorderLayout.CENTER);

		table_1 = new JTable(
				new DefaultTableModel(new Object[] { "Mã món ăn ", "Mã loại", "Mã nguyên liệu", "Tên món ăn " }, 0));
		scrollPane.setViewportView(table_1);
		table_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		loadTable();
	}

	private void btnThemClicked() {
		NguyenLieu n = null;
		try {
			if (txtMaMA.getText().isBlank() || txtTenMA.getText().isBlank())
				throw new Exception("Vui lòng nhập đầy đủ thông tin");

			ObjectMapper mapper = new ObjectMapper();
			IpushMethodService method = new PushMethodService();

			MonAn monan = null;
			try {
				monan = MonAnDAO.layThongTinMonAn(txtMaMA.getText());
			} catch (Exception ex) {
				monan = null;
			}
			if (monan != null)
				throw new Exception("Trùng mã món ăn");

			try {
				monan = MonAnDAO.layThongTinMonAnTheoTen(txtTenMA.getText());
			} catch (Exception e) {
				monan = null;
			}

			if (monan != null)
				throw new Exception("Trùng tên món ăn, vui lòng đổi tên!");

			monan = new MonAn();
			monan.setMaMA(txtMaMA.getText());
			String mlma = cmbMaLoai.getSelectedItem().toString().split("-")[0];
			LoaiMonAn l = getLoaiMonAn(mapper, method, mlma);
			monan.setLoaiMonAn(l);
			String mlnl = cmbMaNL.getSelectedItem().toString().split("-")[0];
			
			n = NguyenLieuDAO.layThongTinNguyenLieu(mlnl);
			
			monan.setNguyenLieu(n);
			monan.setTenMA(txtTenMA.getText());

			MonAnDAO.themMonAn(monan);
			loadTable();

			refreshPn();
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, e.getMessage());
			n = null;
		}
	}

	private void loadTable() {
		ObjectMapper mapper = new ObjectMapper();
		IpushMethodService method = new PushMethodService();

		DefaultTableModel model = (DefaultTableModel) table_1.getModel();
		model.setRowCount(0);

		List<MonAn> list = null;
		list = MonAnDAO.layDanhSachMonAn();

		for (MonAn n : list) {
			model.addRow(new Object[] { n.getMaMA(), n.getLoaiMonAn().getMaLoai(), n.getNguyenLieu().getMaNguyenLieu(),
					n.getTenMA()

			});
		}
	}

	private String[] getCmbMaLoai() {
		List<LoaiMonAn> dsLoaimonAn = null;
		String[] list = null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			IpushMethodService method = new PushMethodService();

			dsLoaimonAn = LoaiMonAnDAO.layDanhSachLoaiMonAn();
			list = new String[dsLoaimonAn.size()];
			for (int i = 0; i < list.length; i++) {
				list[i] = dsLoaimonAn.get(i).getMaLoai() + "-" + dsLoaimonAn.get(i).getTenLoai();

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	private String[] getCmbMaNL() {
		ObjectMapper mapper = new ObjectMapper();
		IpushMethodService method = new PushMethodService();

		List<NguyenLieu> listNL = null;
		String[] list = null;
		try {
			listNL = NguyenLieuDAO.layDanhSachNguyenLieu();
			list = new String[listNL.size()];
			for (int i = 0; i < list.length; i++) {
				list[i] = listNL.get(i).getMaNguyenLieu() + "-" + listNL.get(i).getTenNguyenLieu();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return list;
	}

	private void btnXoaClicked() {
		try {
			if (txtMaMA.getText().isBlank())
				throw new Exception("Vui lòng nhập mã món ăn để xóa");
			ObjectMapper mapper = new ObjectMapper();
			IpushMethodService method = new PushMethodService();

			String httpMA = "http://localhost:8080/APISpring/api/monan/id/" + txtMaMA.getText();
			MonAn monan = null;
			try {
				monan = MonAnDAO.layThongTinMonAn(txtMaMA.getText());
				} catch (Exception ex) {
				monan = null;
			}
			if (monan == null)
				throw new Exception("khong tim thay mon an");

			int isSuccess = MonAnDAO.xoaMonAn(monan);
			if (isSuccess == 0)
				throw new Exception("Error when deleting, check constraint!");

			loadTable();
			refreshPn();
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}

	private void btnSuaClicked() {
		try {
			if (txtMaMA.getText().isBlank() || txtTenMA.getText().isBlank())
				throw new Exception("Vui lòng nhập đầy đủ thông tin");

			ObjectMapper mapper = new ObjectMapper();
			IpushMethodService method = new PushMethodService();

			NguyenLieu n = null;

			MonAn monan = MonAnDAO.layThongTinMonAn(txtMaMA.getText());
			if (monan == null)
				throw new Exception("khong tim thay mon an");

			MonAn monanTest = null;
			try {
				monanTest = MonAnDAO.layThongTinMonAnTheoTen(txtTenMA.getText());
				} catch (Exception ex) {
				monanTest = null;
			}
			if (monanTest != null)
				throw new Exception("Trùng tên món ăn, vui lòng đổi tên!");

			String mlma = cmbMaLoai.getSelectedItem().toString().split("-")[0];
			LoaiMonAn l = getLoaiMonAn(mapper, method, mlma);
			monan.setLoaiMonAn(l);
			String mlnl = cmbMaNL.getSelectedItem().toString().split("-")[0];

			n = NguyenLieuDAO.layThongTinNguyenLieu(mlnl);
			monan.setNguyenLieu(n);
			monan.setTenMA(txtTenMA.getText());

			MonAnDAO.suaMonAn(monan);
			
			loadTable();
			JOptionPane.showMessageDialog(this, "sua thanh cong");

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

	private LoaiMonAn getLoaiMonAn(ObjectMapper mapper, IpushMethodService method, String txt) {
		return LoaiMonAnDAO.layThongTin(txt);
	}
}
