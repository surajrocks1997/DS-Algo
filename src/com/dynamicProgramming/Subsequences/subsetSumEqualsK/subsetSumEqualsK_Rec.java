package com.dynamicProgramming.Subsequences.subsetSumEqualsK;

public class subsetSumEqualsK_Rec {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int k = 100;
        int n = arr.length;

        boolean result = solve(n, k, arr);
        System.out.println(result);
    }

    private static boolean solve(int n, int k, int[] arr) {
        return find(n - 1, k, arr);
    }

    private static boolean find(int index, int target, int[] arr) {
        if (target == 0) return true;
        if (index == 0) return arr[index] == target;

        boolean pick = false;
        if (target >= arr[index])
            pick = find(index - 1, target - arr[index], arr);

        boolean notPick  = find(index - 1, target, arr);

        return pick || notPick;
    }
}
