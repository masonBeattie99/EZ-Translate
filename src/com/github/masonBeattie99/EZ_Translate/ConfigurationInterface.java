/**
 * Interface for configuration settings. Provides interface options for each configuration setting.
 * @author mason
 *
 */
package com.github.masonBeattie99.EZ_Translate;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class ConfigurationInterface extends Menu{

	//private variables
	private JButton appBtn;
	private JButton keyBtn;
	private JButton localBtn;
	private JButton closeBtn;
	
	/**
	 * constructs an EZTranslateMenu
	 */
	public ConfigurationInterface(ApplicationManager am) {
		
		Container cp = getContentPane();
		
		cp.setLayout(new FlowLayout());
		
		appBtn = new JButton("Configure Applications");
		keyBtn = new JButton("Configure Keybinds");
		localBtn = new JButton("Configure Localization");
		closeBtn = new JButton ("Close");
		
		//adding buttons to frame
		cp.add(appBtn);
		cp.add(keyBtn);
		cp.add(localBtn);
		cp.add(closeBtn);
		
		
		//button functionality
		appBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent evt) {
				am.displayACM();
			}
			
		});
		
		keyBtn.addActionListener(new ActionListener() {
				
			@Override
			public void actionPerformed(ActionEvent evt) {
				am.displayKCM();
			}
				
		});
		
		localBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent evt) {
				am.displayLCM();
			}
				
		});
		
		closeBtn.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent evt) {
				am.hideConfigMenu();
				am.hideACM();
				am.hideKCM();
				am.hideLCM();
			}
			
		});
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setTitle("Configuration Menu");
		setSize(350,120);
		
		
	}//constructor
	
	
}//class
