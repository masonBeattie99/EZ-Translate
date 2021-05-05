/**
 * handles configuration loading, additions, updates, and deletions.
 * maintains current configuration settings for use by the application manager.
 * 
 * @author Mason Beattie
 * 
 * 
 * Copyright 2021 Mason Beattie
 *	
 *	Licensed under the Apache License, Version 2.0 (the "License");
 *	you may not use this file except in compliance with the License.
 *	You may obtain a copy of the License at
 *	
 *	    http://www.apache.org/licenses/LICENSE-2.0
 *	
 *	Unless required by applicable law or agreed to in writing, software
 *	distributed under the License is distributed on an "AS IS" BASIS,
 *	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *	See the License for the specific language governing permissions and
 *	limitations under the License.
 *
 */
package com.github.masonBeattie99.EZ_Translate.configuration;

import java.io.File;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
//import java.util.ArrayList;
import java.util.Scanner;

public class Configuration {

	//static variables for configuration file
	private static String CONFIG_DELIM = ".";
	//private static String APPS_DELIM = "#";
	private static String NO_CONFIG = "NOT_CONFIGURED";
	private static String CONFIG_FILE = "config.txt";
	//private static int APP_LIMIT = 10;
	
	//file reading objects
	private File configFile;
	private FileInputStream inputStream;
	private InputStreamReader streamReader;
	private BufferedReader reader;
	private OutputStreamWriter configWriter;
	private Scanner in;
	
	//configuration variables and lists
	//private ArrayList<String> apps;
	private String currOpenKey;
	private String currCloseKey;
	private int currLocal;

