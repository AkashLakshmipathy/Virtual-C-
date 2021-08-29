package chatbox;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class server extends JFrame {

	private JPanel contentPane;
	private JTextField type;

	/**
	 * Launch the application.
	 */
	static ServerSocket ss;
	static Socket s;
	static DataInputStream din;
	static DataOutputStream dout;
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					server frame = new server();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		String msgin = "";
		try {
			ss = new ServerSocket(1201);
			s = ss.accept();
			
			din = new DataInputStream(s.getInputStream());
			dout = new DataOutputStream(s.getOutputStream());
			
			while(!msgin.equals("exit")) {
				msgin = din.readUTF();
				chatbox.server.setText(chatbox.server.getText().trim()+"\n" + msgin);
			}
			
		}catch (Exception e) {
			
		}
	}

	private static String getText() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Create the frame.
	 */
	public server() {
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
		
		type = new JTextField();
		type.setBounds(10, 442, 309, 39);
		contentPane.add(type);
		type.setColumns(10);
		
		JButton btnNewButton = new JButton("Send");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String msgout= "";
					msgout = type.getText().trim();
					dout.writeUTF(msgout);
				}catch(Exception e1) {
					
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton.setBounds(329, 442, 100, 39);
		contentPane.add(btnNewButton);
	}
}
