package college_management;

import java.awt.BorderLayout;

import com.florianingerl.util.regex.Pattern;
import com.mysql.*;
import java.sql.*;
import java.sql.Connection;
import javax.swing.JOptionPane;
//import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;

public class Preview extends JFrame {
	JFrame Register_form;

	private JPanel contentPane;
	public static JTextField textField;
	public static JTextField textField_1;
	public static JTextField textField_2;
	public static JTextField textField_3;
	public static JRadioButton rdbtnNewRadioButton_2;
	public static JRadioButton rdbtnNewRadioButton_3;
	public static JTextField textField_4;
	private static JPasswordField passwordField;
	private static JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Preview frame = new Preview();
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
	public Preview() {
		ButtonGroup group = new ButtonGroup();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 636, 621);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 239, 213));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Check Your Credentials!!");
		lblNewLabel.setForeground(new Color(255, 105, 180));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel.setBounds(146, 11, 265, 34);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setBounds(10, 59, 89, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Date of Birth");
		lblNewLabel_2.setBounds(10, 100, 124, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Mobile no");
		lblNewLabel_3.setBounds(10, 140, 89, 14);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Gender");
		lblNewLabel_4.setBounds(10, 183, 89, 14);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Address");
		lblNewLabel_5.setBounds(10, 224, 89, 14);
		contentPane.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Email id");
		lblNewLabel_6.setBounds(10, 265, 89, 14);
		contentPane.add(lblNewLabel_6);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(
				new String[] { "Advance Programming", "Artifical Inteligence", "DIP", "RM", "ACN " }));
		comboBox_1.setBounds(179, 459, 191, 22);

		contentPane.add(comboBox_1);
		comboBox_1.setVisible(false);
		
		JLabel lblNewLabel_10 = new JLabel("Course Subject");
		lblNewLabel_10.setBounds(10, 463, 89, 18);
		contentPane.add(lblNewLabel_10);
		lblNewLabel_10.setVisible(false);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Student");
		rdbtnNewRadioButton_1.setBounds(306, 404, 109, 23);
		group.add(rdbtnNewRadioButton_1);
		contentPane.add(rdbtnNewRadioButton_1);

		JRadioButton rdbtnNewRadioButton = new JRadioButton("Teacher");
		rdbtnNewRadioButton.setBounds(179, 404, 109, 23);
		group.add(rdbtnNewRadioButton);
		contentPane.add(rdbtnNewRadioButton);
		
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox_1.setVisible(true);
				lblNewLabel_10.setVisible(true);
			}
		});
		
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox_1.setVisible(false);
				lblNewLabel_10.setVisible(false);
			}
		});



		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (!Pattern.matches("[6-9][0-9]{9}", textField_2.getText().trim())) {
						JOptionPane.showMessageDialog(null,
								"Mobile Number is not valid, Please enter a correct mobile number");
					} else {
						String driver = "com.mysql.jdbc.Driver";
						Class.forName(driver);
						Connection con = DriverManager.getConnection(
								"jdbc:mysql://LAPTOP-CBVBHO6M:3306/project?user=newuser&password=akshita@12345&allowPublicKeyRetrieval=true&useSSL=false"); // ?autoReconnect=
																																							// true
						String sql = "insert into register2 values (?, ?, ?, ?, ?, ?, ?, ?);";
						PreparedStatement pstmt = con.prepareStatement(sql);
						pstmt.setString(1, textField.getText().trim());
						pstmt.setString(2, textField_1.getText().trim());
						pstmt.setLong(3, Long.parseLong(textField_2.getText().trim()));

						String gender;
						if (rdbtnNewRadioButton_2.isSelected()) {
							gender = rdbtnNewRadioButton_2.getText();

						} else {
							gender = rdbtnNewRadioButton_3.getText();
						}
						pstmt.setString(4, gender);
						pstmt.setString(5, textField_4.getText().trim());
						pstmt.setString(6, textField_3.getText().trim());
						if (String.valueOf(passwordField.getPassword())
								.equals(String.valueOf(passwordField_1.getPassword()))) {

							pstmt.setString(7, passwordField.getText().trim());
						}
						// pstmt.setString(7, textField_.getText());
						else {
							JOptionPane.showMessageDialog(null, "Re-enter your password ");
						}
						String user_type;
						if (rdbtnNewRadioButton.isSelected()) {
							user_type = rdbtnNewRadioButton.getText();

						} else {
							user_type = rdbtnNewRadioButton_1.getText();
						}
						pstmt.setString(8, user_type.toLowerCase());
						pstmt.execute();
						Email email = new Email(textField_3.getText().trim(), textField.getText().trim());
						if (rdbtnNewRadioButton.isSelected()) {
							sql = "insert into teacher_subject values (?, ?);";
							pstmt = con.prepareStatement(sql);
							pstmt.setString(1, textField_3.getText().trim());
							pstmt.setString(2, comboBox_1.getSelectedItem().toString());
							pstmt.execute();
						}
						con.close();
						JOptionPane.showMessageDialog(null,
								"Email has sent to your registered mail id, You can Login now!!");
					}
				} catch (Exception ep) {
					JOptionPane.showMessageDialog(null, "mobile number is incorrect");
					ep.printStackTrace();

				}

				dispose();

			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.ITALIC, 11));
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setBounds(351, 537, 89, 23);
		contentPane.add(btnNewButton);

		textField = new JTextField();
		textField.setBounds(179, 56, 191, 20);
		textField.setEditable(false);
		contentPane.add(textField);

		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(179, 97, 191, 20);
		textField_1.setEditable(false);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(249, 137, 191, 20);
		textField_2.setEditable(false);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		rdbtnNewRadioButton_2 = new JRadioButton("M");
		rdbtnNewRadioButton_2.setBounds(184, 179, 40, 23);
		rdbtnNewRadioButton_2.setEnabled(false);
		contentPane.add(rdbtnNewRadioButton_2);

		rdbtnNewRadioButton_3 = new JRadioButton("F");
		rdbtnNewRadioButton_3.setBounds(237, 179, 40, 23);
		rdbtnNewRadioButton_3.setEnabled(false);
		contentPane.add(rdbtnNewRadioButton_3);

		textField_3 = new JTextField();
		textField_3.setBounds(179, 262, 284, 20);
		textField_3.setEditable(false);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setBounds(179, 221, 284, 20);
		textField_4.setEditable(false);
		contentPane.add(textField_4);
		textField_4.setColumns(10);

		JLabel lblNewLabel_7 = new JLabel("Password");
		lblNewLabel_7.setBounds(10, 312, 89, 14);
		contentPane.add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("Confirm Password");
		lblNewLabel_8.setBounds(10, 354, 146, 14);
		contentPane.add(lblNewLabel_8);

		passwordField = new JPasswordField();
		passwordField.setBounds(179, 309, 282, 20);
		contentPane.add(passwordField);

		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(179, 351, 284, 20);
		contentPane.add(passwordField_1);

		JLabel lblNewLabel_9 = new JLabel("User Type");
		lblNewLabel_9.setBounds(10, 408, 89, 14);
		contentPane.add(lblNewLabel_9);

		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Register_form regf = new Register_form();
				regf.setVisible(true);

			}
		});
		btnNewButton_1.setForeground(Color.RED);
		btnNewButton_1.setBounds(135, 537, 89, 23);
		contentPane.add(btnNewButton_1);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "+91", "+020", "+54", "+1 264", "+1 268" }));
		comboBox.setBounds(179, 136, 60, 22);
		contentPane.add(comboBox);
	

	}

	public JTextField getTextField() {
		return textField;
	}

	public JRadioButton getRdbtnNewRadioButton() {
		return rdbtnNewRadioButton_2;
	}

	public JRadioButton getRdbtnNewRadioButton_1() {
		return rdbtnNewRadioButton_3;
	}
}