	/**
	 * constructor for Configuration. initializes internal variables
	 */
	public Configuration(){
		
		//apps = new ArrayList<String>();
		currOpenKey = "";
		currCloseKey = "";
		currLocal = 0;
		
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
		//String appsLine = "";
		
		try {
			
			inputStream = new FileInputStream(configFile);
			
			streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
			
			reader = new BufferedReader(streamReader);
			
			configLine = reader.readLine();
			
			if(configLine == null) {
				currLocal = 0;
				currOpenKey = NO_CONFIG;
				currCloseKey = NO_CONFIG;
				//apps.add(NO_CONFIG);
			}
			else {
				
				in = new Scanner(configLine);
				in.useDelimiter("\\" + CONFIG_DELIM);
				
				if(in.hasNextInt()) {
					//parses value in config file to integer
					currLocal = Integer.parseInt(in.next());
				}
				else {
					//default local is set to eng if nothing exists for it
					currLocal = 0;
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
				
				/**
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
				*/
			}
			
			return true;
			
		}
		catch(UnsupportedEncodingException u) {
			u.printStackTrace();
			return false;
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
		
		//String appString = "";
		String configString = "";
		
		
		
		try {
			//created a new file writer that reads in eligible UTF-8 data (for cyrillic characters)
			configWriter = new OutputStreamWriter(new FileOutputStream(configFile), StandardCharsets.UTF_8);
			
			BufferedWriter writer = new BufferedWriter(configWriter);
			
			//creates a string of apps that is formatted for storage within the configuration file. Does not add delimiter for last item
			/**
			for(int i = 0; i < apps.size(); i++) {
				
				if(i != apps.size() - 1) {
					appString += apps.get(i) + APPS_DELIM;
				}
				else {
					appString += apps.get(i);
				}
				
			}
			*/
			
			configString=(
					currLocal + CONFIG_DELIM + 
					currOpenKey + CONFIG_DELIM +
					currCloseKey + CONFIG_DELIM);
			
			writer.write(configString);
			
			writer.flush();
			writer.close();
			configWriter.close();
			
		}
		catch(UnsupportedEncodingException u) {
			return false;
		}
		catch(FileNotFoundException e) {
			return false;
		}
		catch(IOException i) {
			return false;
		}
		
		return true;
		
	}//updateFile
	
//methods for handling application configurations FUNCTION REMOVED FROM REQUIREMENTS
	
	/**
	 * updates the application string
	 * FUNCTION REMOVED FROM REQUIREMENTS
	 * @param application directory being added
	 * @param data to change
	 * @return true upon success, false upon failure
	 */
	/**
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
	*/
	
	/**
	 * removes an application from the list
	 * FUNCTION REMOVED FROM REQUIREMENTS
	 * @param application to be removed
	 * @return true upon success, false upon failure
	 */
	/**
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
	*/
	
//methods for handling keybind configurations
	
	/**
	 * updates the current Open Key Bind
	 * @param Key Bind to configure
	 * @return true upon success, false upon failure
	 */
	public boolean updateOpenKey(String newKey) {
		
		byte[] byteString;
		String encodedString;
		
		if(verifyKeyB(newKey)) {
			
			//shaves off the last space if it is the last value if key bind is valid
			if(newKey.charAt(newKey.length() - 1) == ' ') {
				
				newKey = newKey.substring(0, newKey.length() - 1);
			
			}
			
			byteString = newKey.getBytes(StandardCharsets.UTF_8);
			encodedString = new String(byteString, StandardCharsets.UTF_8);
			currOpenKey = encodedString;
			
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
		
		byte[] byteString;
		String encodedString;
		
		if(verifyKeyB(newKey)) {
			
			//shaves off the last space at the end if it is the last value if key bind is valid
			if(newKey.charAt(newKey.length() - 1) == ' ') {
				
				newKey = newKey.substring(0, newKey.length() - 1);
			
			}
			
			byteString = newKey.getBytes(StandardCharsets.UTF_8);
			encodedString = new String(byteString, StandardCharsets.UTF_8);
			currCloseKey = encodedString;
		
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
	public void changeLocal(int newLocal) {
		
		//methods to encode string
		//byte[] byteString = newLocal.getBytes();
		//String encodedString = new String(byteString, StandardCharsets.UTF_8);
		
		currLocal = newLocal;
		
		this.updateFile();
		
	}//changeLocal
	
//methods that allow for key binds to be verified
	
	/**
	 * verifies that the key bind is not already used by this system.
	 * @param key bind to be verified
	 * @return true if valid, false if invalid
	 */
	public boolean verifyKeyB(String keyBind) {
		
		//checking value of the current open bind
		if(keyBind.length() != 0) {
			
			if(keyBind.contains("Windows")) {
				return false;
			}
			else if(keyBind.contains("End")) {
				return false;
			}
			else if(keyBind.contains("Home")) {
				return false;
			}
			else if(keyBind.contains("Backspace")) {
				return false;
			}
			else if(keyBind.contains("Space")) {
				return false;
			}
			else if(keyBind.contains("Insert")) {
				return false;
			}
			else if(keyBind.contains("Escape")) {
				return false;
			}
			else if(keyBind.contains("Tab")) {
				return false;
			}
			else {
				//do nothing and move on to specific combinations
			}
			
			//add further validation code here
			
			switch(keyBind) {
			
			case "Ctrl X ":
				return false;
			case "Ctrl C ":
				return false;
			case "Ctrl V ":
				return false;
			case "Ctrl Z ":
				return false;
			case "Ctrl F ":
				return false;
			case "Ctrl N ":
				return false;
			case "Ctrl Y":
				return false;
			case "Alt D ":
				return false;
			case "Ctrl W":
				return false;
			case "Alt Tab ":
				return false;
			case "Alt F4 ":
				return false;
			case "F1 ":
				return false;
			case "F2 ":
				return false;
			case "F3 ":
				return false;
			case "F4 ":
				return false;
			case "F5 ":
				return false;
			case "F6 ":
				return false;
			case "F7 ":
				return false;
			case "F8 ":
				return false;
			case "F9 ":
				return false;
			case "F10 ":
				return false;
			case "F11 ":
				return false;
			case "F12 ":
				return false;
			case "Ctrl Alt Delete ":
				return false;
			case "Ctrl Alt Tab":
				return false;
			}
			
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
	public int getLocal() {
		
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
	 * NOT UTILIZED BY APPLICATION
	 * @return apps formatted into a string
	 */
	/*
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
	*/
	
	/**
	 * returns all configurations as a string through get methods provided and labeling corresponding configurations
	 * @return all current configurations
	 */
	public String getConfig() {
		
		String result = "";
		String localConver = "";
		
		if(this.getLocal() == 0) {
			localConver = "eng";
		}
		else if(this.getLocal() == 1) {
			localConver = "deu";
		}
		else if(this.getLocal() == 2) {
			localConver = "рус";
			
		}
		
	
		byte[] byteString = localConver.getBytes(StandardCharsets.UTF_8);
		String encodedString = new String(byteString, StandardCharsets.UTF_8);
		localConver = encodedString;
		
		//result = String.format("Localization: %s \nOpening Keybind: %s \nClosing Keybind: %s \nApplications: %s", localConver, this.getOpenKey(), this.getCloseKey(), this.getApps());
		result = String.format("Localization: %s Open Key: %s Close Key: %s", localConver, this.getOpenKey(), this.getCloseKey());
		
		return result;
		
	}//getConfig
	
}//class
