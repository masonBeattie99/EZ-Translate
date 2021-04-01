/**
 * Handles the interactions of the different components of the application
 * Performs the startup and closing tasks of the application
 * 
 * Maintains the contents of the configuration file for the application for configuration integrity
 * 
 * @author mason
 *
 */
package com.github.masonBeattie99.EZ_Translate;

import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;
import javax.swing.*;
import com.github.masonBeattie99.EZ_Translate.services.*;
import com.github.masonBeattie99.EZ_Translate.configuration.Configuration;

public class ApplicationManager {
	
	//interface object
	private EZTranslateMenu ezmenu;
	private ConfigurationInterface configinter;
	private TranslationInterface trslinter;
	private ApplicationConfigurationMenu acm;
	private KeybindConfigurationMenu kcm;
	private LocalizationConfigurationMenu lcm;
	
	//configuration object
	private Configuration config;
	
	//service object
	private DetectionService ds;
	private TranslationService ts;
	private LanguageDetectionService lds;
	
	//shutdown notification JFrame components
	private JFrame noti;
	
	/**
	 * default constructor for ApplicationManager. Initializes all objects used by the application initially for faster run time during appliaction
	 */
	public ApplicationManager() {
		
		//interface objects
		ezmenu = new EZTranslateMenu(this);
		configinter = new ConfigurationInterface(this);
		trslinter = new TranslationInterface(this);
		acm = new ApplicationConfigurationMenu(this);
		kcm = new KeybindConfigurationMenu(this);
		lcm = new LocalizationConfigurationMenu(this);
		
		//configuration object
		config = new Configuration();
		
		//service objects
		ds = new DetectionService(this);
		ts = new TranslationService(this);
		lds = new LanguageDetectionService(this);
		
		//notification frame
		noti = new JFrame();
		
		//file objects
		
		this.startup();
		
	}//default constructor

	
	//startup and shutdown methods
	
	
	/**
	 * performs the startup activities of the application
	 */
	public void startup() {
		
		if(config.readFile()) {
			JOptionPane.showMessageDialog(noti, "Config File Reading Successful, Starting Application");
		}
		else {
			JOptionPane.showMessageDialog(noti, "Error: FileNotFoundException.", "FileNotFoundException", JOptionPane.ERROR_MESSAGE);
			this.shutdown();
		}
		displayMainMenu();
		
	}//startup
	
	/**
	 * performs the shutdown activities of the application
	 */
	public void shutdown() {
		
		if(config.updateFile()) {
			JOptionPane.showMessageDialog(noti, "Application Has Successfully Shut Down!");
			ezmenu.dispatchEvent(new WindowEvent(ezmenu, WindowEvent.WINDOW_CLOSING));
		}
		else {
			JOptionPane.showMessageDialog(noti, "Error: FileNotFoundException.", "FileNotFoundException", JOptionPane.ERROR_MESSAGE);
		}
		
		
	}//shutdown
		
	
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
	
	//methods for interacting with configuration class and its components
	
	
	//further methods TBD
	
	
	//insert new methods here
	
}//class
