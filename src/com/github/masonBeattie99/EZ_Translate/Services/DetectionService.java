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
	
	GlobalKeyListener gkl;
	
	private String openKeyString;
	private String closeKeyString;
	private String inputString;
	private int currIndex;
	private int iteration;
	
	private ArrayList<String> openKeyList;
	private ArrayList<String> closeKeyList;
	
	private Scanner openLs;
	private Scanner closeLs;
	
	//JNativeHook registers ctrl input unnecessarily, this value is used to work around it.
	private int ctrlBuff;
	
	/**
	 * accepts application manager and component to attach input detection to
	 * @param am
	 */
	public DetectionService(ApplicationManager am) {
		
		this.am = am;
		
		iteration = 0;
		currIndex = 0;
		
		openKeyString = "";
		closeKeyString = "";
		inputString = "";
		
		ctrlBuff = 0;
		
		openKeyList = new ArrayList<String>();
		closeKeyList = new ArrayList<String>();
		
	}//constructor
	
	/**
	 * begins detection service. starts when the start method in the main menu is called
	 */
	public void start() {
		
		openKeyString = am.accessConfig().getOpenKey() + " ";
		closeKeyString = am.accessConfig().getCloseKey() + " ";
		
		System.out.println(openKeyString);
		System.out.println(closeKeyString);
		
		processKeys();
		
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
	 * method for processing keybinds to receive the maximum length needed to be processed
	 */
	public void processKeys() {
		
		int openMax = 0;
		int closeMax = 0;
		
		openLs = new Scanner(openKeyString);
		closeLs = new Scanner(closeKeyString);
		
		while(openLs.hasNext()) {
			openKeyList.add(openLs.next());
		}
		
		while(closeLs.hasNext()) {
			closeKeyList.add(closeLs.next());
		}
		
	}
	
	/**
	 * handles the input received by the GlobalKeyListener subclass
	 */
	public void handleInput(String input) {
		
		inputString += input + " ";
		
		//if the input is not contained within the strings, clear the input stream
		if(!openKeyString.contains(input) && !closeKeyString.contains(input)) {
			
			//clears input string if not values are present in keybind list
			inputString = "";
			
		}
		else {
			
			
			if(inputString.contains(openKeyString)){
				openAction();
				inputString = "";
				currIndex = 0;
			}
			if(inputString.contains(closeKeyString)) {
				closeAction();
				currIndex = 0;
				inputString = "";
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
