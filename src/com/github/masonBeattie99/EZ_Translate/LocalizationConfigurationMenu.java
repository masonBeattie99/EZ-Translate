/**
 * menu for configuring localization
 */
package com.github.masonBeattie99.EZ_Translate;
import java.awt.*;
import java.awt.event.*;
import java.util.Locale;

import javax.swing.*;
@SuppressWarnings("serial")
public class LocalizationConfigurationMenu extends Menu{

	//private variables
			private JButton upLocalBtn;
			private JButton closeBtn;
			private JComboBox<String> locals;
			private String[] options = new String[3];
			
			ApplicationManager am;
			
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
				locals.setSelectedItem((String) am.accessConfig().getLocal());
				
				//adding items to frame
				cp.add(upLocalBtn);
				cp.add(locals);
				cp.add(closeBtn);
				
				
				//button functionality
				upLocalBtn.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent evt) {
						am.changeLocal((String) locals.getSelectedItem());
						am.accessConfig().changeLocal((String)locals.getSelectedItem());
					}
					
				});
				
				locals.addActionListener(new ActionListener() {
						
					@Override
					public void actionPerformed(ActionEvent evt) {
						
						//potentially add something here
						
					}
						
				});
				
				closeBtn.addActionListener(new ActionListener(){
					
					@Override
					public void actionPerformed(ActionEvent evt) {
						am.hideLCM();
					}
					
				});
				
				setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				setTitle(am.accessLocal().getString("localConfigMenuLabel"));
				setSize(350,120);
				
				
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
	
}
