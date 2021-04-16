/**
 * handles configuration loading, additions, updates, and deletions.
 * maintains current configuration settings for use by the application manager.
 */
package com.github.masonBeattie99.EZ_Translate.configuration;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

public class Configuration {

	//static variables for configuration file
	private static String CONFIG_DELIM = ".";
	private static String APPS_DELIM = "#";
	private static String NO_CONFIG = "NOT_CONFIGURED";
	private static String CONFIG_FILE = "src/com/github/masonBeattie99/EZ_Translate/configuration/config.txt";
	private static int APP_LIMIT = 10;
	
	//file reading objects
	private File configFile;
	private FileInputStream inputStream;
	private InputStreamReader streamReader;
	private BufferedReader reader;
	private OutputStreamWriter configWriter;
	private Scanner in;
	
	//configuration variables and lists
	private ArrayList<String> apps;
	private String currOpenKey;
	private String currCloseKey;
	private String currLocal;

	/**
	 * constructor for Configuration. initializes internal variables
	 */
	public Configuration(){
		
		apps = new ArrayList<String>();
		currOpenKey = "";
		currCloseKey = "";
		currLocal = "";
		
		//loading in file object
		try {
			configFile = new File(CONFIG_FILE);
			configFile.createNewFile();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}//constructor
	
//THIS PART IS MESSED UP. NOT RETAINING LOCALIZATION UPON READING OF FILE
	
	/**
	 * reads the configuration file
	 * @return true upon success, false upon failure
	 */
	public boolean readFile() {
		
		String configLine = "";
		String appsLine = "";
		
		try {
			
			inputStream = new FileInputStream(configFile);
			
			streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
			
			reader = new BufferedReader(streamReader);
			
			configLine = reader.readLine();
			
			if(configLine == null) {
				currLocal = NO_CONFIG;
				currOpenKey = NO_CONFIG;
				currCloseKey = NO_CONFIG;
				apps.add(NO_CONFIG);
			}
			else {
			
				System.out.println(configLine);
				
				in = new Scanner(configLine);
				in.useDelimiter("\\" + CONFIG_DELIM);
				
				if(in.hasNext()) {
					currLocal = in.next();
				}
				else {
					//default local is set to eng if nothing exists for it
					currLocal = "eng";
				}
				
				if(in.hasNext()) {
					currOpenKey = in.next();
				}
				else {
					currOpenKey = NO_CONFIG;
				}
				
				if(in.hasNext()) {
					currCloseKey = in.next();
				}
				else {
					currCloseKey = NO_CONFIG;
				}
				
				if(in.hasNext()) {
					
					appsLine = in.next();
					Scanner appls = new Scanner(appsLine);
					appls.useDelimiter("\\"+APPS_DELIM);
					
					//read input file
					while(appls.hasNext()) {
						
						apps.add(appls.next());
						
					}
					
					appls.close();
					
				}
				else {
					
					apps.add(NO_CONFIG);
					
				}
			}
			
			/**
			if(reader.exists()) {
				in = new Scanner(configFile);
			}
			else {
				configFile.createNewFile();
				in = new Scanner(configFile);
			}
			
			if(in.hasNext()) {
				
				//setting up scanner and delimiters
				
				configLine = in.nextLine();
				Scanner ls = new Scanner(configLine); 
				ls.useDelimiter("\\"+CONFIG_DELIM);
				
				if(ls.hasNext()) {
					currLocal = ls.next();
				}
				else {
					currLocal = NO_CONFIG;
				}
				
				if(ls.hasNext()) {
					currOpenKey = ls.next();
				}
				else {
					currOpenKey = NO_CONFIG;
				}
				
				if(ls.hasNext()) {
					currCloseKey = ls.next();
				}
				else {
					currCloseKey = NO_CONFIG;
				}
				
				if(ls.hasNext()) {
					
					appsLine = ls.next();
					Scanner appls = new Scanner(appsLine);
					appls.useDelimiter("\\"+APPS_DELIM);
					
					//read input file
					while(appls.hasNext()) {
						
						apps.add(appls.next());
						
					}
					
					appls.close();
					
				}
				else {
					
					apps.add(NO_CONFIG);
					
				}
				
				in.close();
				ls.close();
				
				
			}
			else {
				
				apps.add(NO_CONFIG);
				currOpenKey = NO_CONFIG;
				currCloseKey = NO_CONFIG;
				currLocal = "eng";//default localization is English. If no configuration is available then automatically assign English
			}
			*/
			
			return true;
			
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
			return false;
		}
		catch(IOException i) {
			i.printStackTrace();
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
		String configString = "";
		
		
		
		try {
			//created a new file writer that reads in eligible UTF-8 data (for cyrillic characters)
			configWriter = new OutputStreamWriter(new FileOutputStream(configFile), StandardCharsets.UTF_8);
			
			//creates a string of apps that is formatted for storage within the configuration file. Does not add delimiter for last item
			for(int i = 0; i < apps.size(); i++) {
				
				if(i != apps.size() - 1) {
					appString += apps.get(i) + APPS_DELIM;
				}
				else {
					appString += apps.get(i);
				}
				
			}
			
			configString=(
					currLocal + CONFIG_DELIM + 
					currOpenKey + CONFIG_DELIM +
					currCloseKey + CONFIG_DELIM +
					appString);
			
			configWriter.write(configString);
			
			configWriter.flush();
			configWriter.close();
			
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
			return false;
		}
		catch(IOException i) {
			i.printStackTrace();
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
		
		if(this.updateFile()) {
			return true;
		}
		else {
			return false;
		}
		
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
		
		if(this.updateFile()) {
			return true;
		}
		else {
			return false;
		}
		
	}//removeapp
	
//methods for handling keybind configurations
	
	/**
	 * updates the current Open Key Bind
	 * @param Key Bind to configure
	 * @return true upon success, false upon failure
	 */
	public boolean updateOpenKey(String newKey) {
		
		if(verifyKeyB(newKey)) {
			
			//shaves off the last + if it is the last value if key bind is valid
			if(newKey.charAt(newKey.length() - 1) == '+') {
				
				newKey = newKey.substring(0, newKey.length() - 1);
			
			}
			
			currOpenKey = newKey;
			
			if(this.updateFile()) {
				return true;
			}
			else {
				return false;
			}
		
		}
		else {
			
			//returns false upon invalid keybind
			return false;
			
		}
		
	}//updateOpenKey
	
	/**
	 * updates the current Close Key Bind
	 * @param Key Bind to configure
	 * @return 
	 */
	public boolean updateCloseKey(String newKey) {
		
		if(verifyKeyB(newKey)) {
			
			//shaves off the last + if it is the last value if key bind is valid
			if(newKey.charAt(newKey.length() - 1) == '+') {
				
				newKey = newKey.substring(0, newKey.length() - 1);
			
			}
			
			currCloseKey = newKey;
			
			if(this.updateFile()) {
				return true;
			}
			else {
				return false;
			}
		
		}
		else {
			
			//returns false upon invalid keybind
			return false;
			
		}
		
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
		
		this.updateFile();
		
	}//changeLocal
	
//methods that allow for key binds to be verified
	
	/**
	 * verifies that the key bind is supported in this system.
	 * @param key bind to be verified
	 * @return true if valid, false if invalid
	 */
	public boolean verifyKeyB(String keyBind) {
		
		//checking value of the current open bind
		if(keyBind.length() != 0) {
			
			//add further validation code here
			
			
			return true;
		}
		else {
			
			return false;
		
		}
		
	}//verifyKeyB
	
//methods to return specific configurations, or all configurations
	
	/**
	 * returns the localization configuration
	 * @return current localConfig
	 */
	public String getLocal() {
		
		return currLocal;
		
	}//getLocal
	
	/**
	 * returns the open keybind
	 * @return current open keybind
	 */
	public String getOpenKey() {
		
		return currOpenKey;
		
	}//getOpenKey
	
	/**
	 * returns the close keybind
	 * @return current close keybind
	 */
	public String getCloseKey() {
		
		return currCloseKey;
		
	}//getCloseKey
	
	/**
	 * returns the applications in a user readable string that does not include delimiters
	 * @return apps formatted into a string
	 */
	public String getApps() {
		String appString = "";
		
		for(int i = 0; i < apps.size(); i++) {
			
			//does not add new line if last value
			if(i != apps.size() - 1) {
				appString += apps.get(i) + "/n";
			}
			else {
				appString += apps.get(i);
			}
		}
		
		return appString;
		
	}//getApps
	
	/**
	 * returns all configurations as a string through get methods provided and labeling corresponding configurations
	 * @return all current configurations
	 */
	public String getConfig() {
		
		String result = "";
		
		result = String.format("Localization: %s \nOpening Keybind: %s \nClosing Keybind: %s \nApplications: %s", this.getLocal(), this.getOpenKey(), this.getCloseKey(), this.getApps());
		
		return result;
		
	}//getConfig
	
}//class
