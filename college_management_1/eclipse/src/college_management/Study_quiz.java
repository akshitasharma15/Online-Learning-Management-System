package college_management;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JEditorPane;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Study_quiz extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Study_quiz frame = new Study_quiz("ap");
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
	public Study_quiz(String subject) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 544, 395);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Academic work");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(184, 11, 230, 41);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Add / Edit Material Link");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				if (subject.equals("Advance Programming")) {
					ap_teacher advp = new ap_teacher();
					advp.setVisible(true);
				} else if (subject.equals("Digital Image Processing")) {
					Dip_teacher dip = new Dip_teacher();
					dip.setVisible(true);
				} else if (subject.equals("Advance Computer Networks")) {
					Advacomp_teacher adva = new Advacomp_teacher();
					adva.setVisible(true);
				} else if (subject.equals("Artifical Intelligence")) {
					Ai_teacher ai = new Ai_teacher();
					ai.setVisible(true);
				} else if (subject.equals("Research Methodology")) {
					Rm_teacher rm = new Rm_teacher();
					rm.setVisible(true);
				}
				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.ITALIC, 14));
		btnNewButton.setBounds(33, 94, 199, 41);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Create Quiz");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Create_quiz ctq  = new  Create_quiz(subject);
				ctq.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.ITALIC, 14));
		btnNewButton_1.setBounds(290, 94, 199, 41);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("View Response");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				View_quiz vq = new View_quiz("Advance Programming");
				vq.setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.ITALIC, 14));
		btnNewButton_2.setBounds(149, 190, 199, 48);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Back");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Teacher_Subject tsj = new Teacher_Subject();
				tsj.setVisible(true);
				
				
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_3.setBounds(207, 297, 89, 23);
		contentPane.add(btnNewButton_3);
	}
}
