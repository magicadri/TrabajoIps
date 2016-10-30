package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JScrollPane;
import javax.swing.JList;

public class VentanaMisReservas extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JList list;

	DefaultListModel model;
	String prueba[] = {"1","2","3"};

	/**
	 * Create the frame.
	 */
	public VentanaMisReservas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getPanel());
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		model = new DefaultListModel();
		list = new JList(prueba);
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBounds(115, 43, 264, 188);
			panel.add(getList());
		}
		return panel;
	}
	private JList getList() {
		if (list == null) {
			list = new JList(prueba);
		}
		return list;
	}
}
