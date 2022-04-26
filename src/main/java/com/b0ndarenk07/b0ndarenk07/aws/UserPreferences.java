package com.b0ndarenk07.b0ndarenk07.aws;

import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

public class UserPreferences {
	// Setup the Preferences for this application, by class.
	Preferences prefs = Preferences.userNodeForPackage(UserPreferences.class);
	// Preference key names
	final String usernameSet = "usernameSet";

	// Standard Accounts
	final String displayCashAccount = "displayCashAccount";
	final String displayBankAccount = "displayBankAccount";

	// Crypto Accounts
	final String displayMidasAccount = "displayMidasAccount";
	final String displayLedgerAccount = "displayLedgerAccount";
	final String displayGeminiAccount = "displayGeminiAccount";
	final String displayCoinbaseAccount = "displayCoinbaseAccount";
	final String displayHotbitAccount = "displayHotbitAccount";
	final String displayCoinbasePro = "displayCoinbasePro";
	final String displayCelsius = "displayCelsius";
	final String displayCashApp = "displayCashApp";
	final String displayVenmo = "displayVenmo";
	
	// Stock Accounts
	final String displayRobinhood = "displayRobinhood";
	final String displayEtrade = "displayEtrade";
	final String displayFidelity = "displayFidelity";
	
	//Other Accounts
	final String displayProsper = "displayProsper";

	// Credit Cards
	final String displayChaseCC = "displayChaseCC";
	final String displayBofaCC = "displayBofaCC";

	// Car Loan
	final String displayCarLoan = "displayCarLoan";

	// House Loan
	final String displayHomeLoan = "displayHomeLoan";

	public UserPreferences() throws BackingStoreException {

		prefs.putBoolean(usernameSet, false);
		prefs.putBoolean(displayCashAccount, true);
		prefs.putBoolean(displayBankAccount, true);
		
		

		prefs.putBoolean(displayMidasAccount, false);
		prefs.putBoolean(displayLedgerAccount, false);
		prefs.putBoolean(displayGeminiAccount, false);
		prefs.putBoolean(displayCoinbaseAccount, false);
		prefs.putBoolean(displayHotbitAccount, false);
		prefs.putBoolean(displayCoinbasePro, false);
		prefs.putBoolean(displayCelsius, false);
		prefs.putBoolean(displayCashApp, false);
		prefs.putBoolean(displayVenmo, false);

		
		prefs.putBoolean(displayRobinhood, false);
		prefs.putBoolean(displayEtrade, false);
		prefs.putBoolean(displayFidelity, false);
		prefs.putBoolean(displayProsper, false);
		prefs.putBoolean(displayChaseCC, false);
		prefs.putBoolean(displayBofaCC, false);
		prefs.putBoolean(displayCarLoan, false);
		prefs.putBoolean(displayHomeLoan, false);
		


		
		//Removal
//	    prefs.remove("A");
//	    prefs.remove("B");


//	    Preferences prefsRoot = Preferences.userRoot();
//	    Preferences myPrefs = prefsRoot.node("PreferenceExample");
//
//	    myPrefs.put("A", "a");
//	    myPrefs.put("B", "b");
//	    myPrefs.put("C", "c");

//		displayAllUserPrefs();

		// Save
//	    prefs.put(PREF_NAME, "a string"); // String
//	    prefs.putBoolean(PREF_NAME, true); // boolean
//	    prefs.putInt(PREF_NAME, 123); // int
//	    prefs.putLong(PREF_NAME, 123L); // long
//	    prefs.putFloat(PREF_NAME, 12.3F); // float
//	    prefs.putDouble(PREF_NAME, 12.3); // double
//	    byte[] bytes = new byte[1024];
//	    prefs.putByteArray(PREF_NAME, bytes); // byte[]

		// Retrieve
//	    String s = prefs.get(PREF_NAME, "a string"); // String
//	    boolean b = prefs.getBoolean(PREF_NAME, true); // boolean
//	    int i = prefs.getInt(PREF_NAME, 123); // int
//	    long l = prefs.getLong(PREF_NAME, 123L); // long
//	    float f = prefs.getFloat(PREF_NAME, 12.3F); // float
//	    double d = prefs.getDouble(PREF_NAME, 12.3); // double
//	    bytes = prefs.getByteArray(PREF_NAME, bytes); // byte[]

//	    // Assume the user chose new preference values: Store them back.
//	    prefs.put("A", "aa");
//	    prefs.put("B", "bb");

	}

	/** 
	 * Displays a single user pref key & value pair
	 */
	public void displayUserPref(String key, Boolean value) {
		Boolean text = prefs.getBoolean(key, false);
		System.out.println("User Preference: " + key + " = " + text);
	}

	/** 
	 * Displays all user pref key
	 */
	public void displayAllUserPrefs() throws BackingStoreException {

		System.out.print("Preferences: \n");
		for (String key : prefs.keys()) {
			Boolean value = prefs.getBoolean(key, false);
			System.out.print(key + " = " + value + "\n");
		}
	}
	
	public Boolean returnUserPref(String key) {
		Boolean value = prefs.getBoolean(key, false);
		System.out.print("User Pref: " + key + " = " + value + "\n");
		return value;
	}
	
	public Boolean setUserPref(String key , Boolean value)  {
		prefs.putBoolean(key, value);
		System.out.print("Set User Pref:" + key + " = " + value + "\n");
		return value;
	}
	
	public void setAllUserPrefToTrue(Boolean value) throws BackingStoreException  {

		System.out.print("Setting All User Prefs to True: \n");
		for (String k : prefs.keys()) {
			prefs.putBoolean(k, value);
			System.out.print(k + " = " + value + "\n");
		}
	}
}

