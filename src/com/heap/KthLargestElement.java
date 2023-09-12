package com.heap;

import java.util.PriorityQueue;

public class KthLargestElement {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;

        int result = solve(nums, k);
        System.out.println(result);
    }

    private static int solve(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int ele: nums){
            minHeap.add(ele);
            if(minHeap.size() > k){
                minHeap.remove();
            }
        }
        return minHeap.remove();
    }
}
