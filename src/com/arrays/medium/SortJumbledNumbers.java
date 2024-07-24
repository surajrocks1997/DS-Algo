package com.arrays.medium;

import java.util.*;

//https://leetcode.com/problems/sort-the-jumbled-numbers/description/
public class SortJumbledNumbers {

    public static void main(String[] args) {
        int[] mapping = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        int[] nums = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        int[] result = solve(mapping, nums);
        System.out.println(Arrays.toString(result));
    }

    private static int[] solve(int[] mapping, int[] nums) {
        int n = mapping.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++)
            map.put(i, mapping[i]);

        List<Pair> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int ele = nums[i];
            int sum = 0;
            int multiplier = 1;
            if (ele == 0) list.add(new Pair(mapping[ele], i));
            else {
                while (ele != 0) {
                    sum += multiplier * mapping[ele % 10];
                    ele /= 10;
                    multiplier *= 10;
                }
                list.add(new Pair(sum, i));
            }

        }
        list.sort((a, b) -> {
            if (a.num < b.num || (a.num == b.num && a.index < b.index)) return -1;
            return 1;
        });

        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++)
            result[i] = nums[list.get(i).index];

        return result;

    }
}

class Pair {
    int num;
    int index;

    public Pair(int num, int index) {
        this.num = num;
        this.index = index;
    }
}