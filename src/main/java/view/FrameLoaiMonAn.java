package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import DAO.LoaiMonAnDAO;
import constant.HttpConstant;
import entities.LoaiMonAn;
import service.IpushMethodService;
import service.impl.PushMethodService;
import java.awt.Color;

public class FrameLoaiMonAn extends JFrame {
	private static final long serialVersionUID = 1L;
	private PnChinhSuaMonAn pnChinhSuaMonAn;

	public FrameLoaiMonAn(PnChinhSuaMonAn pnChinhSuaMonAn) {
		getContentPane().setBackground(new Color(51, 204, 204));
		this.pnChinhSuaMonAn = pnChinhSuaMonAn;
		setBounds(0, 0, 572, 543);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Mã loại");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 49, 116, 30);
		getContentPane().add(lblNewLabel);

		txtMaLoai = new JTextField();
		txtMaLoai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtMaLoai.setBounds(136, 49, 414, 30);
		getContentPane().add(txtMaLoai);
		txtMaLoai.setColumns(10);

		JLabel lblTnLoi = new JLabel("Tên loại");
		lblTnLoi.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTnLoi.setBounds(10, 89, 116, 30);
		getContentPane().add(lblTnLoi);

		txtTenLoai = new JTextField();
		txtTenLoai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTenLoai.setColumns(10);
		txtTenLoai.setBounds(136, 89, 414, 30);
		getContentPane().add(txtTenLoai);

		JLabel lblGiTin = new JLabel("Giá tiền");
		lblGiTin.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblGiTin.setBounds(10, 129, 116, 30);
		getContentPane().add(lblGiTin);

		txtGiaTien = new JTextField();
		txtGiaTien.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtGiaTien.setColumns(10);
		txtGiaTien.setBounds(136, 129, 414, 30);
		getContentPane().add(txtGiaTien);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Tahoma", Font.PLAIN, 11));
		scrollPane.setBounds(10, 210, 540, 290);
		getContentPane().add(scrollPane);

		table = new JTable(new DefaultTableModel(new Object[] { "Mã loại", "Tên loại", "Giá tiền" }, 0));
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPane.setViewportView(table);
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent event) {
				// do some actions here, for example
				// print first column value from selected row
				selectedItemChanged();
			}
		});
		loadTable();

		JButton btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnXoaClicked();
			}
		});
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnXoa.setBounds(465, 169, 85, 30);
		getContentPane().add(btnXoa);

		JButton btnThem = new JButton("Thêm/Sửa");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnThemClicked();
			}
		});
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnThem.setBounds(309, 169, 146, 30);
		getContentPane().add(btnThem);

		JLabel lblChnhSaLoi = new JLabel("Chỉnh sửa loại món ăn");
		lblChnhSaLoi.setForeground(Color.YELLOW);
		lblChnhSaLoi.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblChnhSaLoi.setBounds(161, 8, 293, 30);
		getContentPane().add(lblChnhSaLoi);
	}

	private JTextField txtMaLoai;
	private JTextField txtTenLoai;
	private JTextField txtGiaTien;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public void PnLoaiMonAn() {

	}

	private void loadTable() {
		IpushMethodService method = new PushMethodService();

		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);

		ObjectMapper mapper = new ObjectMapper();

		List<LoaiMonAn> list = null;
		list = LoaiMonAnDAO.layDanhSachLoaiMonAn();

		for (int i = 0; i < list.size(); i++) {
			model.addRow(new Object[] { list.get(i).getMaLoai(), list.get(i).getTenLoai(), list.get(i).getGiaTien() });
		}
	}

	@SuppressWarnings("unused")
	private void btnThemClicked() {
		try {
			ObjectMapper mapper = new ObjectMapper();

			if (!kiemTraTxt(txtGiaTien) || !kiemTraTxt(txtMaLoai) || !kiemTraTxt(txtGiaTien))
				throw new Exception("Vui lòng nhập đầy đủ thông tin!");

			IpushMethodService method = new PushMethodService();
			LoaiMonAn loaiMonAn = getLoaiMonAn(mapper, method, txtMaLoai.getText());
			if (loaiMonAn == null) {
				loaiMonAn = new LoaiMonAn();
				loaiMonAn.setMaLoai(txtMaLoai.getText());
				loaiMonAn.setTenLoai(txtTenLoai.getText());
				loaiMonAn.setGiaTien(Long.parseLong(txtGiaTien.getText()));
				
				LoaiMonAnDAO.themLoaiMonAn(loaiMonAn);

				JOptionPane.showMessageDialog(this, "Thêm loại món ăn thành công!");
				loadTable();
			} else {
				loaiMonAn.setTenLoai(txtTenLoai.getText());
				loaiMonAn.setGiaTien(Long.parseLong(txtGiaTien.getText()));
				
				LoaiMonAnDAO.suaLoaiMonAn(loaiMonAn);

				JOptionPane.showMessageDialog(this, "Sửa loại món ăn thành công!");
				loadTable();
			}

			pnChinhSuaMonAn.refreshPn();
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}

	private boolean kiemTraTxt(JTextField txt) {
		if (txt.getText().compareTo("") == 0)
			return false;
		return true;
	}

	private void selectedItemChanged() {
		if (table.getSelectedRow() != -1) {
			txtMaLoai.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
			txtTenLoai.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
			txtGiaTien.setText(table.getValueAt(table.getSelectedRow(), 2).toString());
		}
	}

	private void btnXoaClicked() {
		try {
			ObjectMapper mapper = new ObjectMapper();
			IpushMethodService method = new PushMethodService();
			LoaiMonAn loaiMonAn = getLoaiMonAn(mapper, method, txtMaLoai.getText());
			if (loaiMonAn == null)
				throw new Exception("Loại món ăn không tồn tại!");
			if (JOptionPane.showConfirmDialog(this,
					"Xóa loại món ăn " + loaiMonAn.getTenLoai() + " ?") == JOptionPane.YES_OPTION) {

				LoaiMonAnDAO.xoaLoaiMonAn(loaiMonAn);
				loadTable();

				refreshTxt();
				pnChinhSuaMonAn.refreshPn();
			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}

	private void refreshTxt() {
		txtGiaTien.setText("");
		txtMaLoai.setText("");
		txtTenLoai.setText("");
	}

	private LoaiMonAn getLoaiMonAn(ObjectMapper mapper, IpushMethodService method, String txt) {
		return LoaiMonAnDAO.layThongTin(txt);
	}

}
