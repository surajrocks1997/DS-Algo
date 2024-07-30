package com.arrays.medium;

// https://leetcode.com/problems/minimum-deletions-to-make-string-balanced/description/
public class MinDeletionsToMakeStringBalanced {

    public static void main(String[] args) {
        String s = "aaaaaabbbbabaaaabbabaaabbabbbaaabababaaaaaaabbaaabaaababaaabababa";
        int result = solve(s);
        System.out.println(result);
    }

    private static int solve(String s) {
        int n = s.length();
        int countRightA = 0;
        int countLeftB = 0;
        int[] rightA = new int[n];
        int[] leftB = new int[n];
        char[] charArr = s.toCharArray();

        for (int i = n - 1; i >= 0; i--) {
            rightA[i] = countRightA;
            countRightA += charArr[i] == 'a' ? 1 : 0;
        }

        int res = n;
        for (int i = 0; i < n; i++) {
            leftB[i] = countLeftB;
            countLeftB += charArr[i] == 'b' ? 1 : 0;

            res = Math.min(res, leftB[i] + rightA[i]);
        }

        return res;

    }

    private static int solve1(String s) {
        int n = s.length();
        int countA = 0;
        int countB = 0;
        char[] charArr = s.toCharArray();

        for (int i = n - 1; i >= 0; i--) {
            countA += charArr[i] == 'a' ? 1 : 0;
        }

        int res = n;
        for (int i = 0; i < n; i++) {
            if (charArr[i] == 'a')
                countA--;

            res = Math.min(res, countA + countB);

            if (charArr[i] == 'b')
                countB++;
        }

        return res;

    }
}