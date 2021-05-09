package view;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import entities.KhachHang;
import java.awt.Color;

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
	
	private Image image;
	private Image scaledImage;
	
	public KhachHang getKhachHang() {
		return khachHang;
	}


	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public PnThongTinTaiKhoan() {
		
		setBounds(0, 0, 560, 600);
		setLayout(null);
		try {
			image = ImageIO.read(new File("picture/main.png"));
			scaledImage = image.getScaledInstance(this.getWidth(),this.getHeight(),Image.SCALE_SMOOTH);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		JLabel lblNewLabel = new JLabel("Mã:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(88, 160, 92, 25);
		add(lblNewLabel);
		
		JLabel lblTn = new JLabel("Tên: ");
		lblTn.setHorizontalAlignment(SwingConstants.LEFT);
		lblTn.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTn.setBounds(88, 205, 92, 25);
		add(lblTn);
		
		JLabel lblLoi = new JLabel("Loại:");
		lblLoi.setHorizontalAlignment(SwingConstants.LEFT);
		lblLoi.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblLoi.setBounds(88, 250, 92, 25);
		add(lblLoi);
		
		JLabel lblGiiTnh = new JLabel("Giới tính:");
		lblGiiTnh.setHorizontalAlignment(SwingConstants.LEFT);
		lblGiiTnh.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblGiiTnh.setBounds(88, 295, 92, 25);
		add(lblGiiTnh);
		
		JLabel lblSt = new JLabel("Sđt:");
		lblSt.setHorizontalAlignment(SwingConstants.LEFT);
		lblSt.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSt.setBounds(88, 340, 92, 25);
		add(lblSt);
		
		JLabel lblNmSinh = new JLabel("Năm sinh:");
		lblNmSinh.setHorizontalAlignment(SwingConstants.LEFT);
		lblNmSinh.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNmSinh.setBounds(88, 385, 92, 25);
		add(lblNmSinh);
		
		JLabel lblTin = new JLabel("Tiền:");
		lblTin.setHorizontalAlignment(SwingConstants.LEFT);
		lblTin.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTin.setBounds(88, 430, 92, 25);
		add(lblTin);
		
		JLabel lblThngTinKhch = new JLabel("THÔNG TIN KHÁCH HÀNG");
		lblThngTinKhch.setForeground(Color.YELLOW);
		lblThngTinKhch.setHorizontalAlignment(SwingConstants.LEFT);
		lblThngTinKhch.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblThngTinKhch.setBounds(100, 60, 350, 40);
		add(lblThngTinKhch);
		
		txtMa = new JTextField();
		txtMa.setForeground(Color.BLACK);
		txtMa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMa.setEnabled(false);
		txtMa.setBounds(210, 160, 200, 25);
		add(txtMa);
		txtMa.setColumns(10);

		
		txtTen = new JTextField();
		txtTen.setForeground(Color.BLACK);
		txtTen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTen.setEnabled(false);
		txtTen.setColumns(10);
		txtTen.setBounds(210, 205, 200, 25);
		add(txtTen);
		
		txtLoai = new JTextField();
		txtLoai.setForeground(Color.BLACK);
		txtLoai.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtLoai.setEnabled(false);
		txtLoai.setColumns(10);
		txtLoai.setBounds(210, 250, 200, 25);
		add(txtLoai);
		
		txtGioiTinh = new JTextField();
		txtGioiTinh.setForeground(Color.BLACK);
		txtGioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtGioiTinh.setEnabled(false);
		txtGioiTinh.setColumns(10);
		txtGioiTinh.setBounds(210, 295, 200, 25);
		add(txtGioiTinh);
		
		txtSdt = new JTextField();
		txtSdt.setForeground(Color.BLACK);
		txtSdt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSdt.setEnabled(false);
		txtSdt.setColumns(10);
		txtSdt.setBounds(210, 340, 200, 25);
		add(txtSdt);
		
		txtNamSinh = new JTextField();
		txtNamSinh.setForeground(Color.BLACK);
		txtNamSinh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNamSinh.setEnabled(false);
		txtNamSinh.setColumns(10);
		txtNamSinh.setBounds(210, 385, 200, 25);
		add(txtNamSinh);
		
		txtTien = new JTextField();
		txtTien.setForeground(Color.BLACK);
		txtTien.setFont(new Font("Tahoma", Font.PLAIN, 14));
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
		txtSdt.setText("0" + khachHang.getSdt().toString());
		txtNamSinh.setText(khachHang.getNamSinh().toString());
		txtTien.setText(khachHang.getTien().toString());
	}
	
	protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(scaledImage, 0, 0, this);       
 }
}
