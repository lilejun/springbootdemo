package com.lilejun.nouseifelse.service.impl;

import com.lilejun.nouseifelse.service.CacluteStrategy;
import org.springframework.stereotype.Service;

@Service
public class CacluteNomarlImpl implements CacluteStrategy {
    @Override
    public String getUserType() {
        return "nomarl";
    }

    @Override
    public double cacluteSale(double fee) {
        //此处可能会有500行计算相关代码
        return fee*0.9;
    }
}
