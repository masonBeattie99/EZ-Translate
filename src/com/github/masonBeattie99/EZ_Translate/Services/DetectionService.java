/**
 * service for monitoring other application activity in terms of execution, closing, and key presses. Monitors keypressed through JNativeHook local library
 * @author mason
 *
 */
package com.github.masonBeattie99.EZ_Translate.services;
import com.github.masonBeattie99.EZ_Translate.ApplicationManager;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Scanner;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
@SuppressWarnings("serial")
public class DetectionService{

	//private variables
	ApplicationManager am;
	
	private String openKeyString;
	private String closeKeyString;
	
	private String inputString;
	
	private Scanner ls;
	
	//JNativeHook registers ctrl input unnecessarily, this value is used to work around it.
	private int ctrlBuff;
	
	/**
	 * accepts application manager and component to attach input detection to
	 * @param am
	 */
	public DetectionService(ApplicationManager am) {
		
		this.am = am;
		
		openKeyString = "";
		closeKeyString = "";
		inputString = "";
		
		ctrlBuff = 0;
		
		ls = new Scanner(inputString);
		
	}//constructor
	
	/**
	 * begins detection service. starts when the start method in the main menu is called
	 */
	public void start() {
		
		openKeyString = am.accessConfig().getOpenKey();
		closeKeyString = am.accessConfig().getCloseKey();
		
		System.out.println(openKeyString);
		System.out.println(closeKeyString);
		
		//code to disable console output
		Logger log = Logger.getLogger(GlobalScreen.class.getPackage().getName());
		log.setLevel(Level.OFF);
		log.setUseParentHandlers(false);
		
		try {
			GlobalScreen.registerNativeHook();
		}
		catch (NativeHookException e) {
			
			System.out.println("Issue registering native hooks");
			am.stopDetect();
			
		}		
		
		GlobalScreen.addNativeKeyListener(new GlobalKeyListener());
		
		
	}//start
	
	/**
	 * stops detection service
	 */
	public void close() {
		
		try {
			GlobalScreen.unregisterNativeHook();
		}
		catch(NativeHookException e){
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
		
		inputString += input + " ";
		
		//method to trim excessive Ctrl values
		
		System.out.println("Current Input String: " + inputString);
		
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
			
			//System.out.println("Key Pressed: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
			
		}

		@Override
		public void nativeKeyReleased(NativeKeyEvent e) {
			
			System.out.println("Key Released: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
			
			handleInput(NativeKeyEvent.getKeyText(e.getKeyCode()));
			
		}

		@Override
		public void nativeKeyTyped(NativeKeyEvent e) {
			
			//System.out.println("Key Typed: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
			
			
		}
		
	}
	
}
