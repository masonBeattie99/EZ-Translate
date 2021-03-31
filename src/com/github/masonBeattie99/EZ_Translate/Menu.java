/**
 * defines functionality for all menus in the application.
 */
package com.github.masonBeattie99.EZ_Translate;
import javax.swing.*;
@SuppressWarnings("serial")
public class Menu extends JFrame{

	/**
	 * default constructor for all menu
	 */
	public Menu(){
		
	}//default constructor
	
	//methods
	
		/**
		 * hides the Menu
		 */
		public void hideMenu() {
			
			setVisible(false);
			
		}//hideMenu
		
		/**
		 * displays the Menu
		 */
		public void displayMenu() {
			
			setVisible(true);
			
		}//displayMenu

}
