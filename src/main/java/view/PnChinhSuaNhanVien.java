package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import constant.HttpConstant;
import entities.NhanVien;
import entities.TaiKhoanNV;
import service.IpushMethodService;
import service.impl.PushMethodService;

public class PnChinhSuaNhanVien extends JPanel {

	private static final long serialVersionUID = 1L;

	private JTable table_1;
	private JTextField txtMaNV;
	private JTextField txtTenNV;
	private JTextField txtNamSinh;
	private JTextField txtSdt;
	private JRadioButton rdBtnNam;
	private JRadioButton rdBtnNu;

	public PnChinhSuaNhanVien() {
		setBounds(0, 0, 560, 600);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(51, 204, 204));
		panel_1.setBounds(0, 0, 560, 230);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("Mã nhân viên:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 60, 130, 25);
		panel_1.add(lblNewLabel);

		txtMaNV = new JTextField();
		txtMaNV.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMaNV.setHorizontalAlignment(SwingConstants.LEFT);
		txtMaNV.setBounds(140, 60, 100, 25);
		panel_1.add(txtMaNV);
		txtMaNV.setColumns(10);

		JLabel lblTnNguynLiu = new JLabel("Tên nhân viên:");
		lblTnNguynLiu.setHorizontalAlignment(SwingConstants.LEFT);
		lblTnNguynLiu.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTnNguynLiu.setBounds(10, 95, 130, 25);
		panel_1.add(lblTnNguynLiu);

		JLabel lblSLng = new JLabel("Giới tính:");
		lblSLng.setHorizontalAlignment(SwingConstants.LEFT);
		lblSLng.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSLng.setBounds(10, 125, 110, 25);
		panel_1.add(lblSLng);

		txtTenNV = new JTextField();
		txtTenNV.setHorizontalAlignment(SwingConstants.LEFT);
		txtTenNV.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTenNV.setColumns(10);
		txtTenNV.setBounds(140, 95, 200, 25);
		panel_1.add(txtTenNV);

		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnThemClicked();
			}
		});
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnThem.setBounds(390, 74, 90, 35);
		panel_1.add(btnThem);

		JButton btnSua = new JButton("Sửa");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSuaClicked();
			}
		});
		btnSua.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSua.setBounds(390, 164, 90, 35);
		panel_1.add(btnSua);

		JLabel lblNmSinh = new JLabel("Năm sinh:");
		lblNmSinh.setHorizontalAlignment(SwingConstants.LEFT);
		lblNmSinh.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNmSinh.setBounds(10, 160, 110, 25);
		panel_1.add(lblNmSinh);

		JLabel lblSinThoi = new JLabel("Số điện thoại:");
		lblSinThoi.setHorizontalAlignment(SwingConstants.LEFT);
		lblSinThoi.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSinThoi.setBounds(10, 195, 130, 25);
		panel_1.add(lblSinThoi);

		txtNamSinh = new JTextField();
		txtNamSinh.setHorizontalAlignment(SwingConstants.LEFT);
		txtNamSinh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNamSinh.setColumns(10);
		txtNamSinh.setBounds(140, 160, 100, 25);
		panel_1.add(txtNamSinh);

		txtSdt = new JTextField();
		txtSdt.setHorizontalAlignment(SwingConstants.LEFT);
		txtSdt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSdt.setColumns(10);
		txtSdt.setBounds(140, 195, 100, 25);
		panel_1.add(txtSdt);

		JButton btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnXoaClicked();
			}
		});
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnXoa.setBounds(390, 119, 90, 35);
		panel_1.add(btnXoa);

		rdBtnNam = new JRadioButton("Nam");
		rdBtnNam.setContentAreaFilled(false);
		rdBtnNam.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdBtnNam.setSelected(true);
		rdBtnNam.setBounds(140, 125, 60, 25);
		panel_1.add(rdBtnNam);

		rdBtnNu = new JRadioButton("Nữ");
		rdBtnNu.setContentAreaFilled(false);
		rdBtnNu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdBtnNu.setBounds(220, 125, 60, 25);
		panel_1.add(rdBtnNu);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 230, 560, 370);
		panel.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel_2.add(scrollPane, BorderLayout.CENTER);

		table_1 = new JTable(new DefaultTableModel(new Object[][] {}, new String[] { "Mã nhân viên", "Tên nhân viên", "Giới tính", "Năm sinh", "SĐT" }));
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mouseClickedInTable();
			}
		});
		loadTable();
		scrollPane.setViewportView(table_1);
		table_1.setFont(new Font("Tahoma", Font.PLAIN, 14));

		ButtonGroup btnGroupGioiTinh = new ButtonGroup();
		btnGroupGioiTinh.add(rdBtnNam);
		btnGroupGioiTinh.add(rdBtnNu);

		JLabel lblChnhSaNhn = new JLabel("Chỉnh sửa nhân viên");
		lblChnhSaNhn.setForeground(Color.YELLOW);
		lblChnhSaNhn.setHorizontalAlignment(SwingConstants.LEFT);
		lblChnhSaNhn.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblChnhSaNhn.setBounds(150, 10, 300, 40);
		panel_1.add(lblChnhSaNhn);
	}

	private void btnThemClicked() {
		try {
			

			if (checkText(txtMaNV) || checkText(txtNamSinh) || checkText(txtTenNV) || checkText(txtSdt))
				throw new Exception("Vui lòng nhập đầy đủ thông tin!");
			if (!isNumber(txtNamSinh.getText()) || !isNumber(txtSdt.getText()))
				throw new Exception("Vui lòng nhập đúng dữ liệu!");
			
			IpushMethodService service = new PushMethodService();
			ObjectMapper mapper = new ObjectMapper();
			
			String httpNV = "http://localhost:8080/APISpring/api/nhanvien/" + txtMaNV.getText();
			NhanVien nv = null;
			try {
				nv = mapper.readValue(service.pushMethod(HttpConstant.HTTPREQUESTGET, httpNV, txtMaNV.getText()), NhanVien.class);
			} catch (Exception e) {
				nv = null;
			}
				
			
			if (nv != null)
				throw new Exception("Mã nhân viên đã tồn tại! Vui lòng chọn mã nhân viên khác");
			NhanVien nhanVien = new NhanVien();
			nhanVien.setMaNV(txtMaNV.getText());
			nhanVien.setTenNV(txtTenNV.getText());
			nhanVien.setGioiTinh((rdBtnNam.isSelected() ? "Nam" : "Nữ"));
			nhanVien.setNamSinh(Integer.parseInt(txtNamSinh.getText()));
			nhanVien.setSdt(Long.parseLong(txtSdt.getText()));
			nhanVien.setStatus(1);
			
			service.pushMethod(HttpConstant.HTTPREQUESTPOST, "http://localhost:8080/APISpring/api/nhanvien/", nhanVien);

			TaiKhoanNV taiKhoanNV = new TaiKhoanNV();
			taiKhoanNV.setMatKhau(nhanVien.getMaNV());
			taiKhoanNV.setNhanVien(nhanVien);

			service.pushMethod(HttpConstant.HTTPREQUESTPOST, "http://localhost:8080/APISpring/api/taikhoannv",
					taiKhoanNV);

			loadTable();
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}

	private void loadTable() {
		IpushMethodService service = new PushMethodService();
		ObjectMapper mapper = new ObjectMapper();
		
		DefaultTableModel model = (DefaultTableModel) table_1.getModel();
		model.setRowCount(0);
		List<NhanVien> list = new ArrayList<NhanVien>();
		try {
			list = mapper.readValue(service.pushMethod(HttpConstant.HTTPREQUESTGET, "http://localhost:8080/APISpring/api/nhanvien", null), new TypeReference<List<NhanVien>>() {
			});
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		for (NhanVien n : list) {
			model.addRow(new Object[] { n.getMaNV(), n.getTenNV(), n.getGioiTinh(), n.getNamSinh(), n.getSdt() });
		}
	}

	private boolean checkText(JTextField txt) {
		if (txt.getText().compareTo("") == 0)
			return true;
		return false;
	}

	@SuppressWarnings("unused")
	private boolean isNumber(String s) {
		try {
			Double d = Double.parseDouble(s);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	private void btnXoaClicked() {
		try {
			if (checkText(txtMaNV))
				throw new Exception("Vui lòng nhập đầy đủ thông tin!");
			ObjectMapper mapper = new ObjectMapper();
			IpushMethodService service = new PushMethodService();
			
			String httpNV = "http://localhost:8080/APISpring/api/nhanvien/" + txtMaNV.getText();
			NhanVien nhanVien = mapper.readValue(service.pushMethod(HttpConstant.HTTPREQUESTGET, httpNV, txtMaNV.getText()), NhanVien.class);

			if (nhanVien == null)
				throw new Exception("Không tìm thấy nhân viên!");
			if (JOptionPane.showConfirmDialog(this,
					"Bạn có muốn xóa nhân viên " + nhanVien.getTenNV() + " không?") == JOptionPane.YES_OPTION) {

				String httpStringNV = "http://localhost:8080/APISpring/api/taikhoannv/" + nhanVien.getMaNV();
				TaiKhoanNV taiKhoanNV = mapper.readValue(
						service.pushMethod(HttpConstant.HTTPREQUESTGET, httpStringNV, nhanVien.getMaNV()),
						TaiKhoanNV.class);

				if (taiKhoanNV != null) {
					service.pushMethod(HttpConstant.HTTPREQUESTDELETE, "http://localhost:8080/APISpring/api/taikhoannv", taiKhoanNV);
				}
				service.pushMethod(HttpConstant.HTTPREQUESTDELETE, "http://localhost:8080/APISpring/api/nhanvien", nhanVien);
				loadTable();
			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}

	private void btnSuaClicked() {
		try {
			if (checkText(txtMaNV) || checkText(txtNamSinh) || checkText(txtTenNV) || checkText(txtSdt))
				throw new Exception("Vui lòng nhập đầy đủ thông tin!");
			if (!isNumber(txtNamSinh.getText()) || !isNumber(txtSdt.getText()))
				throw new Exception("Vui lòng nhập đúng dữ liệu!");
			
			ObjectMapper mapper = new ObjectMapper();
			IpushMethodService service = new PushMethodService();
			
			String httpNV = "http://localhost:8080/APISpring/api/nhanvien/" + txtMaNV.getText();
			NhanVien nhanVien = mapper.readValue(service.pushMethod(HttpConstant.HTTPREQUESTGET, httpNV, txtMaNV.getText()), NhanVien.class);
			if (nhanVien == null)
				throw new Exception("Không tìm thấy nhân viên!");

			if (JOptionPane.showConfirmDialog(this,
					"Bạn có muốn cập nhật nhân viên " + nhanVien.getTenNV() + " không?") == JOptionPane.YES_OPTION) {
				nhanVien.setTenNV(txtTenNV.getText());
				nhanVien.setGioiTinh((rdBtnNam.isSelected() ? "Nam" : "Nữ"));
				nhanVien.setNamSinh(Integer.parseInt(txtNamSinh.getText()));
				nhanVien.setSdt(Long.parseLong(txtSdt.getText()));
				nhanVien.setStatus(1);
				
				service.pushMethod(HttpConstant.HTTPREQUESTPUT,  "http://localhost:8080/APISpring/api/nhanvien/", nhanVien);
				loadTable();
			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}

	private void mouseClickedInTable() {
		int index = table_1.getSelectedRow();
		if (table_1.getSelectedRow() != -1) {
			txtMaNV.setText(table_1.getValueAt(index, 0).toString());
			txtTenNV.setText(table_1.getValueAt(index, 1).toString());
			txtSdt.setText(table_1.getValueAt(index, 4).toString());
			txtNamSinh.setText(table_1.getValueAt(index, 3).toString());
			rdBtnNam.setSelected((table_1.getValueAt(index, 2).toString().compareTo("Nam") == 0 ? true : false));
			rdBtnNu.setSelected((table_1.getValueAt(index, 2).toString().compareTo("Nữ") == 0 ? true : false));
		}
	}
}
