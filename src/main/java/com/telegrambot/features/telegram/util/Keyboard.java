package com.telegrambot.features.telegram.util;

import com.telegrambot.features.currency.dto.Currency;
import com.telegrambot.features.settings.Settings;
import lombok.experimental.UtilityClass;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.telegrambot.features.currency.dto.Currency.EUR;
import static com.telegrambot.features.currency.dto.Currency.USD;
import static com.telegrambot.features.telegram.util.BotConstants.*;

@UtilityClass
public class Keyboard {

    public static InlineKeyboardMarkup setStartLanguageKeyboard() {
        List<List<InlineKeyboardButton>> buttons = new ArrayList<>();

        buttons.add(Collections.singletonList(InlineKeyboardButton.builder()
                .text("Українська")
                .callbackData("ukrLang")
                .build()));

        buttons.add(Collections.singletonList(InlineKeyboardButton.builder()
                .text("English")
                .callbackData("englLang")
                .build()));
        return InlineKeyboardMarkup.builder().keyboard(buttons).build();
    }
    public static InlineKeyboardMarkup setStartKeyboard(Settings settings) {
        List<List<InlineKeyboardButton>> buttons = new ArrayList<>();

        buttons.add(Collections.singletonList(InlineKeyboardButton.builder()
                .text(getNameButton(settings.getLanguage(), "INFO"))
                .callbackData("INFO")
                .build()));

        buttons.add(Collections.singletonList(InlineKeyboardButton.builder()
                .text(getNameButton(settings.getLanguage(), "SETTINGS"))
                .callbackData("SETTINGS")
                .build()));
        return InlineKeyboardMarkup.builder().keyboard(buttons).build();
    }

    private String getLanguageButton(Settings settings, String language, String name){

        return settings.getLanguage().equals(language) ? (Icon.CHECK.get() + name) : name;
    }

    public static InlineKeyboardMarkup setLanguageKeyboard(Settings settings) {
        List<List<InlineKeyboardButton>> buttons = getLanguageButtons(settings);
        return InlineKeyboardMarkup.builder().keyboard(buttons).build();
    }

    public static List<List<InlineKeyboardButton>> getLanguageButtons(Settings settings) {
        List<List<InlineKeyboardButton>> buttons = new ArrayList<>();

        String engLang = getNameButton(settings.getLanguage(), "ENG_LANG");
        String ukrLabg = getNameButton(settings.getLanguage(), "UKR_LANG");

        buttons.add(Collections.singletonList(InlineKeyboardButton.builder()
                .text(getLanguageButton(settings, "eng", engLang))
                .callbackData("eng")
                .build()));

        buttons.add(Collections.singletonList(InlineKeyboardButton.builder()
                .text(getLanguageButton(settings, "ukr", ukrLabg))
                .callbackData("ukr")
                .build()));
        buttons.add(Arrays.asList(
                InlineKeyboardButton.builder().text(Icon.BACK.get()).callbackData("BACK").build(),
                InlineKeyboardButton.builder().text(Icon.HOME.get()).callbackData("HOME").build()));
        return buttons;
    }

    public static InlineKeyboardMarkup setSettingsKeyboard(Settings settings) {
        List<List<InlineKeyboardButton>> buttons = new ArrayList<>();

        buttons.add(Collections.singletonList(InlineKeyboardButton.builder()
                .text(getNameButton(settings.getLanguage(), "ROUNDED_INDEX"))
                .callbackData("ROUNDED_INDEX")
                .build()));
        buttons.add(Collections.singletonList(InlineKeyboardButton.builder()
                .text(getNameButton(settings.getLanguage(), "BANK"))
                .callbackData("BANK")
                .build()));
        buttons.add(Collections.singletonList(InlineKeyboardButton.builder()
                .text(getNameButton(settings.getLanguage(), "CURRENCY"))
                .callbackData("CURRENCY")
                .build()));
        buttons.add(Collections.singletonList(InlineKeyboardButton.builder()
                .text(getNameButton(settings.getLanguage(), "REMINDER_TIME"))
                .callbackData("REMINDER_TIME")
                .build()));
        buttons.add(Collections.singletonList(InlineKeyboardButton.builder()
                .text(getNameButton(settings.getLanguage(), "LANGUAGE"))
                .callbackData("LANGUAGE")
                .build()));
        buttons.add(Collections.singletonList(InlineKeyboardButton.builder()
                .text(Icon.HOME.get())
                .callbackData("HOME")
                .build()));

        return InlineKeyboardMarkup.builder().keyboard(buttons).build();
    }

    private String getRoundButton(Settings settings, int name){

        return (settings.getRoundDigit() == name) ? (Icon.CHECK.get() + name) : String.valueOf(name);
    }

    public static InlineKeyboardMarkup setRoundRateKeyboard(Settings settings) {

        List<List<InlineKeyboardButton>> buttons = getRoundRateButtons(settings);

        return InlineKeyboardMarkup.builder().keyboard(buttons).build();
    }

    public static List<List<InlineKeyboardButton>> getRoundRateButtons(Settings settings) {
        List<List<InlineKeyboardButton>> buttons = new ArrayList<>();
        String roundButton2 = getRoundButton(settings, 2);
        String roundButton3 = getRoundButton(settings, 3);
        String roundButton4 = getRoundButton(settings, 4);


        buttons.add(Collections.singletonList(InlineKeyboardButton.builder()
                        .text(roundButton2)
                        .callbackData("2")
                        .build()));

        buttons.add(Collections.singletonList(InlineKeyboardButton.builder()
                        .text(roundButton3)
                        .callbackData("3")
                        .build()));

        buttons.add(Collections.singletonList(InlineKeyboardButton.builder()
                        .text(roundButton4)
                        .callbackData("4")
                        .build()));
        buttons.add(Arrays.asList(
                InlineKeyboardButton.builder().text(Icon.BACK.get()).callbackData("BACK").build(),
                InlineKeyboardButton.builder().text(Icon.HOME.get()).callbackData("HOME").build()));
        return buttons;
    }

