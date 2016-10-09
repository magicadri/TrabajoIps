package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
//import com.toedter.calendar.JCalendar;
//import com.toedter.calendar.JMonthChooser;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private JPanel panelEscoger;
	private JButton btnSocio;
	private JButton btnAdmin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
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
	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 758, 448);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		contentPane.add(getPanelEscoger());
	}

	private JPanel getPanelEscoger() {
		if (panelEscoger == null) {
			panelEscoger = new JPanel();
			panelEscoger.setLayout(new GridLayout(1, 0, 0, 0));
			panelEscoger.add(getBtnSocio());
			panelEscoger.add(getBtnAdmin());
		}
		return panelEscoger;
	}
	private JButton getBtnSocio() {
		if (btnSocio == null) {
			btnSocio = new JButton("Socio");
			btnSocio.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					VentanaSocio vs = new VentanaSocio();
					vs.setVisible(true);
				}
			});
		}
		return btnSocio;
	}
	private JButton getBtnAdmin() {
		if (btnAdmin == null) {
			btnAdmin = new JButton("Admin");
		}
		return btnAdmin;
	}
}
