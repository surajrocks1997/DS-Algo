package com.trees.medium;

import com.trees.TreeNode;

public class BalancedBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(5);

        boolean result = solve(root);
        System.out.println("Is Balanced: " + result);
    }

    private static boolean solve(TreeNode root) {
        return dfs(root) != -1;
    }

    private static int dfs(TreeNode root) {
        if (root == null) return 0;

        int lh = dfs(root.left);
        if (lh == -1) return -1;

        int rh = dfs(root.right);
        if (rh == -1) return -1;

        if ((Math.abs(lh - rh)) > 1) return -1;

        return 1 + Math.max(lh, rh);
    }
}
