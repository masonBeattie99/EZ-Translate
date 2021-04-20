/**
 * defines functionality for all menus in the application. includes abstract method update text to 
 */
package com.github.masonBeattie99.EZ_Translate;
import javax.swing.*;
@SuppressWarnings("serial")
public abstract class Menu extends JFrame{

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
			
			this.removeListeners();
			setVisible(false);
			
		}//hideMenu
		
		/**
		 * displays the Menu
		 */
		public void displayMenu() {
			
			this.addListeners();
			setVisible(true);
			
		}//displayMenu
		
		public abstract void updateText();
		
		public abstract void addListeners();
		
		public abstract void removeListeners();

}
