package com.telegrambot.features.telegram;

import lombok.experimental.UtilityClass;

import java.nio.charset.StandardCharsets;

@UtilityClass
public class BotConstants {
    public static final String BOT_NAME = "name";
    public static final String BOT_TOKEN = "token";
    public static final String  INFO = new String("Отримати інфо".getBytes(), StandardCharsets.UTF_8);
    public static final String SETTINGS = new String("Налаштування".getBytes(), StandardCharsets.UTF_8);

    public static final String PRIVAT_URL = "https://api.privatbank.ua/p24api/pubinfo?json&exchange&coursid=5";
    public static final String NBU_API_URL = "https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?json";

    public static final String  MONO_URL = "https://api.monobank.ua/bank/currency";
}
