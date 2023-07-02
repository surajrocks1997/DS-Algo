package com.trees.BST.medium;

import com.trees.TreeNode;

public class ValidateABST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(7);
        root.left.right.left = new TreeNode(6);
        root.right = new TreeNode(12);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(14);
        root.right.right.left = new TreeNode(13);

        boolean result = solve(root);
        System.out.println(result);
    }

    private static boolean solve(TreeNode root) {
        return solve(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean solve(TreeNode root, long min, long max) {
        if (root == null) return true;

        if (root.data >= max || root.data <= min) return false;
        return solve(root.left, min, root.data) && solve(root.right, root.data, max);
    }
}
