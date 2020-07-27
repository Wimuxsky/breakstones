package com.wimux.breakstones.guava.ordering;

import com.google.common.collect.Ordering;
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: siqigang
 * @date: 2020/5/13
 * @description:
 **/
public class OrderingTest {

    @Test
    public void testNatural() {

        List<Integer> integerList = Lists.newArrayList(2,3,5,1,2,3,234,21,33,1);
        Ordering<Integer> integerOrdering = Ordering.natural();
        Collections.sort(integerList,integerOrdering.reverse());
        System.out.println(integerList);
    }


    @Test
    public void testOrderObject() {
        List<Foo> objList = Lists.newArrayList();
        objList.add(Foo.builder().id(1).sortKey("haha").build());
        objList.add(Foo.builder().id(2).sortKey("ahaha").build());
        objList.add(Foo.builder().id(8).sortKey("ahaha").build());
        objList.add(Foo.builder().id(3).sortKey("asdfhaha").build());
        objList.add(Foo.builder().id(4).sortKey("erhaha").build());
        objList.add(Foo.builder().id(7).sortKey("zvhaha").build());
        objList.add(Foo.builder().id(5).sortKey("adhaha").build());
        objList.add(Foo.builder().id(3).sortKey(null).build());
        objList.add(Foo.builder().id(9).sortKey(null).build());

        Ordering<Foo> fooOrdering= Ordering.natural().nullsLast().onResultOf(foo->foo.getSortKey());

//        Collections.sort(objList,fooOrdering);
//
//        System.out.println(objList);

        List<Foo> copyList = fooOrdering.compound((x1,x2)->Integer.valueOf(x2.getId()).compareTo(x1.getId())).sortedCopy(objList);
        List<Foo> imutalbecopyList = fooOrdering.immutableSortedCopy(objList);

        System.out.println("origin:"+objList);
        System.out.println("copyed:"+copyList);
        copyList.add(Foo.builder().id(9).sortKey(null).build());
        System.out.println("copyed2:"+copyList);

        imutalbecopyList.add(Foo.builder().id(9).sortKey(null).build());
        System.out.println("imutalbecopyList:"+imutalbecopyList);

    }

}
