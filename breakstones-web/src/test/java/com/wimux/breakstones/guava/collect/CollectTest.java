package com.wimux.breakstones.guava.collect;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.common.collect.Sets;
import org.junit.Test;

/**
 * @author: siqigang
 * @date: 2020/4/29
 * @description:
 **/
public class CollectTest {

    @Test
    public void testMulitSet() {
        Multiset<String> multiset = HashMultiset.create();

        multiset.add("a");
        multiset.add("b");
        multiset.add("c");
        multiset.add("a");
        System.out.println(multiset.toString());
        System.out.println(multiset.contains("a"));
        System.out.println(multiset.count("a"));
    }

}
