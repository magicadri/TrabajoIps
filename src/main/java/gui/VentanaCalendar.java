package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.toedter.calendar.JDateChooser;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.JTextField;

public class VentanaCalendar extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JDateChooser dateChooser;
	private JTextField tf;

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
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.add(getDateChooser());
		contentPanel.add(getTf());
	}
	private JDateChooser getDateChooser() {
		if (dateChooser == null) {
			dateChooser = new JDateChooser();
			dateChooser.addPropertyChangeListener(new PropertyChangeListener() {
				public void propertyChange(PropertyChangeEvent arg0) {
					tf.setText(String.valueOf(dateChooser.getDate()));
				}
			});
			dateChooser.setBounds(142, 64, 95, 20);
		}
		return dateChooser;
	}
	private JTextField getTf() {
		if (tf == null) {
			tf = new JTextField();
			tf.setBounds(76, 136, 86, 20);
			tf.setColumns(10);
		}
		return tf;
	}
}
