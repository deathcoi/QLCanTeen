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

public class PnNhanVien extends JPanel {

	/**
	 * Create the panel.
	 */
	private CardLayout cardLayout;
	private JPanel cardPanel;
	public PnNhanVien(CardLayout cardLayout, JPanel cardPanel) {
		this.cardLayout = cardLayout;
		this.cardPanel = cardPanel;
		
		setBounds(0, 0, 1024, 600);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 64, 600);
		add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(62, 0, 560, 600);
		add(panel_1);
		
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
		
		JPanel panel_7 = new JPanel();
		panel_7.addMouseListener(new PanelButtonMouseAdapter(panel_7));
		panel_5.add(panel_7);
		panel_7.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_7.add(lblNewLabel_1, BorderLayout.CENTER);
		
		JPanel panel_9 = new JPanel();
		panel_9.addMouseListener(new PanelButtonMouseAdapter(panel_9));
		panel_5.add(panel_9);
		panel_9.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1_1 = new JLabel("New label");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_9.add(lblNewLabel_1_1, BorderLayout.CENTER);
		
		JPanel panel_10 = new JPanel();
		panel_10.addMouseListener(new PanelButtonMouseAdapter(panel_10));
		panel_5.add(panel_10);
		panel_10.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1_2 = new JLabel("New label");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_10.add(lblNewLabel_1_2, BorderLayout.CENTER);
		
		JPanel panel_11 = new JPanel();
		panel_11.addMouseListener(new PanelButtonMouseAdapter(panel_11));
		panel_5.add(panel_11);
		panel_11.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1_3 = new JLabel("New label");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_11.add(lblNewLabel_1_3, BorderLayout.CENTER);
		
		JPanel panel_12 = new JPanel();
		panel_12.addMouseListener(new PanelButtonMouseAdapter(panel_12));
		panel_5.add(panel_12);
		panel_12.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1_4 = new JLabel("New label");
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_12.add(lblNewLabel_1_4, BorderLayout.CENTER);
		
		JPanel panel_13 = new JPanel();
		panel_13.addMouseListener(new PanelButtonMouseAdapter(panel_13));
		panel_5.add(panel_13);
		panel_13.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1_5 = new JLabel("New label");
		lblNewLabel_1_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_13.add(lblNewLabel_1_5, BorderLayout.CENTER);
		
		JPanel panel_6 = new JPanel();
		panel_4.add(panel_6);
		panel_6.setLayout(new BoxLayout(panel_6, BoxLayout.Y_AXIS));
		
		JPanel panel_8 = new JPanel();
		panel_8.addMouseListener(new PanelButtonMouseAdapter(panel_8));
		panel_6.add(panel_8);
		panel_8.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1_6 = new JLabel("New label");
		lblNewLabel_1_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_8.add(lblNewLabel_1_6, BorderLayout.CENTER);
		
		JPanel panel_14 = new JPanel();
		panel_14.addMouseListener(new PanelButtonMouseAdapter(panel_14));
		panel_6.add(panel_14);
		panel_14.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1_7 = new JLabel("New label");
		lblNewLabel_1_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_7.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_14.add(lblNewLabel_1_7, BorderLayout.CENTER);
		
		JPanel panel_15 = new JPanel();
		panel_15.addMouseListener(new PanelButtonMouseAdapter(panel_15));
		panel_6.add(panel_15);
		panel_15.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1_8 = new JLabel("New label");
		lblNewLabel_1_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_8.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_15.add(lblNewLabel_1_8, BorderLayout.CENTER);
		
		JPanel panel_16 = new JPanel();
		panel_16.addMouseListener(new PanelButtonMouseAdapter(panel_16));
		panel_6.add(panel_16);
		panel_16.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1_9 = new JLabel("New label");
		lblNewLabel_1_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_9.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_16.add(lblNewLabel_1_9, BorderLayout.CENTER);
		
		JPanel panel_17 = new JPanel();
		panel_17.addMouseListener(new PanelButtonMouseAdapter(panel_17));
		panel_6.add(panel_17);
		panel_17.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1_10 = new JLabel("New label");
		lblNewLabel_1_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_10.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_17.add(lblNewLabel_1_10, BorderLayout.CENTER);
		
		JPanel panel_18 = new JPanel();
		panel_18.addMouseListener(new PanelButtonMouseAdapter(panel_18));
		panel_6.add(panel_18);
		panel_18.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1_11 = new JLabel("New label");
		lblNewLabel_1_11.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_11.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_18.add(lblNewLabel_1_11, BorderLayout.CENTER);

	}
	
	private class PanelButtonMouseAdapter extends MouseAdapter {
		JPanel panel;
		JPanel cardPanel;

		/*public PanelButtonMouseAdapter(JPanel panel, JPanel cardPanel) {
			this.panel = panel;
			this.cardPanel = cardPanel;
		}*/
		
		public PanelButtonMouseAdapter(JPanel panel) {
			this.panel = panel;
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
