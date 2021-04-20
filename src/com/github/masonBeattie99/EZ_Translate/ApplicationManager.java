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
import com.github.masonBeattie99.EZ_Translate.resources.*;
import java.util.ResourceBundle;
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
	
	//localization resource object
	private ResourceBundle localResource;
	
	//shutdown notification JFrame components
	private JFrame noti;
	
	//variable to determine if file reading was successful
	private boolean success;
	
	/**
	 * default constructor for ApplicationManager. Initializes all objects used by the application initially for faster run time during appliaction
	 */
	public ApplicationManager() {

		//create non dependent services
		//ts = new TranslationService();
		//lds = new LanguageDetectionService();
		
		//configuration object
		config = new Configuration();
		
		success = config.readFile();
		
		localResource = ResourceBundle.getBundle("com.github.masonBeattie99.EZ_Translate.resources.Localization");		
		
		//localization resource. Changes based on current local. 0 represents english, 1 represents german, 2 represents russian
		if(config.getLocal() == 0)	{
			localResource = ResourceBundle.getBundle("com.github.masonBeattie99.EZ_Translate.resources.Localization_us");
		}
		else if(config.getLocal() == 1) {
			localResource = ResourceBundle.getBundle("com.github.masonBeattie99.EZ_Translate.resources.Localization_de");
		}
		else if(config.getLocal() == 2) {
			localResource = ResourceBundle.getBundle("com.github.masonBeattie99.EZ_Translate.resources.Localization_ru");
		}
		else {
			localResource = ResourceBundle.getBundle("com.github.masonBeattie99.EZ_Translate.resources.Localization");
		}
		
		//interface objects
		ezmenu = new EZTranslateMenu(this);
		configinter = new ConfigurationInterface(this);
		trslinter = new TranslationInterface(this);
		acm = new ApplicationConfigurationMenu(this);
		kcm = new KeybindConfigurationMenu(this);
		lcm = new LocalizationConfigurationMenu(this);
		
		//service objects
		ds = new DetectionService(this);
		
		//notification frame
		noti = new JFrame();
		
		//file objects
		this.startup();
		
	}//default constructor

	
	//startup and shutdown methods
	
	/**
	 * performs the startup activities of the application, remove this method depending on decision for startup functions
	 */
	public void startup() {
		
		if(success) {
			JOptionPane.showMessageDialog(noti, localResource.getString("startupNoti"));
			displayMainMenu();
		}
		else {
			JOptionPane.showMessageDialog(noti, localResource.getString("errFileNotFoundMsg"), localResource.getString("fileNotFoundMsg"), JOptionPane.ERROR_MESSAGE);
			this.shutdown();
		}
		
	}//startup
	
	/**
	 * performs the shutdown activities of the application
	 */
	public void shutdown() {
		
		if(config.updateFile()) {
			JOptionPane.showMessageDialog(noti, localResource.getString("shutdownNoti"));
			ezmenu.dispatchEvent(new WindowEvent(ezmenu, WindowEvent.WINDOW_CLOSING));
		}
		else {
			JOptionPane.showMessageDialog(noti, localResource.getString("errFileNotFoundMsg"), localResource.getString("fileNotFoundMsg"), JOptionPane.ERROR_MESSAGE);
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
	
	//methods for interaction with configuration and localization objects
	
	/**
	 * returns the configuration object for use by components
	 * @return the configuration object
	 */
	public Configuration accessConfig() {
		return config;
	}//accessConfig
	
	/**
	 * returns the localization resource object for use by components
	 * @return the localization object
	 */
	public ResourceBundle accessLocal() {
		return localResource;
	}//accessLocal
	
	//since the localization functionality is maintained by the application manager. Changes to the current local will be updated here
	//the configuration handles storing and loading
	/**
	 * changes the current resource bundle utilized by the application
	 * @param the value of the index of the desired local. 0 for english, 1 for german, 2 for russian
	 */
	public void changeLocal(int newLocal){
		
		config.changeLocal(newLocal);
		
		if(newLocal == 0) {
			localResource = ResourceBundle.getBundle("com.github.masonBeattie99.EZ_Translate.resources.Localization_us");
		}
		else if(newLocal == 1) {
			localResource = ResourceBundle.getBundle("com.github.masonBeattie99.EZ_Translate.resources.Localization_de");
		}
		else if(newLocal == 2) {
			localResource = ResourceBundle.getBundle("com.github.masonBeattie99.EZ_Translate.resources.Localization_ru");
		}
		else {
			localResource = ResourceBundle.getBundle("com.github.masonBeattie99.EZ_Translate.resources.Localization");
		}
		
		ezmenu.updateText();
		configinter.updateText();
		trslinter.updateText();
		acm.updateText();
		kcm.updateText();
		lcm.updateText();
		
	}//changeLocal
	
	/**
	 * changes the current key bind configuration
	 * @param the open key bind
	 * @param the closing key bind
	 */
	public void changeKeys(String newOpenKey, String newCloseKey) {
		
		boolean changeOpenKeyFail = false;
		boolean changeCloseKeyFail = false;
		
		if(!newOpenKey.isEmpty()) {
			
			if(!config.updateOpenKey(newOpenKey)) {
				changeOpenKeyFail = true;
			}
			
		}
		if(!newCloseKey.isEmpty()) {
			
			if(!config.updateCloseKey(newCloseKey)) {
				changeCloseKeyFail = true;
			}
		
		}
		
		//checks if there was an error, if there was display appropriate menu, if not update menus text
		if(changeOpenKeyFail && changeCloseKeyFail) {
			JOptionPane.showMessageDialog(noti,"TEMP ERROR INVALID OPEN AND CLOSE KEY", "TEMP ERROR INVALID OPEN AND CLOSE KEY", JOptionPane.ERROR_MESSAGE);
		}
		else if(changeOpenKeyFail) {
			JOptionPane.showMessageDialog(noti,"TEMP ERROR INVALID OPEN KEY", "TEMP ERROR INVALID OPEN KEY", JOptionPane.ERROR_MESSAGE);
		}
		else if(changeCloseKeyFail) {
			JOptionPane.showMessageDialog(noti,"TEMP ERROR INVALID CLOSE KEY", "TEMP ERROR INVALID CLOSE KEY", JOptionPane.ERROR_MESSAGE);
		}
		else {
			ezmenu.updateText();
			configinter.updateText();
			trslinter.updateText();
			acm.updateText();
			kcm.updateText();
			lcm.updateText();
		}
		
	}//changeKeys
	
	
	//detection methodology
	
	
	/**
	 * starts detection service to being reading key input. If no keybinds are configured display error message
	 * @return true if able to start, false if not.
	 */
	public boolean startDetect() {
		
		//checking if keybinds are actually configured before starting
		if((config.getOpenKey().equals("NOT_CONFIGURED") && config.getCloseKey().equals("NOT_CONFIGURED")) || (config.getCloseKey().isBlank() && config.getOpenKey().isBlank())) {
			
			JOptionPane.showMessageDialog(noti,"TEMP ERROR NO KEYBIND CONFIG", "TEMP ERROR NO KEYBIND CONFIG", JOptionPane.ERROR_MESSAGE);
			
			return false;
			
		}
		else {
			
			ds.startup();
			return true;
		
		}
		
	}//startDetect
	
	/**
	 * stops the detection service
	 */
	public void stopDetect() {
		
		ds.shutdown();
		
	}//stopDetect
	
	
	//language services methodology
	
	/**
	 * Interprets information from translation interface to be used by language translation service. The goal is to format the information here since language
	 * translation service is temporary, and not intended to be a complex system. Formatting here allows for flexibility
	 * in the future. Additionally uses language detection services to 
	 * @param index of language translating to
	 * @param the phrase itself
	 * @return the translated phrase
	 */
	public String translate(int index, String phrase) {
		
		String result = "";
		String langTo = "";
		String currLang = "";
		
		if(index == 0) {
			langTo  = "eng";
		}
		else if(index == 1) {
			langTo = "ger";
		}
		else if(index == 2) {
			langTo = "rus";
		}
		else {
			//insert appropriate error message box
			System.out.println("ERROR INVALD INDEX");
			return new String("INVALID INDEX ERROR");
		}
		
		currLang = LanguageDetectionService.detectLang(phrase);
		
		if(currLang.equals("NOT_SUPPORTED")) {
			//insert appropriate error message box
			System.out.println("ERROR INVALD LANGUAGE SUPPORT");
			return new String("INVALID LANGUAGE SUPPORT ERROR");
		}
		
		result = TranslationService.translate(currLang, langTo, phrase);
		
		return result;
		
	}//translate
	
	/**
	 * Utilizes Lingua open source software to detect a language
	 * @param the input language to detect
	 * @return the result
	 */
	public String detect(String input) {
		
		String result = "";
		
		result = LanguageDetectionService.detectLang(input);
		
		return result;
		
	}//detect
	
}//class
