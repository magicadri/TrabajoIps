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
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class VentanaCalendarAdmin extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JDateChooser dateChooser;
	private JTextField tf;
	private JTable table;
	Data data = new Data();
	private JTextPane txPDescripcion;
	private JLabel lblDescripcion;
	private JLabel lblHora;
	private JLabel lbHora;
	private JButton btnLlegada;
	private JButton btnSalida;
	private JComboBox comboBox;

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
		// Pone el dia actual en el dateChooser
		dateChooser.setDate((new Date()));
		contentPanel.add(getTxPDescripcion());
		contentPanel.add(getLblDescripcion());
		contentPanel.add(getLblHora());
		contentPanel.add(getLbHora());
		contentPanel.add(getBtnLlegada());
		contentPanel.add(getBtnSalida());
		contentPanel.add(getComboBox());
	}

	private JDateChooser getDateChooser() {
		if (dateChooser == null) {
			dateChooser = new JDateChooser();
			dateChooser.addPropertyChangeListener(new PropertyChangeListener() {
				public void propertyChange(PropertyChangeEvent arg0) {
					limpiarTabla();
				}
			});
			dateChooser.setBounds(44, 30, 95, 20);
		}
		return dateChooser;
	}

	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.setBounds(175, 11, 375, 384);

			DataTableModel dm = new DataTableModel(
					new Object[][] { { "00:00", null, null, null }, { "01:00", null, null, null }, { "02:00", null, null, null }, { "03:00", null, null, null },
							{ "04:00", null, null, null }, { "05:00", null, null, null }, { "06:00", null, null, null }, { "07:00", null, null, null },
							{ "08:00", null, null, null }, { "09:00", null, null, null }, { "10:00", null, null, null }, { "11:00", null, null, null },
							{ "12:00", null, null, null }, { "13:00", null, null, null }, { "14:00", null, null, null }, { "15:00", null, null, null },
							{ "16:00", null, null, null }, { "17:00", null, null, null }, { "18:00", null, null, null }, { "19:00", null, null, null },
							{ "20:00", null, null, null }, { "21:00", null, null, null}, { "22:00", null, null, null }, { "23:00", null, null, null }, },
					new String[] { "Horas", "Disponibilidad", "Llegada", "Salida" });
			table.setModel(dm);
			
			//Listener para tomar los valores de las filas de la tabla
			table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
				@Override
				public void valueChanged(ListSelectionEvent ev) {
					//Pone en la descripcion el valor de la columna fila/columna
					txPDescripcion.setText((String) table.getModel().getValueAt(table.getSelectedRow(),0)+" "+table.getModel().getValueAt(table.getSelectedRow(), 1));
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
	 * Limpia los valores de la tabla en la columna de las reservas
	 */
	private void limpiarTabla() {
		for (int i = 0; i < table.getRowCount(); i++) {
					table.clearSelection();
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
		ColorCellGreen ccg = new ColorCellGreen();

		for (Reserva reserva : reservas) {

			Date a = getDateChooser().getDate();
			String dia = sacarDia(a);
			if (String.valueOf(reserva.getDia()).equals(dia)) {

				if (ins.getId() == "piscina") { // Piscina

					table.setValueAt("Reserva Piscina", reserva.getHoraComienzo().getHours(), 1);
					tcol = table.getColumnModel().getColumn(1);
					if(reserva.getSocio().getSocioID().equals("admin"))
						tcol.setCellRenderer(ccr);
					else 
						tcol.setCellRenderer(ccg);

				} else if (ins.getId() == "canchafutbol") { // Futbol

					table.setValueAt("Reserva Futbol", reserva.getHoraComienzo().getHours(), 1);
					tcol = table.getColumnModel().getColumn(1);
					if(reserva.getSocio().getSocioID().equals("admin"))
						tcol.setCellRenderer(ccr);
					else 
						tcol.setCellRenderer(ccg);

				} else if (ins.getId() == "canchatenis") { // Tenis

					table.setValueAt("Reserva Tenis", reserva.getHoraComienzo().getHours(), 1);
					tcol = table.getColumnModel().getColumn(1);
					if(reserva.getSocio().getSocioID().equals("admin"))
						tcol.setCellRenderer(ccr);
					else 
						tcol.setCellRenderer(ccg);

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
	private JTextPane getTxPDescripcion() {
		if (txPDescripcion == null) {
			txPDescripcion = new JTextPane();
			txPDescripcion.setBounds(580, 70, 270, 84);
		}
		return txPDescripcion;
	}
	private JLabel getLblDescripcion() {
		if (lblDescripcion == null) {
			lblDescripcion = new JLabel("Descripcion:");
			lblDescripcion.setBounds(583, 29, 130, 30);
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
	private JButton getBtnLlegada() {
		if (btnLlegada == null) {
			btnLlegada = new JButton("Llegada");
			btnLlegada.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//Se saca la hora de la columna seleccionada
					String string = (String) table.getModel().getValueAt(table.getSelectedRow(),0);
					String[] Hora1 = string.split(":");
					String Hora = Hora1[0];
					//Set hora de llegada que hay que cambiar al if, pero mientras tanto está de prueba
					table.setValueAt(LocalDateTime.now().getHour()+":"+LocalDateTime.now().getMinute(), table.getSelectedRow(), 2);
					//if(((int)table.getModel().getValueAt(1,table.getSelectedColumn())) == LocalDateTime.now().getHour()){
					if(Hora.equals(String.valueOf(LocalDateTime.now().getHour()))){
						JOptionPane.showMessageDialog(null, "Llegada a las: "+ LocalDateTime.now().getHour());
					}
					else{
						JOptionPane.showMessageDialog(null, "Error");
					}
					
				}
			});
			btnLlegada.setBounds(590, 180, 89, 23);
		}
		return btnLlegada;
	}
	private JButton getBtnSalida() {
		if (btnSalida == null) {
			btnSalida = new JButton("Salida");
			btnSalida.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					//Se saca la hora de la columna seleccionada
					String string = (String) table.getModel().getValueAt(table.getSelectedRow(),0);
					String[] Hora1 = string.split(":");
					String Hora = Hora1[0];
					//Set hora de salida
					table.setValueAt(LocalDateTime.now().getHour()+":"+LocalDateTime.now().getMinute(), table.getSelectedRow(), 3);
					//if(((int)table.getModel().getValueAt(1,table.getSelectedColumn())) == LocalDateTime.now().getHour()){
					if(Hora.equals(String.valueOf(LocalDateTime.now().getHour()))){
						JOptionPane.showMessageDialog(null, "Salida las: "+ LocalDateTime.now().getHour());
					}
					else{
						JOptionPane.showMessageDialog(null, "Error");
					}
					
				}
			});
			btnSalida.setBounds(772, 180, 89, 23);
		}
		return btnSalida;
	}
	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JComboBox cb = (JComboBox)e.getSource();
					Object selected = cb.getSelectedItem();
					if(selected.toString().equals("Piscina")){
						limpiarReserva("Reserva Tenis");
						limpiarReserva("Reserva Futbol");
						
							if (dateChooser.getDate() != null)
								llenarTabla(data.getPiscina());
						}
					else if(selected.toString().equals("Cancha de tenis")){
						limpiarReserva("Reserva Piscina");
						limpiarReserva("Reserva Futbol");
						if (dateChooser.getDate() != null)
							llenarTabla(data.getTenis());
					}
					else if(selected.toString().equals("Cancha de futbol")){
						limpiarReserva("Reserva Piscina");
						limpiarReserva("Reserva Tenis");
						if (dateChooser.getDate() != null)
							llenarTabla(data.getFutbol());
					}
					
					
					else {
							limpiarReserva("Reserva Piscina");
						}
					}
			});
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Piscina", "Cancha de tenis", "Cancha de futbol"}));
			comboBox.setBounds(29, 140, 110, 20);
		}
		return comboBox;
	}
}
