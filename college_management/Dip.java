package college_management;
import java.awt.*;
import java.net.URISyntaxException;
import java.io.IOException;
import java.net.URI;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.sql.*;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Dip extends JFrame {

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
					Dip frame = new Dip("email@email.com");
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
	public Dip(String email) {
		
		
		try {
			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver);
			Connection con = DriverManager.getConnection("jdbc:mysql://LAPTOP-CBVBHO6M:3306/project?user=newuser&password=akshita@12345&allowPublicKeyRetrieval=true&useSSL=false" );
			String sqlcon="select google_link, google_drive, book from project.teacherdata where subject  = \"DIP\";";
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
		setBounds(100, 100, 550, 436);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 239, 213));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Google link");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(31, 113, 98, 24);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Google Drive");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(31, 192, 98, 24);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Book");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(31, 274, 98, 31);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("DIP");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		lblNewLabel_4.setBounds(218, 11, 229, 54);
		contentPane.add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ap_study_quiz mt  = new ap_study_quiz("Digital Image Processing", email);
				mt.setVisible(true);
			}
		});
		btnNewButton.setBounds(204, 363, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(185, 98, 305, 58);
		
		lblNewLabel_3.setForeground(Color.BLUE.darker());
		lblNewLabel_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_3.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URI(str2));
					
				}
				catch (IOException | URISyntaxException eu){
					eu.printStackTrace();
					
				}
			
				
			}
			
		});
		contentPane.add(lblNewLabel_3);
		lblNewLabel_3.setText(str2);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setBounds(185, 179, 305, 54);
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
		lblNewLabel_5.setText(str3);
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setBounds(185, 264, 305, 54);
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
		lblNewLabel_6.setText(str5);
		JButton btnNewButton_1 = new JButton("Log Out");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		btnNewButton_1.setBounds(378, 363, 89, 23);
		contentPane.add(btnNewButton_1);
	}
}
