package com.dynamicProgramming.Subsequences.RodCuttingProblem;

public class RodCuttingProblem_SpaceOpt {
    public static void main(String[] args) {
        int[] price = {3, 5, 6, 7, 10, 12};
        int n = 6;

        int result = solve(price, n);
        System.out.println(result);

    }

    private static int solve(int[] price, int n) {
        int[] prev = new int[n + 1];
        for (int count = 1; count <= n; count++)
            prev[count] = count * price[0];

        for (int index = 2; index <= n; index++) {
            int[] curr = new int[n + 1];
            for (int count = 1; count <= n; count++) {
                int notPick = prev[count];

                int pick = 0;
                if (count >= index)
                    pick = price[index - 1] + curr[count - index];

                curr[count] = Math.max(pick, notPick);
            }
            prev = curr;
        }
        return prev[n];
    }
}
