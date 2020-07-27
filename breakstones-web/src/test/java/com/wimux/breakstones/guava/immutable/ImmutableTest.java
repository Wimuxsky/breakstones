package com.wimux.breakstones.guava.immutable;

import com.google.common.collect.ImmutableSet;
import org.checkerframework.checker.units.qual.C;
import org.junit.Test;

import java.util.concurrent.CompletableFuture;

/**
 * @author: siqigang
 * @date: 2020/4/29
 * @description:
 **/
public class ImmutableTest {

    @Test
    public void testImutableSet() {
        ImmutableSet<String> set = ImmutableSet.of("a","b","c");
        System.out.println(set);

        set.add("123");
     System.out.println(set);


    }
}
