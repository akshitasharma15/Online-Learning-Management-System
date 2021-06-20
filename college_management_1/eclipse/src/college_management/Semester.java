package college_management;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Semester extends JFrame {

	private JPanel contentPane;
	private JFrame frame ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Semester frame = new Semester("email@email.com");
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
	public Semester(String email) {
		ButtonGroup group = new ButtonGroup();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 539, 534);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 239, 213));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("1st Semester");
		rdbtnNewRadioButton.setBounds(31, 75, 109, 23);
		contentPane.add(rdbtnNewRadioButton);
		group.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("3rd Semester");
		rdbtnNewRadioButton_1.setBounds(31, 215, 109, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		group.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("2nd Semester");
		rdbtnNewRadioButton_2.setBounds(31, 149, 109, 23);
		contentPane.add(rdbtnNewRadioButton_2);
		group.add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("4th SEmester");
		rdbtnNewRadioButton_3.setBounds(31, 289, 109, 23);
		contentPane.add(rdbtnNewRadioButton_3);
		group.add(rdbtnNewRadioButton_3);
		
		JLabel lblNewLabel = new JLabel("Choose Your Semester!");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		lblNewLabel.setBounds(128, 11, 309, 57);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(rdbtnNewRadioButton.isSelected()) {
					dispose();
					MTech mt  = new MTech(email);
					mt.setVisible(true);
					
				}
				else {
					dispose();
				}
			}
		});
		btnNewButton.setBackground(new Color(240, 255, 240));
		btnNewButton.setBounds(199, 336, 89, 23);
		contentPane.add(btnNewButton);
	}
}
