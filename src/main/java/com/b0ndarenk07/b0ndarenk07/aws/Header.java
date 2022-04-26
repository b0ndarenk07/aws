package com.b0ndarenk07.b0ndarenk07.aws;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.prefs.BackingStoreException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Header implements ActionListener  {

	// Panel
	public JPanel headerPanel = new JPanel();
	JLabel welcomeMessage = new JLabel("Welcome");
	// Menu Buttons
	JButton homeButton = new JButton("Home");
	JButton profileButton = new JButton("Profile");
	JButton acountsButton = new JButton("Accounts");
	JButton assetsButton = new JButton("Assets");
	JButton liabilitiesButton = new JButton("Liabilities");
	Font myFont = new Font(null, Font.PLAIN, 25);
	String user;

	public Header(String userID) {
		int width = 1420;
		int headerHeight = 40;
		user = userID;
		welcomeMessage.setBounds(0, 0, 200, 35);
		welcomeMessage.setFont(myFont);
		welcomeMessage.setText("Weclome " + userID);
		headerPanel.add(welcomeMessage);
		// Layout - Header
		headerPanel.setBackground(Color.white);
		headerPanel.setBounds(0, 0, width, headerHeight);
		headerPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
		headerPanel.setPreferredSize(new Dimension(width, headerHeight));
		createMenuButtons(homeButton, 0, 0);
		createMenuButtons(profileButton, 100, 0);
		createMenuButtons(acountsButton, 200, 0);
		createMenuButtons(assetsButton, 300, 0);
		createMenuButtons(liabilitiesButton, 400, 0);
	}

	public void createMenuButtons(JButton name, int x, int y) {

		name.setBounds(x, y, 100, 100);
		name.addActionListener(this);
		name.setFocusable(false);
		headerPanel.add(name);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == profileButton) {
			try {
				ProfilePage profile = new ProfilePage(user);
				
			} catch (BackingStoreException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (e.getSource() == homeButton) {
			try {
				HomePage home = new HomePage(user);
			} catch (BackingStoreException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

}

