package com.StacksAndQueues.medium;

import java.util.Arrays;
import java.util.Stack;

public class NextPrevGreaterAndSmallerElement {

    public static void main(String[] args) {
        int[] arr = {3, 10, 4, 2, 1, 2, 6, 1, 7, 2, 9};

//        find nextGreaterElement, prevGreaterElement, nextSmallerElement, prevSmallerElement
        int[] nge = nge(arr);
        int[] pge = pge(arr);
        int[] nse = nse(arr);
        int[] pse = pse(arr);

    }

    private static int[] pse(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] pse = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[i] <= stack.peek())
                stack.pop();

            if (stack.isEmpty())
                pse[i] = -1;
            else
                pse[i] = stack.peek();

            stack.push(nums[i]);
        }

        Arrays.stream(nums).forEach(ele -> System.out.print(ele + " "));
        System.out.println();
        Arrays.stream(pse).forEach(ele -> System.out.print(ele + " "));
        System.out.println(" : PGE");
        System.out.println("STACK Behavior: Monotonic Increasing Stack : Top most Element is largest");
        return pse;
    }

    private static int[] nse(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] nse = new int[nums.length];

        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i] <= stack.peek())
                stack.pop();

            if (stack.isEmpty())
                nse[i] = -1;
            else
                nse[i] = stack.peek();

            stack.push(nums[i]);
        }

        Arrays.stream(nums).forEach(ele -> System.out.print(ele + " "));
        System.out.println();
        Arrays.stream(nse).forEach(ele -> System.out.print(ele + " "));
        System.out.println(" : NSE");
        System.out.println("STACK Behavior: Monotonic Increasing Stack : Top most Element is largest");
        return nse;
    }

    private static int[] pge(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] pge = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[i] >= stack.peek())
                stack.pop();

            if (stack.isEmpty())
                pge[i] = -1;
            else
                pge[i] = stack.peek();

            stack.push(nums[i]);
        }

        Arrays.stream(nums).forEach(ele -> System.out.print(ele + " "));
        System.out.println();
        Arrays.stream(pge).forEach(ele -> System.out.print(ele + " "));
        System.out.println(" : PGE");
        System.out.println("STACK Behavior: Monotonic Decreasing Stack : Top most Element is smallest");
        return pge;
    }

    private static int[] nge(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] nge = new int[nums.length];

        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i] >= stack.peek())
                stack.pop();

            if (stack.isEmpty())
                nge[i] = -1;
            else
                nge[i] = stack.peek();

            stack.push(nums[i]);
        }

        Arrays.stream(nums).forEach(ele -> System.out.print(ele + " "));
        System.out.println();
        Arrays.stream(nge).forEach(ele -> System.out.print(ele + " "));
        System.out.println(" : NGE");
        System.out.println("STACK Behavior: Monotonic Decreasing Stack : Top most Element is smallest");
        return nge;
    }
}