package com.arrays.medium;

import java.util.*;

public class TopKFrequentElements {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;

        int[] result = solve(nums, k);
        Arrays.stream(result).forEach(ele -> System.out.print(ele + " "));
    }

    private static int[] solve(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int ele : nums) {
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }

        ArrayList<Integer>[] countArray = new ArrayList[nums.length + 1];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (countArray[entry.getValue()] == null)
                countArray[entry.getValue()] = new ArrayList();
            countArray[entry.getValue()].add(entry.getKey());
        }

        int[] result = new int[k];
        int index = 0;
        for (int i = nums.length; i >= 0; i--) {
            if (countArray[i] != null) {
                int size = countArray[i].size();
                for (int val : countArray[i]) {
                    result[index++] = val;
                    if (index == k)
                        return result;
                }
            }
        }
        return result;
    }

    private static int[] solve1(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int ele : nums) {
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            minHeap.add(entry);
            if (minHeap.size() > k) minHeap.poll();
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll().getKey();
        }

        return result;
    }
}
