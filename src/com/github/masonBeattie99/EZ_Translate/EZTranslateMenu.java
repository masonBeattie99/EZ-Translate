/**
 * A "main menu" for the application. Handles direction to configuration menu, and provides the option
 * to start or close the application.
 * 
 * @author Mason Beattie
 * 
 * 
 * Copyright 2021 Mason Beattie
 *	
 *	Licensed under the Apache License, Version 2.0 (the "License");
 *	you may not use this file except in compliance with the License.
 *	You may obtain a copy of the License at
 *	
 *	    http://www.apache.org/licenses/LICENSE-2.0
 *	
 *	Unless required by applicable law or agreed to in writing, software
 *	distributed under the License is distributed on an "AS IS" BASIS,
 *	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *	See the License for the specific language governing permissions and
 *	limitations under the License.
 *
 */
package com.github.masonBeattie99.EZ_Translate;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
@SuppressWarnings("serial")
public class EZTranslateMenu extends Menu{

	//variables
	private JButton configBtn;
	private JButton startBtn;
	private JButton shutdownBtn;
	private JButton closeBtn;
	
	private ApplicationManager am;
	
	private ActionListener configBtnAL;
	private ActionListener startBtnAL;
	private ActionListener shutdownBtnAL;
	private ActionListener closeBtnAL;
	
	private WindowAdapter wa;
	
	/**
	 * constructs an EZTranslateMenu
	 */
	public EZTranslateMenu(ApplicationManager am) {
		
		this.am = am;
		
		Container cp = getContentPane();
		
		cp.setLayout(new FlowLayout());
		
		configBtn = new JButton(am.accessLocal().getString("configBtn"));
		startBtn = new JButton(am.accessLocal().getString("startBtn"));
		shutdownBtn = new JButton (am.accessLocal().getString("stopBtn"));
		closeBtn = new JButton(am.accessLocal().getString("closeBtn"));
		
		//sets the shutdown button to invisible
		shutdownBtn.setVisible(false);
		
		//adding items to frame
		cp.add(configBtn);
		cp.add(startBtn);
		cp.add(shutdownBtn);
		cp.add(closeBtn);
		
		
		//button functionality
		
		configBtnAL = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent evt) {
				am.displayConfigMenu();
			}
			
		};
		
		startBtnAL = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent evt) {
				
				if(am.startDetect()) {
					startBtn.setEnabled(false);
					configBtn.setEnabled(false);
					
					startBtn.setVisible(false);
					shutdownBtn.setVisible(true);
				}
				
			}
			
		};
		
		shutdownBtnAL = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent evt) {
							
				am.stopDetect();
				
				startBtn.setEnabled(true);
				configBtn.setEnabled(true);
				
				startBtn.setVisible(true);
				shutdownBtn.setVisible(false);
				
			}
				
		};
		
		closeBtnAL = new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent evt) {
				
				am.shutdown();
				
			}
			
		};
		
		wa = new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				//performs the same action as close button for consistency
				am.shutdown();
				removeListeners();
			}
		};
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setTitle(am.accessLocal().getString("mainMenuLabel"));
		setSize(700,240);
		
		
	}//constructor	
	
	/**
	 * changes sets text components to new localization settings
	 */
	public void updateText() {
		
		configBtn.setText(am.accessLocal().getString("configBtn"));
		startBtn.setText(am.accessLocal().getString("startBtn"));
		shutdownBtn.setText(am.accessLocal().getString("stopBtn"));
		closeBtn.setText(am.accessLocal().getString("closeBtn"));
		this.setTitle(am.accessLocal().getString("mainMenuLabel"));
		
	}//updateText

	/**
	 * adds listeners
	 */
	@Override
	public void addListeners() {
		
		configBtn.addActionListener(configBtnAL);
		startBtn.addActionListener(startBtnAL);
		shutdownBtn.addActionListener(shutdownBtnAL);
		closeBtn.addActionListener(closeBtnAL);
		super.addWindowListener(wa);
		
	}

	/**
	 * removes listeners
	 */
	@Override
	public void removeListeners() {
		
		configBtn.removeActionListener(configBtnAL);
		startBtn.removeActionListener(startBtnAL);
		shutdownBtn.removeActionListener(shutdownBtnAL);
		closeBtn.removeActionListener(closeBtnAL);
		super.removeWindowListener(wa);
		
	}
	
}//class
