package com.lilejun.nouseifelse.service.impl;

import com.lilejun.nouseifelse.service.BankMoneyRateOpByFactoryService;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class BankMoneyRateOpFactory {
    private static Map<String, BankMoneyRateOpByFactoryService> factoryServiceMap = new HashMap<>();
    //此处也可以使用构造器初始化
    static {
        factoryServiceMap.put("ICBC_BANK",new ICBCBanKRateServiceImpl());
        factoryServiceMap.put("ABC_BANK",new ABCBankRateServiceImpl());
        factoryServiceMap.put("CCB",new CCBBankRateServiceImpl());

    }
    public static BankMoneyRateOpByFactoryService getByName(String bankType){
        return factoryServiceMap.get(bankType);
    }
}
