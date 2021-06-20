package college_management;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;

public class View_quiz extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View_quiz frame = new View_quiz("Advance Programming");
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
	public View_quiz(String subject) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 587, 385);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		String[] columnNames = { "Email", "Subject", "Marks", "Response" };
		

		try {
			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver);
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://LAPTOP-CBVBHO6M:3306/project?user=newuser&password=akshita@12345&allowPublicKeyRetrieval=true&useSSL=false"); // ?autoReconnect=
																																				// true
			String sql = "select * from quiz_response where subject = \"" + subject + "\";";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rst = pstmt.executeQuery(sql);
			rst.next();
			String[][] data = new String[50][50];
			for (int i = 0; i < rst.getRow(); i++) {
				data[i][0] = rst.getString("student_email").trim();
				data[i][1] = rst.getString("subject").trim();
				data[i][2] = rst.getString("marks").trim();
				data[i][3] = rst.getString("response_time").trim();
				rst.next();
			}
			JTable j1 = new JTable(data, columnNames);
			j1.setBounds(30, 30, 441, 310);
			JScrollPane sp = new JScrollPane(j1);
			sp.setBounds(28, 11, 533, 324);
			contentPane.add(sp);
			contentPane.setVisible(true);
		} catch (

		Exception ex) {
			JOptionPane.showMessageDialog(null, "exception occured");
			ex.printStackTrace();
		}
	}
}
