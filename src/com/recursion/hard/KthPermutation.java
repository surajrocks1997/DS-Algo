package com.recursion.hard;

import java.util.ArrayList;
import java.util.List;

public class KthPermutation {
    public static void main(String[] args) {
        int n = 3;
        int k = 1;
        String result = solve(n, k);
        System.out.println(result);
    }

    private static String solve(int n, int k) {
        StringBuilder str = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        k--;
        while (list.size() > 1) {
            int fact = fact(list.size()-1);
            n = k / fact;
            k = k % fact;
            str.append(list.remove(n));
        }
        return str.append(list.remove(0)).toString();
    }

    private static int fact(int n) {
        if (n == 1) return 1;
        return n * (fact(n - 1));
    }
}
