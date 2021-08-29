package chatbox;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class client extends JFrame {

	private JPanel contentPane;
	private JTextField type;

	/**
	 * Launch the application.
	 */
	static Socket s;
	static DataInputStream din;
	static DataOutputStream dout;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					client frame = new client();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		try {
			s = new Socket("1207.0.0.1",1201);
			din = new DataInputStream(s.getInputStream());
			dout = new DataOutputStream(s.getOutputStream());
			String msgin="";
			while(msgin.equals("exit")){
				msgin = din.readUTF();
				chatbox.client.setText(chatbox.client.getText().trim()+"\n Server: \t"+msgin);
			}catch(exception e) {
				
			}
		}
	}

	/**
	 * Create the frame.
	 */
	public client() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 453, 528);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea chatbox = new JTextArea();
		chatbox.setEditable(false);
		chatbox.setBounds(10, 10, 419, 401);
		contentPane.add(chatbox);
		
	
		JButton btnNewButton = new JButton("Send");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String msgout = "";
					msgout = type.getText().trim();
					dout.writeUTF(msgout);
				}
				catch(Exception e1){
					
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton.setBounds(329, 442, 100, 39);
		contentPane.add(btnNewButton);
		
		type = new JTextField();
		type.setBounds(10, 442, 309, 39);
		contentPane.add(type);
		type.setColumns(10);
	}

}
