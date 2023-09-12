package com.heap;

import java.util.*;

public class ReplaceEleWithItsRank {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(Arrays.asList(4, 7, 2, 90));
        int n = arr.size();

        List<Integer> result = solve(arr, n);
        System.out.println(result);
    }

    private static List<Integer> solve(List<Integer> arr, int n) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(n);

        for (int ele : arr)
            minHeap.add(ele);

        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        int k = 1;

        while (!minHeap.isEmpty()) {
            int top = minHeap.poll();
            if (!map.containsKey(top)) map.put(top, k++);
        }

        for (int ele : arr)
            list.add(map.get(ele));

        return list;
    }
}
