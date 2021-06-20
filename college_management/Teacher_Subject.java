package college_management;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Teacher_Subject extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Teacher_Subject frame = new Teacher_Subject();
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
	public Teacher_Subject() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 538, 438);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 228, 225));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("M.Tech CSE Advance Programming");
		btnNewButton.setForeground(new Color(255, 20, 147));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Study_quiz apt = new Study_quiz("Advance Programming");
				apt.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		btnNewButton.setBounds(70, 106, 382, 34);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("M.Tech CSE Advance Computer Networks ");
		btnNewButton_1.setForeground(new Color(255, 99, 71));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Study_quiz adt = new Study_quiz("Advance Computer Networks");
				adt.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		btnNewButton_1.setBounds(70, 170, 382, 34);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("M.Tech CSE Digital Image Processing");
		btnNewButton_2.setForeground(new Color(255, 165, 0));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Study_quiz dpt = new Study_quiz("Digital Image Processing");
				dpt.setVisible(true);

			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		btnNewButton_2.setBounds(70, 230, 382, 34);
		contentPane.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("M.Tech CSE Research Methodology");
		btnNewButton_3.setForeground(new Color(210, 105, 30));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Study_quiz rmt = new Study_quiz("Research Methodology");
				rmt.setVisible(true);

			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		btnNewButton_3.setBounds(70, 286, 382, 34);
		contentPane.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("M.Tech CSE Artifical Intelligence");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Study_quiz ait = new Study_quiz("Artifical Intelligence");
				ait.setVisible(true);
			}
		});
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		btnNewButton_4.setBounds(70, 342, 382, 34);
		contentPane.add(btnNewButton_4);

		JLabel lblNewLabel = new JLabel("Teacher Portal For 1st Semester M.Tech CSE");
		lblNewLabel.setForeground(new Color(255, 105, 180));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(44, 11, 448, 84);
		contentPane.add(lblNewLabel);
	}
}
