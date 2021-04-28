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
	//private JButton detectBtn;
	private JTextField transField;
	//private JTextField detectField;
	private JTextField transResult;
	//private JTextField detectResult;
	
	private String[] options = new String[3];
	
	private JComboBox<String> transTo;
	
	ApplicationManager am;
	
	ActionListener transBtnAL;
	//ActionListener detectBtnAL;
	
	WindowAdapter wa;
	
	
	/**
	 * constructs a Translation Interface menu
	 * @param the application manager object
	 */
	public TranslationInterface(ApplicationManager am) {
		
		this.am = am;
		
		Container cp = getContentPane();
		
		cp.setLayout(new FlowLayout());
		
		transBtn = new JButton ("TEMP TRANS BUTTON");
		//detectBtn = new JButton ("TEMP DETECT BUTTON");
		transField = new JTextField();
		//detectField = new JTextField();
		transResult = new JTextField();
		//detectResult = new JTextField();
		
		options = new String[] {
				am.accessLocal().getString("localChoicesEng"),
				am.accessLocal().getString("localChoicesGer"),
				am.accessLocal().getString("localChoicesRus")};
		
		transTo = new JComboBox<String>(options);
		
		transField.setEditable(true);
		//detectField.setEditable(true);
		transResult.setEditable(false);
		//detectResult.setEditable(false);
		
		transField.setColumns(5);
		//detectField.setColumns(5);
		transResult.setColumns(5);
		//detectResult.setColumns(5);
		
		cp.add(transBtn);
		cp.add(transTo);
		cp.add(transField);
		cp.add(transResult);
		//cp.add(detectBtn);
		//cp.add(detectField);
		//cp.add(detectResult);
		
		transBtnAL = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent evt) {
				
				transResult.setText(am.translateLang(transTo.getSelectedIndex(), transField.getText()));
				
			}
			
		};
		
		/**
		detectBtnAL = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent evt) {
				
				detectResult.setText(am.detectLang(detectField.getText()));
				
			}
			
		};
		*/
		
		wa = new WindowAdapter() {
			
			public void windowClosing(WindowEvent e) {
				//performs the same action as close button for consistency
				am.hideTransMenu();
			}
		};
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setTitle("TEMP TRANSLATE INTERFACE");
		setSize(350,120);
		
	}//constructor
	
	/**
	 * changes sets text components to new localization settings
	 */
	public void updateText() {
		
		setTitle("TEMP TRANSLATE INTERFACE");
		transBtn.setText(am.accessLocal().getString("localChoicesGer"));
		//detectBtn = new JButton ("TEMP DETECT BUTTON");
		
		options = new String[] {
				am.accessLocal().getString("localChoicesEng"),
				am.accessLocal().getString("localChoicesGer"),
				am.accessLocal().getString("localChoicesRus")};
		
		transTo.removeAllItems();
		for(int i = 0; i < options.length; i++) {
			
			transTo.addItem(options[i]);
			
		}
		
	}//updateText
	
	/**
	 * adds the action listeners
	 */
	public void addListeners() {
		
		transBtn.addActionListener(transBtnAL);
		//detectBtn.addActionListener(detectBtnAL);
		super.addWindowListener(wa);
		
	}//addListeners
	
	/**
	 * removes the action listeners
	 */
	public void removeListeners() {
		
		transBtn.removeActionListener(transBtnAL);
		super.removeWindowListener(wa);
		//detectBtn.removeActionListener(detectBtnAL);
		
	}
	
	@Override
	public void displayMenu() {
		
		this.addListeners();
		setVisible(true);
		requestFocusInWindow();
		transField.grabFocus();
		
	}
	
}//class
