package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import constant.HttpConstant;
import entities.NguyenLieu;
import service.IpushMethodService;
import service.impl.PushMethodService;

public class PnNhapNguyenLieu extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JTable table_1;
	private JTextField txtMNL;
	private JTextField txtTenNL;
	private JTextField txtSL;
	private PnQuanLy pnQuanLy;

	public PnNhapNguyenLieu(JPanel pnQuanLy) {
		this.pnQuanLy = (PnQuanLy) pnQuanLy;
		setBounds(0, 0, 560, 600);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(51, 204, 204));
		panel_1.setBounds(0, 0, 560, 160);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mã nguyên liệu:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 54, 140, 25);
		panel_1.add(lblNewLabel);
		
		txtMNL = new JTextField();
		txtMNL.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMNL.setHorizontalAlignment(SwingConstants.LEFT);
		txtMNL.setBounds(150, 54, 100, 25);
		panel_1.add(txtMNL);
		txtMNL.setColumns(10);
		
		JLabel lblTnNguynLiu = new JLabel("Tên nguyên liệu:");
		lblTnNguynLiu.setHorizontalAlignment(SwingConstants.LEFT);
		lblTnNguynLiu.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTnNguynLiu.setBounds(10, 89, 140, 25);
		panel_1.add(lblTnNguynLiu);
		
		JLabel lblSLng = new JLabel("Số lượng:");
		lblSLng.setHorizontalAlignment(SwingConstants.LEFT);
		lblSLng.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSLng.setBounds(10, 124, 140, 25);
		panel_1.add(lblSLng);
		
		txtTenNL = new JTextField();
		txtTenNL.setHorizontalAlignment(SwingConstants.LEFT);
		txtTenNL.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTenNL.setColumns(10);
		txtTenNL.setBounds(150, 89, 200, 25);
		panel_1.add(txtTenNL);
		
		txtSL = new JTextField();
		txtSL.setHorizontalAlignment(SwingConstants.LEFT);
		txtSL.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSL.setColumns(10);
		txtSL.setBounds(150, 124, 100, 25);
		panel_1.add(txtSL);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnThemClicked();
			}
		});
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnThem.setBounds(390, 69, 90, 30);
		panel_1.add(btnThem);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSuaClicked();
			}
		});
		btnSua.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSua.setBounds(390, 104, 90, 30);
		panel_1.add(btnSua);
		
		JLabel lblNhpNguynLiu = new JLabel("Nhập nguyên liệu");
		lblNhpNguynLiu.setForeground(Color.YELLOW);
		lblNhpNguynLiu.setHorizontalAlignment(SwingConstants.LEFT);
		lblNhpNguynLiu.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNhpNguynLiu.setBounds(165, 11, 227, 30);
		panel_1.add(lblNhpNguynLiu);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 160, 560, 440);
		panel.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_2.add(scrollPane, BorderLayout.CENTER);
		
		table_1 = new JTable(new DefaultTableModel(new Object[] {"Mã nguyên liệu", "Tên nguyên liệu", "Số lượng"}, 0));
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tableMouseClicked();
			}
		});
		scrollPane.setViewportView(table_1);
		table_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		loadTable();
	}

	private void loadTable() {
		ObjectMapper mapper = new ObjectMapper();
		IpushMethodService method = new PushMethodService();
		
		DefaultTableModel model = (DefaultTableModel) table_1.getModel();
		model.setRowCount(0);
		List<NguyenLieu> listNL = null;
		try {
			listNL = mapper.readValue(method.pushMethod(HttpConstant.HTTPREQUESTGET, "http://localhost:8080/APISpring/api/nguyenlieu", null), new TypeReference<List<NguyenLieu>>() {
			});
		} catch(Exception ex) {
			listNL = null;
		}
		for (NguyenLieu n : listNL) {
			model.addRow(new Object[] {
				n.getMaNguyenLieu(),
				n.getTenNguyenLieu(),
				n.getSoLuong()
			});
		}
	}
	
	 private void tableMouseClicked() {                                     
	        int index = table_1.getSelectedRow();
	        txtMNL.setText((String) table_1.getValueAt(index, 0));
	        txtTenNL.setText((String) table_1.getValueAt(index, 1));
	        txtSL.setText((String) table_1.getValueAt(index, 2).toString());
	    }
	
	private void btnThemClicked() {
		IpushMethodService method = new PushMethodService();
		
		try {
			NguyenLieu nguyenLieu = new NguyenLieu();
			nguyenLieu.setMaNguyenLieu(txtMNL.getText());
			nguyenLieu.setTenNguyenLieu(txtTenNL.getText());
			nguyenLieu.setSoLuong(Integer.parseInt(txtSL.getText()));
			
			method.pushMethod(HttpConstant.HTTPREQUESTPOST, "http://localhost:8080/APISpring/api/nguyenlieu", nguyenLieu);
			
			loadTable();
			loadText();
			
			pnQuanLy.getPnChinhSuaMonAn().refreshPn();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void btnSuaClicked() {
		try {
			IpushMethodService method = new PushMethodService();
			
			NguyenLieu nguyenLieu = new NguyenLieu();
			
			nguyenLieu.setMaNguyenLieu(txtMNL.getText());
			nguyenLieu.setTenNguyenLieu(txtTenNL.getText());
			nguyenLieu.setSoLuong(Integer.parseInt(txtSL.getText()));
			
			method.pushMethod(HttpConstant.HTTPREQUESTPUT, "http://localhost:8080/APISpring/api/nguyenlieu", nguyenLieu);
			
			loadTable();
			
			loadText();
			
			pnQuanLy.getPnChinhSuaMonAn().refreshPn();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void loadText() {
		txtMNL.setText("");
		txtTenNL.setText("");
		txtSL.setText("");
	}
}
