package view;

import javax.swing.JPanel;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

public class PnNhanVien extends JPanel {

	/**
	 * Create the panel.
	 */
	private CardLayout cardLayout;
	private JPanel cardPanel;
	
	private CardLayout cardLayoutThis;
	private JPanel cardPanelThis;
	public PnNhanVien(CardLayout cardLayout, JPanel cardPanel) {
		this.cardLayout = cardLayout;
		this.cardPanel = cardPanel;
		
		setBounds(0, 0, 1024, 600);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 64, 600);
		add(panel);
		
		cardPanelThis = new JPanel();
		cardPanelThis.setBounds(62, 0, 560, 600);
		add(cardPanelThis);
		cardLayoutThis = new CardLayout(0, 0);
		cardPanelThis.setLayout(cardLayoutThis);
		
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(622, 0, 402, 600);
		add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_3.add(lblNewLabel);
		
		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.X_AXIS));
		
		JPanel panel_5 = new JPanel();
		panel_4.add(panel_5);
		panel_5.setLayout(new BoxLayout(panel_5, BoxLayout.Y_AXIS));
		
		JPanel pnHoaDonButton;
		pnHoaDonButton = new JPanel();
		pnHoaDonButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		pnHoaDonButton.setName("pnHoaDonButton");
		pnHoaDonButton.addMouseListener(new PanelButtonMouseAdapter(pnHoaDonButton, cardPanelThis));
		panel_5.add(pnHoaDonButton);
		pnHoaDonButton.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("Hóa đơn");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		pnHoaDonButton.add(lblNewLabel_1, BorderLayout.CENTER);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_9.addMouseListener(new PanelButtonMouseAdapter(panel_9, cardPanelThis));
		panel_5.add(panel_9);
		panel_9.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1_1 = new JLabel("New label");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_9.add(lblNewLabel_1_1, BorderLayout.CENTER);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_10.addMouseListener(new PanelButtonMouseAdapter(panel_10, cardPanelThis));
		panel_5.add(panel_10);
		panel_10.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1_2 = new JLabel("New label");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_10.add(lblNewLabel_1_2, BorderLayout.CENTER);
		
		JPanel panel_6 = new JPanel();
		panel_4.add(panel_6);
		panel_6.setLayout(new BoxLayout(panel_6, BoxLayout.Y_AXIS));
		
		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_8.addMouseListener(new PanelButtonMouseAdapter(panel_8, cardPanelThis));
		panel_6.add(panel_8);
		panel_8.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1_6 = new JLabel("New label");
		lblNewLabel_1_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_8.add(lblNewLabel_1_6, BorderLayout.CENTER);
		
		JPanel panel_14 = new JPanel();
		panel_14.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_14.addMouseListener(new PanelButtonMouseAdapter(panel_14, cardPanelThis));
		panel_6.add(panel_14);
		panel_14.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1_7 = new JLabel("New label");
		lblNewLabel_1_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_7.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_14.add(lblNewLabel_1_7, BorderLayout.CENTER);
		
		JPanel pnLoaiMonAnButton = new JPanel();
		pnLoaiMonAnButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		pnLoaiMonAnButton.setName("pnLoaiMonAnButton");
		pnLoaiMonAnButton.addMouseListener(new PanelButtonMouseAdapter(pnLoaiMonAnButton, cardPanelThis));
		panel_6.add(pnLoaiMonAnButton);
		pnLoaiMonAnButton.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1_8 = new JLabel("New label");
		lblNewLabel_1_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_8.setFont(new Font("Tahoma", Font.PLAIN, 18));
		pnLoaiMonAnButton.add(lblNewLabel_1_8, BorderLayout.CENTER);
		
		JPanel pnLoaiMonAn = new PnLoaiMonAn();
		cardPanelThis.add(pnLoaiMonAn, "pnLoaiMonAn");
		
		JPanel pnHoaDon = new PnMenuKhongChucNang();
		cardPanelThis.add(pnHoaDon, "pnHoaDon");

	}
	
	private class PanelButtonMouseAdapter extends MouseAdapter {
		JPanel panel;
		JPanel cardPanel;

		/*public PanelButtonMouseAdapter(JPanel panel, JPanel cardPanel) {
			this.panel = panel;
			this.cardPanel = cardPanel;
		}*/
		
		public PanelButtonMouseAdapter(JPanel panel, JPanel cardPanel) {
			this.panel = panel;
			this.cardPanel = cardPanel;
		}

		@Override
		public void mousePressed(MouseEvent e) {
			panel.setBackground(Color.CYAN);
			/*if (panel.getName().compareTo("pnImport") == 0) {
				card.show(cardPanel, "pnImportLop");
			}
			if (panel.getName().compareTo("pnDiem") == 0) {
				card.show(cardPanel, "pnChinhSuaDiem");
			}
			if (panel.getName().compareTo("pnMonHoc") == 0) {
				card.show(cardPanel, "pnChinhSuaMonHoc");
			}
			if (panel.getName().compareTo("pnSinhVien") == 0) {
				card.show(cardPanel, "pnChinhSuaSinhVien");
			}
			if (panel.getName().compareTo("pnXem") == 0) {
				card.show(cardPanel, "pnXemThongTin");
			}*/
			if (panel.getName().compareTo("pnLoaiMonAnButton") == 0) {
				cardLayoutThis.show(cardPanel, "pnLoaiMonAn");
			}
			if (panel.getName().compareTo("pnHoaDonButton") == 0) {
				cardLayoutThis.show(cardPanel, "pnHoaDon");
			}
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			panel.setBackground(Color.BLUE);
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			panel.setBackground(Color.BLUE);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			panel.setBackground(Color.LIGHT_GRAY);
		}
	}
}
