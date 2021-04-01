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
	private static String CONFIG_DELIM = "%";
	private static String APPS_DELIM = "#";
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
	private ArrayList<String> apps;
	private String currOpenKey;
	private String currCloseKey;
	private String currLocal;
	
	//hash map to store configuration settings
	//private ArrayList<Map<String, String>> configs;
	
	/**
	 * constructor for Configuration
	 */
	public Configuration(){
		
		apps = new ArrayList<String>();
		currOpenKey = "";
		currCloseKey = "";
		currLocal = "";
		
	}//constructor
	
	/**
	 * reads the configuration file
	 * @return true upon success, false upon failure
	 */
	public boolean readFile() {
		
		String configLine = "";
		String appsLine = "";
		
		try {
			configFile = new File(CONFIG_FILE);
			in = new Scanner(configFile);
			
			if(in.hasNext()) {
				configLine = in.nextLine();
				Scanner ls = new Scanner(configLine); 
				ls.useDelimiter(CONFIG_DELIM);
				
				currLocal = ls.next();
				currOpenKey = ls.next();
				currCloseKey = ls.next();
				appsLine = ls.next();
				
				Scanner als = new Scanner(appsLine);
				als.useDelimiter(APPS_DELIM);
				
				while(als.hasNext()) {
					apps.add(als.next());
				}
				
				ls.close();
				als.close();
				
			}
			else {
				apps.add(NO_CONFIG);
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
		
		String appString = "";
		
		try {
			configWriter = new PrintWriter(CONFIG_FILE);
			
			//creates a string of apps that is readable by the system
			
			for(int i = 0; i < apps.size(); i++) {
				
				if(i != apps.size() - 1) {
					appString += apps.get(i) + APPS_DELIM;
				}
				else {
					appString += apps.get(i);
				}
				
			}
			
			configWriter.write(
					currLocal + CONFIG_DELIM + 
					currOpenKey + CONFIG_DELIM +
					currCloseKey + CONFIG_DELIM +
					appString);
			
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
		
	}//updateFile
	
	//methods for handling application configurations
	
	/**
	 * updates the application string
	 * @param application directory being added
	 * @param data to change
	 * @return true upon success, false upon failure
	 */
	public boolean updateApp(String app) {
		
		//if no app is configured, removes no configuraion message and adds an app in its place
		if(apps.get(0).equals(NO_CONFIG)){
			apps.set(0,app);
		}
		else if(apps.size() == APP_LIMIT){
			return false;
		}
		else {
			apps.add(app);
		}
		
		return true;
		
	}//updateFile
	
	/**
	 * removes an application from the list
	 * @param application to be removed
	 * @return true upon success, false upon failure
	 */
	public boolean removeApp(String app) {
		
		for(int i = 0; i < apps.size(); i++) {
			if(apps.get(i).equals(app)) {
				apps.remove(i);
				return true;
			}
		}
		
		return false;
		
	}//removeapp
	
	
	//methods for handling keybind configurations
	
	/**
	 * updates the current Open Key Bind
	 * @param Key Bind to configure
	 * @return true upon success, false upon failure
	 */
	public boolean updateOpenKey(String newKey) {
		
		currOpenKey = newKey;
		
		return true;
		
	}//updateOpenKey
	
	/**
	 * updates the current Close Key Bind
	 * @param Key Bind to configure
	 * @return 
	 */
	public boolean updateCloseKey(String newKey) {
		
		currCloseKey = newKey;
		
		return true;
		
	}//updateCloseKey
	
	/**
	 * clears the current Open Key Bind
	 */
	public void clearOpenKey() {
		
		currOpenKey = NO_CONFIG;
		
	}//clearOpenkey
	
	/**
	 * clears the current Close Key Bind
	 */
	public void clearCloseKey() {
		
		currCloseKey = NO_CONFIG;
		
		//maybe insert line to update file
		
	}//clearCloseKey
	
	//methods for handling localization configuration. No method to clear localization due to issues pertaining to having no localization set
	
	/**
	 * changes current localization configuration
	 * @param local to change to
	 * @return true upon success, false upon failure
	 */
	public void changeLocal(String newLocal) {
		
		currLocal = newLocal;
		
	}//changeLocal
	
}//class
