package college_management;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.florianingerl.util.regex.Pattern;

//import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
//import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
//import net.sourceforge.jdatepicker.impl.UtilDateModel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class Register_form extends JFrame {

	private JPanel contentPane;
	private JFrame frame;
	public static JTextField textField;
	// public static JTextField textField_1;
	public static JTextField textField_2;
	public static JTextField textField_3;
	public static JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register_form frame = new Register_form();
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
	public Register_form() {
		ButtonGroup group = new ButtonGroup();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 558, 439);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 239, 213));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Registeration Form");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel.setBounds(184, 11, 248, 26);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(22, 64, 76, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Date of Birth");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(22, 117, 105, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Mobile no");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(22, 170, 76, 14);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Gender");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(22, 212, 76, 14);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Address");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(22, 271, 76, 14);
		contentPane.add(lblNewLabel_5);

		textField = new JTextField();
		textField.setBounds(184, 55, 281, 26);
		contentPane.add(textField);
		textField.setColumns(10);

		// textField_1 = new JTextField();
		// textField_1.setBounds(413, 113, 105, 26);
		// contentPane.add(textField_1);
		// textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		textField_2.setBounds(274, 161, 191, 26);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(184, 252, 292, 36);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("Email id");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(22, 323, 76, 14);
		contentPane.add(lblNewLabel_6);

		textField_4 = new JTextField();
		textField_4.setBounds(184, 314, 292, 26);
		contentPane.add(textField_4);
		textField_4.setColumns(10);

		JRadioButton rdbtnNewRadioButton = new JRadioButton("M");
		rdbtnNewRadioButton.setBounds(184, 208, 46, 23);
		group.add(rdbtnNewRadioButton);
		contentPane.add(rdbtnNewRadioButton);

		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("F");
		rdbtnNewRadioButton_1.setBounds(254, 208, 46, 23);
		group.add(rdbtnNewRadioButton_1);
		contentPane.add(rdbtnNewRadioButton_1);
		// ButtonGroup gen = new ButtonGroup();

		// String days [] ={"1","2","3","4","5","6", "7", "8", "9", "10", "11", "12",
		// "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25",
		// "26", "27", "28", "29", "30", "31"};
		// String month [] ={"January", "february", "March", "April", "May", "June",
		// "July", "August", "Septeber", "October", "November", "December"};
		// String year [] ={"2020", "2019", "2018", "2017", "2016", "2015","2014",
		// "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005",
		// "2004", "2003", "2002","2001", "2000", "1999", "1998", "1997", "1996",
		// "1995","1994", "1993", "1992", "1991", "1990","1989", "1988"};

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(
				new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16",
						"17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
		comboBox.setBounds(184, 115, 57, 22);
		contentPane.add(comboBox);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] { "January", "february", "March", "April", "May",
				"June", "July", "August", "September", "October", "November", "December" }));
		comboBox_1.setBounds(254, 115, 75, 22);
		contentPane.add(comboBox_1);

		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(
				new String[] { "2020", "2019", "2018", "2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010",
						"2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998",
						"1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988" }));
		comboBox_2.setBounds(339, 115, 75, 22);
		contentPane.add(comboBox_2);

		String dob = comboBox.getSelectedItem().toString() + " " + comboBox_1.getSelectedItem().toString() + " "
				+ comboBox_2.getSelectedItem().toString();
		JButton btnNewButton = new JButton("Preview");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Register_form.textField_2.getText().isEmpty() || Register_form.textField.getText().isEmpty()
						|| Register_form.textField_3.getText().isEmpty()
						|| Register_form.textField_4.getText().isEmpty()
						|| (!rdbtnNewRadioButton.isSelected() && !rdbtnNewRadioButton_1.isSelected())) {
					JOptionPane.showMessageDialog(null, "Please fill all the fields");
				}

				else if (!Pattern.matches("[6-9][0-9]{9}", Register_form.textField_2.getText().trim())) {
					JOptionPane.showMessageDialog(null,
							"Mobile Number is not valid, Please enter a correct mobile number");
				} else if (!Pattern.matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", textField_4.getText().trim())) {
					JOptionPane.showMessageDialog(null, "Email Id is not valid, Please enter a correct Email Id");
				} else {

					dispose();
					Preview pr = new Preview();
					pr.setVisible(true);

					Preview.textField.setText(Register_form.textField.getText());
					Preview.textField_1.setText(dob);

					Preview.textField_2.setText(Register_form.textField_2.getText());
					Preview.textField_4.setText(Register_form.textField_3.getText());
					Preview.textField_3.setText(Register_form.textField_4.getText());
					if (rdbtnNewRadioButton.isSelected()) {
						Preview.rdbtnNewRadioButton_2.setSelected(true);
					} else {
						Preview.rdbtnNewRadioButton_3.setSelected(true);
					}
				}
			}
		});
		btnNewButton.setBounds(209, 366, 89, 23);
		contentPane.add(btnNewButton);

		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] { "+91", "+020", "+54", "+1 264", "+1 268" }));
		comboBox_3.setBounds(184, 168, 57, 22);
		contentPane.add(comboBox_3);

		// UtilDateModel model = new UtilDateModel();
		// JDatePanelImpl datePanel = new JDatePanelImpl(model);
		// datePanel.setBounds(184, 115, 57, 22);
		// JDatePickerImpl datePicker = new JDatePickerImpl(datePanel);

		// contentPane.add(datePicker);

	}
}