    private String getBankButton(Settings settings, String bankName, String savedBankName){

            String name = getNameButton(settings.getLanguage(), savedBankName);
            String result = settings.getBank().getName().equals(bankName) ? (Icon.CHECK.get() + name) : name.toString();


        return result;
    }


    public static InlineKeyboardMarkup setBankKeyboard(Settings settings) {
        List<List<InlineKeyboardButton>> buttons = getBankButtons(settings);

        return InlineKeyboardMarkup.builder().keyboard(buttons).build();
    }

    public static List<List<InlineKeyboardButton>> getBankButtons(Settings settings) {
        List<List<InlineKeyboardButton>> buttons = new ArrayList<>();

        buttons.add(Collections.singletonList(InlineKeyboardButton.builder()
//                .text(getBankButton(settings, "PrivatBank"))
                .text(getBankButton(settings, "PrivatBank", "PRIVAT_BANK"))
                .callbackData("privat")
                .build()));
        buttons.add(Collections.singletonList(InlineKeyboardButton.builder()
//                .text(getBankButton(settings, "MonoBank"))
                .text(getBankButton(settings, "MonoBank", "MONOBANK"))
                .callbackData("mono")
                .build()));
        buttons.add(Collections.singletonList(InlineKeyboardButton.builder()
//                .text(getBankButton(settings, "NBU"))
                .text(getBankButton(settings, "NBU", "NBU"))
                .callbackData("nbu")
                .build()));
        buttons.add(Arrays.asList(
                InlineKeyboardButton.builder().text(Icon.BACK.get()).callbackData("BACK").build(),
                InlineKeyboardButton.builder().text(Icon.HOME.get()).callbackData("HOME").build()));
        return buttons;
    }

    private String getCurrencyButton(Settings settings, String name){

        return settings.getCurrencies().contains(Currency.valueOf(name)) ?
                (Icon.CHECK.get() + name) : name;

    }


    public static InlineKeyboardMarkup setCurrencyKeyboard(Settings settings) {
        List<List<InlineKeyboardButton>> buttons = getCurrencyButtons(settings);
        return InlineKeyboardMarkup.builder().keyboard(buttons).build();
    }

    public static List<List<InlineKeyboardButton>> getCurrencyButtons(Settings settings) {
        List<List<InlineKeyboardButton>> buttons = new ArrayList<>();
        buttons.add(Collections.singletonList(InlineKeyboardButton.builder()
                .text(getCurrencyButton(settings, USD.name()))
                .callbackData("USD")
                .build()));
        buttons.add(Collections.singletonList(InlineKeyboardButton.builder()
                .text(getCurrencyButton(settings, EUR.name()))
                .callbackData("EUR")
                .build()));
        buttons.add(Arrays.asList(
                InlineKeyboardButton.builder().text(Icon.BACK.get()).callbackData("BACK").build(),
                InlineKeyboardButton.builder().text(Icon.HOME.get()).callbackData("HOME").build()));
        return buttons;
    }

    public static InlineKeyboardMarkup setReminderKeyboard(Settings settings) {
        List<List<InlineKeyboardButton>> buttons = getReminderButtons(settings);

        return InlineKeyboardMarkup.builder().keyboard(buttons).build();
    }

    public static List<List<InlineKeyboardButton>> getReminderButtons(Settings settings) {
        List<List<InlineKeyboardButton>> buttons = new ArrayList<>();

        String cancelReminder = BotConstants.getNameButton(settings.getLanguage(), "CANCEL_REMINDER");


        buttons.add(Arrays.asList(
                InlineKeyboardButton.builder()
                        .text(getReminderButton(settings, 9))
                        .callbackData("9")
                        .build(),
                InlineKeyboardButton.builder()
                        .text(getReminderButton(settings, 10))
                        .callbackData("10")
                        .build(),
                InlineKeyboardButton.builder()
                        .text(getReminderButton(settings, 11))
                        .callbackData("11")
                        .build()));

        buttons.add(Arrays.asList(
                InlineKeyboardButton.builder()
                        .text(getReminderButton(settings, 12))
                        .callbackData("12")
                        .build(),
                InlineKeyboardButton.builder()
                        .text(getReminderButton(settings, 13))
                        .callbackData("13")
                        .build(),
                InlineKeyboardButton.builder()
                        .text(getReminderButton(settings, 14))
                        .callbackData("14")
                        .build()));

        buttons.add(Arrays.asList(
                InlineKeyboardButton.builder()
                        .text(getReminderButton(settings, 15))
                        .callbackData("15")
                        .build(),
                InlineKeyboardButton.builder()
                        .text(getReminderButton(settings, 16))
                        .callbackData("16")
                        .build(),
                InlineKeyboardButton.builder()
                        .text(getReminderButton(settings, 17))
                        .callbackData("17")
                        .build()));

        buttons.add(Arrays.asList(
                InlineKeyboardButton.builder()
                        .text(getReminderButton(settings, 18))
                        .callbackData("18")
                        .build(),
                InlineKeyboardButton.builder().text(cancelReminder).callbackData("0").build()));

        buttons.add(Arrays.asList(
                InlineKeyboardButton.builder().text(Icon.BACK.get()).callbackData("BACK").build(),
                InlineKeyboardButton.builder().text(Icon.HOME.get()).callbackData("HOME").build()));
        return buttons;
    }

    private String getReminderButton(Settings settings, int name){

        return settings.getReminderTime() == name ?
                (Icon.CHECK.get() + name) : String.valueOf(name);

    }
}
