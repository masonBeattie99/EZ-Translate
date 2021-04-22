/**
 * Interface for configuration settings. Provides interface options for each configuration setting.
 * @author mason
 *
 */
package com.github.masonBeattie99.EZ_Translate;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
@SuppressWarnings("serial")
public class ConfigurationInterface extends Menu{

	//private variables
	private JButton appBtn;
	private JButton keyBtn;
	private JButton localBtn;
	private JButton closeBtn;
	private JTextField configs;
	private JLabel configLabel;
	
	ApplicationManager am;
	
	ActionListener appBtnAL;
	ActionListener keyBtnAL;
	ActionListener localBtnAL;
	ActionListener closeBtnAL;
	
	WindowAdapter wa;
	
	/**
	 * constructs an EZTranslateMenu
	 * @param the application manager object
	 */
	public ConfigurationInterface(ApplicationManager am) {
		
		this.am = am;
		
		Container cp = getContentPane();
		
		cp.setLayout(new FlowLayout());
		
		appBtn = new JButton(am.accessLocal().getString("configAppBtn"));
		keyBtn = new JButton(am.accessLocal().getString("configKeyBndBtn"));
		localBtn = new JButton(am.accessLocal().getString("configLocalBtn"));
		closeBtn = new JButton (am.accessLocal().getString("closeBtn"));
		configLabel = new JLabel(am.accessLocal().getString("configsLabel"));
		configs = new JTextField();
		configs.setEditable(false);
		
		//adding items to frame
		cp.add(appBtn);
		cp.add(keyBtn);
		cp.add(localBtn);
		cp.add(configLabel);
		cp.add(configs);
		cp.add(closeBtn);
		
		configs.setText(am.accessConfig().getConfig());
		
		//button functionality
		
		appBtnAL = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent evt) {
				am.displayACM();
			}
			
		};
		
		keyBtnAL = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent evt) {
				am.displayKCM();
			}
			
		};
		
		localBtnAL = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent evt) {
				am.displayLCM();
			}
				
		};
		
		
		closeBtnAL = new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent evt) {
				
				am.hideConfigMenu();
				am.hideACM();
				am.hideKCM();
				am.hideLCM();
			}
			
		};
		
		wa = new WindowAdapter() {
			
			public void windowClosing(WindowEvent e) {
				//performs the same action as close button for consistency
				am.hideConfigMenu();
			}
		};
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setTitle(am.accessLocal().getString("configMenuLabel"));
		setSize(700,240);
		
		
	}//constructor
	
	/**
	 * changes sets text components to new localization settings
	 */
	public void updateText() {
		
		appBtn.setText(am.accessLocal().getString("configAppBtn"));
		keyBtn.setText(am.accessLocal().getString("configKeyBndBtn"));
		localBtn.setText(am.accessLocal().getString("configLocalBtn"));
		closeBtn.setText(am.accessLocal().getString("closeBtn"));
		configLabel.setText(am.accessLocal().getString("configsLabel"));
		configs.setText(am.accessConfig().getConfig());
		
		this.setTitle(am.accessLocal().getString("configMenuLabel"));
		
	}//updateText

	/**
	 * adds listeners
	 */
	@Override
	public void addListeners() {
		
		appBtn.addActionListener(appBtnAL);
		keyBtn.addActionListener(keyBtnAL);
		localBtn.addActionListener(localBtnAL);
		closeBtn.addActionListener(closeBtnAL);
		super.addWindowListener(wa);
		
	}

	/**
	 * removes listeners
	 */
	@Override
	public void removeListeners() {
		
		appBtn.removeActionListener(appBtnAL);
		keyBtn.removeActionListener(keyBtnAL);
		localBtn.removeActionListener(localBtnAL);
		closeBtn.removeActionListener(closeBtnAL);
		super.removeWindowListener(wa);
		
	}
	
	
}//class
