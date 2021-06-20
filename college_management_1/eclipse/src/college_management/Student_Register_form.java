/*package college_management;

import java.awt.*;
import java.sql.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JRadioButton;
import java.awt.Image;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class Student_Register_form extends JFrame {

	private JPanel contentPane;
	private JFrame frame;
	public static String str1;
	public static String str2;
	public String user_type;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student_Register_form frame = new Student_Register_form();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Student_Register_form() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 616, 547);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("What is your Role?");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel.setBounds(20, 40, 236, 34);
		contentPane.add(lblNewLabel);

		JRadioButton rdbtnNewRadioButton = new JRadioButton("Student");
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdbtnNewRadioButton.setBounds(71, 127, 109, 23);
		contentPane.add(rdbtnNewRadioButton);

		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Teacher");
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdbtnNewRadioButton_1.setBounds(278, 127, 109, 23);
		contentPane.add(rdbtnNewRadioButton_1);

		JLabel lblNewLabel_1 = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/imagea.jpg")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img));

		lblNewLabel_1.setBounds(10, 11, 565, 413);
		contentPane.add(lblNewLabel_1);

		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (rdbtnNewRadioButton.isSelected()) {
						user_type = rdbtnNewRadioButton.getText();
					} else if (rdbtnNewRadioButton_1.isSelected()) {
						user_type = rdbtnNewRadioButton_1.getText();
					}
					String driver = "com.mysql.jdbc.Driver";
					Class.forName(driver);
					Connection con = DriverManager.getConnection(
							"jdbc:mysql://LAPTOP-CBVBHO6M:3306/project?user=newuser&password=akshita@12345&allowPublicKeyRetrieval=true&useSSL=false"); // ?autoReconnect=
					// true
					String sql = "SELECT COUNT(*) FROM project.register2 where email = \"" + str1 + "\" and pasword= \""
							+ str2 + "\" and user_type= \"" + user_type.toLowerCase() + "\";";
					PreparedStatement pstmt = con.prepareStatement(sql);
					ResultSet results = pstmt.executeQuery(sql);
					results.next();
					if (results.getInt("count(*)") != 1) {
						JOptionPane.showMessageDialog(null, "This account doesn't belong to a " + user_type
								+ ". Please enter your correct credentials");
					dispose();
					Login_form lgf = new Login_form();
					lgf.setVisible(true);
					} else {
						if (rdbtnNewRadioButton.isSelected()) {
							dispose();
							Choice c1 = new Choice(email);
							c1.setVisible(true);
						 
						} else {
							dispose();
							Teacher_Choice tc = new Teacher_Choice();
							tc.setVisible(true);

						}

					}

				}

				catch (Exception ep) {
					JOptionPane.showMessageDialog(null, ep);
					ep.printStackTrace();

				}

			}
		});
		btnNewButton.setBounds(262, 435, 89, 23);
		contentPane.add(btnNewButton);
	}
}
*/