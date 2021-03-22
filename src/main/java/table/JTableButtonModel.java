package table;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

public class JTableButtonModel extends DefaultTableModel{

	public JTableButtonModel(Object[] rows, int columns) {
		super(rows, columns);
	}
	
	public boolean isCellEditable(int row, int column) {
		return false;
	}

	public Class getColumnClass(int column) {
		return getValueAt(0, column).getClass();
	}
}
