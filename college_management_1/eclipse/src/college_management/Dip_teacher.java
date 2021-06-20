package college_management;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Dip_teacher extends JFrame {

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
					Dip_teacher frame = new Dip_teacher();
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
	public Dip_teacher() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 545, 519);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 235, 205));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DIP Teacher Portal");
		lblNewLabel.setForeground(new Color(255, 105, 180));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(154, 11, 198, 49);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Google Link");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(17, 109, 100, 35);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Google Drive");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(17, 223, 100, 36);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Book");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(17, 309, 87, 35);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Clear Google Link");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String driver = "com.mysql.jdbc.Driver";
					Class.forName(driver);
					Connection con = DriverManager.getConnection(
							"jdbc:mysql://LAPTOP-CBVBHO6M:3306/project?user=newuser&password=akshita@12345&allowPublicKeyRetrieval=true&useSSL=false");
					String sqlconn = "delete from teacherdata where subject = \"DIP\";";
					PreparedStatement pst = con.prepareStatement(sqlconn);
					pst.execute();

					dispose();
				} catch (Exception et) {

				}
			}
			
		});
		btnNewButton.setBounds(35, 446, 131, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Teacher_Subject ts = new Teacher_Subject();
				ts.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(234, 446, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Submit");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String driver = "com.mysql.jdbc.Driver";
					Class.forName(driver);
					PreparedStatement pst;
					Connection con = DriverManager.getConnection("jdbc:mysql://LAPTOP-CBVBHO6M:3306/project?user=newuser&password=akshita@12345&allowPublicKeyRetrieval=true&useSSL=false" );
					
					String queryString = "SELECT COUNT(*) FROM teacherdata where subject = \"DIP\";";
					pst = con.prepareStatement(queryString);
					ResultSet results = pst.executeQuery(queryString);
					results.next();
					if (results.getInt("count(*)") == 1) {
						if (results.getRow() == 1) {
							String query = "update teacherdata set google_link = ?, google_drive = ?, book = ? where subject = \"DIP\";";
							pst = con.prepareStatement(query);
							pst.setString(1, textField.getText());
							pst.setString(2, textField_1.getText());
							pst.setString(3, textField_2.getText());
							pst.execute();
						}
					}
					
					
					else {
						String sqlconn="insert into teacherdata values (?, ?, ?, 'DIP');";
						pst = con.prepareStatement(sqlconn);
						
						pst.setString(1, textField.getText());
						pst.setString(2, textField_1.getText());
						pst.setString(3, textField_2.getText());
				//		ResultSet rs  = pst.executeQuery(sqlconn);
			//	        String g_link = rs.getString(textField.getText().trim());
				        
		//			    String g_dlink = rs.getString(textField_1.getText().trim());
		//			    String book_link = rs.getString(textField_2.getText().trim());
					    
					    //System.out.println(aa);
				        pst.execute();
					
					
					
			        
					}
				    
				   
				    dispose();
				}
				catch(Exception et) {
					
				}
			}
		});
		btnNewButton_2.setBounds(406, 446, 89, 23);
		contentPane.add(btnNewButton_2);
		
		textField = new JTextField();
		textField.setBounds(154, 109, 313, 73);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(154, 202, 313, 79);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(154, 292, 313, 73);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
	}

}
