package table;

import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class JTableButtonModel extends DefaultTableModel{

	public JTableButtonModel(Object[] rows, int columns) {
		super(rows, columns);
	}
	
	public boolean isCellEditable(int row, int column) {
		return false;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Class getColumnClass(int column) {
		return getValueAt(0, column).getClass();
	}
}
