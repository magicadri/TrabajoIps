package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaSocio extends JFrame {

	private JPanel contentPane;
	private JLabel lblOpciones;
	private JButton btnCalendar;
	private JButton btnReserva;
	private JButton btnConsulta;
	private JButton btnCancelarReserva;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaSocio frame = new VentanaSocio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaSocio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 548, 402);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		GridBagConstraints gbc_lblOpciones = new GridBagConstraints();
		gbc_lblOpciones.insets = new Insets(0, 0, 5, 5);
		gbc_lblOpciones.gridx = 1;
		gbc_lblOpciones.gridy = 2;
		contentPane.add(getLblOpciones(), gbc_lblOpciones);
		GridBagConstraints gbc_btnCalendar = new GridBagConstraints();
		gbc_btnCalendar.insets = new Insets(0, 0, 5, 0);
		gbc_btnCalendar.gridx = 2;
		gbc_btnCalendar.gridy = 3;
		contentPane.add(getBtnCalendar(), gbc_btnCalendar);
		GridBagConstraints gbc_btnReserva = new GridBagConstraints();
		gbc_btnReserva.insets = new Insets(0, 0, 5, 0);
		gbc_btnReserva.gridx = 2;
		gbc_btnReserva.gridy = 5;
		contentPane.add(getBtnReserva(), gbc_btnReserva);
		GridBagConstraints gbc_btnConsulta = new GridBagConstraints();
		gbc_btnConsulta.insets = new Insets(0, 0, 5, 0);
		gbc_btnConsulta.gridx = 2;
		gbc_btnConsulta.gridy = 7;
		contentPane.add(getBtnConsulta(), gbc_btnConsulta);
		GridBagConstraints gbc_btnCancelarReserva = new GridBagConstraints();
		gbc_btnCancelarReserva.gridx = 2;
		gbc_btnCancelarReserva.gridy = 9;
		contentPane.add(getBtnCancelarReserva(), gbc_btnCancelarReserva);
	}
	private JLabel getLblOpciones() {
		if (lblOpciones == null) {
			lblOpciones = new JLabel("Menu:");
		}
		return lblOpciones;
	}
	private JButton getBtnCalendar() {
		if (btnCalendar == null) {
			btnCalendar = new JButton("Consultar disponibilidad");
			btnCalendar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					VentanaCalendar vc = new VentanaCalendar();
					vc.setVisible(true);
				}
			});
		}
		return btnCalendar;
	}
	private JButton getBtnReserva() {
		if (btnReserva == null) {
			btnReserva = new JButton("Reservar instalaciones");
			btnReserva.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					VentanaReservaS vr = new VentanaReservaS();
					vr.setVisible(true);
				}
			});
		}
		return btnReserva;
	}
	private JButton getBtnConsulta() {
		if (btnConsulta == null) {
			btnConsulta = new JButton("Consultar Reservas");
			btnConsulta.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					VentanaConsulta vc = new VentanaConsulta();
					vc.setVisible(true);
				}
			});
		}
		return btnConsulta;
	}
	private JButton getBtnCancelarReserva() {
		if (btnCancelarReserva == null) {
			btnCancelarReserva = new JButton("Cancelar reserva");
			btnCancelarReserva.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					VentanaCancelarReserva vcr = new VentanaCancelarReserva();
					vcr.setVisible(true);
				}
			});
		}
		return btnCancelarReserva;
	}
}
