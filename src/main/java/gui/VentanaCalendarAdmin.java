package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.toedter.calendar.JDateChooser;

import logic.Administrador;
import logic.Data;
import logic.Instalacion;
import logic.Reserva;
import logic.Socio;

import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.beans.PropertyChangeEvent;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

public class VentanaCalendarAdmin extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JDateChooser dateChooser;
	private JTextField tf;
	private JTable table;
	private JCheckBox chbPiscina;
	Data data = new Data();
	private JCheckBox chbTenis;
	private JCheckBox chbFutbol;
	private JTextPane txPDescripcion;
	private JLabel lblDescripcion;
	private JLabel lblHora;
	private JLabel lbHora;
	private JButton btnHora;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VentanaCalendarAdmin dialog = new VentanaCalendarAdmin();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VentanaCalendarAdmin() {
		setBounds(100, 100, 887, 470);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.add(getDateChooser());
		contentPanel.add(getTable());
		contentPanel.add(getChbPiscina());
		contentPanel.add(getChbTenis());
		contentPanel.add(getChbFutbol());
		// Pone el dia actual en el dateChooser
		dateChooser.setDate((new Date()));
		contentPanel.add(getTxPDescripcion());
		contentPanel.add(getLblDescripcion());
		contentPanel.add(getLblHora());
		contentPanel.add(getLbHora());
		contentPanel.add(getBtnHora());
	}

	private JDateChooser getDateChooser() {
		if (dateChooser == null) {
			dateChooser = new JDateChooser();
			dateChooser.addPropertyChangeListener(new PropertyChangeListener() {
				public void propertyChange(PropertyChangeEvent arg0) {
					limpiarTabla();
					// Actualizar el horario para cada dia cambiado
					if (chbPiscina.isSelected()) {
						llenarTabla(data.getPiscina());
					}
					if (chbTenis.isSelected()) {
						llenarTabla(data.getTenis());
					}
					if (chbFutbol.isSelected()) {
						llenarTabla(data.getFutbol());
					}
				}
			});
			dateChooser.setBounds(44, 30, 95, 20);
		}
		return dateChooser;
	}

	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.setBounds(175, 11, 248, 384);

			DataTableModel dm = new DataTableModel(
					new Object[][] { { "00:00", null }, { "01:00", null }, { "02:00", null }, { "03:00", null },
							{ "04:00", null }, { "05:00", null }, { "06:00", null }, { "07:00", null },
							{ "08:00", null }, { "09:00", null }, { "10:00", null }, { "11:00", null },
							{ "12:00", null }, { "13:00", null }, { "14:00", null }, { "15:00", null },
							{ "16:00", null }, { "17:00", null }, { "18:00", null }, { "19:00", null },
							{ "20:00", null }, { "21:00", null }, { "22:00", null }, { "23:00", null }, },
					new String[] { "Horas", "Disponibilidad" });
			table.setModel(dm);
			
			//Listener para tomar los valores de las filas de la tabla
			table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
				@Override
				public void valueChanged(ListSelectionEvent ev) {
					//Pone en la descripcion el valor de la columna fila/columna
					txPDescripcion.setText((String) table.getModel().getValueAt(1,table.getSelectedColumn())+" "+table.getModel().getValueAt(table.getSelectedRow(), 1));
				}
				
				//No editable NO FUNCIONA DE MOMENTO
				public boolean isCellEditable(int row, int column){
						return false;
				}
				
			});			
			data.meterDatos();
		}
		return table;
	}

	/**
	 * CheckBox para la instalacion piscina
	 * 
	 * @return
	 */
	private JCheckBox getChbPiscina() {
		if (chbPiscina == null) {
			chbPiscina = new JCheckBox("Piscina");
			chbPiscina.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (chbPiscina.isSelected()) {
						if (dateChooser.getDate() != null)
							llenarTabla(data.getPiscina());
					} else {
						limpiarReserva("Reserva Piscina");
					}
				}
			});
			chbPiscina.setBounds(29, 154, 97, 23);
		}
		return chbPiscina;
	}

	/**
	 * Limpia los valores de la tabla en la columna de las reservas
	 */
	private void limpiarTabla() {
		for (int i = 0; i < table.getRowCount(); i++) {
					table.setValueAt("", i, 1);
		}
	}
	
	/**
	 * Limpia los valores de la tabla para una reserva en particular
	 */
	private void limpiarReserva(String inst) {
		for (int i = 0; i < table.getRowCount(); i++) {
			if(table.getValueAt(i, 1).equals(inst))
					table.setValueAt("", i, 1);
		}
	}

	/**
	 * Coge las reservas de una instalacion y rellena la tabla
	 * 
	 * @param ins,
	 *            Instalacion
	 */
	@SuppressWarnings("deprecation")
	private void llenarTabla(Instalacion ins) {
		ArrayList<Reserva> reservas = ins.getReservas();
		TableColumn tcol;
		ColorCellRenderer ccr = new ColorCellRenderer();

		for (Reserva reserva : reservas) {

			Date a = getDateChooser().getDate();
			String dia = sacarDia(a);
			if (String.valueOf(reserva.getDia()).equals(dia)) {

				if (ins.getId() == "piscina") { // Piscina

					table.setValueAt("Reserva Piscina", reserva.getHoraComienzo().getHours(), 1);
					tcol = table.getColumnModel().getColumn(1);
					tcol.setCellRenderer(ccr);

				} else if (ins.getId() == "canchafutbol") { // Futbol

					table.setValueAt("Reserva Futbol", reserva.getHoraComienzo().getHours(), 1);
					tcol = table.getColumnModel().getColumn(1);
					tcol.setCellRenderer(ccr);

				} else if (ins.getId() == "canchatenis") { // Tenis

					table.setValueAt("Reserva Tenis", reserva.getHoraComienzo().getHours(), 1);
					tcol = table.getColumnModel().getColumn(1);
					tcol.setCellRenderer(ccr);

				}
			}
		}
	}

	/**
	 * Saca el dia de un Date
	 * 
	 * @param date
	 * @return String con el dia
	 */
	private String sacarDia(Date date) {
		String[] var = date.toString().split(" ");
		return var[2];
	}

	private JCheckBox getChbTenis() {
		if (chbTenis == null) {
			chbTenis = new JCheckBox("Cancha de tenis");
			chbTenis.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (chbTenis.isSelected()) {
						if (dateChooser.getDate() != null)
							llenarTabla(data.getTenis());
					} else {
						limpiarReserva("Reserva Tenis");
					}
				}
			});
			chbTenis.setBounds(29, 194, 123, 23);
		}
		return chbTenis;
	}

	private JCheckBox getChbFutbol() {
		if (chbFutbol == null) {
			chbFutbol = new JCheckBox("Cancha de futbol");
			chbFutbol.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (chbFutbol.isSelected()) {
						if (dateChooser.getDate() != null)
							llenarTabla(data.getFutbol());
					} else {
						limpiarReserva("Reserva Futbol");
					}
				}
			});
			chbFutbol.setBounds(29, 231, 123, 23);
		}
		return chbFutbol;
	}
	private JTextPane getTxPDescripcion() {
		if (txPDescripcion == null) {
			txPDescripcion = new JTextPane();
			txPDescripcion.setBounds(453, 71, 338, 84);
		}
		return txPDescripcion;
	}
	private JLabel getLblDescripcion() {
		if (lblDescripcion == null) {
			lblDescripcion = new JLabel("Descripcion:");
			lblDescripcion.setBounds(453, 30, 130, 30);
		}
		return lblDescripcion;
	}
	private JLabel getLblHora() {
		if (lblHora == null) {
			lblHora = new JLabel("Hora:");
			lblHora.setBounds(10, 74, 38, 20);
		}
		return lblHora;
	}
	private JLabel getLbHora() {
		if (lbHora == null) {
			lbHora = new JLabel("");
			lbHora.setBounds(54, 77, 46, 14);
			lbHora.setText(String.valueOf(LocalDateTime.now().getHour())+":"+String.valueOf(LocalDateTime.now().getMinute()));
		}
		return lbHora;
	}
	private JButton getBtnHora() {
		if (btnHora == null) {
			btnHora = new JButton("Llegada/Salida");
			btnHora.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String ID = JOptionPane.showInputDialog("Introduce tu ID de Admin:");
					//If ID == ADmin en la bbdd
					VentanaLlegadaS VLLS = new VentanaLlegadaS();
					VLLS.setVisible(true);
					//else mensaje de error
				}
			});
			btnHora.setBounds(453, 177, 156, 23);
		}
		return btnHora;
	}
}
