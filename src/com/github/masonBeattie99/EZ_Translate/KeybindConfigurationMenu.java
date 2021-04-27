/**
 * menu for configuring keybinds
 */
package com.github.masonBeattie99.EZ_Translate;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
@SuppressWarnings("serial")
public class KeybindConfigurationMenu extends Menu{

		//content pane
		Container cp;
	
		//private variables
		private JButton upOpenKeyBtn;
		private JButton upCloseKeyBtn;
		private JButton saveKeyBtn;
		private JButton closeBtn;
		
		//text fields
		private JTextField openKeyInputField;
		private JTextField closeKeyInputField;
		
		//variables used for storing keybind values to be sent to configuraiton
		private String currentOpenBind;
		private String currentCloseBind;
		
		ApplicationManager am;
		
		//action listeners used by buttons
		ActionListener openKeyAL;
		ActionListener closeKeyAL;
		ActionListener closeBtnAL;
		ActionListener saveKeyAL;
		
		//key adapters used by the key listeners to observe keyboard input
		KeyAdapter openKeyAda;
		KeyAdapter closeKeyAda;
		
		//window adapter to detect when menu closes, to perform a custom closing operation
		WindowAdapter wa;
		
		//testing code, hope this works
		ArrayList<KeyEvent> keyEventList;
		
		
		/**
		 * constructs an EZTranslateMenu
		 * @param the application manager object
		 */
		public KeybindConfigurationMenu(ApplicationManager am) {
			
			this.am = am;
			
			//variable used to store input
			currentOpenBind = "";
			currentCloseBind = "";			
			
			cp = getContentPane();
			
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
			
			keyEventList = new ArrayList<KeyEvent>();
			
			openKeyAda = new KeyAdapter() {
				
				@Override public void keyPressed(final KeyEvent e) {
					
					keyEventList.add(e);
					
					
					//adds space for storage within file
					currentOpenBind += KeyEvent.getKeyText(e.getExtendedKeyCode()) + " ";
					
					//updates text field
					openKeyInputField.setText(currentOpenBind);
					
				}
				
			};
			
			closeKeyAda = new KeyAdapter() {
				
				@Override public void keyPressed(final KeyEvent e) {
					
					//adds space for storage within file
					currentCloseBind += KeyEvent.getKeyText(e.getExtendedKeyCode()) + ' ';
					
					//updates textfield
					closeKeyInputField.setText(currentCloseBind);
					
				}
				
			};
			
			//opening key bind key
			openKeyAL = new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent evt) {
					
					//resets the current config and the text field associated with it
					currentOpenBind = "";
					am.accessConfig().clearOpenKey();
					openKeyInputField.setText(currentOpenBind);
					
					//forces input into the text field
					openKeyInputField.grabFocus();
					
					
					openKeyInputField.addKeyListener(openKeyAda);
					
				}
				
			};//update open key
		
			
			
			//closing key bind key
			closeKeyAL = new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent evt) {
									
					//resets the current config and the text field associated with it
					currentCloseBind = "";
					am.accessConfig().clearCloseKey();
					closeKeyInputField.setText(currentCloseBind);
					
					//forces input into the text field
					closeKeyInputField.grabFocus();
					
					closeKeyInputField.addKeyListener(closeKeyAda);
				
				}
			
			};//update close key
			
			closeBtnAL = new ActionListener(){
				
				@Override
				public void actionPerformed(ActionEvent evt) {
					
					am.hideKCM();
				}
				
			};
			
			saveKeyAL = new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent evt) {
					
					//key listeners need to be removed when saving to prevent issues
					openKeyInputField.removeKeyListener(openKeyAda);
					closeKeyInputField.removeKeyListener(closeKeyAda);
					
					am.changeKeys(currentOpenBind, currentCloseBind);
					
					currentOpenBind = "";
					currentCloseBind = "";
					
					//action listener has to be refreshed. Doesn't work any other way.
					//upOpenKeyBtn.addActionListener(upKeyAL);
					//upCloseKeyBtn.addActionListener(closeKeyAL);
					
				}
				
			};
			
			wa = new WindowAdapter() {
				
				public void windowClosing(WindowEvent e) {
					//performs the same action as close button for consistency
					am.hideKCM();
				}
			};
			
			setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
			setTitle(am.accessLocal().getString("keyConfigMenuLabel"));
			setSize(350,120);
			
			
		}//constructor
		
		/**
		 * changes sets text components to new localization settings
		 */
		public void updateText() {
			
			upOpenKeyBtn.setText(am.accessLocal().getString("upOpenKeyBtn"));
			upCloseKeyBtn.setText(am.accessLocal().getString("upCloseKeyBtn"));
			saveKeyBtn.setText("TEMP SAVE CLOSE BUTTON");
			closeBtn.setText(am.accessLocal().getString("closeBtn"));
			this.setTitle(am.accessLocal().getString("keyConfigMenuLabel"));
			
		}//updateText
		
		/**
		 * adds listeners
		 */
		@Override
		public void addListeners() {
			
			upOpenKeyBtn.addActionListener(openKeyAL);
			upCloseKeyBtn.addActionListener(closeKeyAL);
			closeBtn.addActionListener(closeBtnAL);
			saveKeyBtn.addActionListener(saveKeyAL);
			super.addWindowListener(wa);
			
			
		}//addListeners
		
		/**
		 * removes listeners
		 */
		@Override
		public void removeListeners() {
			
			//removes listeners to prevent issues
			openKeyInputField.removeKeyListener(openKeyAda);
			closeKeyInputField.removeKeyListener(closeKeyAda);
			super.removeWindowListener(wa);
			
			upOpenKeyBtn.removeActionListener(openKeyAL);
			upCloseKeyBtn.removeActionListener(closeKeyAL);
			closeBtn.removeActionListener(closeBtnAL);
			saveKeyBtn.removeActionListener(saveKeyAL);
			
		}//removeListeners
	
}
