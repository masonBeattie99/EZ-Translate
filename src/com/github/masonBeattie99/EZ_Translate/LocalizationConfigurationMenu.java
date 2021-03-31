/**
 * menu for configuring localization
 */
package com.github.masonBeattie99.EZ_Translate;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class LocalizationConfigurationMenu extends Menu{

	//private variables
			private JButton upLocalBtn;
			private JButton closeBtn;
			private JComboBox<String> locals;
			private String[] options = new String[3];
			private String currentLocal;
			/**
			 * constructs an EZTranslateMenu
			 */
			public LocalizationConfigurationMenu(ApplicationManager am) {
				
				Container cp = getContentPane();
				
				cp.setLayout(new FlowLayout());
				
				upLocalBtn = new JButton("Update Localization");
				closeBtn = new JButton ("Close");
				options = new String[] {"eng", "ger", "rus"};
				locals = new JComboBox<String>(options);
				currentLocal = "";
				
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
						currentLocal = (String) locals.getSelectedItem();
					}
						
				});
				
				closeBtn.addActionListener(new ActionListener(){
					
					@Override
					public void actionPerformed(ActionEvent evt) {
						am.hideLCM();
					}
					
				});
				
				setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				setTitle("Localization Configuration Menu");
				setSize(350,120);
				
				
			}//constructor
	
}
