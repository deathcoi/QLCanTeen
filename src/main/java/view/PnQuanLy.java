package view;

import javax.swing.JPanel;

import java.awt.CardLayout;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToolBar;
import javax.swing.JComboBox;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PnQuanLy extends JPanel {

	/**
	 * Create the panel.
	 */
	private CardLayout cardLayout;
	private JPanel cardPanel;
	public PnQuanLy(CardLayout cardLayout, JPanel cardPanel) {
		this.cardLayout = cardLayout;
		this.cardPanel = cardPanel;
		
		setBounds(0, 0, 1024, 600);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(116, 97, 85, 21);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnClicked();
			}
		});
		setLayout(null);
		
		JPopupMenu popupMenu = new JPopupMenu();
		popupMenu.setBounds(0, 0, 416, 16);
		addPopup(this, popupMenu);
		
		JButton btnNewButton_1 = new JButton("New button");
		popupMenu.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		popupMenu.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("New button");
		popupMenu.add(btnNewButton_3);
		add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Quản lý");
		lblNewLabel.setBounds(211, 101, 34, 13);
		add(lblNewLabel);

	}
	private void btnClicked() {
		cardLayout.next(cardPanel);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
