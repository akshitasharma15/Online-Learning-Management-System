package college_management;
import java.awt.*;
import java.sql.*;
import java.sql.Connection;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MTech extends JFrame {

	private JPanel contentPane;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MTech frame = new MTech("email@email.com");
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
	public MTech(String email) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 602, 503);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 239, 213));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("[M.Tech CSE] Advance Programming");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ap_study_quiz apsq = new ap_study_quiz("Advance Programming",email);
				apsq.setVisible(true);
				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		btnNewButton.setForeground(Color.MAGENTA);
		btnNewButton.setBounds(106, 80, 371, 33);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("[M.Tech CSE] Digital Image Processing");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ap_study_quiz apsq = new ap_study_quiz("Digital Image Processing",email);
				apsq.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		btnNewButton_1.setForeground(Color.PINK);
		btnNewButton_1.setBounds(106, 149, 371, 33);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("[M.Tech CSE] Advance Computer networks");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ap_study_quiz apsq = new ap_study_quiz("Advance Computer networks",email);
				apsq.setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		btnNewButton_2.setForeground(Color.ORANGE);
		btnNewButton_2.setBounds(106, 214, 371, 33);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("[M.Tech CSE] Research Methodology");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ap_study_quiz apsq = new ap_study_quiz("Research Methodology",email);
				apsq.setVisible(true);
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		btnNewButton_3.setForeground(new Color(165, 42, 42));
		btnNewButton_3.setBounds(106, 284, 371, 33);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("[M.Tech CSE] Artifical Intelligence");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ap_study_quiz apsq = new ap_study_quiz("Artifical Intelligence",email);
				apsq.setVisible(true);
			}
		});
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		btnNewButton_4.setForeground(new Color(135, 206, 250));
		btnNewButton_4.setBounds(106, 355, 371, 34);
		contentPane.add(btnNewButton_4);
		
		JLabel lblNewLabel = new JLabel("Subjects");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(217, 11, 211, 58);
		contentPane.add(lblNewLabel);
	}
}
