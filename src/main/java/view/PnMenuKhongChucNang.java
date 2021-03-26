package view;

import javax.swing.JPanel;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.util.List;
import java.awt.Color;
import javax.swing.border.LineBorder;

import DAO.MonAnDAO;
import entities.MonAn;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.Font;

public class PnMenuKhongChucNang extends JPanel {

	/**
	 * Create the panel.
	 */
	private JPanel pnMonAn;
	private JPanel pnNuoc;

	private Image image;
	private Image scaledImage;
	public PnMenuKhongChucNang() {
		setBounds(0, 0, 560, 500);
		try {
			image = ImageIO.read(new File("picture/menu.jpg"));
			scaledImage = image.getScaledInstance(this.getWidth(),this.getHeight(),Image.SCALE_SMOOTH);
		} catch (IOException e) {
			e.printStackTrace();
		}
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBackground(new Color(1.0f, 1.0f, 1.0f, 0.5f));
		
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
			JPanel pnBtn = new JPanel();
			pnBtn.setOpaque(false);
			pnBtn.setLayout(new BorderLayout());
			pnBtn.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
			//pnBtn.setBackground(Color.cyan);
			
			JLabel lb = new JLabel(monAn.getTenMA());
			lb.setForeground(Color.WHITE);
			lb.setHorizontalAlignment(SwingConstants.CENTER);
			lb.setFont(new Font("Tahoma", Font.BOLD, 18));
			pnBtn.add(lb, BorderLayout.CENTER);
			
			if (monAn.getLoaiMonAn().getMaLoai().compareTo("nuoc") != 0 && monAn.getLoaiMonAn().getMaLoai().compareTo("nuocSuoi") != 0) {
				pnMonAn.add(pnBtn);
			}
			else {
				pnNuoc.add(pnBtn);
			}
		}
	}
	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(scaledImage, 0, 0, this); // see javadoc for more info on the parameters            
    }
	//monAnPn.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
}
