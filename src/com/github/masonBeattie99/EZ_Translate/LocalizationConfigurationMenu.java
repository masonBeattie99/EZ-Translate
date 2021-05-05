/**
 * menu for configuring localization
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
public class LocalizationConfigurationMenu extends Menu{

	//private variables
			private JButton upLocalBtn;
			private JButton closeBtn;
			private JComboBox<String> locals;
			private String[] options = new String[3];
			
			private ApplicationManager am;
			
			private ActionListener upLocalBtnAL;
			private ActionListener closeBtnAL;
			
			private WindowAdapter wa;
			
			/**
			 * constructs an EZTranslateMenu
			 * @param the application manager object
			 */
			public LocalizationConfigurationMenu(ApplicationManager am) {
				
				//assigns new application manager
				this.am = am;
				
				Container cp = getContentPane();
				
				cp.setLayout(new FlowLayout());
				
				upLocalBtn = new JButton(am.accessLocal().getString("upLocalBtn"));
				closeBtn = new JButton (am.accessLocal().getString("closeBtn"));
				options = new String[] {
						am.accessLocal().getString("localChoicesEng"), 
						am.accessLocal().getString("localChoicesGer"),
						am.accessLocal().getString("localChoicesRus")};
				locals = new JComboBox<String>(options);
				
				//setting the default selection to the current localization
				locals.setSelectedIndex(am.accessConfig().getLocal());
				
				//adding items to frame
				cp.add(upLocalBtn);
				cp.add(locals);
				cp.add(closeBtn);
				
				upLocalBtnAL = new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent evt) {
						
						am.changeLocal(locals.getSelectedIndex());
						
						locals.setSelectedIndex(am.accessConfig().getLocal());
						
					}
					
				};
				
				
				
				closeBtnAL = new ActionListener(){
					
					@Override
					public void actionPerformed(ActionEvent evt) {
						
						am.hideLCM();
					}
					
				};
				
				wa = new WindowAdapter() {
					
					@Override
					public void windowClosing(WindowEvent e) {
						//performs the same action as close button for consistency
						am.hideLCM();
					}
				};
				
				setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				setTitle(am.accessLocal().getString("localConfigMenuLabel"));
				setSize(400,200);
				
				
			}//constructor
			
			/**
			 * changes sets text components to new localization settings
			 */
			public void updateText() {
				
				//this.setLocale((Locale) am.accessLocal());
				
				upLocalBtn.setText(am.accessLocal().getString("upLocalBtn"));
				closeBtn.setText(am.accessLocal().getString("closeBtn"));
				options = new String[] {
						am.accessLocal().getString("localChoicesEng"), 
						am.accessLocal().getString("localChoicesGer"),
						am.accessLocal().getString("localChoicesRus")};
				//removes all items within dropdown box, then readds items from options string
				locals.removeAllItems();
				for(int i = 0; i < options.length; i++) {
					
					locals.addItem(options[i]);
					
				}
				
				this.setTitle(am.accessLocal().getString("localConfigMenuLabel"));
				
			}//updateText

			/**
			 * adds listeners
			 */
			@Override
			public void addListeners() {
				
				upLocalBtn.addActionListener(upLocalBtnAL);
				closeBtn.addActionListener(closeBtnAL);
				super.addWindowListener(wa);
				
			}

			/**
			 * removes listeners
			 */
			@Override
			public void removeListeners() {
				
				upLocalBtn.removeActionListener(upLocalBtnAL);
				closeBtn.removeActionListener(closeBtnAL);
				super.removeWindowListener(wa);
				
			}
	
}
