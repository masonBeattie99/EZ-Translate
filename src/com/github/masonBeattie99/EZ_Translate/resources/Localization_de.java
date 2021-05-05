/**
 * Resource bundle for the German language from the Country of the Federal Republic of Germany that is utilized by the application.
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
		if(key.equals("addAppMsg")) return "Anwendung hinzufügen";
		if(key.equals("deleAppMsg")) return "Anwendung löschen";
		if(key.equals("closeBtn")) return "Schließen";
		if(key.equals("appLabel")) return "Anwendungen";
		if(key.equals("appConfigMenuLabel")) return "Anwendungskonfigurationsmenü";
		if(key.equals("configAppBtn")) return "Anwendungen konfigurieren";
		if(key.equals("configKeyBndBtn")) return "Konfigurieren Sie die Tastenkombinationen";
		if(key.equals("configLocalBtn")) return "Konfigurieren Sie die Lokalisierung";
		if(key.equals("configsLabel")) return "Aktuelle Konfigurationen";
		if(key.equals("configMenuLabel")) return "Konfigurationsmenü";
		if(key.equals("configBtn")) return "Konfigurationseinstellungen";
		if(key.equals("startBtn")) return "Anfang";
		if(key.equals("mainMenuLabel")) return "EZTranslate-Menü";
		if(key.equals("upOpenKeyBtn")) return "Aktualisieren Sie die offene Schlüsselbindung";
		if(key.equals("upCloseKeyBtn")) return "Aktualisieren Sie die schließen Schlüsselbindung ";
		if(key.equals("keyConfigMenuLabel")) return "Tastaturkonfigurationsmenü";
		if(key.equals("upLocalBtn")) return "Lokalisierung aktualisieren";
		if(key.equals("localChoicesEng")) return "eng";
		if(key.equals("localChoicesGer")) return "deu";
		if(key.equals("localChoicesRus")) return "rus";
		if(key.equals("localConfigMenuLabel")) return "Konfigurationsmenü für die Lokalisierung";
		if(key.equals("errOpenKey")) return "Fehler: Ungültiger offener Schlüssel";
		if(key.equals("errCloseKey")) return "Fehler: Ungültiger Schließschlüssel";
		if(key.equals("errCloseOpenKey")) return "Fehler: Ungültiger Öffnungs- und Schließschlüssel";
		if(key.equals("errNoKeys")) return "Fehler: Keine Schlüsselbindungen konfiguriert";
		if(key.equals("startDetectBtn")) return "Starten der Tastatureingabe";
		if(key.equals("stopDetectBtn")) return "Lesen der Tastatureingabe gestoppt";
		if(key.equals("errIndex")) return "Fehler: Indexfehler";
		if(key.equals("stopBtn")) return "Halt";
		if(key.equals("saveKeys")) return "Keybinds speichern";
		if(key.equals("transBtn")) return "Übersetzen";
		if(key.equals("transLabel")) return "Übersetzungsschnittstelle";
		
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
