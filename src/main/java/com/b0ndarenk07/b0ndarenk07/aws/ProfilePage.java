package com.b0ndarenk07.b0ndarenk07.aws;

import java.awt.Font;
import java.util.Locale;
import java.util.prefs.BackingStoreException;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ProfilePage extends UserPreferences {
	JFrame profile = new JFrame();

	Font myFont = new Font(null, Font.PLAIN, 25);
	Locale locale = Locale.US;
	double startValue;
	Header header;
	Footer footer = new Footer();

	public ProfilePage(String userID) throws BackingStoreException {
		header = new Header(userID);
	
		profile.add(header.headerPanel);
		profile.add(footer.footerPanel);
		

		
		
		
		profile.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		profile.setSize(main.frameWidth, main.frameHeight);
		profile.setVisible(true);
	}


}

