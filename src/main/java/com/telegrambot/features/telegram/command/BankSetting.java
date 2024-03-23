package com.telegrambot.features.telegram.command;

import com.telegrambot.features.currency.MonoBankCurrencyService;
import com.telegrambot.features.currency.NBUService;
import com.telegrambot.features.currency.PrivatBankCurrencyService;
import com.telegrambot.features.settings.Settings;
import com.telegrambot.features.settings.StorageInMemoryRepo;
import com.telegrambot.features.telegram.CurrencyTelegramBot;
import com.telegrambot.features.telegram.util.BotConstants;
import com.telegrambot.features.telegram.util.Keyboard;
import lombok.SneakyThrows;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageReplyMarkup;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

import java.util.Map;

import static com.telegrambot.features.telegram.util.BotConstants.*;

public class BankSetting {
    @SneakyThrows
        public void handleCallbackRoundRate(CallbackQuery callbackQuery, Settings settings, StorageInMemoryRepo storageInMemory, CurrencyTelegramBot bot) {

            String answer = callbackQuery.getData();
            Integer messageId = callbackQuery.getMessage().getMessageId();

            String mono = BotConstants.getNameButton(settings.getLanguage(), "MONOBANK");
            String nbu = BotConstants.getNameButton(settings.getLanguage(), "NBU");
            String privat = BotConstants.getNameButton(settings.getLanguage(), "PRIVAT_BANK");


        if (answer.equals(MONOBANK)) {

//                settings.setBank(new MonoBankCurrencyService());
                settings.setBank(new MonoBankCurrencyService());
                storageInMemory.addSetting(settings.getChatId(), settings);
                System.out.println("successful");
            } else if (answer.equals(NBU)) {
//                settings.setBank(new NBUService());
                settings.setBank(new NBUService());
                storageInMemory.addSetting(settings.getChatId(), settings);
                System.out.println("successful");
            }else if (answer.equals(PRIVAT_BANK)) {
//            settings.setBank(new PrivatBankCurrencyService());
            settings.setBank(new PrivatBankCurrencyService());
            storageInMemory.addSetting(settings.getChatId(), settings);
            System.out.println("successful");
            } else  {
            System.out.println();
        }

            InlineKeyboardMarkup updatedMarkup = Keyboard.setBankKeyboard(answer, settings);

            EditMessageReplyMarkup editMessageReplyMarkup = EditMessageReplyMarkup.builder()
                    .chatId(settings.getChatId())
                    .messageId(messageId)
                    .replyMarkup(updatedMarkup)
                    .build();

            bot.execute(editMessageReplyMarkup);
    }




}
