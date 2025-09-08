package com.ngm.service.impl;

import java.io.StringReader;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.meta.api.objects.Document;
import org.xml.sax.InputSource;

import com.ngm.client.CbrClient;
import com.ngm.exception.ServiceException;
import com.ngm.service.ExchangeRateService;

public class ExchangeRateServiceImpl implements ExchangeRateService {
    private static final String USD_XPATH = "/ValCurs//Valute[@ID='R01235']/Value";
    private static final String EUR_XPATH = "/ValCurs//Valute[@ID='R01239']/Value";

    @Autowired
    private CbrClient cbrClient;

    @Override
    public String getUSDExchangeRate() throws ServiceException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUSDExchangeRate'");
    }

    @Override
    public String getEUREchangeRate() throws ServiceException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getEUREchangeRate'");
    }
    
    private static String extractCurrencyValueFromXML(String xml, String xpathExpression) throws ServiceException {
        var source = new InputSource(new StringReader(xml));

        try {
            var xpath = XPathFactory.newInstance().newXPath();
            var document = (Document) xpath.evaluate("/", source, XPathConstants.NODE);

            return xpath.evaluate(xpathExpression, document);
        } catch (XPathExpressionException exception) {
            throw new ServiceException("Ошибка парсинга XML", exception);
        }
    }
}
