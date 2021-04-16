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
	
	ApplicationManager am;
	
	/**
	 * constructs an EZTranslateMenu
	 */
	public EZTranslateMenu(ApplicationManager am) {
		
		this.am = am;
		
		Container cp = getContentPane();
		
		cp.setLayout(new FlowLayout());
		
		configBtn = new JButton(am.accessLocal().getString("configBtn"));
		startBtn = new JButton(am.accessLocal().getString("startBtn"));
		shutdownBtn = new JButton (am.accessLocal().getString("closeBtn"));
		
		//adding items to frame
		cp.add(configBtn);
		cp.add(startBtn);
		cp.add(shutdownBtn);
		
		
		//button functionality
		configBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent evt) {
				am.displayConfigMenu();
			}
			
		});
		
		startBtn.addActionListener(new ActionListener() {
				
			@Override
			public void actionPerformed(ActionEvent evt) {
				System.out.println("Starting Application");
			}
				
		});
		
		shutdownBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent evt) {
				am.shutdown();
			}
				
		});
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle(am.accessLocal().getString("mainMenuLabel"));
		setSize(700,240);
		
		
	}//constructor	
	
	/**
	 * changes sets text components to new localization settings
	 */
	public void updateText() {
		
		configBtn.setText(am.accessLocal().getString("configBtn"));
		startBtn.setText(am.accessLocal().getString("startBtn"));
		shutdownBtn.setText(am.accessLocal().getString("closeBtn"));
		this.setTitle(am.accessLocal().getString("mainMenuLabel"));
		
	}//updateText
	
}//class
