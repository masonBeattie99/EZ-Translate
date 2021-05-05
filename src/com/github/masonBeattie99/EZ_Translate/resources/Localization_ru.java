/**
 * Resource bundle for the Russian language from the Country of the Russian Federation that is utilized by the application.
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

public class Localization_ru extends Localization{

	@Override
	protected Object handleGetObject(String key) {
		
		if(key.equals("startupNoti")) return "Файл конфигурации прочитан успешно, приложение запускается";
		if(key.equals("errFileNotFoundMsg")) return "Ошибка: FileNotFoundException.";
		if(key.equals("fileNotFoundMsg")) return "FileNotFoundException";
		if(key.equals("shutdownNoti")) return "Приложение успешно закрыто!";
		if(key.equals("addAppMsg")) return "Добавить приложение";
		if(key.equals("deleAppMsg")) return "Удалить приложение";
		if(key.equals("closeBtn")) return "Закрывать";
		if(key.equals("appLabel")) return "Приложения";
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
		if(key.equals("errOpenKey")) return "Ошибка: недействительный открытый ключ";
		if(key.equals("errCloseKey")) return "Ошибка: недействительный ключ закрытия";
		if(key.equals("errCloseOpenKey")) return "Ошибка: недействительный ключ открытия и закрытия";
		if(key.equals("errNoKeys")) return "Ошибка: не настроены привязки клавиш";
		if(key.equals("startDetectBtn")) return "Начало чтения ввода с клавиатуры";
		if(key.equals("stopDetectBtn")) return "Чтение ввода с клавиатуры остановлено";
		if(key.equals("errIndex")) return "Ошибка: ошибка индекса";
		if(key.equals("stopBtn")) return "Стоп";
		if(key.equals("saveKeys")) return "Сохранить привязки клавиш";
		if(key.equals("transBtn")) return "Переведите";
		if(key.equals("transLabel")) return "Интерфейс перевода";
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
