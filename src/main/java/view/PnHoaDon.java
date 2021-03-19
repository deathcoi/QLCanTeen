package view;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class PnHoaDon extends JPanel {

	/**
	 * Create the panel.
	 */
	public PnHoaDon() {
		setBounds(0, 0, 560, 600);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel pnMonAn = new JPanel();
		add(pnMonAn);
		pnMonAn.setLayout(new BoxLayout(pnMonAn, BoxLayout.Y_AXIS));
		
		JPanel pnMonChinh = new JPanel();
		pnMonAn.add(pnMonChinh);
		pnMonChinh.setLayout(new BoxLayout(pnMonChinh, BoxLayout.X_AXIS));
		
		JPanel pnNuocNgot = new JPanel();
		pnMonAn.add(pnNuocNgot);
		pnNuocNgot.setLayout(new BoxLayout(pnNuocNgot, BoxLayout.X_AXIS));
		
		JPanel pnNuocLoc = new JPanel();
		pnMonAn.add(pnNuocLoc);
		pnNuocLoc.setLayout(new BoxLayout(pnNuocLoc, BoxLayout.X_AXIS));
		
		JPanel pnTable = new JPanel();
		add(pnTable);
		pnTable.setLayout(null);
	}
}
