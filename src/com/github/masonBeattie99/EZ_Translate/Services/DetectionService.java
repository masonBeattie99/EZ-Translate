/**
 * service for monitoring other application activity in terms of execution, closing, and key presses. Monitors keypressed through Jnativehook local library
 * @author mason
 *
 */
package com.github.masonBeattie99.EZ_Translate.services;
import com.github.masonBeattie99.EZ_Translate.ApplicationManager;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.KeyStroke;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
@SuppressWarnings("serial")
public class DetectionService implements NativeKeyListener{

	//private variables
	ApplicationManager am;
	
	/**
	 * accepts application manager and component to attach input detection to
	 * @param am
	 */
	public DetectionService(ApplicationManager am) {
		
		this.am = am;
		
		
	}//constructor
	
	/**
	 * begins detection service. starts when the start method in the main menu is called
	 */
	public void start() {
		
		String openKeyString = "typed a";
		String closeKeyString = "alt shift X";
		
		
		//String openKeyString = "alt shift D";
		//String closeKeyString = "alt shift D";
	
		KeyStroke ksO = KeyStroke.getKeyStroke(openKeyString);
		KeyStroke ksC = KeyStroke.getKeyStroke(closeKeyString);
		
		//input.getInputMap().put(ksO, "open");
		//input.getInputMap().put(ksC, "close");
		
		//input.getActionMap().put("open", openAction());
		//input.getActionMap().put("close", closeAction());
		
		//openKeyString = am.accessConfig().getOpenKey();
		//closeKeyString = am.accessConfig().getCloseKey();
		
		
		
	}//start
	
	/**
	 * stops detection service
	 */
	public void close() {
		
		
		
	}//close
	
	//actionMethods
	
	/**
	 * opening action
	 * @return action to be performed
	 */
	public Action openAction() {
		
		return new AbstractAction() {
			
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("Action is called");
				
				am.displayTransMenu();
				
				
			}
			
		};
		
	}//openAction
	
	/**
	 * closing action
	 * @return action to be performed
	 */
	public Action closeAction() {
		
		return new AbstractAction() {
			
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("Action is called");
				
				am.hideTransMenu();
				
			}
			
		};
		
	}//closeAction

	@Override
	public void nativeKeyPressed(NativeKeyEvent e) {
		// TODO Auto-generated method stub
		
		System.out.println("Key Pressed: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
		
	}

	@Override
	public void nativeKeyReleased(NativeKeyEvent e) {
		// TODO Auto-generated method stub
		
		System.out.println("Key Released: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
		
	}

	@Override
	public void nativeKeyTyped(NativeKeyEvent e) {
		// TODO Auto-generated method stub
		
		System.out.println("Key Typed: " + e.getKeyText(e.getKeyCode()));
		
		
	}
	
}
