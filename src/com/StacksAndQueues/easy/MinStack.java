package com.StacksAndQueues.easy;

import java.util.Stack;

public class MinStack {
    public static void main(String[] args) {
        MyMinStack minStack = new MyMinStack();
        minStack.push(1);
        minStack.push(-2);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        System.out.println(minStack.top());
        minStack.pop();
        System.out.println(minStack.getMin());
    }
}

class MyMinStack {
    Stack<Pair> stack;

    public MyMinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        int min;
        if (stack.isEmpty()) min = val;
        else min = Math.min(stack.peek().getMin(), val);
        stack.push(new Pair(val, min));

    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().getValue();
    }

    public int getMin() {
        return stack.peek().getMin();
    }
}

class Pair {
    int value;
    int min;

    public Pair(int value, int min) {
        this.value = value;
        this.min = min;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }
}
