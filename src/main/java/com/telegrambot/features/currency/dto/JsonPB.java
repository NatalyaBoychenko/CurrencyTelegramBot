package com.telegrambot.features.currency.dto;

import com.telegrambot.features.currency.dto.Currency;
import lombok.Data;
@Data
public class JsonPB {
    private Currency ccy;
    private Currency base_ccy;
    private float buy;
    private float sale;

}


