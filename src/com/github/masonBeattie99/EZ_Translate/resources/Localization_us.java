/**
 * Resource bundle for the English language from the Country of the United States of America that is utilized by the application.
 * Utilizes Alpha-2 of the ISO-3166 for country codes and ISO-639-2 for the language codes
 */
package com.github.masonBeattie99.EZ_Translate.resources;

import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

public class Localization_us extends Localization{

	@Override
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
	
	@Override
	protected Set<String> handleKeySet() {
		return new HashSet<String>(Arrays.asList(
				"startupNoti",		
				"errFileNotFoundMsg",
				"fileNotFoundMsg",
				"shutdownNoti",
				"addAppMsg",
				"deleAppMsg",
				"closeMsg",
				"appliMsg",
				"appConfigMenuLabel",
				"configAppBtn",
				"configKeyBndBtn",
				"configLocalBtn",
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

	
}//class