package college_management;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class ap_teacher extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ap_teacher frame = new ap_teacher();
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
	public ap_teacher() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 858, 891);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 235, 205));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Google Link");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(22, 73, 106, 42);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Google Drive");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(22, 167, 106, 31);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Book");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(22, 242, 106, 24);
		contentPane.add(lblNewLabel_2);

		textField = new JTextField();
		textField.setBounds(187, 73, 412, 65);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(187, 147, 412, 70);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(187, 228, 412, 56);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();
				Teacher_Subject ts = new Teacher_Subject();
				ts.setVisible(true);
			}
		});
		btnNewButton.setBounds(244, 348, 89, 23);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel_3 = new JLabel("Advance Programming Teacher Portal");
		lblNewLabel_3.setForeground(new Color(255, 105, 180));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_3.setBounds(126, 11, 402, 31);
		contentPane.add(lblNewLabel_3);

		JButton btnNewButton_1 = new JButton("Submit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String driver = "com.mysql.jdbc.Driver";
					Class.forName(driver);
					PreparedStatement pst;
					Connection con = DriverManager.getConnection(
							"jdbc:mysql://LAPTOP-CBVBHO6M:3306/project?user=newuser&password=akshita@12345&allowPublicKeyRetrieval=true&useSSL=false");
					String queryString = "SELECT COUNT(*) FROM teacherdata where subject = \"Advance Programming\";";
					pst = con.prepareStatement(queryString);
					ResultSet results = pst.executeQuery(queryString);
					results.next();
					if (results.getInt("count(*)") == 1) {
						if (results.getRow() == 1) {
							String query = "update teacherdata set google_link = ?, google_drive = ?, book = ? where subject = \"Advance Programming\";";
							pst = con.prepareStatement(query);
							pst.setString(1, textField.getText());
							pst.setString(2, textField_1.getText());
							pst.setString(3, textField_2.getText());
							pst.execute();
						}
					} else {
						String sqlconn = "insert into teacherdata values (?, ?, ?, 'Advance Programming');";
						pst = con.prepareStatement(sqlconn);

						pst.setString(1, textField.getText());
						pst.setString(2, textField_1.getText());
						pst.setString(3, textField_2.getText());
						// ResultSet rs = pst.executeQuery(sqlconn);
						// String g_link = rs.getString(textField.getText().trim());

						// String g_dlink = rs.getString(textField_1.getText().trim());
						// String book_link = rs.getString(textField_2.getText().trim());

						// System.out.println(aa);
						pst.execute();
					}

					dispose();
				} catch (Exception et) {

				}
			}
		});
		btnNewButton_1.setBounds(375, 348, 89, 23);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Clear Link");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String driver = "com.mysql.jdbc.Driver";
					Class.forName(driver);
					Connection con = DriverManager.getConnection(
							"jdbc:mysql://LAPTOP-CBVBHO6M:3306/project?user=newuser&password=akshita@12345&allowPublicKeyRetrieval=true&useSSL=false");
					String sqlconn = "delete from teacherdata where subject = \"Advance Programming\";";
					PreparedStatement pst = con.prepareStatement(sqlconn);
					pst.execute();

					dispose();
				} catch (Exception et) {

				}

			}
		});
		btnNewButton_2.setBounds(68, 348, 106, 23);
		contentPane.add(btnNewButton_2);
	}
}
