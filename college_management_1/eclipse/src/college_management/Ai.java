package college_management;
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.net.URISyntaxException;
import java.io.IOException;
import java.net.URI;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.*;
public class Ai extends JFrame {

	private JPanel contentPane;
	public static String str2;
    public static String str3;
    public static  String str5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ai frame = new Ai("email@email.com");
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
	public Ai(String email) {
		
		try {
			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver);
			Connection con = DriverManager.getConnection("jdbc:mysql://LAPTOP-CBVBHO6M:3306/project?user=newuser&password=akshita@12345&allowPublicKeyRetrieval=true&useSSL=false" );
			String sqlcon="select google_link, google_drive, book from teacherdata where subject  = \"Artifical Intelligence\";";
			PreparedStatement pst = con.prepareStatement(sqlcon);
			ResultSet rs  = pst.executeQuery(sqlcon);
			rs.next();
			str2= rs.getString("google_link").trim();
			str3= rs.getString("google_drive").trim();
			str5= rs.getString("book").trim();
			//lblNewLabel_4.setText(str2);
		
			con.close();

			
		}
		catch(Exception ex) {
			
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 507, 429);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 239, 213));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Artifical Inteligence & Fuzzy Logic");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(80, 11, 328, 50);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Google Link");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(10, 75, 100, 36);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Google Drive");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(10, 162, 100, 39);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Book");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setBounds(10, 228, 100, 32);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				ap_study_quiz mt1  = new ap_study_quiz("Artifical Intelligence",email);
				mt1.setVisible(true);
			
			}
		});
		btnNewButton.setBounds(183, 332, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBounds(154, 77, 278, 58);
		lblNewLabel_4.setForeground(Color.BLUE.darker());
		lblNewLabel_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_4.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URI(str2));
					
				}
				catch (IOException | URISyntaxException eu){
					eu.printStackTrace();
					
				}
			
				
			}
			
		});
		contentPane.add(lblNewLabel_4);
		lblNewLabel_4.setText(str2);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setBounds(154, 165, 278, 55);
		lblNewLabel_5.setForeground(Color.BLUE.darker());
		lblNewLabel_5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_5.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URI(str3));
					
				}
				catch (IOException | URISyntaxException eu){
					eu.printStackTrace();
					
				}
			
				
			}
			
		});
		contentPane.add(lblNewLabel_5);
		lblNewLabel_4.setText(str3);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setBounds(154, 239, 278, 58);
		lblNewLabel_6.setForeground(Color.BLUE.darker());
		lblNewLabel_6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_6.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URI(str5));
					
				}
				catch (IOException | URISyntaxException eu){
					eu.printStackTrace();
					
				}
			
				
			}
			
		});
		contentPane.add(lblNewLabel_6);
		lblNewLabel_4.setText(str5);
		
		JButton btnNewButton_1 = new JButton("Log Out");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(319, 332, 89, 23);
		contentPane.add(btnNewButton_1);
	}

}
