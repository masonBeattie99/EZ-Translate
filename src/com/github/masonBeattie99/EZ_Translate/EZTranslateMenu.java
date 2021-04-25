/**
 * A "main menu" for the application. Handles direction to configuration menu, and provides the option
 * to start or close the application.
 * 
 * @author mason
 *
 */
package com.github.masonBeattie99.EZ_Translate;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
@SuppressWarnings("serial")
public class EZTranslateMenu extends Menu{

	//variables
	private JButton configBtn;
	private JButton startBtn;
	private JButton shutdownBtn;
	private JButton closeBtn;
	
	ApplicationManager am;
	
	ActionListener configBtnAL;
	ActionListener startBtnAL;
	ActionListener shutdownBtnAL;
	ActionListener closeBtnAL;
	
	WindowAdapter wa;
	
	/**
	 * constructs an EZTranslateMenu
	 */
	public EZTranslateMenu(ApplicationManager am) {
		
		this.am = am;
		
		Container cp = getContentPane();
		
		cp.setLayout(new FlowLayout());
		
		configBtn = new JButton(am.accessLocal().getString("configBtn"));
		startBtn = new JButton(am.accessLocal().getString("startBtn"));
		shutdownBtn = new JButton ("TEMP SHUTDOWN BTN");
		closeBtn = new JButton(am.accessLocal().getString("closeBtn"));
		
		//sets the shutdown button to invisible
		shutdownBtn.setVisible(false);
		
		//adding items to frame
		cp.add(configBtn);
		cp.add(startBtn);
		cp.add(shutdownBtn);
		cp.add(closeBtn);
		
		
		//button functionality
		
		configBtnAL = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent evt) {
				am.displayConfigMenu();
			}
			
		};
		
		startBtnAL = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent evt) {
				
				if(am.startDetect()) {
					startBtn.setEnabled(false);
					configBtn.setEnabled(false);
					
					startBtn.setVisible(false);
					shutdownBtn.setVisible(true);
				}
				
			}
			
		};
		
		shutdownBtnAL = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent evt) {
							
				am.stopDetect();
				
				startBtn.setEnabled(true);
				configBtn.setEnabled(true);
				
				startBtn.setVisible(true);
				shutdownBtn.setVisible(false);
				
			}
				
		};
		
		closeBtnAL = new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent evt) {
				
				am.shutdown();
				
			}
			
		};
		
		wa = new WindowAdapter() {
			
			public void windowClosing(WindowEvent e) {
				//performs the same action as close button for consistency
				am.shutdown();
				removeListeners();
			}
		};
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setTitle(am.accessLocal().getString("mainMenuLabel"));
		setSize(700,240);
		
		
	}//constructor	
	
	/**
	 * changes sets text components to new localization settings
	 */
	public void updateText() {
		
		configBtn.setText(am.accessLocal().getString("configBtn"));
		startBtn.setText(am.accessLocal().getString("startBtn"));
		shutdownBtn.setText(("TEMP SHUTDOWN BTN"));
		closeBtn.setText(am.accessLocal().getString("closeBtn"));
		this.setTitle(am.accessLocal().getString("mainMenuLabel"));
		
	}//updateText

	/**
	 * adds listeners
	 */
	@Override
	public void addListeners() {
		
		configBtn.addActionListener(configBtnAL);
		startBtn.addActionListener(startBtnAL);
		shutdownBtn.addActionListener(shutdownBtnAL);
		closeBtn.addActionListener(closeBtnAL);
		super.addWindowListener(wa);
		
	}

	/**
	 * removes listeners
	 */
	@Override
	public void removeListeners() {
		
		configBtn.removeActionListener(configBtnAL);
		startBtn.removeActionListener(startBtnAL);
		shutdownBtn.removeActionListener(shutdownBtnAL);
		closeBtn.removeActionListener(closeBtnAL);
		super.removeWindowListener(wa);
		
	}
	
}//class
