package com.ngm.bot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import com.ngm.service.ExchangeRateService;

@Component
public class ExchangeRateBot extends TelegramLongPollingBot {

    private final static Logger LOG = LoggerFactory.getLogger(ExchangeRateBot.class);

    private final static String START = "/start";
    private final static String USD = "/usd";
    private final static String EUR = "/eur";
    private final static String HELP = "/help";

    @Autowired
    private ExchangeRateService exchangeRateService;

    public ExchangeRateBot(@Value("${bot.token}") String botToken) {
        super(botToken);
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (!update.hasMessage() || !update.getMessage().hasText()) {
            return;
        }

        String message = update.getMessage().getText();
        Long chatId = update.getMessage().getChatId();


    }

    @Override
    public String getBotUsername() {
        return "NadyaVasyaBot";
    }

    private void sendMessage(Long chatId, String text) {
        String charIdStr = String.valueOf(chatId);
        var sendMessage = new SendMessage(charIdStr, text);

        try {
            execute(sendMessage);
        } catch (TelegramApiException apiException) {
            LOG.error("Ошибка отправки сообщения", apiException);
        }
    }
}