package com.wimux.breakstones.guava.stringop;

import com.google.common.base.Joiner;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.Map;

/**
 * @author: siqigang
 * @date: 2020/4/30
 * @description:
 **/
public class JoinerTest {


    @Test
    public void testJoiner() {
        Joiner joiner = Joiner.on("; ").skipNulls();
        String result = joiner.join("Harry", null, "Ron", "Hermione");
        System.out.println(result);
    }

    @Test
    public void testJoinerUseForNull() {
        Joiner joiner = Joiner.on("; ").useForNull("hala");
        String result = joiner.join("Harry", null, "Ron", "Hermione");
        System.out.println(result);
    }

    @Test
    public void testJoiner3() {
        Map<String,String> map = Maps.newHashMap();
        map.put("abcd","3rwer");
        map.put("abcd1","3rwer1");
        map.put("abcd2","3rwer2");

        Joiner.MapJoiner joiner = Joiner.on(",").withKeyValueSeparator(":");
        String result = joiner.join(map);
        System.out.println(result);
    }


}
