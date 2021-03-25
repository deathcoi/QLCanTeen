package view;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class PnChinhSuaMonAn extends JPanel {

	private JTable table_1;
	private JTextField txtMaMA;
	private JTextField txtML;
	private JTextField txtMNL;
	private JTextField txtTenMA;
	
	public PnChinhSuaMonAn() {
		setBounds(0, 0, 560, 500);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
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
		
		txtML = new JTextField();
		txtML.setHorizontalAlignment(SwingConstants.LEFT);
		txtML.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtML.setColumns(10);
		txtML.setBounds(120, 45, 100, 20);
		panel_1.add(txtML);
		
		txtMNL = new JTextField();
		txtMNL.setHorizontalAlignment(SwingConstants.LEFT);
		txtMNL.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMNL.setColumns(10);
		txtMNL.setBounds(120, 80, 100, 20);
		panel_1.add(txtMNL);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnThem.setBounds(390, 25, 90, 25);
		panel_1.add(btnThem);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSua.setBounds(390, 95, 90, 25);
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
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnXoa.setBounds(390, 60, 90, 25);
		panel_1.add(btnXoa);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 150, 560, 350);
		panel.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_2.add(scrollPane, BorderLayout.CENTER);
		
		table_1 = new JTable(new DefaultTableModel(new Object[] {"Mã nguyên liệu", "Tên nguyên liệu", "Số lượng"}, 0));
		scrollPane.setViewportView(table_1);
		table_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
	}

}
