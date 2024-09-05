package com.arrays.medium;

import java.util.Arrays;

// https://leetcode.com/problems/find-missing-observations/description/
public class FindMissingObservation {

    public static void main(String[] args) {
        int[] rolls = {4, 5, 6, 2, 3, 6, 5, 4, 6, 4, 5, 1, 6, 3, 1, 4, 5, 5, 3, 2, 3, 5, 3, 2, 1, 5, 4, 3, 5, 1, 5};
        int mean = 4;
        int n = 40;
        int[] result = solve(rolls, mean, n);
        for (int ele : result)
            System.out.print(ele + " ");
    }

    private static int[] solve(int[] rolls, int mean, int n) {
        int sum = 0;
        for (int ele : rolls)
            sum += ele;

        int missingSum = (mean * (rolls.length + n)) - sum;

        double requiredEle = (double) missingSum / n;
        if (requiredEle < 1 || requiredEle > 6)
            return new int[]{};

        int[] result = new int[n];
        int part = missingSum / n;
        int rem = missingSum % n;

        Arrays.fill(result, part);
        for(int i = 0; i < rem; i++){
            ++result[i];
        }

        return result;
    }
}