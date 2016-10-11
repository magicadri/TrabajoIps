package gui;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class ColorCellRenderer extends DefaultTableCellRenderer{
	
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int col)
	{
		JLabel l = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);
		DataTableModel tableModel = (DataTableModel) table.getModel();
		
		if(tableModel.getStatus(row) == "Reserva Pisc")
		{
			l.setForeground(Color.RED);
		}
		
		return l;
	}

}
