package com.trees.medium;

import com.trees.TreeNode;

public class DiameterOfBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(5);

        int[] max = new int[1];
        solve(root, max);
        System.out.println("Diameter: " + max[0]);
    }

    private static int solve(TreeNode root, int[] max) {
        if (root == null) return 0;

        int lh = solve(root.left, max);
        int rh = solve(root.right, max);
        max[0] = Math.max(lh + rh, max[0]);
        return 1 + Math.max(lh, rh);
    }
}
