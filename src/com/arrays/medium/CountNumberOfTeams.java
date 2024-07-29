package com.arrays.medium;

//https://leetcode.com/problems/count-number-of-teams/description/
public class CountNumberOfTeams {

    public static void main(String[] args) {
        int[] rating = {2, 5, 3, 4, 1};
        int result = solve(rating);
        System.out.println(result);
    }

    private static int solve(int[] rating) {
        int result = 0;
        int n = rating.length;

        for (int i = 1; i < n - 1; i++) {
            int leftSmaller = 0;
            int rightLarger = 0;

            for (int j = 0; j < i; j++) {
                if (rating[j] < rating[i])
                    leftSmaller++;
            }

            for (int j = i + 1; j < n; j++) {
                if (rating[j] > rating[i])
                    rightLarger++;
            }

            result += leftSmaller * rightLarger;

            int leftLarger = i - leftSmaller;
            int rightSmaller = n - i - 1 - rightLarger;

            result += leftLarger * rightSmaller;
        }
        return result;
    }
}
