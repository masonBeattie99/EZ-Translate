/**
 * service for monitoring other application activity in terms of execution, closing, and key presses. Inherits from the menu class to enable keypress reading functionality
 * @author mason
 *
 */
package com.github.masonBeattie99.EZ_Translate.services;
import com.github.masonBeattie99.EZ_Translate.ApplicationManager;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.KeyStroke;
@SuppressWarnings("serial")
public class DetectionService extends JFrame{

	//private variables
	ApplicationManager am;
	JFrame frame;
	JTextField input;
	
	/**
	 * accepts application manager and component to attach input detection to
	 * @param am
	 */
	public DetectionService(ApplicationManager am) {
		
		this.am = am;
		
		Container cp = getContentPane();
		
		cp.setLayout(new FlowLayout());
		
		input = new JTextField();
		
		input.setEditable(true);
		
		cp.add(input);
		
		setSize(120,350);
		setVisible(true);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		
	}//constructor
	
	/**
	 * begins detection service. starts when the start method in the main menu is called
	 */
	public void start() {
		
		String openKeyString = "typed a";
		String closeKeyString = "alt shift X";
		
		input.grabFocus();
		
		//String openKeyString = "alt shift D";
		//String closeKeyString = "alt shift D";
	
		KeyStroke ksO = KeyStroke.getKeyStroke(openKeyString);
		KeyStroke ksC = KeyStroke.getKeyStroke(closeKeyString);
		
		input.getInputMap().put(ksO, "open");
		input.getInputMap().put(ksC, "close");
		
		input.getActionMap().put("open", openAction());
		input.getActionMap().put("close", closeAction());
		
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
				
				input.grabFocus();
				
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
	
}
