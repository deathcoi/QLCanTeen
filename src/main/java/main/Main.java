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
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		cardLayout = new CardLayout(0, 0);
		contentPane.setLayout(cardLayout);
		
		JPanel pnDangNhap = new PnDangNhap(cardLayout, contentPane);
		contentPane.add(pnDangNhap, "pnDangNhap");
		
		JPanel pnQuanLy = new PnQuanLy(cardLayout, contentPane);
		contentPane.add(pnQuanLy, "pnQuanLy");
		
		JPanel pnNhanVienJPanel = new PnNhanVien(cardLayout, contentPane);
		contentPane.add(pnNhanVienJPanel, "pnNhanVien");
		
		JPanel pnKhachHang = new PnKhachHang(cardLayout, contentPane);
		contentPane.add(pnKhachHang, "pnKhachHang");
	}

}
