package college_management;


import java.awt.*;
import java.sql.*;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JPasswordField;

public class Reset_Pass extends JFrame {

	private JPanel contentPane;
	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reset_Pass frame = new Reset_Pass();
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
	public Reset_Pass() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 627, 587);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 235, 205));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Email id");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(33, 185, 69, 26);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(212, 186, 181, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(33, 230, 98, 29);
		contentPane.add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(212, 235, 181, 20);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel_2 = new JLabel("Confirm Password");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(33, 269, 124, 26);
		contentPane.add(lblNewLabel_2);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(212, 273, 181, 20);
		contentPane.add(passwordField_1);
		
		JButton btnNewButton = new JButton("Reset");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String driver = "com.mysql.jdbc.Driver";
					Class.forName(driver);
					Connection con = DriverManager.getConnection("jdbc:mysql://LAPTOP-CBVBHO6M:3306/project?user=newuser&password=akshita@12345&allowPublicKeyRetrieval=true&useSSL=false" );
					String sqlconn="update register2 set pasword =  \""+passwordField.getText().trim()+"\" where email = \""+textField.getText().trim()+"\" ";
					PreparedStatement pst = con.prepareStatement(sqlconn);
					
					
					if(String.valueOf(passwordField.getPassword()).equals(String.valueOf(passwordField_1.getPassword()))) {
						
				
					}
				
					else {
						JOptionPane.showMessageDialog(null, "Re-enter your password " );
					}
					
			        pst.execute();
			        dispose();
			        con.close();
				   
					
					//Login_form lgf = new Login_form();
					//lgf.setVisible(true);
					JOptionPane.showMessageDialog(null, "successfully changed Password Login again");
				}
				catch(Exception et) {
					
				}
				
				
				
			}
		});
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnNewButton.setBounds(240, 362, 119, 34);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("Password Reset");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_3.setBounds(196, 11, 230, 67);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/password.png")).getImage();
		lblNewLabel_4.setIcon(new ImageIcon(img));
		lblNewLabel_4.setBounds(10, 40, 569, 497);
		contentPane.add(lblNewLabel_4);
	}
}
