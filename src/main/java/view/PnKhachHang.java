package view;

import javax.swing.JPanel;

import java.awt.CardLayout;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PnKhachHang extends JPanel {

	/**
	 * Create the panel.
	 */
	private JFrame mainFrame;
	
	private CardLayout cardLayout;
	private JPanel cardPanel;
	public PnKhachHang(CardLayout cardLayout, JPanel cardPanel, JFrame mainFrame) {
		this.cardLayout = cardLayout;
		this.cardPanel = cardPanel;
		this.mainFrame = mainFrame;
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnClicked();
			}
		});
		add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("khách hàng");
		add(lblNewLabel);
		
	}
	private void btnClicked() {
		cardLayout.next(cardPanel);
	}
}
