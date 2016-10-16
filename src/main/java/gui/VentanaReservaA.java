package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logic.Data;
import logic.Instalacion;
import logic.Reserva;
import logic.Socio;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class VentanaReservaA extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblIdDeSocio;
	private JTextField txIDAdmin;
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
	private JButton btnComprobar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VentanaReservaA dialog = new VentanaReservaA();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VentanaReservaA() {
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
		contentPanel.add(getTxIDAdmin());
		contentPanel.add(getSpDia());
		contentPanel.add(getLblDia());
		contentPanel.add(getCbHoraComienzo());
		contentPanel.add(getLblHoraDeComienzo());
		contentPanel.add(getLblHoraFin());
		contentPanel.add(getCbHoraFin());
		contentPanel.add(getChckbxPiscina());
		contentPanel.add(getChckbxCanchaDeFutbol());
		contentPanel.add(getChckbxCanchaDeTenis());
		contentPanel.add(getBtnComprobar());
	}

	private JLabel getLblIdDeSocio() {
		if (lblIdDeSocio == null) {
			lblIdDeSocio = new JLabel("ID de admin:");
			lblIdDeSocio.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblIdDeSocio.setBounds(63, 102, 142, 42);
		}
		return lblIdDeSocio;
	}

	private JTextField getTxIDAdmin() {
		if (txIDAdmin == null) {
			txIDAdmin = new JTextField();
			txIDAdmin.setFont(new Font("Tahoma", Font.PLAIN, 18));
			txIDAdmin.setBounds(205, 106, 196, 34);
			txIDAdmin.setColumns(10);
		}
		return txIDAdmin;
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
			cbHoraComienzo.setModel(new DefaultComboBoxModel(new String[] {"00:00", "01:00", "02:00", "03:00", "04:00", "05:00", "06:00", "07:00", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00", "23:00"}));
			cbHoraComienzo.setMaximumRowCount(24);
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
			cbHoraFin.setModel(new DefaultComboBoxModel(new String[] {"00:00", "01:00", "02:00", "03:00", "04:00", "05:00", "06:00", "07:00", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00", "23:00"}));
			cbHoraFin.setMaximumRowCount(24);
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

		//Cuando sea por base de datos se incluira en ella la reserva en su correspondiente instalacion.
		if (getChckbxCanchaDeFutbol().isSelected()) {
			Reserva newResFut = new Reserva(Integer.valueOf(getSpDia().getValue().toString()), new Date(2016,10,Integer.valueOf(getSpDia().getValue().toString())), new Date(2016,10,Integer.valueOf(getSpDia().getValue().toString())),
					new Socio(getTxIDAdmin().getText()), preciofutbol, new Instalacion("canchafutbol"));
		} else if (getChckbxCanchaDeTenis().isSelected()) {
			Reserva newResTen = new Reserva(Integer.valueOf(getSpDia().getValue().toString()), new Date(2016,10,Integer.valueOf(getSpDia().getValue().toString())), new Date(2016,10,Integer.valueOf(getSpDia().getValue().toString())),
					new Socio(getTxIDAdmin().getText()), preciotenis, new Instalacion("canchatenis"));
		} else if (getChckbxPiscina().isSelected()) {
			Reserva newResPis = new Reserva(Integer.valueOf(getSpDia().getValue().toString()), new Date(2016,10,Integer.valueOf(getSpDia().getValue().toString())), new Date(2016,10,Integer.valueOf(getSpDia().getValue().toString())),
					new Socio(getTxIDAdmin().getText()), preciopiscina, new Instalacion("piscina"));
		}
	}
	private JButton getBtnComprobar() {
		if (btnComprobar == null) {
			btnComprobar = new JButton("Comprobar");
			btnComprobar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String ID = txIDAdmin.getText();
					//If ID == alguna id en la bbdd de admins
					JOptionPane.showMessageDialog(null,"Comprobación exitosa.");
					//else
					//JOptionPane.showMessageDialog(null, "Error. No existe ese usuario.", "Error", ERROR);
				}
			});
			btnComprobar.setBounds(423, 104, 142, 34);
		}
		return btnComprobar;
	}
}
