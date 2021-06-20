package college_management;

import com.mysql.*;

//import com.mysql.jdbc.Connection;
import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import com.mysql.*;
import com.mysql.*;

public class Login_form extends JFrame {

	private JFrame frame;
	public static JTextField textField;
	public static JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_form window = new Login_form();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login_form() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		ButtonGroup group = new ButtonGroup();
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 239, 213));
		frame.setBounds(100, 100, 751, 1010);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("WELCOME TO LMS");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(137, 30, 263, 44);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Email id");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_1.setBounds(70, 126, 65, 22);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_2.setBounds(70, 175, 82, 22);
		frame.getContentPane().add(lblNewLabel_2);

		textField = new JTextField();
		textField.setBounds(196, 126, 204, 25);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JRadioButton rdbtnNewRadioButton = new JRadioButton("Teacher");
		rdbtnNewRadioButton.setBounds(196, 226, 109, 23);
		frame.getContentPane().add(rdbtnNewRadioButton);
		group.add(rdbtnNewRadioButton);

		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Student");
		rdbtnNewRadioButton_1.setBounds(329, 226, 109, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_1);
		group.add(rdbtnNewRadioButton_1);

		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBackground(new Color(240, 255, 240));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (textField.getText().trim().isEmpty() || passwordField.getText().trim().isEmpty()
							|| (!rdbtnNewRadioButton.isSelected() && !rdbtnNewRadioButton_1.isSelected())) {
						JOptionPane.showMessageDialog(null, "Please fill all the fields");
					} else {
						String user_type;
						if (rdbtnNewRadioButton.isSelected()) {
							user_type = "Teacher";
						} else {
							user_type = "Student";
						}

						String driver = "com.mysql.jdbc.Driver";
						Class.forName(driver);
						Connection con = DriverManager.getConnection(
								"jdbc:mysql://LAPTOP-CBVBHO6M:3306/project?user=newuser&password=akshita@12345&allowPublicKeyRetrieval=true&useSSL=false"); // ?autoReconnect=
																																							// true
						String queryString = "SELECT COUNT(*) FROM project.register2 where email = \""
								+ textField.getText().trim() + "\" and pasword= \"" + passwordField.getText().trim()
								+ "\" and user_type= \"" + user_type.toLowerCase() + "\";";
						PreparedStatement ps = con.prepareStatement(queryString);
						ResultSet results = ps.executeQuery(queryString);
						results.next();
						if (results.getInt("count(*)") == 1) {
							if (results.getRow() == 1) {
								JOptionPane.showMessageDialog(null, "Username and Password exist");
								dispose();
								if (rdbtnNewRadioButton_1.isSelected()) {

									Choice c1 = new Choice(textField.getText().trim());
									c1.setVisible(true);
									// btnNewButton.isSelected() &&
								} else if (rdbtnNewRadioButton.isSelected()) {

									Teacher_Choice tc = new Teacher_Choice();
									tc.setVisible(true);

								}

							}
						} else {
							JOptionPane.showMessageDialog(null, "Please Check Username and Password ");
							dispose();
						}
						results.close();
						con.close();
					}
				} catch (Exception ex) {

				}
				dispose();

			}
		});
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnNewButton.setBounds(175, 309, 108, 37);
		frame.getContentPane().add(btnNewButton);

		passwordField = new JPasswordField();
		passwordField.setBounds(196, 175, 204, 25);
		frame.getContentPane().add(passwordField);

		JButton btnNewButton_1 = new JButton("Reset Password");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Reset_Pass reset = new Reset_Pass();
				reset.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnNewButton_1.setBounds(321, 308, 153, 37);
		frame.getContentPane().add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Register");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Register_form regf1 = new Register_form();
				regf1.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(31, 309, 104, 37);
		frame.getContentPane().add(btnNewButton_2);

		JLabel lblNewLabel_3 = new JLabel("User Type");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_3.setBounds(70, 227, 93, 17);
		frame.getContentPane().add(lblNewLabel_3);

	}
}
