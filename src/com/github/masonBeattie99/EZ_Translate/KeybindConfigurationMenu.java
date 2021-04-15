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
		private JTextField openKeyInputField;
		private JTextField closeKeyInputField;
		
		//variables used for storing keybind values to be sent to configuraiton
		private String currentOpenBind;
		private String currentCloseBind;
		
		
		//testing code, remove when done
		private JFrame noti;
		
		
		/**
		 * constructs an EZTranslateMenu
		 */
		public KeybindConfigurationMenu(ApplicationManager am) {
			
			//variable used to store input
			currentOpenBind = "";
			currentCloseBind = "";
			
			//testing code
			noti = new JFrame();
			
			Container cp = getContentPane();
			
			cp.setLayout(new FlowLayout());
			
			upOpenKeyBtn = new JButton(am.accessLocal().getString("upOpenKeyBtn"));
			upCloseKeyBtn = new JButton(am.accessLocal().getString("upCloseKeyBtn"));
			saveKeyBtn = new JButton("TEMP SAVE CLOSE BUTTON");
			closeBtn = new JButton (am.accessLocal().getString("closeBtn"));
			openKeyInputField = new JTextField(am.accessConfig().getOpenKey());
			closeKeyInputField = new JTextField(am.accessConfig().getCloseKey());
			
			//input fields are used solely for display
			openKeyInputField.setEditable(false);
			closeKeyInputField.setEditable(false);
			
			//adding items to frame
			cp.add(upOpenKeyBtn);
			cp.add(openKeyInputField);
			cp.add(upCloseKeyBtn);
			cp.add(closeKeyInputField);
			cp.add(closeBtn);
			cp.add(saveKeyBtn);			
			
			//button functionality
			upOpenKeyBtn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent evt) {
					
					//testing message
					System.out.println("ITS HAPPENING");
					
					//resets the current config
					currentOpenBind = "";
					am.accessConfig().clearOpenKey();
					
					//forces input into the text field
					openKeyInputField.grabFocus();
					
					
					openKeyInputField.addKeyListener(new KeyAdapter() {
						
						@Override public void keyPressed(final KeyEvent e) {
							System.out.print("Something happened");
							JOptionPane.showMessageDialog(noti, "Key Pressed: " + KeyEvent.getKeyText(e.getExtendedKeyCode()));
							
							currentOpenBind += KeyEvent.getKeyText(e.getExtendedKeyCode()) + "+";
							
							openKeyInputField.setText(currentOpenBind + " ");
							
						}
						
					});
					
				}
				
			});//update open key
			
			upCloseKeyBtn.addActionListener(new ActionListener() {
					
				@Override
				public void actionPerformed(ActionEvent evt) {
					
					//testing message
					System.out.println("ITS HAPPENING");
					
					//resets the current config
					currentCloseBind = "";
					am.accessConfig().clearCloseKey();
					
					//forces input into the text field
					closeKeyInputField.grabFocus();
					
					closeKeyInputField.addKeyListener(new KeyAdapter() {
						
						@Override public void keyPressed(final KeyEvent e) {
							System.out.print("Something happened");
							JOptionPane.showMessageDialog(noti, "Key Pressed: " + KeyEvent.getKeyText(e.getExtendedKeyCode()));
							
							currentCloseBind += KeyEvent.getKeyText(e.getExtendedKeyCode()) + "+";
							
							closeKeyInputField.setText(currentCloseBind);
							
						}
						
					});
					
				}
			});
			
			closeBtn.addActionListener(new ActionListener(){
				
				@Override
				public void actionPerformed(ActionEvent evt) {
					am.hideKCM();
				}
				
			});//update close key
			
			saveKeyBtn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent evt) {
					
					//checking open key bind
					if(am.accessConfig().updateOpenKey(currentOpenBind)) {
						
						JOptionPane.showMessageDialog(noti, "TEMP MESSAGE SUCCESS");
						
					}
					else{
						
						//display the error
						JOptionPane.showMessageDialog(noti, "TEMP ERR MESSAGE UPDATE FAILURE", "TEMP ERR MESSAGE UPDATE FAILURE", JOptionPane.ERROR_MESSAGE);
						
						//resets the current config
						currentOpenBind = "";
						am.accessConfig().clearOpenKey();
						
					}
					
					//checking close key bind
					if(am.accessConfig().updateCloseKey(currentCloseBind)){
						
						JOptionPane.showMessageDialog(noti, "TEMP MESSAGE SUCCESS");
						
					}
					else{
						
						//display the error
						JOptionPane.showMessageDialog(noti, "TEMP ERR MESSAGE UPDATE FAILURE", "TEMP ERR MESSAGE UPDATE FAILURE", JOptionPane.ERROR_MESSAGE);
						
						//resets the current config
						currentCloseBind = "";
						am.accessConfig().clearCloseKey();
						
					}
					
				}
				
			});//save key btn
			
			setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			setTitle(am.accessLocal().getString("keyConfigMenuLabel"));
			setSize(350,120);
			
			
		}//constructor
	
}
