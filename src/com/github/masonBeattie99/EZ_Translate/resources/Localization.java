/**
 * structure for localizations within application
 */
package com.github.masonBeattie99.EZ_Translate.resources;

import java.util.Collections;
import java.util.Enumeration;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

public class Localization extends ResourceBundle{

	/**
	* overrides ResourceBundle method for handling get objects
	* utilizes same methods for Localization_us for a base localization
	* Handles handleGetObject identically to Localization_us
	*/
	protected Object handleGetObject(String key) {
		
		if(key.equals("startupNoti")) return "Configuration File Reading Successful, Starting Application";
		if(key.equals("errFileNotFoundMsg")) return "Error: FileNotFoundException.";
		if(key.equals("fileNotFoundMsg")) return "FileNotFoundException";
		if(key.equals("shutdownNoti")) return "Application Has Successfully Shut Down!";
		if(key.equals("addAppMsg")) return "Add Application";
		if(key.equals("deleAppMsg")) return "Delete Application";
		if(key.equals("closeBtn")) return "Close";
		if(key.equals("appLabel")) return "Applications";
		if(key.equals("appConfigMenuLabel")) return "Application Configuration Menu";
		if(key.equals("configAppBtn")) return "Configure Applications";
		if(key.equals("configKeyBndBtn")) return "Configure Key Binds";
		if(key.equals("configLocalBtn")) return "Configure Localization";
		if(key.equals("configsLabel")) return "Current Configurations";
		if(key.equals("configMenuLabel")) return "Configuration Menu";
		if(key.equals("configBtn")) return "Configuration Settings";
		if(key.equals("startBtn")) return "Start";
		if(key.equals("mainMenuLabel")) return "EZTranslate Menu";
		if(key.equals("upOpenKeyBtn")) return "Update Open Key Bind";
		if(key.equals("upCloseKeyBtn")) return "Update Close Key Bind";
		if(key.equals("keyConfigMenuLabel")) return "Keybind Configuration Menu";
		if(key.equals("upLocalBtn")) return "Update Localization";
		if(key.equals("localChoicesEng")) return "eng";
		if(key.equals("localChoicesGer")) return "ger";
		if(key.equals("localChoicesRus")) return "rus";
		if(key.equals("localConfigMenuLabel")) return "Localization Configuration Menu";
		
		return null;
	}

	/**
	* overrides ResourceBundle method for handling key sets
	* utilizes same methods for Localization_us for a base localization
	* Handles handleKeySet identically to Localization_us
	*/
	protected Set<String> handleKeySet(){
		return new HashSet<String>(Arrays.asList(
				"startupNoti",		
				"errFileNotFoundMsg",
				"fileNotFoundMsg",
				"shutdownNoti",
				"addAppMsg",
				"deleAppMsg",
				"closeBtn",
				"appLabel",
				"appConfigMenuLabel",
				"configAppBtn",
				"configKeyBndBtn",
				"configLocalBtn",
				"configsLabel",
				"configMenuLabel",
				"configBtn",
				"startBtn",
				"mainMenuLabel",
				"upOpenKeyBtn",
				"upCloseKeyBtn",
				"keyConfigMenuLabel",
				"upLocalBtn",
				"localChoicesEng",
				"localChoicesGer",
				"localChoicesRus",
				"localConfigMenuLabel"
				));
	}
	
	@Override
	public Enumeration<String> getKeys() {
		return Collections.enumeration(keySet());
	}
	
}//class
