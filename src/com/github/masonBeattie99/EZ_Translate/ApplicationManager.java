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
//import java.util.Scanner;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ApplicationManager {
	
	private static String CONFIG_FILE = "configuration\\config.txt";
	
	//interface classes
	private EZTranslateMenu ezmenu;
	private ConfigurationInterface configinter;
	private TranslationInterface trslinter;
	private ApplicationConfigurationMenu acm;
	private KeybindConfigurationMenu kcm;
	private LocalizationConfigurationMenu lcm;
	
	//service classes
	private DetectionService ds;
	private TranslationService ts;
	private LanguageDetectionService lds;
	
	//file reading objects
	private FileInputStream configFile;
	private PrintWriter configWriter;
	//private Scanner in;
	
	//shudown notification jframe components
	private JFrame noti;
	
	//configuration variables and lists
	private ArrayList<String> apps;
	private String currOpenKey;
	private String currCloseKey;
	private String currLocal;
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
		
		try {
		configFile = new FileInputStream(CONFIG_FILE);
		}
		catch(FileNotFoundException e) {
			JOptionPane.showMessageDialog(noti, "Config File Not Found. Exiting Program", "File Error", JOptionPane.ERROR_MESSAGE);
			this.shutdown();
		}
		JOptionPane.showMessageDialog(noti, "Config File Reading Successful, Starting Application");
		
		displayMainMenu();
		
	}//startup
	
	/**
	 * performs the shutdown activities of the application
	 */
	public void shutdown() {
		
		try {
			configFile.close();
		}
		catch(FileNotFoundException e) {
			
		}
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
	
	//file methods
	
	/**
	 * loads the configuration file and its contents
	 */
	
	//further methods TBD
	
	
	//insert new methods here
	
}//class
