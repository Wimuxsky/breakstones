package com.wimux.breakstones.stone.guava.eventbus;

import com.google.common.eventbus.Subscribe;

/**
 * @author: siqigang
 * @date: 2020/4/1
 * @description:
 **/
public class DataObserverB {
    /**
     * 只有通过@Subscribe注解的方法才会被注册进EventBus
     * 而且方法有且只能有1个参数
     *
     * @param msg
     */
    @Subscribe
    public void func(Integer msg) {
        System.out.println("DataObserverA:Integer msg: " + msg);
    }

}
