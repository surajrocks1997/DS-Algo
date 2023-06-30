package com.trees.medium;

import com.trees.TreeNode;

public class SymmetricBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(5);

        boolean result = solve(root);
        System.out.println(result);
    }

    private static boolean solve(TreeNode root) {
        return root == null || solve(root.left, root.right);
    }

    private static boolean solve(TreeNode left, TreeNode right) {
        if (left == null || right == null) return left == right;
        if (left.data != right.data) return false;
        return solve(left.left, right.right) && solve(left.right, right.left);
    }
}
