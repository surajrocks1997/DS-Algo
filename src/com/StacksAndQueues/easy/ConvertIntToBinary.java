package com.StacksAndQueues.easy;

import java.util.Stack;

public class ConvertIntToBinary {
    public static void main(String[] args) {
        int x = 10245;
        String binary = solve(x);
        System.out.println(binary);

        // for direct conversion
        System.out.println(Integer.toBinaryString(x));
    }

    private static String solve(int x) {
        Stack<Integer> stack = new Stack<>();
        while(x > 0){
            stack.push(x%2);
            x /= 2;

        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}
