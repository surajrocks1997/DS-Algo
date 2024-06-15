package com.greedy.hard;

//https://leetcode.com/problems/ipo/description/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class IPO {
    public static void main(String[] args) {
        int k = 3;
        int w = 0;
        int[] profits = {1, 2, 3, 4};
        int[] capital = {0, 1, 2, 3};

        int result = solve(k, w, profits, capital);
        System.out.println(result);
    }

    private static int solve(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        List<Pair> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Pair(profits[i], capital[i]));
        }

        list.sort((a, b) -> a.capital - b.capital);
        PriorityQueue<Integer> maxCapital = new PriorityQueue<>(Collections.reverseOrder());

        int i = 0;
        while (k > 0) {
            while (i < n && list.get(i).capital <= w) {
                maxCapital.add(list.get(i).profit);
                i++;
            }
            if (maxCapital.isEmpty()) return w;

            w += maxCapital.poll();

            k--;
        }

        return w;
    }
}

class Pair {
    int profit;
    int capital;

    public Pair(int profit, int capital) {
        this.profit = profit;
        this.capital = capital;
    }
}