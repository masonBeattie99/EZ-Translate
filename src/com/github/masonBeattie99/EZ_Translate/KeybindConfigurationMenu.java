/**
 * menu for configuring keybinds
 */
package com.github.masonBeattie99.EZ_Translate;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
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
			
			upOpenKeyBtn = new JButton("Update Open Keybind");
			upCloseKeyBtn = new JButton("Update Close Keybind");
			closeBtn = new JButton ("Close");
			
			closeBtn = new JButton ("Close");
			
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
			setTitle("Keybind Configuration Menu");
			setSize(350,120);
			
			
		}//constructor
	
}
