package com.betaben.server;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JToolBar;

public class Main extends JFrame {

	static Main frame;
	
	static UserClient client;
	
	private JPanel contentPane;
	private JTextField textField;
	JTextArea textArea = new JTextArea();
	JScrollPane scrollPane = new JScrollPane();
	JButton btnSend = new JButton("Send");
	private final JRadioButton rdbtnDarkMode;
	
	private static String username = "BetaBen";
	private static Date date = null;
	private static DateFormat format = new SimpleDateFormat("HH:mm:ss");
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Main();
					runWindowActions();
					frame.setResizable(false);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public Main() throws Exception {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 317);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		String ip = "10.1.15.254";
		short port = 31415;
		
		
		client = new UserClient(new Socket(ip, port), this);
		client.start();
		
		textField = new JTextField();
		textField.setBounds(6, 258, 309, 29);
		textField.setBorder(new LineBorder(Color.black));
		textField.setColumns(10);
		contentPane.add(textField);
		
		btnSend.setBounds(327, 259, 117, 29);
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				try {
					date = new Date();
					client.send("[" + username + "] " +  textField.getText() + "		Sent: " + format.format(date).toString());
					textField.setText("");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		contentPane.add(btnSend);
		
		contentPane.getRootPane().setDefaultButton(btnSend);
		
		scrollPane.setBounds(6, 6, 438, 223);
		contentPane.add(scrollPane);
		
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		
		rdbtnDarkMode = new JRadioButton("Dark Mode");
		rdbtnDarkMode.setSelected(true);
		rdbtnDarkMode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				if(rdbtnDarkMode.isSelected()){
					contentPane.setBackground(Color.lightGray);
					textArea.setBackground(Color.white);
					textArea.setForeground(Color.black);
					textField.setBackground(Color.white);
					textField.setForeground(Color.black);
					rdbtnDarkMode.setForeground(Color.black);
				} else {
					contentPane.setBackground(Color.black);
					textArea.setBackground(Color.darkGray);
					textArea.setForeground(Color.white);
					textField.setBackground(Color.darkGray);
					textField.setForeground(Color.white);
					rdbtnDarkMode.setForeground(Color.white);
				}
			}
		});
		rdbtnDarkMode.setBounds(0, 229, 100, 23);
		contentPane.add(rdbtnDarkMode);

		runThread();
		
	}
	
	public void write(String data) {
	    textArea.append(data);
	}
	
	public void runThread(){
		Thread thread = new Thread(){
			@Override
			public void run() {
				while(true){
					if(textField.getText().isEmpty()){
						btnSend.setEnabled(false);
					} else {
						btnSend.setEnabled(true);
					}
					if(rdbtnDarkMode.isSelected()){
						contentPane.setBackground(Color.black);
						textArea.setBackground(Color.darkGray);
						textArea.setForeground(Color.white);
						textField.setBackground(Color.darkGray);
						textField.setForeground(Color.white);
						rdbtnDarkMode.setForeground(Color.white);
					} else {
						contentPane.setBackground(Color.lightGray);
						textArea.setBackground(Color.white);
						textArea.setForeground(Color.black);
						textField.setBackground(Color.white);
						textField.setForeground(Color.black);
						rdbtnDarkMode.setForeground(Color.black);
					}
					try {
						sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		thread.start();
	}
	
	public static void runWindowActions(){
		frame.addWindowListener(new WindowListener(){

			@Override
			public void windowOpened(WindowEvent e) {
				try {
					client.send("[" + username + "] joined the chatroom.");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}

			@Override
			public void windowClosing(WindowEvent e) {
				try {
					client.send("[" + username + "] left the chatroom.");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}

			@Override
			public void windowClosed(WindowEvent e) {
				
			}

			@Override
			public void windowIconified(WindowEvent e) {
				
			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				
			}

			@Override
			public void windowActivated(WindowEvent e) {
				
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				
			}
			
		});
	}
}
