/**
 * Contains interactions with language detection and translation library.
 * @author mason
 *
 */
package com.github.masonBeattie99.EZ_Translate.services;
public class TranslationService {
	
	String[] engList = {"Hello", "How are you?", "Good morning", "Good day", "Good night", "Goodbye"};
	String[] germList = {"Hallo", "Wie gehts?", "Guten Morgen", "Guten Tag", "Guten Nacht", "Tschüss"};
	String[] rusList = {"Привет", "Как дела?", "Доброе утро", "Добрый день", "Добрый вечер","до свидания"};
	
	public TranslationService() {
		
	}//constructor
	
	public static String translate(String languageFrom, String languageTo, String phrase) {
		
		String result = "";
		
		return result;
		
	}//translate
	
}//class
