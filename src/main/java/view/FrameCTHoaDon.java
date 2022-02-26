package view;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import DAO.CTHoaDonDAO;
import constant.HttpConstant;
import entities.CTHoaDon;
import entities.HoaDon;
import service.IpushMethodService;
import service.impl.PushMethodService;

public class FrameCTHoaDon extends JFrame {

	private static final long serialVersionUID = 1L;
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
		setBounds(50, 50, 480, 300);
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
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public JTableUnEdit(Object[] objects, int i) {
			super(objects, i);
		}

		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}
	}
	
	private void loadData() {
		ObjectMapper mapper = new ObjectMapper();
		IpushMethodService service = new PushMethodService();
		
		List<CTHoaDon> list = null;
		try {
			list = CTHoaDonDAO.layDanhSachCTHoaDon(hoaDon);
		} catch (Exception e) {
			e.printStackTrace();
		} 
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
