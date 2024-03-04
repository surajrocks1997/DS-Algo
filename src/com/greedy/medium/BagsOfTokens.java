package com.greedy.medium;

import java.util.Arrays;

// https://leetcode.com/problems/bag-of-tokens/description
public class BagsOfTokens {

    public static void main(String[] args) {

        int[] tokens = {100, 200};
        int power = 150;

        int result = solve(tokens, power);
        System.out.println(result);

    }

    private static int solve(int[] tokens, int power) {
        if (tokens.length == 0) return 0;
        Arrays.sort(tokens);
        int score = 0;
        int max = 0;
        int i = 0;
        int j = tokens.length - 1;
        while (i <= j) {
            if (power >= tokens[i]) {
                power -= tokens[i++];
                score += 1;
                max = Math.max(score, max);
            } else if (score >= 1) {
                power += tokens[j--];
                score -= 1;
            } else return max;
        }
        return max;
    }


}