/**
 * Resource bundle for the Russian language from the Country of the Russian Federation that is utilized by the application.
 * Utilizes Alpha-2 of the ISO-3166 for country codes and ISO-639-2 for the language codes
 */
package com.github.masonBeattie99.EZ_Translate.resources;

import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

public class Localization_ru extends Localization{

	@Override
	protected Object handleGetObject(String key) {
		
		if(key.equals("startupNoti")) return "Файл конфигурации прочитан успешно, приложение запускается";
		if(key.equals("errFileNotFoundMsg")) return "Ошибка: FileNotFoundException.";
		if(key.equals("fileNotFoundMsg")) return "FileNotFoundException";
		if(key.equals("shutdownNoti")) return "Приложение успешно закрыто!";
		if(key.equals("addAppMsg")) return "Добавить приложение";
		if(key.equals("deleAppMsg")) return "Удалить приложение";
		if(key.equals("closeMsg")) return "Закрывать";
		if(key.equals("appliMsg")) return "Приложения";
		if(key.equals("appConfigMenuLabel")) return "Меню конфигурации приложения";
		if(key.equals("configAppBtn")) return "Настроить приложения";
		if(key.equals("configKeyBndBtn")) return "Настроить привязку клавиш";
		if(key.equals("configLocalBtn")) return "Настроить локализацию";
		if(key.equals("configsLabel")) return "Текущие конфигурации";
		if(key.equals("configMenuLabel")) return "Меню конфигурации";
		if(key.equals("configBtn")) return "Настройки конфигурации";
		if(key.equals("startBtn")) return "Начинать";
		if(key.equals("mainMenuLabel")) return "Меню ЭЗпереводить";
		if(key.equals("upOpenKeyBtn")) return "Обновить привязку открытого ключа";
		if(key.equals("upCloseKeyBtn")) return "Обновить привязку клавиш закрытия";
		if(key.equals("keyConfigMenuLabel")) return "Меню настройки привязки клавиш";
		if(key.equals("upLocalBtn")) return "Обновить локализацию";
		if(key.equals("localChoicesEng")) return "анг";
		if(key.equals("localChoicesGer")) return "нем";
		if(key.equals("localChoicesRus")) return "рус";
		if(key.equals("localConfigMenuLabel")) return "Меню настройки локализации";
		
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
				"localConfigMenuLabel"
				));
	}
	
}//class
