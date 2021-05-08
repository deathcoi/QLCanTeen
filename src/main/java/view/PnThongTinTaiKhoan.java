package view;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import entities.KhachHang;

import java.awt.Font;
import javax.swing.JTextField;

public class PnThongTinTaiKhoan extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTextField txtMa;
	private JTextField txtTen;
	private JTextField txtLoai;
	private JTextField txtGioiTinh;
	private JTextField txtSdt;
	private JTextField txtNamSinh;
	private JTextField txtTien;

	private KhachHang khachHang;
	
	public KhachHang getKhachHang() {
		return khachHang;
	}


	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	/**
	 * Create the panel.
	 */
	public PnThongTinTaiKhoan() {
		
		setBounds(0, 0, 560, 600);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mã:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(110, 160, 70, 25);
		add(lblNewLabel);
		
		JLabel lblTn = new JLabel("Tên: ");
		lblTn.setHorizontalAlignment(SwingConstants.LEFT);
		lblTn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTn.setBounds(110, 205, 70, 25);
		add(lblTn);
		
		JLabel lblLoi = new JLabel("Loại:");
		lblLoi.setHorizontalAlignment(SwingConstants.LEFT);
		lblLoi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLoi.setBounds(110, 250, 70, 25);
		add(lblLoi);
		
		JLabel lblGiiTnh = new JLabel("Giới tính:");
		lblGiiTnh.setHorizontalAlignment(SwingConstants.LEFT);
		lblGiiTnh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGiiTnh.setBounds(110, 295, 70, 25);
		add(lblGiiTnh);
		
		JLabel lblSt = new JLabel("Sđt:");
		lblSt.setHorizontalAlignment(SwingConstants.LEFT);
		lblSt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSt.setBounds(110, 340, 70, 25);
		add(lblSt);
		
		JLabel lblNmSinh = new JLabel("Năm sinh:");
		lblNmSinh.setHorizontalAlignment(SwingConstants.LEFT);
		lblNmSinh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNmSinh.setBounds(110, 385, 70, 25);
		add(lblNmSinh);
		
		JLabel lblTin = new JLabel("Tiền:");
		lblTin.setHorizontalAlignment(SwingConstants.LEFT);
		lblTin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTin.setBounds(110, 430, 70, 25);
		add(lblTin);
		
		JLabel lblThngTinKhch = new JLabel("THÔNG TIN KHÁCH HÀNG");
		lblThngTinKhch.setHorizontalAlignment(SwingConstants.LEFT);
		lblThngTinKhch.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblThngTinKhch.setBounds(150, 60, 250, 40);
		add(lblThngTinKhch);
		
		txtMa = new JTextField();
		txtMa.setEnabled(false);
		txtMa.setBounds(210, 160, 200, 25);
		add(txtMa);
		txtMa.setColumns(10);

		
		txtTen = new JTextField();
		txtTen.setEnabled(false);
		txtTen.setColumns(10);
		txtTen.setBounds(210, 205, 200, 25);
		add(txtTen);
		
		txtLoai = new JTextField();
		txtLoai.setEnabled(false);
		txtLoai.setColumns(10);
		txtLoai.setBounds(210, 250, 200, 25);
		add(txtLoai);
		
		txtGioiTinh = new JTextField();
		txtGioiTinh.setEnabled(false);
		txtGioiTinh.setColumns(10);
		txtGioiTinh.setBounds(210, 295, 200, 25);
		add(txtGioiTinh);
		
		txtSdt = new JTextField();
		txtSdt.setEnabled(false);
		txtSdt.setColumns(10);
		txtSdt.setBounds(210, 340, 200, 25);
		add(txtSdt);
		
		txtNamSinh = new JTextField();
		txtNamSinh.setEnabled(false);
		txtNamSinh.setColumns(10);
		txtNamSinh.setBounds(210, 385, 200, 25);
		add(txtNamSinh);
		
		txtTien = new JTextField();
		txtTien.setEnabled(false);
		txtTien.setColumns(10);
		txtTien.setBounds(210, 430, 200, 25);
		add(txtTien);
		
	}
	
	public void dienThongTin() {
		txtMa.setText(khachHang.getMaKH());
		txtTen.setText(khachHang.getTenKH());
		txtLoai.setText(khachHang.getLoaiKhachHang().getTenLoaiKH());
		txtGioiTinh.setText(khachHang.getGioiTinh());
		txtSdt.setText(khachHang.getSdt().toString());
		txtNamSinh.setText(khachHang.getNamSinh().toString());
		txtTien.setText(khachHang.getTien().toString());
	}

}
