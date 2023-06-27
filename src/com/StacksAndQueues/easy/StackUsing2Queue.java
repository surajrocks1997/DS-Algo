package com.StacksAndQueues.easy;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsing2Queue {
    public static void main(String[] args) {
        MyStack1 stack = new MyStack1();
        stack.push(2);
        stack.push(4);
        stack.push(6);
        System.out.println(stack.pop());
        System.out.println(stack.top());
    }
}

class MyStack2 {

    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    public MyStack2() {
        this.queue1 = new LinkedList<>();
        this.queue2 = new LinkedList<>();
    }

    public void push(int x) {
        queue2.add(x);
        if (!queue1.isEmpty())
            while (!queue1.isEmpty()) {
                queue2.add(queue1.remove());
            }

        Queue<Integer> tempQueue = new LinkedList<>();
        tempQueue = queue1;
        queue1 = queue2;
        queue2 = tempQueue;

    }

    public int pop() {
        return queue1.remove();
    }

    public int top() {
        return queue1.peek();
    }

    public boolean empty() {
        return queue1.isEmpty();
    }
}
