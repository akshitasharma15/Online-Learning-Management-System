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
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class Take_quiz extends JFrame {

	private JPanel contentPane;
	int size = 0;
	int marks = 0;
	PreparedStatement pstmt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Take_quiz frame = new Take_quiz("Advance Programming", "abc@gmail.com");
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
	public Take_quiz(String subject, String email) {
		try {

			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver);
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://LAPTOP-CBVBHO6M:3306/project?user=newuser&password=akshita@12345&allowPublicKeyRetrieval=true&useSSL=false"); // ?autoReconnect=
																																				// true
			String sql = "select * from quiz where subject = \"" + subject + "\";";
			pstmt = con.prepareStatement(sql);
			ResultSet rst = pstmt.executeQuery(sql);
			rst.next();

			List<Question> questionList = new ArrayList<Question>();
			if (rst.getRow() == 0) {
				dispose();
				JOptionPane.showMessageDialog(null, "No quiz is available at this time");
				ap_study_quiz apsq = new ap_study_quiz(subject, email);
				apsq.setVisible(true);
			} else {
				for (int i = 0; i < rst.getRow(); i++) {
					Question question = new Question();
					question.setQuestion(rst.getString("question").trim());
					question.setOption1(rst.getString("option1").trim());
					question.setOption2(rst.getString("option2").trim());
					question.setOption3(rst.getString("option3").trim());
					question.setOption4(rst.getString("option4").trim());
					question.setAnswer(rst.getString("answer").trim());
					questionList.add(question);
					rst.next();
				}
				ButtonGroup group = new ButtonGroup();
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				setBounds(100, 100, 587, 443);
				contentPane = new JPanel();
				contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				setContentPane(contentPane);
				contentPane.setLayout(null);

				JLabel lblNewLabel = new JLabel("Question");
				lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
				lblNewLabel.setBounds(229, 11, 207, 33);
				contentPane.add(lblNewLabel);

				JLabel lblNewLabel_1 = new JLabel("");
				lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
				lblNewLabel_1.setBounds(25, 66, 536, 68);
				contentPane.add(lblNewLabel_1);
				lblNewLabel_1.setText(questionList.get(size).getQuestion());

				JRadioButton rdbtnNewRadioButton = new JRadioButton("New radio button");
				rdbtnNewRadioButton.setBounds(57, 153, 109, 23);
				contentPane.add(rdbtnNewRadioButton);
				group.add(rdbtnNewRadioButton);
				rdbtnNewRadioButton.setText(questionList.get(size).getOption1());

				JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("New radio button");
				rdbtnNewRadioButton_1.setBounds(57, 208, 109, 23);
				contentPane.add(rdbtnNewRadioButton_1);
				group.add(rdbtnNewRadioButton_1);
				rdbtnNewRadioButton_1.setText(questionList.get(size).getOption2());

				JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("New radio button");
				rdbtnNewRadioButton_2.setBounds(57, 258, 109, 23);
				contentPane.add(rdbtnNewRadioButton_2);
				group.add(rdbtnNewRadioButton_2);
				rdbtnNewRadioButton_2.setText(questionList.get(size).getOption3());

				JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("New radio button");
				rdbtnNewRadioButton_3.setBounds(57, 308, 109, 23);
				contentPane.add(rdbtnNewRadioButton_3);
				group.add(rdbtnNewRadioButton_3);
				rdbtnNewRadioButton_3.setText(questionList.get(size).getOption4());

				JButton btnNewButton = new JButton("Next");
				if (size == questionList.size() - 1) {
					btnNewButton.setEnabled(false);
				}
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (!rdbtnNewRadioButton.isSelected() && !rdbtnNewRadioButton_1.isSelected()
								&& !rdbtnNewRadioButton_2.isSelected() && !rdbtnNewRadioButton_3.isSelected()) {
							JOptionPane.showMessageDialog(null, "Please select one option");
						} else {
							if (rdbtnNewRadioButton.isSelected()) {
								questionList.get(size).setUserAnswer("1");
								group.clearSelection();
							} else if (rdbtnNewRadioButton_1.isSelected()) {
								questionList.get(size).setUserAnswer("2");
								group.clearSelection();
							} else if (rdbtnNewRadioButton_2.isSelected()) {
								questionList.get(size).setUserAnswer("3");
								group.clearSelection();
							} else {
								questionList.get(size).setUserAnswer("4");
								group.clearSelection();
							}
							size = size + 1;
							lblNewLabel_1.setText(questionList.get(size).getQuestion());
							rdbtnNewRadioButton.setText(questionList.get(size).getOption1());
							rdbtnNewRadioButton_1.setText(questionList.get(size).getOption2());
							rdbtnNewRadioButton_2.setText(questionList.get(size).getOption3());
							rdbtnNewRadioButton_3.setText(questionList.get(size).getOption4());
							if (size == questionList.size() - 1) {
								btnNewButton.setEnabled(false);
							}

						}
					}
				});
				btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
				btnNewButton.setBounds(382, 370, 89, 23);
				contentPane.add(btnNewButton);

				JButton btnNewButton_1 = new JButton("Submit");
				btnNewButton_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (!rdbtnNewRadioButton.isSelected() && !rdbtnNewRadioButton_1.isSelected()
								&& !rdbtnNewRadioButton_2.isSelected() && !rdbtnNewRadioButton_3.isSelected()) {
							JOptionPane.showMessageDialog(null, "Please select one option");
						} else if (size != questionList.size() - 1) {
							JOptionPane.showMessageDialog(null, "Please answer all the questions");
						} else {
							if (rdbtnNewRadioButton.isSelected()) {
								questionList.get(size).setUserAnswer("1");
							} else if (rdbtnNewRadioButton_1.isSelected()) {
								questionList.get(size).setUserAnswer("2");
							} else if (rdbtnNewRadioButton_2.isSelected()) {
								questionList.get(size).setUserAnswer("3");
							} else {
								questionList.get(size).setUserAnswer("4");
							}
							for (int i = 0; i < questionList.size(); i++) {
								if (questionList.get(i).getUserAnswer().equals(questionList.get(i).getAnswer())) {
									marks++;
								}
							}
							try {
								Email email1 = new Email();
								String sql = "insert into quiz_response values (?, ?, ?, ?)";
								pstmt = con.prepareStatement(sql);
								pstmt.setString(1, email);
								pstmt.setString(2, subject);
								pstmt.setString(3, String.valueOf(marks + "/" + questionList.size()));
								SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
								pstmt.setString(4, simpleDateFormat.format(new Date(System.currentTimeMillis())));
								pstmt.execute();
								sql = "select email from teacher_subject where subject = \"" + subject + "\";";
								pstmt = con.prepareStatement(sql);
								ResultSet rst = pstmt.executeQuery(sql);
								rst.next();
								String teacherEmail = rst.getString("email");
								sql = "select name from register2 where email = \"" + email
										+ "\" and user_type = \"student\";";
								pstmt = con.prepareStatement(sql);
								rst = pstmt.executeQuery(sql);
								rst.next();
								String studentName = rst.getString("name");
								email1.quizEmail(teacherEmail, studentName, subject);
							} catch (SQLException e1) {
								e1.printStackTrace();
							}
							dispose();
							JOptionPane.showMessageDialog(null, "Your Response for this quiz submitted sucessfully.");
							ap_study_quiz apsq = new ap_study_quiz(subject, email);
							apsq.setVisible(true);
						}
					}
				});
				btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
				btnNewButton_1.setBounds(111, 370, 89, 23);
				contentPane.add(btnNewButton_1);
			}

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "exception occured");
			ex.printStackTrace();
		}

	}

}
