package com.wimux.breakstones.guava.ordering;

import lombok.Builder;
import lombok.Data;

import javax.annotation.Nullable;

/**
 * @author: siqigang
 * @date: 2020/5/13
 * @description:
 **/
@Data
@Builder
public class Foo {

    @Nullable
    private String sortKey;

    private int id;
}
