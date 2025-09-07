package com.ngm.configuration;

import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import com.ngm.bot.ExchangeRateBot;

@Configuration
public class ExchangeRateBotConfiguration {
    
    public TelegramBotsApi telegramBotsApi(ExchangeRateBot exchangeRateBot) throws TelegramApiException {
        TelegramBotsApi api = new TelegramBotsApi(DefaultBotSession.class);
        api.registerBot(exchangeRateBot);
        return api;
    }
}
