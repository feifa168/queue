package com.ft.queue.examples.blockqueue;

import org.junit.Test;

import java.util.NoSuchElementException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//  add(e)//队列未满时，返回true；队列满则抛出IllegalStateException(“Queue full”)异常——AbstractQueue
//  offer(e)//队列未满时，返回true；队列满时返回false。非阻塞立即返回。
//  offer(e, time, unit)//设定等待的时间，如果在指定时间内还不能往队列中插入数据则返回false，插入成功返回true。
//  put(e)//队列未满时，直接插入没有返回值；队列满时会阻塞等待，一直等到队列未满时再插入。
//
//  remove()//队列不为空时，返回队首值并移除；队列为空时抛出NoSuchElementException()异常——AbstractQueue
//  poll()//队列不为空时返回队首值并移除；队列为空时返回null。非阻塞立即返回。
//  poll(time, unit)//设定等待的时间，如果在指定时间内队列还未孔则返回null，不为空则返回队首值
//  take(e)//队列不为空返回队首值并移除；当队列为空时会阻塞等待，一直等到队列不为空时再返回队首值。
public class TestArrayBlockingQueue {
    @Test
    public void testAdd() {
        final int capacity = 2;
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(capacity);
        try {
            for (int i = 0; i < capacity; i++) {
                queue.add(i + 1);
            }
            queue.add(capacity + 1);
        } catch (IllegalStateException e) {
            System.out.println(e);
        }

        System.out.println(queue);
    }

    @Test
    public void testOffer() {
        final int capacity = 2;
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(capacity);
        for (int i = 0; i < capacity; i++) {
            queue.offer(i + 1);
        }
        queue.offer(capacity + 1);

        System.out.println(queue);
    }
    @Test
    public void testOfferTimeOut() {
        final int capacity = 2;
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(capacity);
        for (int i = 0; i < capacity; i++) {
            queue.offer(i + 1);
        }
        try {
            queue.offer(capacity + 1, 3, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(queue);
    }

    @Test
    public void testAddAndOffer() {
        final int capacity = 2;
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(capacity);
        for (int i = 0; i < capacity; i+=2) {
            queue.offer(i + 1);
            queue.add(i+2);
        }
        queue.offer(capacity + 1);
        queue.add(capacity + 1);

        System.out.println(queue);
    }

    @Test
    public void testPut() {
        final int capacity = 2;
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(capacity);
        for (int i = 0; i < capacity; i++) {
            try {
                queue.put(i + 1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            queue.put(capacity + 1);    // 阻塞
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(queue);
    }

    @Test
    public void testRemove() {
        final int capacity = 2;
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(capacity);

        try {
            queue.remove();
        } catch (NoSuchElementException e) {
            System.out.println(e);
        }
        queue.remove("tom");
    }

    @Test
    public void testPoll() {
        final int capacity = 2;
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(capacity);

        Integer ret = queue.poll();
        System.out.println(ret);    // null
    }

    @Test
    public void testPollTimeOut() {
        final int capacity = 2;
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(capacity);

        Integer ret = null;
        try {
            ret = queue.poll(3, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(ret);    // null
    }

    @Test
    public void testTake() {
        final int capacity = 2;
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(capacity);

        Integer ret = null;
        try {
            ret = queue.take();         // 阻塞
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(ret);    // null
    }

    @Test
    public void testPutAndTake() {
        final int capacity = 10;
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(capacity);
        Lock lock = new ReentrantLock();

        Thread producerT = new Thread(()->{
            for (int i=0; i<100; i++) {
                try {
                    queue.put(i);
                    System.out.println("put " + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread consumerT = new Thread(()->{
            for (int i=0; i<100; i++) {
                try {
                    Integer ret = queue.take();
                    System.out.println("take " + ret);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        producerT.start();
        consumerT.start();

        try {
            producerT.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            consumerT.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
