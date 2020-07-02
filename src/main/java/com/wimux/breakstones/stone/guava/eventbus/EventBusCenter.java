package com.wimux.breakstones.stone.guava.eventbus;

import com.google.common.eventbus.EventBus;

/**
 * @author: siqigang
 * @date: 2020/4/1
 * @description:
 **/
public class EventBusCenter {

    private static EventBus eventBus = new EventBus();

    private EventBusCenter(){}


    public static EventBus getInstanct() {
        return eventBus;
    }

    public static void register(Object obj) {
        eventBus.register(obj);
    }

    public static void unregister(Object obj) {
        eventBus.unregister(obj);
    }

    public static void post(Object obj) {
        eventBus.post(obj);
    }
}
