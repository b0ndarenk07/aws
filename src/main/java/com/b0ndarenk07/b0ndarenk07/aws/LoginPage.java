package com.b0ndarenk07.b0ndarenk07.aws;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPage implements ActionListener{





		JFrame frame = new JFrame();
		JButton loginButton = new JButton("Login");
		JButton resetButton = new JButton("Reset");
		JTextField userIDField = new JTextField();
		JPasswordField passwordField = new JPasswordField();
		JLabel userIDLabel = new JLabel("username:");
		JLabel passwordLabel = new JLabel("password:");
		JLabel messageLabel = new JLabel();
		JLabel welcomeMessage = new JLabel("Welcome, please sign in");

		LoginPage(){

			welcomeMessage.setBounds(50, 25, 250, 100);
			frame.add(welcomeMessage);
			messageLabel.setBounds(125, 250, 250, 35);
			messageLabel.setFont(new Font(null,Font.ITALIC, 25));
			
			userIDLabel.setBounds(50, 100, 75, 25);
			userIDField.setBounds(125,100,200,25);
			
			passwordLabel.setBounds(50, 150, 75, 25);
			passwordField.setBounds(125, 150, 200, 25);
			
			//Login Button
			loginButton.setBounds(125, 200, 100, 25);
			loginButton.addActionListener(this);
			loginButton.setFocusable(false);
			
			//Reset Button
			resetButton.setBounds(225, 200, 100, 25);
			resetButton.addActionListener(this);
			resetButton.setFocusable(false);
			
			frame.add(userIDLabel);
			frame.add(passwordLabel);
			frame.add(messageLabel);
			frame.add(userIDField);
			frame.add(passwordField);
			frame.add(loginButton);
			frame.add(resetButton);
					
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(420, 420);
			frame.setLayout(null);
			frame.setVisible(true);
			frame.getRootPane().setDefaultButton(loginButton);
				
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == resetButton) {
				userIDField.setText("");
				passwordField.setText("");
				messageLabel.setText("");
			}
			
			if(e.getSource() == loginButton) {
				String userID = userIDField.getText();
				String password = String.valueOf(passwordField.getPassword());
				
				Connection con = null;
		    	Statement st = null;
		    	
		    	try {
		    		Class.forName("com.mysql.cj.jdbc.Driver");
//			    	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/data?useSSL=false", "root", "");
			    	con = DriverManager.getConnection("jdbc:mysql://vlad.cqvkm2zu9o7w.us-west-1.rds.amazonaws.com:3306/data", "admin", "MasterL0ck!777");
			    	st = con.createStatement();
			    	String sql = "select * from login where username='" + userID+"' and password='"+ password+"'";
			    	ResultSet rs = st.executeQuery(sql);
			    	
			    	if(rs.next()) {
			    		messageLabel.setForeground(Color.green);
						messageLabel.setText("Login Successful");
						frame.dispose();
						HomePage homePage = new HomePage(userID);
			    	}
			    	else {
						messageLabel.setForeground(Color.red);
						messageLabel.setText("Wrong password");
					}
			    	
			    	con.close();
		    	}
		    	catch(Exception e1) {
		    		e1.printStackTrace();
		    	}
				
	//
//				if (loginInfo.containsKey(userID)) {
//					if(loginInfo.get(userID).equals(password)) {
//						messageLabel.setForeground(Color.green);
//						messageLabel.setText("Login Successful");
//						frame.dispose();
//						WelcomePage welcomePage = new WelcomePage(userID);
//					}
//					else {
//						messageLabel.setForeground(Color.red);
//						messageLabel.setText("Wrong password");
//					}
//				}
//				
//				else {
//					messageLabel.setForeground(Color.red);
//					messageLabel.setText("User not found");
//				}
			}
			
		}
	}


