/**
 * structure for localizations within application
 */
package com.github.masonBeattie99.EZ_Translate.resources;
import java.util.ListResourceBundle;

public class Localization extends ListResourceBundle{

	private static Object[][] resources;
	
	public Localization(){
		
	}//constructor
	
	/**
	 * overriding getContents method of ListResourceBundle
	 */
	@Override
	protected Object[][] getContents() {
		return resources;
	}//getContents
	
}//class
