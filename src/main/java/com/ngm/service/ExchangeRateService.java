package com.ngm.service;

import com.ngm.exception.ServiceException;

public interface ExchangeRateService {
    String getUSDExchangeRate() throws ServiceException;

    String getEUREchangeRate() throws ServiceException;
}
