package com.ft.queue.examples.blockqueue;

import org.junit.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class TestLinkedBlockingQueue {
    @Test
    public void testAdd() {
        int capacity = 2;
        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(capacity);
        for (int i=0; i<capacity; i++) {
            queue.add(i+1);
        }
        try {
            queue.add(capacity + 1);
        } catch (IllegalStateException e) {
            System.out.println(e);
        }

        System.out.println(queue);
    }

    @Test
    public void testPut() {
        int capacity = 2;
        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(capacity);
        for (int i=0; i<capacity; i++) {
            try {
                queue.put(i+1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            queue.put(capacity + 1);        // 阻塞
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(queue);
    }

    @Test
    public void testTake() {
        int capacity = 2;
        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(capacity);
        try {
            queue.take();        // 阻塞
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(queue);
    }

    @Test
    public void testPutAndTake() {
        int capacity = 10;
        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(capacity);
        Thread t1 = new Thread(()->{
            try {
                for (int i=0; i<100; i++) {
                    queue.put(i + 1);
                    System.out.println("put " + (i+1));
                    Thread.sleep(10);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(()->{
            try {
                for (int i=0; i<100; i++) {
                    Integer ret = queue.take();
                    System.out.println("take " + ret);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(queue);
    }
}
