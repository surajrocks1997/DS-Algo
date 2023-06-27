package com.StacksAndQueues.easy;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsing1Queue {
    public static void main(String[] args) {
        MyStack1 stack = new MyStack1();
        stack.push(2);
        stack.push(4);
        stack.push(6);
        System.out.println(stack.pop());
        System.out.println(stack.top());
    }
}

class MyStack1 {

    private Queue<Integer> queue;

    public MyStack1() {
        this.queue = new LinkedList<>();
    }

    public void push(int x) {
        queue.add(x);
        for (int i = 0; i < queue.size() - 1; i++) {
            queue.add(queue.remove());
        }
    }

    public int pop() {
        return queue.remove();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
