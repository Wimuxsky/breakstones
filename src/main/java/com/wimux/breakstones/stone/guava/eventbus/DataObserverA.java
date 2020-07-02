package com.wimux.breakstones.stone.guava.eventbus;

import com.google.common.eventbus.Subscribe;

import java.util.List;

/**
 * @author: siqigang
 * @date: 2020/4/1
 * @description:
 **/
public class DataObserverA {
    /**
     * 只有通过@Subscribe注解的方法才会被注册进EventBus
     * 而且方法有且只能有1个参数
     *
     * @param msg
     */
    @Subscribe
    public void func(String msg) {
        System.out.println("DataObserverA:String msg: " + msg);
    }


    @Subscribe
    public void func(List msg) {
        System.out.println("DataObserverA:List msg: " + msg.toString());
    }

    @Subscribe
    public void func2(String msg) {
        System.out.println("DataObserverA-2:String msg: " + msg);
    }


}
