package com.ft.queue.examples.queue;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class TestArrayList {
    @Test
    public void test() {
        Queue<String> queue = new ArrayDeque<>(2);
        queue.add("tom");
        queue.add("lucy");
        queue.add("jerry");
        queue.remove("jerry");
        queue.element();
        queue.offer("bruce");
        queue.poll();
        queue.peek();

        ((ArrayDeque<String>) queue).push("p1");
        ((ArrayDeque<String>) queue).pop();

        System.out.println(queue);
    }
}
