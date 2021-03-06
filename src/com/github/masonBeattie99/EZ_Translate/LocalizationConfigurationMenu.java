/**
 * menu for configuring localization
 * 
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
