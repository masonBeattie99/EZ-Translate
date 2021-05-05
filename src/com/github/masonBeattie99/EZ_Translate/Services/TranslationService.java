/**
 * Contains interactions with language detection and translation library.
 * 
 * @author Mason Beattie
 * 
 * 
 * Copyright 2021 Mason Beattie
 *	
 *	Licensed under the Apache License, Version 2.0 (the "License");
 *	you may not use this file except in compliance with the License.
 *	You may obtain a copy of the License at
 *	
 *	    http://www.apache.org/licenses/LICENSE-2.0
 *	
 *	Unless required by applicable law or agreed to in writing, software
 *	distributed under the License is distributed on an "AS IS" BASIS,
 *	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *	See the License for the specific language governing permissions and
 *	limitations under the License.
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
