package com.ft.queue.examples.queue;

import org.junit.Test;

import java.util.PriorityQueue;
import java.util.Queue;

public class TestPriorityQueue {

    @Test
    public void testAddRemove() {
        Queue<Integer> queue = new PriorityQueue<>(4);
        queue.add(6);
        queue.add(3);
        queue.add(-2);
        queue.remove();
        queue.remove(7);
        queue.element();

        queue.add(5);
        queue.add(1);
        queue.element();
        queue.remove();

        System.out.println(queue);
    }

    @Test
    public void test() {
        Queue<String> queue = new PriorityQueue<>(4);
        queue.add("5");
        queue.add("2");
        queue.add("4");
        queue.remove();
        queue.remove("2");
        queue.element();

        queue.offer("jerry7");
        queue.offer("jerry2");
        queue.peek();
        queue.poll();

        System.out.println(queue);
    }

    @Test
    public void test2() {
        Queue<Integer> queue = new PriorityQueue<>(4);
        queue.add(6);
        queue.add(3);
        queue.add(-2);
        queue.remove();
        queue.remove(7);
        queue.element();

        queue.offer(5);
        queue.offer(1);
        queue.peek();
        queue.poll();

        System.out.println(queue);
    }
}
