package com.trees.medium;

import com.trees.TreeNode;

public class LargestSubTreeSum {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(-2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(-6);
        root.right.right = new TreeNode(2);

        int result = solve(root);
        System.out.println(result);
    }

    private static int solve(TreeNode root) {
        int[] max = new int[1];
        solve(root, max);
        return max[0];
    }

    private static int solve(TreeNode root, int[] max) {
        if (root == null) return 0;

        int left = solve(root.left, max);
        int right = solve(root.right, max);
        max[0] = Math.max(max[0], root.data + left + right);

        return root.data + left + right;
    }
}
