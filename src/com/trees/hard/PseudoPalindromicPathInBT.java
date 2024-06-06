package com.trees.hard;

import com.trees.TreeNode;

// https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree/description

public class PseudoPalindromicPathInBT {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.right = new TreeNode(1);
        root.left.right = new TreeNode(1);
        root.left.left = new TreeNode(3);
        root.right.right = new TreeNode(1);

        int result = solve(root);
        System.out.println(result);
    }


    private static int solve(TreeNode root) {
        int[] digits = new int[10];
        return dfs(root, digits);
    }

    private static int dfs(TreeNode root, int[] digits) {
        if (root == null) return 0;

        digits[root.data]++;
        if (root.left == null && root.right == null) {
            int cnt = countOdd(digits);
            digits[root.data]--;  // Backtrack
            return (cnt <= 1) ? 1 : 0;
        }

        int leftCount = dfs(root.left, digits);
        int rightCount = dfs(root.right, digits);

        digits[root.data]--;  // Backtrack

        return leftCount + rightCount;
    }

    private static int countOdd(int[] digits) {
        int cnt = 0;
        for (int i = 1; i < 10; ++i) {
            if ((digits[i] % 2) == 1) cnt++;
        }
        return cnt;
    }


}
