/**
 * Resource bundle for the German language from the Country of the Federal Republic of Germany that is utilized by the application.
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
		if(key.equals("closeBtn")) return "Schlie�en";
		if(key.equals("appLabel")) return "Anwendungen";
		if(key.equals("appConfigMenuLabel")) return "Anwendungskonfigurationsmen�";
		if(key.equals("configAppBtn")) return "Anwendungen konfigurieren";
		if(key.equals("configKeyBndBtn")) return "Konfigurieren Sie die Tastenkombinationen";
		if(key.equals("configLocalBtn")) return "Konfigurieren Sie die Lokalisierung";
		if(key.equals("configsLabel")) return "Aktuelle Konfigurationen";
		if(key.equals("configMenuLabel")) return "Konfigurationsmen�";
		if(key.equals("configBtn")) return "Konfigurationseinstellungen";
		if(key.equals("startBtn")) return "Anfang";
		if(key.equals("mainMenuLabel")) return "EZTranslate-Men�";
		if(key.equals("upOpenKeyBtn")) return "Aktualisieren Sie die offene Schl�sselbindung";
		if(key.equals("upCloseKeyBtn")) return "Aktualisieren Sie die schlie�en Schl�sselbindung ";
		if(key.equals("keyConfigMenuLabel")) return "Tastaturkonfigurationsmen�";
		if(key.equals("upLocalBtn")) return "Lokalisierung aktualisieren";
		if(key.equals("localChoicesEng")) return "eng";
		if(key.equals("localChoicesGer")) return "deu";
		if(key.equals("localChoicesRus")) return "rus";
		if(key.equals("localConfigMenuLabel")) return "Konfigurationsmen� f�r die Lokalisierung";
		if(key.equals("errOpenKey")) return "Fehler: Ung�ltiger offener Schl�ssel";
		if(key.equals("errCloseKey")) return "Fehler: Ung�ltiger Schlie�schl�ssel";
		if(key.equals("errCloseOpenKey")) return "Fehler: Ung�ltiger �ffnungs- und Schlie�schl�ssel";
		if(key.equals("errNoKeys")) return "Fehler: Keine Schl�sselbindungen konfiguriert";
		if(key.equals("startDetectBtn")) return "Starten der Tastatureingabe";
		if(key.equals("stopDetectBtn")) return "Lesen der Tastatureingabe gestoppt";
		if(key.equals("errIndex")) return "Fehler: Indexfehler";
		if(key.equals("stopBtn")) return "Halt";
		if(key.equals("saveKeys")) return "Keybinds speichern";
		if(key.equals("transBtn")) return "�bersetzen";
		if(key.equals("transLabel")) return "�bersetzungsschnittstelle";
		
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
				"closeBtn",
				"appLabel",
				"appConfigMenuLabel",
				"configAppBtn",
				"configKeyBndBtn",
				"configLocalBtn",
				"configsLabel",
				"configMenuLabel",
				"configBtn",
				"startBtn",
				"mainMenuLabel",
				"upOpenKeyBtn",
				"upCloseKeyBtn",
				"keyConfigMenuLabel",
				"upLocalBtn",
				"localChoicesEng",
				"localChoicesGer",
				"localChoicesRus",
				"localConfigMenuLabel",
				"errOpenKey",
				"errCloseKey",
				"errCloseOpenKey",
				"errNoKeys",
				"startDetectBtn",
				"stopDetectBtn",
				"errIndex",
				"stopBtn",
				"saveKeys",
				"transBtn",
				"transLabel"
				));
	}
	
}//class
