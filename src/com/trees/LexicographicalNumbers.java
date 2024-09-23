package com.trees;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/lexicographical-numbers/description/
public class LexicographicalNumbers {

    public static void main(String[] args) {
        int n = 13510;
        List<Integer> result = solve(n);
        System.out.println(result);
    }

    private static List<Integer> solve(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            dfs(i, n, list);
        }

        return list;
    }

    private static void dfs(int i, int n, List<Integer> list) {
        if (i > n) return;

        list.add(i);
        for (int idx = 0; idx <= 9; idx++) {
            if (i * 10 + idx > n) break;
            dfs(i * 10 + idx, n, list);
        }
    }
}