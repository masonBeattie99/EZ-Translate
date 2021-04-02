/**
 * menu for configuring applications
 */
package com.github.masonBeattie99.EZ_Translate;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
@SuppressWarnings("serial")
public class ApplicationConfigurationMenu extends Menu{

	//private variables
			private JButton addAppBtn;
			private JButton deAppBtn;
			private JButton closeBtn;
			private JTextField apps;
			private JLabel appsLabel;
			
			/**
			 * constructs an EZTranslateMenu
			 */
			public ApplicationConfigurationMenu(ApplicationManager am) {
				
				Container cp = getContentPane();
				
				cp.setLayout(new FlowLayout());
				
				addAppBtn = new JButton(am.accessLocal().getString("addAppMsg"));
				deAppBtn = new JButton(am.accessLocal().getString("deleAppMsg"));
				closeBtn = new JButton (am.accessLocal().getString("closeBtn"));
				appsLabel = new JLabel(am.accessLocal().getString("appLabel"));
				apps = new JTextField();
				apps.setEditable(false);
				
				//adding items to frame
				cp.add(addAppBtn);
				cp.add(deAppBtn);
				cp.add(closeBtn);
				cp.add(appsLabel);
				cp.add(apps);
				
				//populating textfield item
				
				apps.setText(am.accessConfig().getApps());
				
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
				setTitle(am.accessLocal().getString("appConfigMenuLabel"));
				setSize(350,120);
				
				
			}//constructor
	
}
