package com.dynamicProgramming.Subsequences.RodCuttingProblem;

public class RodCuttingProblem_Rec {
    public static void main(String[] args) {
        int[] price = {3, 5, 6, 7, 10, 12};
        int n = 6;

        int result = solve(price, n);
        System.out.println(result);

    }

    private static int solve(int[] price, int n) {
        return solve(n, n, price);
    }

    private static int solve(int index, int count, int[] price) {
        if (index - 1 == 0)
            return count / index * price[index - 1];

        int notPick = solve(index - 1, count, price);
        int pick = 0;
        if (count >= index)
            pick = price[index - 1] + solve(index, count - index, price);
        return Math.max(pick, notPick);
    }
}
