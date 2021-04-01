/**
 * Resource bundle for the German language from the Country of the Federal Republic of Germany that is utilized by the application.
 * Utilizes Alpha-2 of the ISO-3166 for country codes and ISO-639-2 for the language codes
 */
package com.github.masonBeattie99.EZ_Translate.resources;

import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

public class Localization_de extends Localization{

	@Override
	protected Object handleGetObject(String key) {
		
		if(key.equals("startupNoti")) return "Lesen der Konfigurationsdatei erfolgreich, Anwendung wird gestartet";
		if(key.equals("errFileNotFoundMsg")) return "Fehler: FileNotFoundException.";
		if(key.equals("fileNotFoundMsg")) return "FileNotFoundException";
		if(key.equals("shutdownNoti")) return "Anwendung wurde erfolgreich beendet!";
		if(key.equals("addAppMsg")) return "Anwendung hinzuf�gen";
		if(key.equals("deleAppMsg")) return "Anwendung l�schen";
		if(key.equals("closeMsg")) return "Schlie�en";
		if(key.equals("appliMsg")) return "Anwendungen";
		if(key.equals("appConfigMenuLabel")) return "Anwendungskonfigurationsmen�";
		if(key.equals("configAppBtn")) return "Anwendungen konfigurieren";
		if(key.equals("configKeyBndBtn")) return "Konfigurieren Sie die Tastenkombinationen";
		if(key.equals("configLocalBtn")) return "Konfigurieren Sie die Lokalisierung";
		if(key.equals("configMenuLabel")) return "Konfigurationsmen�";
		if(key.equals("configBtn")) return "Konfigurationseinstellungen";
		if(key.equals("startBtn")) return "Anfang";
		if(key.equals("mainMenuLabel")) return "EZTranslate-Men�";
		if(key.equals("upOpenKeyBtn")) return "Aktualisieren Sie die offene Schl�sselbindung";
		if(key.equals("upCloseKeyBtn")) return "Aktualisieren Sie die schlie�en Schl�sselbindung ";
		if(key.equals("keyConfigMenuLabel")) return "Tastaturkonfigurationsmen�";
		if(key.equals("upLocalBtn")) return "Lokalisierung aktualisieren";
		if(key.equals("localChoices")) return "\"eng\", \"deu\", \"rus\"";
		if(key.equals("localConfigMenuLabel")) return "Konfigurationsmen� f�r die Lokalisierung";
		
		return null;
	}
	
	@Override
	protected Set<String> handleKeySet() {
		return new HashSet<String>(Arrays.asList(
				"startupNoti",		
				"errFileNotFoundMsg",
				"fileNotFoundMsg",
				"shutdownNoti",
				"addAppMsg",
				"deleAppMsg",
				"closeMsg",
				"appliMsg",
				"appConfigMenuLabel",
				"configAppBtn",
				"configKeyBndBtn",
				"configLocalBtn",
				"configMenuLabel",
				"configBtn",
				"startBtn",
				"mainMenuLabel",
				"upOpenKeyBtn",
				"upCloseKeyBtn",
				"keyConfigMenuLabel",
				"upLocalBtn",
				"localChoices",
				"localConfigMenuLabel"
				));
	}
	
}//class
