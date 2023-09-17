package com.greedy.medium;

import java.util.PriorityQueue;

public class ConnectNRopesWithMinCost {
    public static void main(String[] args) {
        int[] arr = {4,3,2,6};
        int n = 4;

        int result = solve(arr);
        System.out.println(result);
    }

    private static int solve(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int ele: arr)
            pq.add(ele);

        int res = 0;
        while(pq.size() > 1){
            int first = pq.poll();
            int second = pq.poll();

            res += first + second;
            pq.add(first + second);
        }

        return res;
    }
}
