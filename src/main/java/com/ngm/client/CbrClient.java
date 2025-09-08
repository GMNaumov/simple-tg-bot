package com.ngm.client;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.ngm.exception.ServiceException;

import okhttp3.OkHttpClient;
import okhttp3.Request;

@Component
public class CbrClient {
    @Autowired
    public OkHttpClient okHttpClient;

    @Value("${cbr.currency.rates.xml.url}")
    private String cbrCurrencyRatesXmlUrl;

    public Optional<String> getCurrencyRatesXml() throws ServiceException {
        var request = new Request.Builder()
                .url(cbrCurrencyRatesXmlUrl)
                .build();

        try (var responce = okHttpClient.newCall(request).execute()) {
            var body = responce.body();
            return body == null ? Optional.empty() : Optional.of(body.string());
        } catch (IOException exception) {
            throw new ServiceException("Не удалось получить курсы валют от ЦБ...", exception);
        }
    }
}