/**
 * Handles the interactions of the different components of the application
 * Performs the startup and closing tasks of the application
 * 
 * @author mason
 *
 */
package com.github.masonBeattie99.EZ_Translate;

import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;
import javax.swing.*;

public class ApplicationManager {
	
	//interface classes
	EZTranslateMenu ezmenu;
	ConfigurationInterface configinter;
	TranslationInterface trslinter;
	ApplicationConfigurationMenu acm;
	KeybindConfigurationMenu kcm;
	LocalizationConfigurationMenu lcm;
	
	//service classes
	DetectionService ds;
	TranslationService ts;
	LanguageDetectionService lds;
	
	//shudown notification components
	JFrame noti;
	
	/**
	 * default constructor for ApplicationManager. Initializes all objects for faster run time during appliaction
	 */
	public ApplicationManager() {
		
		ezmenu = new EZTranslateMenu(this);
		configinter = new ConfigurationInterface(this);
		trslinter = new TranslationInterface(this);
		acm = new ApplicationConfigurationMenu(this);
		kcm = new KeybindConfigurationMenu(this);
		lcm = new LocalizationConfigurationMenu(this);
		ds = new DetectionService(this);
		ts = new TranslationService(this);
		lds = new LanguageDetectionService(this);
		
		noti = new JFrame();
		
	}//default constructor

	
	//startup and shutdown methods
	
	
	/**
	 * performs the startup activities of the application
	 */
	public void startup() {
		
		JOptionPane.showMessageDialog(noti, "Starting Application");
		
		displayMainMenu();
		
	}//startup
	
	/**
	 * performs the shutdown activities of the application
	 */
	public void shutdown() {
		
		JOptionPane.showMessageDialog(noti, "Application Has Successfully Shut Down!");
		ezmenu.dispatchEvent(new WindowEvent(ezmenu, WindowEvent.WINDOW_CLOSING));
		
	}//shutdown
	
	//menu display methods
	
	
	//displaying menus
	
	
	/**
	 * invokes the ezmenu object to display the main menu of the application
	 */
	public void displayMainMenu() {
		
		ezmenu.displayMenu();
		
	}//displayMainMenu
	
	/**
	 * invokes the configinter object to display the main menu of the application
	 */
	public void displayConfigMenu() {
		
		configinter.displayMenu();
		
	}//displayConfigMenu
	
	/**
	 * invokes the trslinter object to display the main menu of the application
	 */
	public void displayTransMenu() {
		
		trslinter.displayMenu();
		
	}//displayTransMenu
	
	/**
	 * invokes acm object to display the application configuration menu
	 */
	public void displayACM() {
		acm.displayMenu();
	}//displayACM
	
	/**
	 * invokes lcm object to display the localization configuration menu
	 */
	public void displayLCM() {
		lcm.displayMenu();
	}//displayLCM
	
	/**
	 * invokes kcm object to display the keybind configuration menu
	 */
	public void displayKCM() {
		kcm.displayMenu();
	}//displayKCM
	
	
	//hiding menus
	
	
	/**
	 * invokes the ezmenu object to display the main menu of the application
	 */
	public void hideMainMenu() {
		
		ezmenu.hideMenu();
		
	}//hideMainMenu
	
	/**
	 * invokes the configinter object to display the main menu of the application
	 */
	public void hideConfigMenu() {
		
		configinter.hideMenu();
		
	}//hideConfigMenu
	
	/**
	 * invokes the trslinter object to display the main menu of the application
	 */
	public void hideTransMenu() {
		
		trslinter.hideMenu();
		
	}//hideTransMenu
	
	/**
	 * invokes acm object to display the application configuration menu
	 */
	public void hideACM() {
		acm.hideMenu();
	}//hideACM
	
	/**
	 * invokes lcm object to display the localization configuration menu
	 */
	public void hideLCM() {
		lcm.hideMenu();
	}//hideLCM
	
	/**
	 * invokes kcm object to display the keybind configuration menu
	 */
	public void hideKCM() {
		kcm.hideMenu();
	}//hideKCM
	
	
	//further methods TBD
	
	
	//insert new methods here
	
}//class
