/**
 * service for monitoring other application activity in terms of execution, closing, and key presses. 
 * @author mason
 *
 */
package com.github.masonBeattie99.EZ_Translate.services;
import com.github.masonBeattie99.EZ_Translate.ApplicationManager;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.nio.charset.StandardCharsets;

import javax.swing.KeyStroke;
public class DetectionService {

	//private variables
	ApplicationManager am;
	
	
	public DetectionService(ApplicationManager am) {
		
		this.am = am;
		
		//processes the configuration to interpret key binds
		
	}//constructor
	
	/**
	 * begins detection service
	 */
	public void startup() {
		
		String openKeyString = "alt shift D";
		String closeKeyString = "alt shift D";
		
		//byte[] byteString;
		//String encodedString;
		
		openKeyString = am.accessConfig().getOpenKey();
		closeKeyString = am.accessConfig().getCloseKey();
		
		
		
		//KeyStroke.getKeyStrokeForEvent();
		
		//byteString = openKeyString.getBytes();
		//encodedString = new String(byteString, StandardCharsets.UTF_8);
		
		
		
		System.out.println(openKeyString);
		System.out.println(closeKeyString);
		
		System.out.println("Encoded String " + KeyStroke.getKeyStroke(openKeyString));
		System.out.println("Not Encoded " + KeyStroke.getKeyStroke(closeKeyString));
		
		
	}//startup
	
	/**
	 * stops detection service
	 */
	public void shutdown() {
		
	}//shutdown
	
}
