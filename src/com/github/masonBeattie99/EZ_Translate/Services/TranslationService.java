/**
 * Contains interactions with language detection and translation library.
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
package com.github.masonBeattie99.EZ_Translate.services;

import java.nio.charset.StandardCharsets;

public class TranslationService {
	
	public TranslationService() {
		
	}//constructor
	
	public static String translate(int index, String phrase) {
		
		final String NO_SUPP = "Error: Language Not Supported!";
		
		String[] engList = {
				"Hello",
				"How are you",
				"Good morning",
				"Good day",
				"Good evening",
				"Good night",
				"Goodbye",
				"What time is it",
				"Where are you from",
				"Thank you"};
		
		String[] gerList = {
				"Hallo",
				"Wie gehts",
				"Guten Morgen",
				"Guten Tag",
				"Guten Abend",
				"Guten Nacht",
				"Auf Wiedersehen",
				"wie spät ist es",
				"Woher kommst du",
				"Vielen Dank"};
		
		String[] rusList = {
				"Привет",
				"Как дела",
				"Доброе утро",
				"Добрый день", 
				"Добрый вечер",
				"Спокойной ночи",
				"До свидания",
				"который сейчас час",
				"Откуда ты",
				"Спасибо"};
		
		String[] transToList = new String[6];
		
		//set result to deaful to no support
		String result = NO_SUPP;
		
		if(index == 0) {
			transToList = engList.clone();
		}
		else if(index == 1) {
			transToList = gerList.clone();
		}
		else if(index == 2) {
			transToList = rusList.clone();
		}
		else {
			result = NO_SUPP;
		}
		
		for(int i = 0; i < engList.length && i < gerList.length && i < rusList.length; i++) {
			
			if(phrase.equalsIgnoreCase(engList[i])) {
				
				result = transToList[i];
				break;
				
			}
			if(phrase.equalsIgnoreCase(gerList[i])) {
				
				result = transToList[i];
				break;
				
			}
			if(phrase.equalsIgnoreCase(rusList[i])) {
				
				result = transToList[i];
				break;
				
			}
			
		}
		
		byte[] byteString = result.getBytes(StandardCharsets.UTF_8);
		return new String (byteString, StandardCharsets.UTF_8);
		
	}//translate
	
}//class
