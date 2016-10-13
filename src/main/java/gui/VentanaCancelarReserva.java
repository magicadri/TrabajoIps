package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import logic.Data;
import logic.Instalacion;
import logic.Reserva;
import logic.Socio;

import javax.swing.JLabel;

public class VentanaCancelarReserva extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblIdDeSocio;
	private JTextField txIDdeSocio;
	private JSpinner spDia;
	private JLabel lblDia;
	private JComboBox cbHoraComienzo;
	private JLabel lblHoraDeComienzo;
	private JLabel lblHoraFin;
	private JComboBox cbHoraFin;
	private JCheckBox chckbxPiscina;
	private JCheckBox chckbxCanchaDeFutbol;
	private JCheckBox chckbxCanchaDeTenis;
	private Data data;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VentanaCancelarReserva dialog = new VentanaCancelarReserva();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VentanaCancelarReserva() {
		data = new Data();
		setBounds(100, 100, 1055, 788);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.add(getLblIdDeSocio());
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 651, 1033, 81);
			contentPanel.add(buttonPane);
			buttonPane.setLayout(null);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						crearNuevaReserva();
						dispose();
					}
				});
				okButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
				okButton.setBounds(771, 16, 116, 52);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
				cancelButton.setBounds(902, 13, 116, 55);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		contentPanel.add(getTxIDdeSocio());
		contentPanel.add(getSpDia());
		contentPanel.add(getLblDia());
		contentPanel.add(getCbHoraComienzo());
		contentPanel.add(getLblHoraDeComienzo());
		contentPanel.add(getLblHoraFin());
		contentPanel.add(getCbHoraFin());
		contentPanel.add(getChckbxPiscina());
		contentPanel.add(getChckbxCanchaDeFutbol());
		contentPanel.add(getChckbxCanchaDeTenis());
	}

	private JLabel getLblIdDeSocio() {
		if (lblIdDeSocio == null) {
			lblIdDeSocio = new JLabel("ID de socio:");
			lblIdDeSocio.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblIdDeSocio.setBounds(63, 102, 142, 42);
		}
		return lblIdDeSocio;
	}

	private JTextField getTxIDdeSocio() {
		if (txIDdeSocio == null) {
			txIDdeSocio = new JTextField();
			txIDdeSocio.setFont(new Font("Tahoma", Font.PLAIN, 18));
			txIDdeSocio.setBounds(205, 106, 196, 34);
			txIDdeSocio.setColumns(10);
		}
		return txIDdeSocio;
	}

	private JSpinner getSpDia() {
		if (spDia == null) {
			spDia = new JSpinner();
			spDia.setFont(new Font("Tahoma", Font.PLAIN, 18));
			spDia.setBounds(576, 200, 65, 34);
		}
		return spDia;
	}

	private JLabel getLblDia() {
		if (lblDia == null) {
			lblDia = new JLabel("Dia:");
			lblDia.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblDia.setBounds(511, 201, 81, 33);
		}
		return lblDia;
	}

	private JComboBox getCbHoraComienzo() {
		if (cbHoraComienzo == null) {
			cbHoraComienzo = new JComboBox();
			cbHoraComienzo.setFont(new Font("Tahoma", Font.PLAIN, 18));
			cbHoraComienzo.setBounds(704, 282, 214, 30);
		}
		return cbHoraComienzo;
	}

	private JLabel getLblHoraDeComienzo() {
		if (lblHoraDeComienzo == null) {
			lblHoraDeComienzo = new JLabel("Hora de comienzo:");
			lblHoraDeComienzo.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblHoraDeComienzo.setBounds(511, 280, 178, 34);
		}
		return lblHoraDeComienzo;
	}

	private JLabel getLblHoraFin() {
		if (lblHoraFin == null) {
			lblHoraFin = new JLabel("Hora final:");
			lblHoraFin.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblHoraFin.setBounds(511, 360, 178, 34);
		}
		return lblHoraFin;
	}

	private JComboBox getCbHoraFin() {
		if (cbHoraFin == null) {
			cbHoraFin = new JComboBox();
			cbHoraFin.setFont(new Font("Tahoma", Font.PLAIN, 18));
			cbHoraFin.setBounds(704, 362, 214, 30);
		}
		return cbHoraFin;
	}

	private JCheckBox getChckbxPiscina() {
		if (chckbxPiscina == null) {
			chckbxPiscina = new JCheckBox("Piscina");
			chckbxPiscina.setFont(new Font("Tahoma", Font.PLAIN, 18));
			chckbxPiscina.setBounds(60, 215, 170, 42);
		}
		return chckbxPiscina;
	}

	private JCheckBox getChckbxCanchaDeFutbol() {
		if (chckbxCanchaDeFutbol == null) {
			chckbxCanchaDeFutbol = new JCheckBox("Cancha de futbol");
			chckbxCanchaDeFutbol.setFont(new Font("Tahoma", Font.PLAIN, 18));
			chckbxCanchaDeFutbol.setBounds(60, 283, 170, 42);
		}
		return chckbxCanchaDeFutbol;
	}

	private JCheckBox getChckbxCanchaDeTenis() {
		if (chckbxCanchaDeTenis == null) {
			chckbxCanchaDeTenis = new JCheckBox("Cancha de tenis");
			chckbxCanchaDeTenis.setFont(new Font("Tahoma", Font.PLAIN, 18));
			chckbxCanchaDeTenis.setBounds(60, 356, 170, 42);
		}
		return chckbxCanchaDeTenis;
	}

	/**
	 * Crea una nueva reserva cuando el usuario pulsa OK
	 */
	private void crearNuevaReserva() {
		float preciofutbol = 2;
		float preciotenis = 1;
		float preciopiscina = 5;
		ArrayList<Reserva> reservas = new ArrayList<>(); //Serian las reservas de la base de datos para cada instalacion
		
		//Se eliminara en la base la reserva en su correspondiente instalacion.
		if (getChckbxCanchaDeFutbol().isSelected()) {
			Reserva tofind = new Reserva(Integer.valueOf(getSpDia().getValue().toString()), new Date(2016,10,Integer.valueOf(getSpDia().getValue().toString())), new Date(2016,10,Integer.valueOf(getSpDia().getValue().toString())),
					new Socio(getTxIDdeSocio().getText()), preciofutbol, new Instalacion("canchafutbol"));
			for(Reserva res: reservas){
				if(res.equals(tofind)){
					reservas.remove(res);
				}
			}
		} else if (getChckbxCanchaDeTenis().isSelected()) {
			Reserva tofind = new Reserva(Integer.valueOf(getSpDia().getValue().toString()), new Date(2016,10,Integer.valueOf(getSpDia().getValue().toString())), new Date(2016,10,Integer.valueOf(getSpDia().getValue().toString())),
					new Socio(getTxIDdeSocio().getText()), preciotenis, new Instalacion("canchatenis"));
			for(Reserva res: reservas){
				if(res.equals(tofind)){
					reservas.remove(res);
				}
			}
		} else if (getChckbxPiscina().isSelected()) {
			Reserva tofind = new Reserva(Integer.valueOf(getSpDia().getValue().toString()), new Date(2016,10,Integer.valueOf(getSpDia().getValue().toString())), new Date(2016,10,Integer.valueOf(getSpDia().getValue().toString())),
					new Socio(getTxIDdeSocio().getText()), preciopiscina, new Instalacion("piscina"));
			for(Reserva res: reservas){
				if(res.equals(tofind)){
					reservas.remove(res);
				}
			}
		}
	}
}