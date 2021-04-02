/**
 * menu for configuring localization
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
			/**
			 * constructs an EZTranslateMenu
			 */
			public LocalizationConfigurationMenu(ApplicationManager am) {
				
				Container cp = getContentPane();
				
				cp.setLayout(new FlowLayout());
				
				upLocalBtn = new JButton(am.accessLocal().getString("upLocalBtn"));
				closeBtn = new JButton (am.accessLocal().getString("closeBtn"));
				options = new String[] {
						am.accessLocal().getString("localChoicesEng"), 
						am.accessLocal().getString("localChoicesGer"),
						am.accessLocal().getString("localChoicesRus")};
				locals = new JComboBox<String>(options);
				
				//adding buttons to frame
				cp.add(upLocalBtn);
				cp.add(locals);
				cp.add(closeBtn);
				
				
				//button functionality
				upLocalBtn.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent evt) {
						
					}
					
				});
				
				locals.addActionListener(new ActionListener() {
						
					@Override
					public void actionPerformed(ActionEvent evt) {
						
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
	
}
