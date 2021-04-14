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
		private JButton saveKeyBtn;
		private JButton closeBtn;
		
		//there might need to be an invisible text field to fix this issue
		private JTextField keyInputField;
		
		private boolean typing;
		
		
		//testing code, remove when done
		private JFrame noti;
		
		
		/**
		 * constructs an EZTranslateMenu
		 */
		public KeybindConfigurationMenu(ApplicationManager am) {
			
			//testing code
			noti = new JFrame();
			
			Container cp = getContentPane();
			
			cp.setLayout(new FlowLayout());
			
			upOpenKeyBtn = new JButton(am.accessLocal().getString("upOpenKeyBtn"));
			upCloseKeyBtn = new JButton(am.accessLocal().getString("upCloseKeyBtn"));
			saveKeyBtn = new JButton("TEMP SAVE BUTTON");
			closeBtn = new JButton (am.accessLocal().getString("closeBtn"));
			
			keyInputField = new JTextField();
	
			//adding items to frame
			cp.add(upOpenKeyBtn);
			cp.add(upCloseKeyBtn);
			cp.add(closeBtn);
			cp.add(saveKeyBtn);
			cp.add(keyInputField);
			
			/**
			cp.addKeyListener(new KeyListener(){
				
				@Override
				public void keyTyped(KeyEvent e) {
					
					
				}
				
				@Override
				public void keyPressed(KeyEvent e) {
					System.out.print("Something happened");
					JOptionPane.showMessageDialog(noti, "Key Pressed: " + e.getKeyCode() + " - Key Pressed: " + e.getKeyChar());
					am.shutdown();
					
				}
				
				@Override
				public void keyReleased(KeyEvent e) {
					
					
					
				}
				
			});
			*/
			
			
			//button functionality
			upOpenKeyBtn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent evt) {
					
					System.out.println("ITS HAPPENING");
					
					keyInputField.grabFocus();
					
					keyInputField.addKeyListener(new KeyAdapter() {
						
						@Override public void keyReleased(final KeyEvent e) {
							System.out.print("Something happened");
							JOptionPane.showMessageDialog(noti, "Key Pressed: " + e.getKeyCode() + " - Key Pressed: " + e.getKeyChar());
							am.shutdown();
						}
						
					});
					
					/**
					while (!typing) {
						
					}
					*/
					
				}
				
			});
			
			upCloseKeyBtn.addActionListener(new ActionListener() {
					
				@Override
				public void actionPerformed(ActionEvent evt) {
				/**
					while (!typing) {
						
					}
				*/
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
