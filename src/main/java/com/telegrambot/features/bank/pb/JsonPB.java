package com.telegrambot.features.bank.pb;

import com.telegrambot.features.bank.Currency;
import lombok.Data;
@Data
public class JsonPB {
        private Currency ccy;
        private Currency base_ccy;
        private float buy;
        private float sale;
   
}
