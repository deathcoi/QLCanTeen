package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import view.PnDangNhap;
import view.PnKhachHang;
import view.PnNhanVien;
import view.PnQuanLy;

import java.awt.CardLayout;

public class Main extends JFrame {

	private JPanel contentPane;
	private CardLayout cardLayout;
	
	public PnDangNhap pnDangNhap;
	public PnQuanLy pnQuanLy;
	public PnNhanVien pnNhanVien;
	public PnKhachHang pnKhachHang;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(100, 100, 1050, 650);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		cardLayout = new CardLayout(0, 0);
		contentPane.setLayout(cardLayout);
		
		pnDangNhap = new PnDangNhap(cardLayout, contentPane, this);
		contentPane.add(pnDangNhap, "pnDangNhap");
		
		pnQuanLy = new PnQuanLy(cardLayout, contentPane, this);
		contentPane.add(pnQuanLy, "pnQuanLy");
		
		pnNhanVien = new PnNhanVien(cardLayout, contentPane, this);
		contentPane.add(pnNhanVien, "pnNhanVien");
		
		pnKhachHang = new PnKhachHang(cardLayout, contentPane, this);
		contentPane.add(pnKhachHang, "pnKhachHang");
	}

}
