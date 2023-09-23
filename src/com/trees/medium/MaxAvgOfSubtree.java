package com.trees.medium;

import com.trees.TreeNode;

public class MaxAvgOfSubtree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(12);
        root.right = new TreeNode(18);
        root.left.left = new TreeNode(11);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(8);

        double result = solve(root);
        System.out.println(result);
    }

    private static double solve(TreeNode root) {
        double[] max = new double[1];
        solve(root, max);
        return max[0];
    }

    private static double[] solve(TreeNode root, double[] max) {
        if (root == null) return new double[]{0, 0};

        double[] left = solve(root.left, max);
        double[] right = solve(root.right, max);

        double count = 1 + left[1] + right[1];
        double sum = root.data + left[0] + right[0];

        max[0] = Math.max(max[0], sum / count);

        return new double[]{sum, count};
    }
}
