/**
 * Interface for configuration settings. Provides interface options for each configuration setting.
 * @author mason
 *
 */
package com.github.masonBeattie99.EZ_Translate;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
@SuppressWarnings("serial")
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
		
		appBtn = new JButton(am.accessLocal().getString("configAppBtn"));
		keyBtn = new JButton(am.accessLocal().getString("configKeyBndBtn"));
		localBtn = new JButton(am.accessLocal().getString("configLocalBtn"));
		closeBtn = new JButton (am.accessLocal().getString("closeBtn"));
		
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
		setTitle(am.accessLocal().getString("configMenuLabel"));
		setSize(350,120);
		
		
	}//constructor
	
	
}//class
