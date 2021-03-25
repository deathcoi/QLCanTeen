package view;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.Dimension;

public class PnNhapNguyenLieu extends JPanel {

	private JTable table_1;
	private JTextField txtMNL;
	private JTextField txtTenNL;
	private JTextField txtSL;

	/**
	 * Create the panel.
	 */
	public PnNhapNguyenLieu() {
		setBounds(0, 0, 560, 500);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 560, 110);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mã nguyên liệu:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 10, 110, 20);
		panel_1.add(lblNewLabel);
		
		txtMNL = new JTextField();
		txtMNL.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMNL.setHorizontalAlignment(SwingConstants.LEFT);
		txtMNL.setBounds(120, 10, 100, 20);
		panel_1.add(txtMNL);
		txtMNL.setColumns(10);
		
		JLabel lblTnNguynLiu = new JLabel("Tên nguyên liệu:");
		lblTnNguynLiu.setHorizontalAlignment(SwingConstants.LEFT);
		lblTnNguynLiu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTnNguynLiu.setBounds(10, 45, 110, 20);
		panel_1.add(lblTnNguynLiu);
		
		JLabel lblSLng = new JLabel("Số lượng:");
		lblSLng.setHorizontalAlignment(SwingConstants.LEFT);
		lblSLng.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSLng.setBounds(10, 80, 110, 20);
		panel_1.add(lblSLng);
		
		txtTenNL = new JTextField();
		txtTenNL.setHorizontalAlignment(SwingConstants.LEFT);
		txtTenNL.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTenNL.setColumns(10);
		txtTenNL.setBounds(120, 45, 200, 20);
		panel_1.add(txtTenNL);
		
		txtSL = new JTextField();
		txtSL.setHorizontalAlignment(SwingConstants.LEFT);
		txtSL.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSL.setColumns(10);
		txtSL.setBounds(120, 80, 100, 20);
		panel_1.add(txtSL);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnThem.setBounds(390, 25, 90, 25);
		panel_1.add(btnThem);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSua.setBounds(390, 60, 90, 25);
		panel_1.add(btnSua);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 110, 560, 390);
		panel.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_2.add(scrollPane, BorderLayout.CENTER);
		
		table_1 = new JTable(new DefaultTableModel(new Object[] {"Mã nguyên liệu", "Tên nguyên liệu", "Số lượng"}, 0));
		scrollPane.setViewportView(table_1);
		table_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
	}
}