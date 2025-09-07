package com.ngm.bot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class ExchangeRateBot extends TelegramLongPollingBot {
    public ExchangeRateBot(@Value("${bot.token}") String botToken) {
        super(botToken);
    }

    @Override
    public void onUpdateReceived(Update arg0) {

    }

    @Override
    public String getBotUsername() {
        return "NadyaVasyaBot";
    }

}