/**
 * handles configuration loading, additions, updates, and deletions.
 * maintains current configuration settings for use by the application manager.
 */
package com.github.masonBeattie99.EZ_Translate.configuration;

import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Configuration {

	//static variables for configuration file
	private static String NO_CONFIG = "NOT CONFIGURED";
	private static String CONFIG_FILE = "config.txt";
	private static int APP_LIMIT = 10;
	
	/**
	//static variables for configurations themselves
	private static String 
	private static int APP_INDEX = 3;
	private static int OPEN_KEY_INDEX = 1;
	private static int CLOSE_KEY_INDEX = 2;
	private static int LOCAL_INDEX = 0;
	*/
	
	//file reading objects
	private File configFile;
	private PrintWriter configWriter;
	private Scanner in;
	
	//configuration variables and lists
	private String apps;
	private String currOpenKey;
	private String currCloseKey;
	private String currLocal;
	
	//hash map to store configuration settings
	//private ArrayList<Map<String, String>> configs;
	
	/**
	 * constructor for Configuration
	 */
	public Configuration(){
		
		apps = "";
		currOpenKey = "";
		currCloseKey = "";
		currLocal = "";
		
	}//constructor
	
	/**
	 * reads the configuration file
	 * @return true upon success, false upon failure
	 */
	public boolean readFile() {
		
		String temp = "";
		
		try {
			configFile = new File(CONFIG_FILE);
			in = new Scanner(configFile);
			
			if(in.hasNext()) {
				in.useDelimiter("%");
				
			}
			else {
				apps = NO_CONFIG;
				currOpenKey = NO_CONFIG;
				currCloseKey = NO_CONFIG;
				currLocal = "eng";//default localization is English. If no configuration is available then automatically assign English
			}
			
			return true;
			
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
			return false;
		}
		
	}//readConfig
	
	/**
	 * updates the contents of config.txt to current configuration settings
	 * @param configuration to update
	 * @param data to change
	 * @return true upon success, false upon failure
	 */
	public boolean updateFile() {
		
		try {
			configWriter = new PrintWriter(CONFIG_FILE);
			
			configWriter.write(
					currLocal + "%" + 
					currOpenKey + "%" +
					currCloseKey + "%" +
					apps);
			
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
			return false;
		}
		
		
		
		return true;
		
	}//updateFile
	
	/**
	 * updates the application string
	 * @param application directory being added
	 * @param data to change
	 * @return true upon success, false upon failure
	 */
	public boolean updateApp(String changedConfig, String data) {
		
		return true;
		
	}//updateFile
	
}//class
