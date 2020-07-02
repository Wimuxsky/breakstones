package com.wimux.breakstones.stone.guava.eventbus;

import com.google.common.collect.Lists;
import com.google.common.eventbus.EventBus;

/**
 * @author: siqigang
 * @date: 2020/4/1
 * @description:
 **/
public class EventBusMain {

    public static void main(String[] args) {
        DataObserverA observer1 = new DataObserverA();
        DataObserverB observer2 = new DataObserverB();

        EventBusCenter.register(observer1);
        EventBusCenter.register(observer2);

        System.out.println("============   start  ====================");

        // 只有注册的参数类型为String的方法会被调用
        EventBusCenter.post("post string method");
        EventBusCenter.post(123);
        EventBusCenter.post(Lists.newArrayList(1,2,3));

        System.out.println("============ after unregister ============");
        // 注销observer2
        EventBusCenter.unregister(observer2);
        EventBusCenter.post("post string method");
        EventBusCenter.post(123);
        EventBusCenter.post(Lists.newArrayList(1,2,3));


        System.out.println("============    end           =============");
    }
}
