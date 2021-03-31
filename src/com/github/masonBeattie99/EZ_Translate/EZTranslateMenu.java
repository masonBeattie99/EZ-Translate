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
public class EZTranslateMenu extends Menu{

	//variables
	private JButton configBtn;
	private JButton startBtn;
	private JButton shutdownBtn;
	
	/**
	 * constructs an EZTranslateMenu
	 */
	public EZTranslateMenu(ApplicationManager am) {
		
		Container cp = getContentPane();
		
		cp.setLayout(new FlowLayout());
		
		configBtn = new JButton("Configuration Settings");
		startBtn = new JButton("Start");
		shutdownBtn = new JButton ("Close");
		
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
		setTitle("EZTranslate Menu");
		setSize(700,240);
		
		
	}//constructor	
	
}//class
