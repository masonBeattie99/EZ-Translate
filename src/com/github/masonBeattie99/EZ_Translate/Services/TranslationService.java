/**
 * Contains interactions with language detection and translation library.
 * @author mason
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
