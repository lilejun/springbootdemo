package com.lilejun.nouseifelse.service;

public interface CacluteStrategy {
    //返回客户类型
    String getUserType();

    //进行折扣计算
    double cacluteSale(double fee);
}
