package com.b0ndarenk07.b0ndarenk07.aws;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.ParseException;
import java.util.Locale;
import java.util.prefs.BackingStoreException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class HomePage extends UserPreferences implements ActionListener, KeyListener {

	JFrame frame = new JFrame();
	JButton calculate = new JButton("Calculate");
	JButton exit = new JButton("Exit");

	// Assets
	JTextField assets = new JTextField();

	JTextField cash = new JTextField();
	JTextField bank = new JTextField();
	JTextField midas = new JTextField();
	JTextField ledger = new JTextField();
	JTextField robinhood = new JTextField();
	JTextField etrade = new JTextField();
	JTextField prosper = new JTextField();
	JTextField fidelity = new JTextField();
	JTextField gemini = new JTextField();
	JTextField coinbase = new JTextField();
	JTextField hotbit = new JTextField();
	JTextField celsius = new JTextField();
	JTextField netWorth = new JTextField();

	// Liabilities
	JTextField liabilities = new JTextField();

	JTextField chaseCC = new JTextField();
	JTextField carLoan = new JTextField();
	JTextField otherL = new JTextField();
	JTextField bofaCC = new JTextField();

	// Asset Labels
	JLabel assetsLabel = new JLabel("Assets:");
	JLabel netWorthLabel = new JLabel("Net Worth:");

	JLabel cashLabel = new JLabel("Cash:");
	JLabel bankLabel = new JLabel("Bank:");
	JLabel midasLabel = new JLabel("Midas:");
	JLabel ledgerLabel = new JLabel("Ledger:");
	JLabel robinhoodLabel = new JLabel("Robinhood:");
	JLabel etradeLabel = new JLabel("Etrade:");
	JLabel prosperLabel = new JLabel("Prosper:");
	JLabel fidelityLabel = new JLabel("Fidelity:");
	JLabel geminiLabel = new JLabel("Gemini:");
	JLabel coinbaseLabel = new JLabel("Coinbase");
	JLabel hotbitLabel = new JLabel("Hotbit:");
	JLabel celsiusLabel = new JLabel("Celsius:");

	JLabel chaseCCLabel = new JLabel("Chase CC:");
	JLabel bofaCCLabel = new JLabel("BofA CC:");
	JLabel carLoanLabel = new JLabel("Car Loan:");
	JLabel otherLLabel = new JLabel("Other:");
	UserPreferences userprefs = new UserPreferences();
	JLabel liabilitiesLabel = new JLabel("Liabilities:");
	Font myFont = new Font(null, Font.PLAIN, 25);
	Locale locale = Locale.US;
	double startValue;
	String user;

	
	public HomePage(String userID) throws BackingStoreException {
		user=userID;
		Header header = new Header(user);
		frame.add(header.headerPanel);

		UserPreferences userprefs = new UserPreferences();
		userprefs.setAllUserPrefToTrue(true);

		if (userprefs.returnUserPref(displayBankAccount) == true) {
			addAsset(bank, bankLabel, 75);
		}
		if (userprefs.returnUserPref(displayCashAccount) == true) {
			addAsset(cash, cashLabel, 50);
		}
		if (userprefs.returnUserPref(displayMidasAccount) == true) {
			addAsset(midas, midasLabel, 100);
		}
		if (userprefs.returnUserPref(displayLedgerAccount) == true) {
			addAsset(ledger, ledgerLabel, 125);
		}
		if (userprefs.returnUserPref(displayRobinhood) == true) {
			addAsset(robinhood, robinhoodLabel, 150);
		}
		if (userprefs.returnUserPref(displayEtrade) == true) {
			addAsset(etrade, etradeLabel, 175);
		}
		if (userprefs.returnUserPref(displayProsper) == true) {
			addAsset(prosper, prosperLabel, 200);
		}
		if (userprefs.returnUserPref(displayFidelity) == true) {
			addAsset(fidelity, fidelityLabel, 225);
		}
		if (userprefs.returnUserPref(displayGeminiAccount) == true) {
			addAsset(gemini, geminiLabel, 250);
		}
		if (userprefs.returnUserPref(displayCoinbaseAccount) == true) {
			addAsset(coinbase, coinbaseLabel, 275);
		}
		if (userprefs.returnUserPref(displayHotbitAccount) == true) {
			addAsset(hotbit, hotbitLabel, 300);
		}
		if (userprefs.returnUserPref(displayCelsius) == true) {
			addAsset(celsius, celsiusLabel, 325);
		}
		// All Assets

		addAsset(assets, assetsLabel, 375);
		addAsset(netWorth, netWorthLabel, 400);

		// All Liabilities
		addLiability(chaseCC, chaseCCLabel, 50);
		addLiability(bofaCC, bofaCCLabel, 75);
		addLiability(carLoan, carLoanLabel, 100);
		addLiability(otherL, otherLLabel, 125);

		addLiability(liabilities, liabilitiesLabel, 375);

		// Calculate Button
		calculate.setBounds(0, 450, 100, 25);
		calculate.setFocusable(true);
		calculate.addActionListener(this);
		calculate.addKeyListener(this);
		frame.add(calculate);
		frame.getRootPane().setDefaultButton(calculate);

		// Exit Button
		exit.setBounds(100, 450, 100, 25);
		exit.setFocusable(false);
		exit.addActionListener(this);
		frame.add(exit);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(Application.frameWidth, Application.frameHeight);
		frame.setLayout(null);
		frame.setVisible(true);
	}

	public void addAsset(JTextField account, JLabel accountLabel, int Yposition) {
		int labelX = 50;
		int fieldX = labelX + 75;
		int fieldWidth = 200;
		int fieldHeight = 25;
		int labelHeight = 25;
		int labelWidth = 75;

		accountLabel.setBounds(labelX, Yposition, labelWidth, labelHeight);
		account.setBounds(fieldX, Yposition, fieldWidth, fieldHeight);
		account.setText(Double.toString(startValue));
		frame.add(account);
		frame.add(accountLabel);

	}

	public void addLiability(JTextField account, JLabel accountLabel, int Yposition) {
		int labelX = 400;
		int fieldX = labelX + 75;
		int fieldWidth = 200;
		int fieldHeight = 25;
		int labelHeight = 25;
		int labelWidth = 75;

		accountLabel.setBounds(labelX, Yposition, labelWidth, labelHeight);
		account.setBounds(fieldX, Yposition, fieldWidth, fieldHeight);
		account.setText(Double.toString(startValue));
		frame.add(account);
		frame.add(accountLabel);

	}

	public void calculateAssets() throws ParseException {

		double sumA = 0.00;
		try {
			sumA = Double.parseDouble(cash.getText()) + Double.parseDouble(bank.getText())
					+ Double.parseDouble(midas.getText()) + Double.parseDouble(ledger.getText())
					+ Double.parseDouble(robinhood.getText()) + Double.parseDouble(etrade.getText())
					+ Double.parseDouble(prosper.getText()) + Double.parseDouble(fidelity.getText())
					+ Double.parseDouble(gemini.getText()) + Double.parseDouble(coinbase.getText())
					+ Double.parseDouble(hotbit.getText()) + Double.parseDouble(celsius.getText());
			System.out.println("Assets: " + sumA);
			String str = Double.toString(sumA);
			assets.setText(str);
		} catch (NumberFormatException e) {

		}

	}

	public void calculateLiabilities() {
		double numL = Double.parseDouble(chaseCC.getText()) + Double.parseDouble(bofaCC.getText())
				+ Double.parseDouble(carLoan.getText()) + Double.parseDouble(otherL.getText());
		String str = Double.toString(numL);
		liabilities.setText(str);
	}

	public void calculateNetWorth() {
		double net = Double.parseDouble(assets.getText()) - Double.parseDouble(liabilities.getText());
		String str = Double.toString(net);
		netWorth.setText(str);
	}

	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == exit) {
			// gets rid of launch page and leaves the other one
			frame.dispose();
		}

		if (e.getSource() == calculate) {
			try {
				calculateAssets();
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			calculateLiabilities();
			calculateNetWorth();
		}
		

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			try {
				calculateAssets();
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}


}

