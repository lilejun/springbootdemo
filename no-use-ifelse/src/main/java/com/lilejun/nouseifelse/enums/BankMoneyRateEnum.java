package com.lilejun.nouseifelse.enums;

import com.lilejun.nouseifelse.service.BankMoneyRateService;


/**
 *  @author: lejun.li
 *  @Date: 2019/12/27 下午4:50
 *  @Description:利息枚举类实现,消除if  else
 */
public enum BankMoneyRateEnum implements BankMoneyRateService {
    /*
     *工商银行
     */
    ICBC_BANK{
        @Override
        public Double opBankMoneyRate(Double money) {
            return money + money*0.05;
        }
    },

    /*
     *农业银行
     */
    ABC_BANK{
        @Override
        public Double opBankMoneyRate(Double money) {
            return money+money*0.1;
        }
    },

    /*
     * 建设银行
     */
    CCB{
        @Override
        public Double opBankMoneyRate(Double money) {
            return money+money*0.15;
        }
    };
}
