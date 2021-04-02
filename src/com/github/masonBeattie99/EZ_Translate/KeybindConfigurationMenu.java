/**
 * menu for configuring keybinds
 */
package com.github.masonBeattie99.EZ_Translate;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
@SuppressWarnings("serial")
public class KeybindConfigurationMenu extends Menu{

	//private variables
		private JButton upOpenKeyBtn;
		private JButton upCloseKeyBtn;
		private JButton closeBtn;
		
		/**
		 * constructs an EZTranslateMenu
		 */
		public KeybindConfigurationMenu(ApplicationManager am) {
			
			Container cp = getContentPane();
			
			cp.setLayout(new FlowLayout());
			
			upOpenKeyBtn = new JButton(am.accessLocal().getString("upOpenKeyBtn"));
			upCloseKeyBtn = new JButton(am.accessLocal().getString("upCloseKeyBtn"));
			closeBtn = new JButton (am.accessLocal().getString("closeBtn"));
			
			//adding buttons to frame
			cp.add(upOpenKeyBtn);
			cp.add(upCloseKeyBtn);
			cp.add(closeBtn);
			
			//button functionality
			upOpenKeyBtn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent evt) {
					
				}
				
			});
			
			upCloseKeyBtn.addActionListener(new ActionListener() {
					
				@Override
				public void actionPerformed(ActionEvent evt) {
				
				}
					
			});
			
			closeBtn.addActionListener(new ActionListener(){
				
				@Override
				public void actionPerformed(ActionEvent evt) {
					am.hideKCM();
				}
				
			});
			
			setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			setTitle(am.accessLocal().getString("keyConfigMenuLabel"));
			setSize(350,120);
			
			
		}//constructor
	
}
