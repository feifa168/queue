package com.ft.queue.examples.queue;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

//add           增加一个元索              如果队列已满，则抛出一个IIIegaISlabEepeplian异常
//remove        移除并返回队列头部的元素    如果队列为空，则抛出一个NoSuchElementException异常
//element       返回队列头部的元素           如果队列为空，则抛出一个NoSuchElementException异常
//offer         添加一个元素并返回true       如果队列已满，则返回false
//poll          移除并返问队列头部的元素    如果队列为空，则返回null
//peek          返回队列头部的元素           如果队列为空，则返回null
//put           添加一个元素                  如果队列满，则阻塞
//take          移除并返回队列头部的元素
public class TestLinkedList {
    @Test
    public void test1() {
        Queue<String>  queue = new LinkedList<>();
        queue.add("tom");
        queue.add("lucy");
        queue.add("jerry");
        queue.remove("jerry");
        queue.element();
        queue.offer("bruce");
        queue.poll();
        queue.peek();

        ((LinkedList<String>) queue).push("p1");
        ((LinkedList<String>) queue).pop();

        System.out.println(queue);
    }
}
