/**
 * menu for configuring applications
 */
package com.github.masonBeattie99.EZ_Translate;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class ApplicationConfigurationMenu extends Menu{

	//private variables
			private JButton addAppBtn;
			private JButton deAppBtn;
			private JButton closeBtn;
			private JTextField apps;
			
			/**
			 * constructs an EZTranslateMenu
			 */
			public ApplicationConfigurationMenu(ApplicationManager am) {
				
				Container cp = getContentPane();
				
				cp.setLayout(new FlowLayout());
				
				addAppBtn = new JButton("Add Application");
				deAppBtn = new JButton("Delete Application");
				closeBtn = new JButton ("Close");
				apps = new JTextField("Applications");
				apps.setEditable(false);
				
				//adding buttons to frame
				cp.add(addAppBtn);
				cp.add(deAppBtn);
				cp.add(closeBtn);
				cp.add(apps);
				
				//populating textfield item
				
				apps.setText("Testing");
				
				//button functionality
				addAppBtn.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent evt) {
						
					}
					
				});
				
				deAppBtn.addActionListener(new ActionListener() {
						
					@Override
					public void actionPerformed(ActionEvent evt) {
					
					}
						
				});
				
				closeBtn.addActionListener(new ActionListener(){
					
					@Override
					public void actionPerformed(ActionEvent evt) {
						am.hideACM();
					}
					
				});
				
				setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				setTitle("Application Configuration Menu");
				setSize(350,120);
				
				
			}//constructor
	
}
