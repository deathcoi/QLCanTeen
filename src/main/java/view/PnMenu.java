package view;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.xdevapi.Table;

import DAO.MonAnDAO;
import entities.MonAn;
import table.JTableButtonModel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class PnMenu extends JPanel {
	private JPanel pnMonAn;
	private JPanel pnNuoc;
	private PnThanhToan pnThanhToan;

	private BufferedImage image;
	private Image scaledImage;

	public PnMenu(PnThanhToan pnThanhToan) {
		this.pnThanhToan = pnThanhToan;
		setBounds(0, 0, 560, 600);
		try {
			image = ImageIO.read(new File("picture/main.png"));
			scaledImage = image.getScaledInstance(this.getWidth(),this.getHeight(),Image.SCALE_SMOOTH);
		} catch (IOException e) {
			e.printStackTrace();
		}
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		pnMonAn = new JPanel();
		pnMonAn.setOpaque(false);
		add(pnMonAn);
		pnMonAn.setLayout(new GridLayout(3, 3, 5, 5));
		
		pnNuoc = new JPanel();
		pnNuoc.setOpaque(false);
		add(pnNuoc);
		pnNuoc.setLayout(new GridLayout(3, 3, 5, 5));

		addMonAnAuto();

	}

	private void addMonAnAuto() {
		List<MonAn> list = MonAnDAO.layDanhSachMonAn();

		for (MonAn monAn : list) {
			//System.out.println(monAn.getTenMA());
			if (monAn.getNguyenLieu().getSoLuong() != 0) {
				JPanel pnBtn = new JPanel();
				pnBtn.setOpaque(false);
				pnBtn.setLayout(new BorderLayout());
				pnBtn.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
				pnBtn.setName(monAn.getMaMA() + "," + monAn.getTenMA() + "," + monAn.getLoaiMonAn().getGiaTien());

				pnBtn.addMouseListener(new PanelButtonMouseAdapter(pnBtn));
				// pnBtn.setBackground(Color.cyan);

				JLabel lb = new JLabel(monAn.getTenMA() + " : " + monAn.getNguyenLieu().getSoLuong());
				lb.setForeground(Color.WHITE);
				lb.setHorizontalAlignment(SwingConstants.CENTER);
				lb.setFont(new Font("Tahoma", Font.BOLD, 18));
				pnBtn.add(lb, BorderLayout.CENTER);

				if (monAn.getLoaiMonAn().getMaLoai().compareTo("nuoc") != 0
						&& monAn.getLoaiMonAn().getMaLoai().compareTo("nuocSuoi") != 0) {
					pnMonAn.add(pnBtn);
				} else {
					pnNuoc.add(pnBtn);
				}
			}
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(scaledImage, 0, 0, this); // see javadoc for more info on the parameters
	}

	private class PanelButtonMouseAdapter extends MouseAdapter {
		JPanel panel; // panel nhận sự kiện click

		public PanelButtonMouseAdapter(JPanel panel) {
			this.panel = panel;
		}

		@Override
		public void mousePressed(MouseEvent e) {
			panel.setBackground(Color.CYAN);
			monAnClicked(panel);
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			panel.setBackground(Color.BLUE);
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			panel.setOpaque(true);
			panel.setBackground(Color.BLUE);
		}
		@Override
		public void mouseExited(MouseEvent e) {
			panel.setOpaque(false);
			panel.setBackground(Color.WHITE);
		}
	}

	private void monAnClicked(JPanel panel) {
		String[] monAns = panel.getName().split(",");// 1 la ma, 2 la ten, 3 la gia tien
		JTableButtonModel model = (JTableButtonModel) pnThanhToan.table.getModel();
		int flag = 0;
		for (int i = 0; i < model.getRowCount(); i++) {
			if (model.getValueAt(i, 0).toString().compareTo(monAns[1]) == 0) {
				flag = 1;
			}
		}
		if (flag == 0)
			model.addRow(new Object[] { monAns[1], "1", monAns[2], new JButton("+"), new JButton("-")});
		tinhTong();
	}
	
	private void tinhTong() {
		JTableButtonModel model = (JTableButtonModel) pnThanhToan.table.getModel();
		Long tong = (long) 0;
		for (int i = 0; i < model.getRowCount(); i++) {
			Long gia = Long.parseLong(model.getValueAt(i, 2).toString());
			Long sl = Long.parseLong(model.getValueAt(i, 1).toString());
			tong += gia * sl;
		}
		JLabel lbTongCong = pnThanhToan.getLbTongCong();
		lbTongCong.setText(tong.toString());
	}
}
