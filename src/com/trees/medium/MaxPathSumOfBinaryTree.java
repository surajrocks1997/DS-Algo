package com.trees.medium;

import com.trees.TreeNode;

public class MaxPathSumOfBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(5);

        int max = solve(root);
        System.out.println(max);
    }

    private static int solve(TreeNode root) {
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        solve(root, max);
        return max[0];
    }

    private static int solve(TreeNode root, int[] max) {
        if (root == null) return 0;
        int left = Math.max(0, solve(root.left, max));
        int right = Math.max(0, solve(root.right, max));
        max[0] = Math.max(max[0], left + right + root.data);
        return root.data + Math.max(left, right);
    }
}
