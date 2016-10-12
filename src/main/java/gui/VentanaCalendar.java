package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.toedter.calendar.JDateChooser;

import logic.Administrador;
import logic.Data;
import logic.Instalacion;
import logic.Reserva;
import logic.Socio;

import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
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

public class VentanaCalendar extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JDateChooser dateChooser;
	private JTextField tf;
	private JTable table;
	private JCheckBox chbPiscina;
	Data data = new Data();
	private JCheckBox chbTenis;
	private JCheckBox chbFutbol;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VentanaCalendar dialog = new VentanaCalendar();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VentanaCalendar() {
		setBounds(100, 100, 477, 469);
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
			// No editable
			table.setEnabled(false);
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
						limpiarTabla();
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
						limpiarTabla();
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
						limpiarTabla();
					}
				}
			});
			chbFutbol.setBounds(29, 231, 123, 23);
		}
		return chbFutbol;
	}
}
