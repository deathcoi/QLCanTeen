package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import DAO.LoaiMonAnDAO;
import DAO.MonAnDAO;
import DAO.NguyenLieuDAO;
import entities.LoaiMonAn;
import entities.MonAn;
import entities.NguyenLieu;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.BoxLayout;

public class FrameLoaiMonAn extends JFrame {
	public FrameLoaiMonAn() {
		setBounds(0, 0, 560, 500);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mã loại");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 10, 116, 30);
		getContentPane().add(lblNewLabel);
		
		txtMaLoai = new JTextField();
		txtMaLoai.setBounds(136, 10, 414, 30);
		getContentPane().add(txtMaLoai);
		txtMaLoai.setColumns(10);
		
		JLabel lblTnLoi = new JLabel("Tên loại");
		lblTnLoi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTnLoi.setBounds(10, 50, 116, 30);
		getContentPane().add(lblTnLoi);
		
		txtTenLoai = new JTextField();
		txtTenLoai.setColumns(10);
		txtTenLoai.setBounds(136, 50, 414, 30);
		getContentPane().add(txtTenLoai);
		
		JLabel lblGiTin = new JLabel("Giá tiền");
		lblGiTin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblGiTin.setBounds(10, 90, 116, 30);
		getContentPane().add(lblGiTin);
		
		txtGiaTien = new JTextField();
		txtGiaTien.setColumns(10);
		txtGiaTien.setBounds(136, 90, 414, 30);
		getContentPane().add(txtGiaTien);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 170, 540, 330);
		getContentPane().add(scrollPane);
		
		table = new JTable(new DefaultTableModel(new Object[] {"Mã loại", "Tên loại", "Giá tiền"}, 0));
		scrollPane.setViewportView(table);
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
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
		btnXoa.setBounds(465, 130, 85, 30);
		getContentPane().add(btnXoa);
		
		JButton btnThem = new JButton("Thêm/Sửa");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnThemClicked();
			}
		});
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnThem.setBounds(309, 130, 146, 30);
		getContentPane().add(btnThem);
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
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		List<LoaiMonAn> list = LoaiMonAnDAO.layDanhSachLoaiMonAn();
		for (int i = 0; i < list.size(); i++) {
			model.addRow(new Object[] {
					list.get(i).getMaLoai(),
					list.get(i).getTenLoai(),
					list.get(i).getGiaTien()
			});
		}
	}
	
	private void btnThemClicked() {
		try {
			if (!kiemTraTxt(txtGiaTien) || !kiemTraTxt(txtMaLoai) || !kiemTraTxt(txtGiaTien))
				throw new Exception("Vui lòng nhập đầy đủ thông tin!");
			LoaiMonAn loaiMonAn = LoaiMonAnDAO.layThongTin(txtMaLoai.getText());
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
			LoaiMonAn loaiMonAn = LoaiMonAnDAO.layThongTin(txtMaLoai.getText());
			if (loaiMonAn == null)
				throw new Exception("Loại món ăn không tồn tại!");
			if (JOptionPane.showConfirmDialog(this, "Xóa loại món ăn " + loaiMonAn.getTenLoai() + " ?") == JOptionPane.YES_OPTION) {
				LoaiMonAnDAO.xoaLoaiMonAn(loaiMonAn);
				loadTable();
				
				refreshTxt();
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
}
