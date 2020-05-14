package com.lilejun.nouseifelse.service.impl;

import com.lilejun.nouseifelse.service.CacluteStrategy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class CaculateMoney {

    /**
     *  根据不同客户有不同折扣
     * @param type 用户类型：nomarl(普通客户)、vip、vvip
     * @param fee 原价
     * @return
     */
/*    public double cacluteMoneyByUserType(String type ,double fee){
        //if else 写法
        if("nomarl".equals(type)){
            return fee*0.9;
        }else if("vip".equals(type)){
            return fee*0.8;
        }else if("svip".equals(type)){
            return fee*0.7;
        }
        return fee;
    }*/
    //以上写法挡if else过多时会很烦，而且中间的计算代码还可能根据各个不同情况很复杂，因此，
    //可以使用策略模式进行修改
    /**
     * 1、定义一个统一的策略接口
     * 2、每个算法都去实现这个接口
     * 3、在调用类中的构造方法中初始化这几个实现类
     */
    /**
     * spring 也是这么转载初始化的一些bean的
     */
    Map<String,CacluteStrategy> map = new ConcurrentHashMap<>();

    //使用构造器初始化该策略类的子类

    public CaculateMoney(List<CacluteStrategy> strategyList) {
        for (CacluteStrategy strategy:strategyList) {
            map.put(strategy.getUserType(),strategy);
        }
    }

    public double cacluteMoneyByUserType(String type , double fee){
        //if else 写法
        CacluteStrategy strategy = map.get(type);
        double cacluteSale = strategy.cacluteSale(fee);
        return cacluteSale;
    }

}
