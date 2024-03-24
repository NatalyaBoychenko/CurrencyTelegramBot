package com.telegrambot.features.telegram.command;

import com.telegrambot.features.settings.Settings;
import com.telegrambot.features.settings.StorageInMemoryRepo;
import com.telegrambot.features.telegram.CurrencyTelegramBot;
import com.telegrambot.features.telegram.util.Keyboard;
import lombok.SneakyThrows;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageReplyMarkup;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

public class Reminder {

    public EditMessageReplyMarkup handleCallbackReminder(CallbackQuery callbackQuery, Settings settings, StorageInMemoryRepo storageInMemory) {
        String answer = callbackQuery.getData();
        Message message = (Message) callbackQuery.getMessage();

        switch (answer) {
            case "9" -> {
                settings.setReminderTime(9);
                storageInMemory.addSetting(settings.getChatId(), settings);
                System.out.println("successful 9");
            }
            case "10" -> {
                settings.setReminderTime(10);
                storageInMemory.addSetting(settings.getChatId(), settings);
                System.out.println("successful 10");
            }
            case "11" -> {
                settings.setReminderTime(11);
                storageInMemory.addSetting(settings.getChatId(), settings);
            }
            case "12" -> {
                settings.setReminderTime(12);
                storageInMemory.addSetting(settings.getChatId(), settings);
                System.out.println("12");
            }
            case "13" -> {
                settings.setReminderTime(13);
                storageInMemory.addSetting(settings.getChatId(), settings);
            }
            case "14" -> {
                settings.setReminderTime(14);
                storageInMemory.addSetting(settings.getChatId(), settings);
            }
            case "15" -> {
                settings.setReminderTime(15);
                storageInMemory.addSetting(settings.getChatId(), settings);
            }
            case "16" -> {
                settings.setReminderTime(16);
                storageInMemory.addSetting(settings.getChatId(), settings);
            }
            case "17" -> {
                settings.setReminderTime(17);
                storageInMemory.addSetting(settings.getChatId(), settings);
            }
            case "18" -> {
                settings.setReminderTime(18);
                storageInMemory.addSetting(settings.getChatId(), settings);
            }
            case "0" -> {
                settings.setReminderTime(26);
                storageInMemory.addSetting(settings.getChatId(), settings);
            }
            default -> {
                System.out.println();
            }
        }

        return EditMessageReplyMarkup.builder()
                .chatId(message.getChatId())
                .messageId(message.getMessageId())
                .replyMarkup(InlineKeyboardMarkup.builder()
                        .keyboard(Keyboard.getReminderButtons(settings))
                        .build())
                .build();
    }



}
