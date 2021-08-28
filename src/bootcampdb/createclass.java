package bootcampdb;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class createclass extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public createclass() {
		setBounds(100, 100, 720, 420);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Classroom Name");
		lblNewLabel.setBounds(230, 70, 124, 20);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Class Section");
		lblNewLabel_1.setBounds(230, 154, 111, 25);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(161, 45, 59, 66);
		lblNewLabel_2.setIcon(new ImageIcon("/Users/Hareshvar A R/Desktop/Access Camera and Microphone/imgs/icons8-classroom-50.png"));
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("/Users/Hareshvar A R/Desktop/Access Camera and Microphone/imgs/icons8-class-50.png"));
		lblNewLabel_3.setBounds(161, 136, 59, 55);
		contentPane.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(420, 72, 96, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(420, 158, 96, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Create Classroom");
		btnNewButton.setIcon(new ImageIcon("/Users/Hareshvar A R/Desktop/Access Camera and Microphone/imgs/icons8-plus-+-50.png"));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnNewButton.setBounds(264, 296, 224, 59);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("/Users/Hareshvar A R/Desktop/Access Camera and Microphone/imgs/icons8-study-50 (1).png"));
		lblNewLabel_4.setBounds(164, 224, 50, 55);
		contentPane.add(lblNewLabel_4);
		
		textField_2 = new JTextField();
		textField_2.setBounds(420, 236, 96, 19);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Year of Study");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_5.setBounds(230, 229, 101, 31);
		contentPane.add(lblNewLabel_5);
	}

}
