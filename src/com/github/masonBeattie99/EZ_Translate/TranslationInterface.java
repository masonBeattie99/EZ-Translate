/**
 * Interface for the translation and language detection service classes. 
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
public class TranslationInterface extends Menu{

	//private variables
	private JButton transBtn;
	//private JButton detectBtn;
	private JTextField transField;
	//private JTextField detectField;
	private JTextField transResult;
	//private JTextField detectResult;
	
	private String[] options = new String[3];
	
	private JComboBox<String> transTo;
	
	private ApplicationManager am;
	
	private ActionListener transBtnAL;
	//ActionListener detectBtnAL;
	
	private WindowAdapter wa;
	
	
	/**
	 * constructs a Translation Interface menu
	 * @param the application manager object
	 */
	public TranslationInterface(ApplicationManager am) {
		
		this.am = am;
		
		Container cp = getContentPane();
		
		cp.setLayout(new FlowLayout());
		
		transBtn = new JButton (am.accessLocal().getString("transBtn"));
		//detectBtn = new JButton ("TEMP DETECT BUTTON");
		transField = new JTextField(50);
		//detectField = new JTextField();
		transResult = new JTextField(50);
		//detectResult = new JTextField();
		
		options = new String[] {
				am.accessLocal().getString("localChoicesEng"),
				am.accessLocal().getString("localChoicesGer"),
				am.accessLocal().getString("localChoicesRus")};
		
		transTo = new JComboBox<String>(options);
		
		transField.setEditable(true);
		//detectField.setEditable(true);
		transResult.setEditable(false);
		//detectResult.setEditable(false);
		
		transField.setColumns(20);
		//detectField.setColumns(5);
		transResult.setColumns(20);
		//detectResult.setColumns(5);
		
		cp.add(transBtn);
		cp.add(transTo);
		cp.add(transField);
		cp.add(transResult);
		//cp.add(detectBtn);
		//cp.add(detectField);
		//cp.add(detectResult);
		
		transBtnAL = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent evt) {
				
				transResult.setText(am.translateLang(transTo.getSelectedIndex(), transField.getText()));
				
			}
			
		};
		
		/**
		detectBtnAL = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent evt) {
				
				detectResult.setText(am.detectLang(detectField.getText()));
				
			}
			
		};
		*/
		
		wa = new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				//performs the same action as close button for consistency
				am.hideTransMenu();
			}
		};
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setTitle(am.accessLocal().getString("transLabel"));
		setSize(500,300);
		
	}//constructor
	
	/**
	 * changes sets text components to new localization settings
	 */
	public void updateText() {
		
		setTitle(am.accessLocal().getString("transLabel"));
		transBtn.setText(am.accessLocal().getString("transBtn"));
		//detectBtn = new JButton ("TEMP DETECT BUTTON");
		
		options = new String[] {
				am.accessLocal().getString("localChoicesEng"),
				am.accessLocal().getString("localChoicesGer"),
				am.accessLocal().getString("localChoicesRus")};
		
		transTo.removeAllItems();
		for(int i = 0; i < options.length; i++) {
			
			transTo.addItem(options[i]);
			
		}
		
	}//updateText
	
	/**
	 * adds the action listeners
	 */
	public void addListeners() {
		
		transBtn.addActionListener(transBtnAL);
		//detectBtn.addActionListener(detectBtnAL);
		super.addWindowListener(wa);
		
	}//addListeners
	
	/**
	 * removes the action listeners
	 */
	public void removeListeners() {
		
		transBtn.removeActionListener(transBtnAL);
		super.removeWindowListener(wa);
		//detectBtn.removeActionListener(detectBtnAL);
		
	}
	
	@Override
	public void displayMenu() {
		
		this.addListeners();
		setVisible(true);
		requestFocusInWindow();
		toFront();
		
	}
	
}//class
