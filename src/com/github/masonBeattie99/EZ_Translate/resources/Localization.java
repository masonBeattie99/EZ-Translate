/**
 * structure for localizations within application
 */
package com.github.masonBeattie99.EZ_Translate.resources;

import java.util.Enumeration;
import java.util.ResourceBundle;

public class Localization extends ResourceBundle{

	@Override
	protected Object handleGetObject(String key) {
		
		if(key.equals("ConfigMenuLabel")) return "Configuration Menu";
		
		return null;
	}

	@Override
	public Enumeration<String> getKeys() {
		// TODO Auto-generated method stub
		return null;
	}
	
}//class
