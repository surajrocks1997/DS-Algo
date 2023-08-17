package com.dynamicProgramming.Subsequences.CountPartitionWithGivenDifference;

public class CountPartitionWithGivenDifference_Rec {
    public static void main(String[] args) {
        int[] arr = {5, 2, 5, 1};
        int n = 4;
        int d = 3;

        int result = solve(n, d, arr);
        System.out.println(result);
    }

    private static int solve(int n, int d, int[] arr) {
        int totalSum = 0;
        for (int ele : arr) totalSum += ele;
        if (totalSum - d < 0) return 0;
        if ((totalSum - d) % 2 == 1) return 0;
        int sum = (totalSum - d) / 2;

        return find(n - 1, sum, arr);
    }

    public static int mod = (int) 1e9 + 7;

    private static int find(int index, int sum, int[] arr) {
        if (index == 0) {
            if (sum == 0 && arr[0] == 0)
                return 2;
            if (sum == 0 || sum == arr[0])
                return 1;
            return 0;
        }

        int pick = 0;
        if (sum >= arr[index])
            pick = find(index - 1, sum - arr[index], arr);
        int notPick = find(index - 1, sum, arr);
        return (pick + notPick) % mod;
    }
}
