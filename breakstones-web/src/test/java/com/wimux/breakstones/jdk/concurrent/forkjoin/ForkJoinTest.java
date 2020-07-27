package com.wimux.breakstones.jdk.concurrent.forkjoin;

import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;

/**
 * @author: siqigang
 * @date: 2020/5/9
 * @description:
 **/
public class ForkJoinTest {


    @Test
    public void testForkJoin() throws ExecutionException, InterruptedException {
        ForkJoinPool forkJoinPool = new ForkJoinPool();

        //创建一个计算任务，计算 由1加到12
        CountTask countTask = new CountTask(1, 12);
        Future<Integer> future = forkJoinPool.submit(countTask);
        System.out.println("最终的计算结果：" + future.get());
    }
}
