package com.arrays;

import java.util.ArrayList;
import java.util.List;

public class SuperiorElements {
    public static void main(String[] args) {
        int[] a = {187, 64, 133, 62, 49, 163, 50, 115, 42, 65, 60, 49, 32, 87, 141, 142, 146, 159};

        List<Integer> result = solve(a);
        System.out.println(result);


    }

    private static List<Integer> solve(int[] a) {
        int n = a.length;
        List<Integer> list = new ArrayList<>();
        list.add(a[n - 1]);
        if (n == 1) {
            return list;
        }
        int max = a[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            if (a[i] > max) {
                list.add(a[i]);
                max = a[i];
            }
        }
        return list;
    }
}
