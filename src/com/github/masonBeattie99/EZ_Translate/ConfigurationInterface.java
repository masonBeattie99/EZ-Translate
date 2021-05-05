/**
 * Interface for configuration settings. Provides interface options for each configuration setting.
 * @author Mason Beattie
 * 
 * EZ-Translate
 * Copyright (C) 2021 Mason Beattie.  All Rights Received.
 * https://github.com/masonBeattie99/EZ-Translate
 * 
 * This file is part of EZ-Translate.
 *
 *  EZ-Translate is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  EZ-Translate is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with EZ-Translate.  If not, see <https://www.gnu.org/licenses/>.
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
	private JTextField configs;
	private JLabel configLabel;
	
	private ApplicationManager am;
	
	private ActionListener appBtnAL;
	private ActionListener keyBtnAL;
	private ActionListener localBtnAL;
	private ActionListener closeBtnAL;
	
	private WindowAdapter wa;
	
	/**
	 * constructs an EZTranslateMenu
	 * @param the application manager object
	 */
	public ConfigurationInterface(ApplicationManager am) {
		
		this.am = am;
		
		Container cp = getContentPane();
		
		cp.setLayout(new FlowLayout());
		
		appBtn = new JButton(am.accessLocal().getString("configAppBtn"));
		keyBtn = new JButton(am.accessLocal().getString("configKeyBndBtn"));
		localBtn = new JButton(am.accessLocal().getString("configLocalBtn"));
		closeBtn = new JButton (am.accessLocal().getString("closeBtn"));
		configLabel = new JLabel(am.accessLocal().getString("configsLabel"));
		configs = new JTextField(75);
		configs.setEditable(false);
		
		//adding items to frame
		
		//application button not being added
		//cp.add(appBtn);
		cp.add(keyBtn);
		cp.add(localBtn);
		cp.add(configLabel);
		cp.add(configs);
		cp.add(closeBtn);
		
		configs.setText(am.accessConfig().getConfig());
		
		//button functionality
		
		appBtnAL = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent evt) {
				am.displayACM();
			}
			
		};
		
		keyBtnAL = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent evt) {
				am.displayKCM();
			}
			
		};
		
		localBtnAL = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent evt) {
				am.displayLCM();
			}
				
		};
		
		
		closeBtnAL = new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent evt) {
				
				am.hideConfigMenu();
				am.hideACM();
				am.hideKCM();
				am.hideLCM();
			}
			
		};
		
		wa = new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				//performs the same action as close button for consistency
				am.hideConfigMenu();
			}
		};
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setTitle(am.accessLocal().getString("configMenuLabel"));
		setSize(1000,300);
		
		
	}//constructor
	
	/**
	 * changes sets text components to new localization settings
	 */
	public void updateText() {
		
		appBtn.setText(am.accessLocal().getString("configAppBtn"));
		keyBtn.setText(am.accessLocal().getString("configKeyBndBtn"));
		localBtn.setText(am.accessLocal().getString("configLocalBtn"));
		closeBtn.setText(am.accessLocal().getString("closeBtn"));
		configLabel.setText(am.accessLocal().getString("configsLabel"));
		configs.setText(am.accessConfig().getConfig());
		
		this.setTitle(am.accessLocal().getString("configMenuLabel"));
		
	}//updateText

	/**
	 * adds listeners
	 */
	@Override
	public void addListeners() {
		
		appBtn.addActionListener(appBtnAL);
		keyBtn.addActionListener(keyBtnAL);
		localBtn.addActionListener(localBtnAL);
		closeBtn.addActionListener(closeBtnAL);
		super.addWindowListener(wa);
		
	}

	/**
	 * removes listeners
	 */
	@Override
	public void removeListeners() {
		
		appBtn.removeActionListener(appBtnAL);
		keyBtn.removeActionListener(keyBtnAL);
		localBtn.removeActionListener(localBtnAL);
		closeBtn.removeActionListener(closeBtnAL);
		super.removeWindowListener(wa);
		
	}
	
	
}//class
