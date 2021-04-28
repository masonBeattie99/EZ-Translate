/**
 * service for monitoring other application activity in terms of execution, closing, and key presses. Monitors keypressed through JNativeHook local library
 * @author mason
 *
 */
package com.github.masonBeattie99.EZ_Translate.services;
import com.github.masonBeattie99.EZ_Translate.ApplicationManager;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

public class DetectionService{

	//private variables
	private ApplicationManager am;
	
	private GlobalKeyListener gkl;
	
	private String openKeyString;
	private String closeKeyString;
	private String inputString;
	
	private boolean same;
	private boolean open;
	
	/**
	 * accepts application manager and component to attach input detection to
	 * @param am
	 */
	public DetectionService(ApplicationManager am) {
		
		this.am = am;
		
		open = false;
		
		openKeyString = "";
		closeKeyString = "";
		inputString = "";
		
	}//constructor
	
	/**
	 * begins detection service. starts when the start method in the main menu is called
	 */
	public void start() {
		
		//removes all white spaces
		openKeyString = (am.accessConfig().getOpenKey()).replaceAll(" ","");
		closeKeyString = (am.accessConfig().getCloseKey()).replaceAll(" ","");
		
		if(openKeyString.equals(closeKeyString)) {
			same = true;
		}
		else {
			same = false;
		}
		
		//code to disable console output
		Logger log = Logger.getLogger(GlobalScreen.class.getPackage().getName());
		log.setLevel(Level.OFF);
		log.setUseParentHandlers(false);
		
		//starting the detection services
		try {
			GlobalScreen.registerNativeHook();
		}
		catch (NativeHookException e) {
			
			System.out.println("Issue registering native hooks");
			am.stopDetect();
			
		}		
		
		gkl = new GlobalKeyListener();
		GlobalScreen.addNativeKeyListener(gkl);
		
		
	}//start
	
	/**
	 * stops detection service
	 */
	public void close() {
		
		try {
			GlobalScreen.removeNativeKeyListener(gkl);
			GlobalScreen.unregisterNativeHook();
		}
		catch(NativeHookException e){
			System.out.println("Issue unregistering native hooks");
			e.printStackTrace();			
		}
		
	}//close
	
	//actionMethods
	
	/**
	 * opening action
	 * @return action to be performed
	 */
	public void openAction() {
		
		am.displayTransMenu();
				
		
	}//openAction
	
	/**
	 * closing action
	 * @return action to be performed
	 */
	public void closeAction() {
		
		am.hideTransMenu();
				
		
	}//closeAction
	
	/**
	 * handles the input received by the GlobalKeyListener subclass
	 */
	public void handleInput(String input) {
		
		inputString += input;
		
		//if the input is not contained within the strings, clear the input stream
		if(!openKeyString.contains(input) && !closeKeyString.contains(input)) {
			
			//clears input string if not values are present in keybind list
			inputString = "";
			
		}
		else {
			
			if(same) {
				
				if(inputString.contains(openKeyString) && !open) {
					closeAction();
					
					//declares the menu opened
					open = true;
					
					//clears input string
					inputString = "";
				}
				else if(inputString.contains(closeKeyString) && open){
					openAction();
					
					//declares the menu closed
					open = false;
					
					//clears input string
					inputString = "";
				}
				else {
					
					//do nothing
					
				}
				
			}
			else {
				if(inputString.contains(openKeyString)){
					openAction();
					
					//clears input string
					inputString = "";
				}
				if(inputString.contains(closeKeyString)) {
					closeAction();
					
					//clears input string
					inputString = "";
				}
			}
			
		}
		
	}//handleInput
		
	/**
	 * key listener subclass that implements JNativeHook NativeKeyListener interface
	 * @author mason
	 *
	 */
	public class GlobalKeyListener implements NativeKeyListener{
		
		/**
		 * constructor
		 */
		public GlobalKeyListener(){
			
		}
		
		@Override
		public void nativeKeyPressed(NativeKeyEvent e) {
			
			handleInput(NativeKeyEvent.getKeyText(e.getKeyCode()));
			
		}

		@Override
		public void nativeKeyReleased(NativeKeyEvent e) {
			
		}

		@Override
		public void nativeKeyTyped(NativeKeyEvent e) {
			
		}
		
	}
	
}
