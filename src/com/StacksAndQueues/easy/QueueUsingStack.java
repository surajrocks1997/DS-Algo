package com.StacksAndQueues.easy;

import java.util.Stack;

public class QueueUsingStack {

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        System.out.println(queue.pop());
        System.out.println(queue.peek());
    }
}

class MyQueue {

    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public MyQueue() {
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();

    }

    public void push(int x) {
        while (!stack1.isEmpty())
            stack2.push(stack1.pop());

        stack1.push(x);
        while (!stack2.isEmpty())
            stack1.add(stack2.pop());
    }

    public int pop() {
        return stack1.pop();
    }

    public int peek() {
        return stack1.peek();
    }

    public boolean empty() {
        return stack1.isEmpty();
    }
}
