package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DAO.CTHoaDonDAO;
import entities.CTHoaDon;
import entities.HoaDon;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class FrameCTHoaDon extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private HoaDon hoaDon;

	/**
	 * Create the frame.
	 */
	public FrameCTHoaDon(HoaDon hoaDon) {
		this.hoaDon = hoaDon;
		setTitle("Chi tiết hóa đơn " + hoaDon.getMaHD());
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 480, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable(new JTableUnEdit(new Object[] {"Mã HĐ", "Tên món ăn", "Số lượng"}, 0));
		scrollPane.setViewportView(table);
		
		loadData();
	}

	private class JTableUnEdit extends DefaultTableModel {
		public JTableUnEdit(Object[] objects, int i) {
			super(objects, i);
		}

		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}
	}
	
	private void loadData() {
		List<CTHoaDon> list = CTHoaDonDAO.layDanhSachCTHoaDon(hoaDon);
		JTableUnEdit model = (JTableUnEdit) table.getModel();
		for (CTHoaDon ctHoaDon : list) {
			model.addRow(new Object[] {
					ctHoaDon.getHoaDon().getMaHD(),
					ctHoaDon.getMonAn().getTenMA(),
					ctHoaDon.getSoLuong()
			});
		}
	}
}
