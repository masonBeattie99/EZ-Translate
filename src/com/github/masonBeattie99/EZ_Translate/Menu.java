/**
 * defines functionality for all menus in the application. includes abstract method update text to 
 * 
 * @author Mason Beattie
 * 
 * EZ-Translate
 * Copyright (C) 2021 Mason Beattie.  All Rights Received.
 * https://github.com/masonBeattie99/EZ-Translate
 * 
 * This file is part of EZ-Translate.
 *
 *  EZ-Translate is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  EZ-Translate is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with EZ-Translate.  If not, see <https://www.gnu.org/licenses/>.
 *
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
