package college_management;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class Create_quiz extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Create_quiz frame = new Create_quiz("Advance Programming");
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
	public Create_quiz(String subject) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 653, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Add Questions");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(210, 11, 279, 35);
		contentPane.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(76, 70, 551, 46);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Question");
		lblNewLabel_1.setBounds(10, 75, 56, 14);
		contentPane.add(lblNewLabel_1);

		textField_1 = new JTextField();
		textField_1.setBounds(76, 153, 260, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(76, 193, 260, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(76, 235, 260, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setBounds(76, 276, 260, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Options");
		lblNewLabel_3.setBounds(10, 131, 46, 14);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_2 = new JLabel("1.");
		lblNewLabel_2.setBounds(20, 156, 46, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("2.");
		lblNewLabel_2_1.setBounds(20, 196, 46, 14);
		contentPane.add(lblNewLabel_2_1);

		JLabel lblNewLabel_2_1_1 = new JLabel("3.");
		lblNewLabel_2_1_1.setBounds(20, 238, 46, 14);
		contentPane.add(lblNewLabel_2_1_1);

		JLabel lblNewLabel_2_1_2 = new JLabel("4.");
		lblNewLabel_2_1_2.setBounds(20, 279, 46, 14);
		contentPane.add(lblNewLabel_2_1_2);

		JButton btnNewButton = new JButton("Add a new Question");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (textField_2.getText().isEmpty() || textField.getText().isEmpty()
							|| textField_3.getText().isEmpty() || textField_4.getText().isEmpty()
							|| textField_1.getText().isEmpty() || textField_5.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Please fill all the fields");
					} else {
						String driver = "com.mysql.jdbc.Driver";
						Class.forName(driver);
						Connection con = DriverManager.getConnection(
								"jdbc:mysql://LAPTOP-CBVBHO6M:3306/project?user=newuser&password=akshita@12345&allowPublicKeyRetrieval=true&useSSL=false"); // ?autoReconnect=
																																							// true
						String sql = "insert into quiz values (?, ?, ?, ?, ?, ?, ?);";
						PreparedStatement pstmt = con.prepareStatement(sql);
						pstmt.setString(1, subject);
						pstmt.setString(2, textField.getText().trim());
						pstmt.setString(3, textField_1.getText().trim());
						pstmt.setString(4, textField_2.getText().trim());
						pstmt.setString(5, textField_3.getText().trim());
						pstmt.setString(6, textField_4.getText().trim());
						pstmt.setString(7, textField_5.getText().trim());
						pstmt.execute();
						dispose();
						Create_quiz ctq = new Create_quiz(subject);
						ctq.setVisible(true);
					}
				} catch (Exception ep) {
					JOptionPane.showMessageDialog(null, "Exception occured");
					ep.printStackTrace();

				}
			}
		});
		btnNewButton.setBounds(58, 342, 161, 23);
		contentPane.add(btnNewButton);

		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField_2.getText().isEmpty() || textField.getText().isEmpty() || textField_3.getText().isEmpty()
						|| textField_4.getText().isEmpty() || textField_1.getText().isEmpty()
						|| textField_5.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please fill all the fields");
				} else {
					try {
						String driver = "com.mysql.jdbc.Driver";
						Class.forName(driver);
						Connection con = DriverManager.getConnection(
								"jdbc:mysql://LAPTOP-CBVBHO6M:3306/project?user=newuser&password=akshita@12345&allowPublicKeyRetrieval=true&useSSL=false"); // ?autoReconnect=
																																							// true
						String sql = "insert into quiz values (?, ?, ?, ?, ?, ?, ?);";
						PreparedStatement pstmt = con.prepareStatement(sql);
						pstmt.setString(1, subject);
						pstmt.setString(2, textField.getText().trim());
						pstmt.setString(3, textField_1.getText().trim());
						pstmt.setString(4, textField_2.getText().trim());
						pstmt.setString(5, textField_3.getText().trim());
						pstmt.setString(6, textField_4.getText().trim());
						pstmt.setString(7, textField_5.getText().trim());
						pstmt.execute();
						dispose();
						Study_quiz stq = new Study_quiz(subject);
						stq.setVisible(true);
					} catch (Exception ep) {
						JOptionPane.showMessageDialog(null, "Exception occured");
						ep.printStackTrace();

					}
				}
			}
		});
		btnSave.setBounds(261, 342, 89, 23);
		contentPane.add(btnSave);

		JLabel lblNewLabel_4 = new JLabel("Answer:");
		lblNewLabel_4.setBounds(369, 156, 46, 14);
		contentPane.add(lblNewLabel_4);

		textField_5 = new JTextField();
		textField_5.setBounds(444, 153, 86, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);

		JButton btnNewButton_1 = new JButton("Delete Existing Questions");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String driver = "com.mysql.jdbc.Driver";
					Class.forName(driver);
					Connection con = DriverManager.getConnection(
							"jdbc:mysql://LAPTOP-CBVBHO6M:3306/project?user=newuser&password=akshita@12345&allowPublicKeyRetrieval=true&useSSL=false"); // ?autoReconnect=
																																						// true
					String sql = "delete from quiz where subject = \"" + subject +"\"";
					PreparedStatement pstmt = con.prepareStatement(sql);
					pstmt.execute();
					JOptionPane.showMessageDialog(null, "All existing questions deleted!");
				} catch (Exception ep) {
					JOptionPane.showMessageDialog(null, "Exception occured");
					ep.printStackTrace();
						
				}

			}
		});
		btnNewButton_1.setBounds(387, 342, 181, 23);
		contentPane.add(btnNewButton_1);
	}
}
