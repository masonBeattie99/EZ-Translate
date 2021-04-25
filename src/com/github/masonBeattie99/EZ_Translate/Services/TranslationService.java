/**
 * Contains interactions with language detection and translation library.
 * @author mason
 *
 */
package com.github.masonBeattie99.EZ_Translate.services;

import java.nio.charset.StandardCharsets;
import java.io.UnsupportedEncodingException;

public class TranslationService {
	
	public TranslationService() {
		
	}//constructor
	
	public static String translate(String transTo, String phrase) {
		
		final String NO_SUPP = "Error: Language Not Supported!";
		
		String[] engList = {"Hello", "How are you?", "Good morning", "Good day", "Good night", "Goodbye"};
		String[] gerList = {"Hallo", "Wie gehts?", "Guten Morgen", "Guten Tag", "Guten Nacht", "Auf Wiedersehen"};
		String[] rusList = {"Привет", "Как дела?", "Доброе утро", "Добрый день", "Спокойной ночи","До свидания"};
		
		String[] transToList = new String[6];
		
		//set result to deaful to no support
		String result = NO_SUPP;
		
		
		if(transTo.equals("eng")) {
			transToList = engList.clone();
		}
		else if(transTo.equals("ger")) {
			transToList = gerList.clone();
		}
		else if(transTo.equals("rus")) {
			transToList = rusList.clone();
		}
		
		//german based transTo. Only ger is replaced with deu
		
		else if(transTo.equals("deu")) {
			transToList = gerList.clone();
		}
		
		//russian based transTo
		
		else if(transTo.equals("анг")) {
			transToList = engList.clone();
		}
		else if(transTo.equals("нем")) {
			transToList = gerList.clone();
		}
		else if(transTo.equals("рус")) {
			transToList = rusList.clone();
		}
		
		//if nothing else
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
		
		try {
			byte[] byteString = result.getBytes("UTF-8");
			return new String (byteString, StandardCharsets.UTF_8);
		}
		catch(UnsupportedEncodingException e) {
			return NO_SUPP;
		}
		
		
		
	}//translate
	
}//class
