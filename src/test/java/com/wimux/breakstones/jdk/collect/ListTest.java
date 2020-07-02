package com.wimux.breakstones.jdk.collect;

import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author: siqigang
 * @date: 2020/5/11
 * @description:
 **/
public class ListTest {

    @Test
    public void testA() {
        List<Integer> aList = Lists.newArrayList(1, 2, 3, 4);
        CompletableFuture.runAsync(() -> {
            System.out.println("start 1");
            for (int i = 0; i < 10000; i++) {
                System.out.println("1-" + i);
                aList.add(i);
                try {
                    TimeUnit.MILLISECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("end 1");

        });
        CompletableFuture.runAsync(() -> {
            System.out.println("start 2");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int a : aList) {
                System.out.println("2-" + a);
                try {
                    TimeUnit.MILLISECONDS.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("end 2");
        });

    }

}
