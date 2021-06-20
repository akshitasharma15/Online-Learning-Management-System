package college_management;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ap_study_quiz extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ap_study_quiz frame = new ap_study_quiz("Advance Programming", "email@email.com");
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
	public ap_study_quiz(String subject, String email) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 549, 420);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 239, 213));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Course Work");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(178, 11, 230, 74);
		contentPane.add(lblNewLabel);

		JButton btnNewButton = new JButton("View Study Material Links");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				if (subject.equals("Advance Programming")) {
					AdvaProg advp = new AdvaProg(email);
					advp.setVisible(true);
				} else if (subject.equals("Digital Image Processing")) {
					Dip dip = new Dip(email);
					dip.setVisible(true);
				} else if (subject.equals("Advance Computer Networks")) {
					Advacomp adva = new Advacomp(email);
					adva.setVisible(true);
				} else if (subject.equals("Artifical Intelligence")) {
					Ai ai = new Ai(email);
					ai.setVisible(true);
				} else if (subject.equals("Research Methodolog")) {
					Rm rm = new Rm(email);
					rm.setVisible(true);
				}

			}
		});
		btnNewButton.setBackground(new Color(255, 160, 122));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(40, 196, 217, 35);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Start Quiz");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Take_quiz quiz = new Take_quiz(subject,email);
				quiz.setVisible(true);
			}
		});
		btnNewButton_1.setBackground(new Color(255, 160, 122));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBounds(281, 196, 217, 35);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();
				MTech mte = new MTech(email);
				mte.setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_2.setBounds(218, 334, 89, 23);
		contentPane.add(btnNewButton_2);
	}

}
