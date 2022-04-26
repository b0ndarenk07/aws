package com.b0ndarenk07.b0ndarenk07.aws;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Footer {

	public JPanel footerPanel = new JPanel();
	JLabel welcomeMessage = new JLabel("Welcome");
	int footerHeight = 40;
	public Footer(){
		footerPanel.setBackground(Color.black);
	
//		footerPanel.setBounds(0, 500, main.frameWidth, footerHeight);
//		footerPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
//		footerPanel.setLayout(null);
//		footerPanel.setPreferredSize(new Dimension(main.frameWidth, footerHeight));
	}
	
}

