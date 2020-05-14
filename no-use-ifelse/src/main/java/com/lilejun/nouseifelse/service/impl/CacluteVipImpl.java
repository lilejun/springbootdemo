package com.lilejun.nouseifelse.service.impl;

import com.lilejun.nouseifelse.service.CacluteStrategy;
import org.springframework.stereotype.Service;

@Service
public class CacluteVipImpl implements CacluteStrategy {
    @Override
    public String getUserType() {
        return "vip";
    }

    @Override
    public double cacluteSale(double fee) {
        return fee*0.8;
    }
}
