package com.lilejun.nouseifelse.service.impl;

import com.lilejun.nouseifelse.service.BankMoneyRateOpByFactoryService;
import org.springframework.stereotype.Service;

@Service
public class ABCBankRateServiceImpl implements BankMoneyRateOpByFactoryService {
    @Override
    public Double opRateByBankEnum(Double money) {
        return money+money*0.1;
    }
}
