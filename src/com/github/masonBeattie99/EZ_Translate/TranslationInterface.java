/**
 * Interface for the translation and language detection service classes. 
 * 
 * @author mason
 *
 */
package com.github.masonBeattie99.EZ_Translate;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
@SuppressWarnings("serial")
public class TranslationInterface extends Menu{

	//private variables
	private JButton transBtn;
	private JButton detectBtn;
	private JTextField transField;
	private JTextField detectField;
	private JTextField transResult;
	private JTextField detectResult;
	
	private String[] options = new String[3];
	
	private JComboBox<String> transTo;
	
	ApplicationManager am;
	
	ActionListener transBtnAL;
	ActionListener detectBtnAL;
	
	
	/**
	 * constructs a Translation Interface menu
	 * @param the application manager object
	 */
	public TranslationInterface(ApplicationManager am) {
		
		this.am = am;
		
		Container cp = getContentPane();
		
		transBtn = new JButton ("TEMP TRANS BUTTON");
		detectBtn = new JButton ("TEMP DETECT BUTTON");
		transField = new JTextField();
		detectField = new JTextField();
		transResult = new JTextField();
		detectResult = new JTextField();
		
		options = new String[] {
				am.accessLocal().getString("localChoicesEng"),
				am.accessLocal().getString("localChoicesGer"),
				am.accessLocal().getString("localChoicesRus")};
		
		transTo = new JComboBox<String>(options);
		
		transField.setEditable(true);
		detectField.setEditable(true);
		transResult.setEditable(false);
		detectResult.setEditable(false);
		
		transBtnAL = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent evt) {
				
				transResult.setText(am.translate(transTo.getSelectedIndex(), transField.getText()));
				
			}
			
		};
		
		detectBtnAL = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent evt) {
				
				detectResult.setText(am.detect(detectField.getText()));
				
			}
			
		};
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setTitle("TEMP TRANSLATE INTERFACE");
		setSize(350,120);
		
	}//constructor
	
	/**
	 * changes sets text components to new localization settings
	 */
	public void updateText() {
		
		//I'll get here soon
		setTitle("TEMP TRANSLATE INTERFACE");
		
		transBtn = new JButton ("TEMP TRANS BUTTON");
		detectBtn = new JButton ("TEMP DETECT BUTTON");
		
		options = new String[] {
				am.accessLocal().getString("localChoicesEng"),
				am.accessLocal().getString("localChoicesGer"),
				am.accessLocal().getString("localChoicesRus")};
		
		transTo = new JComboBox<String>(options);
		
	}//updateText
	
	/**
	 * adds the action listeners
	 */
	public void addListeners() {
		
		transBtn.addActionListener(transBtnAL);
		detectBtn.addActionListener(detectBtnAL);
		
	}//addListeners
	
	/**
	 * removes the action listeners
	 */
	public void removeListeners() {
		
		transBtn.removeActionListener(transBtnAL);
		detectBtn.removeActionListener(detectBtnAL);
		
	}
	
}//class
