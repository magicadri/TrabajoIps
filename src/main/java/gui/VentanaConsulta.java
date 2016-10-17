package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logic.Data;
import logic.Reserva;

import javax.swing.JTextField;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;

public class VentanaConsulta extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textSocioID;
	private JTable tableReservas;
	Data data = new Data();
	DefaultTableModel md;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VentanaConsulta dialog = new VentanaConsulta();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VentanaConsulta() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		contentPanel.add(getTextSocioID(), BorderLayout.NORTH);
		contentPanel.add(getTableReservas(), BorderLayout.CENTER);
	}

	private JTextField getTextSocioID() {
		if (textSocioID == null) {
			textSocioID = new JTextField();
			textSocioID.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String socio= textSocioID.getText();
					fillTable(socio);
				}
			});
			textSocioID.setColumns(10);
		}
		return textSocioID;
	}
	
	private void fillTable(String socio)
	{
		if(socio.equals(data.getSocio1().getSocioID()))
		{
			for(Reserva each: data.getReservas())
			{
				if(each.getHoraComienzo().after(new Date()))
					if (each.getSocio().getSocioID().equals(socio))
						md.addRow(new Object[] {each.getInstalacion()+" "+ each.getHoraComienzo()+ " -" + each.getHoraFinal()});
			}
		}
		tableReservas.setModel(md);
	}
	
	private JTable getTableReservas() {
		if (tableReservas == null) {
			tableReservas = new JTable();
			md = new DefaultTableModel(new Object[]{"Column1"},1);
			tableReservas.setModel(md);
		}
		return tableReservas;
	}
}
