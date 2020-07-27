package com.wimux.breakstones.stone.guava.range;

import com.google.common.collect.ContiguousSet;
import com.google.common.collect.DiscreteDomain;
import com.google.common.collect.Range;

/**
 * @author: siqigang
 * @date: 2020/4/27
 * @description:
 **/
public class RangeMain {

    public static void main(String[] args) {
        testRange();
    }


    private static final void testRange() {
        Range closeRange = Range.closed(1,5);
        System.out.println(closeRange);


        ContiguousSet contiguousSet=  ContiguousSet.create(Range.closed(0,10), DiscreteDomain.integers());
        System.out.println(contiguousSet);



    }
}
