package com.dynamicProgramming.Strings.EditDistance;

public class EditDistance_SpaceOpt {
    public static void main(String[] args) {
        String word1 = "intention";
        String word2 = "execution";

        int result = solve(word1, word2);
        System.out.println(result);
    }

    private static int solve(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[] prev = new int[n + 1];

        for (int j = 0; j <= n; j++)
            prev[j] = j;


        for (int i = 1; i <= m; i++) {
            int[] curr = new int[n + 1];
            curr[0] = i;
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    curr[j] = prev[j - 1];

                else {
                    int insert = 1 + curr[j - 1];
                    int delete = 1 + prev[j];
                    int replace = 1 + prev[j - 1];

                    curr[j] = Math.min(insert, Math.min(delete, replace));
                }

            }
            prev = curr;
        }

        return prev[n];
    }
}
