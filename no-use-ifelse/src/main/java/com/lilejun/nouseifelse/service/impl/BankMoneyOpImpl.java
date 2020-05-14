package com.lilejun.nouseifelse.service.impl;

import com.lilejun.nouseifelse.enums.BankMoneyRateEnum;
import com.lilejun.nouseifelse.service.OpBankRateService;
import org.springframework.stereotype.Service;

@Service
public class BankMoneyOpImpl implements OpBankRateService {
    @Override
    public Double opRateByBankEnum(String bankEnum,Double money) {
        return BankMoneyRateEnum.valueOf(bankEnum).opBankMoneyRate(money);
    }
}
