package com.dynamicProgramming.PartitionDP.BurstBalloons;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BurstBalloons_Rec {
    public static void main(String[] args) {
        int[] nums = {3, 1, 5, 8};

        int result = solve(nums);
        System.out.println(result);
    }

    private static int solve(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Arrays.stream(nums).forEach(list::add);
        list.add(0, 1);
        list.add(1);
        return solve(1, nums.length, list);
    }

    private static int solve(int i, int j, List<Integer> list) {
        if (i > j) return 0;

        int max = Integer.MIN_VALUE;
        for (int index = i; index <= j; index++) {
            int coins = list.get(i - 1) * list.get(index) * list.get(j + 1) +
                    solve(i, index - 1, list) + solve(index + 1, j, list);

            max = Math.max(coins, max);

        }
        return max;
    }
}
