package com.trees.medium;

public class DistributeCoinsinBT {

    static int res = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(3);
        root.right = new TreeNode(0);

        int result = solve(root);
        System.out.println(result);
    }

    private static int solve(TreeNode root) {
        solveThis(root);
        return res;
    }

    private static int[] solveThis(TreeNode root) {
        if (root == null) return new int[]{0, 0};

        int[] left = solveThis(root.left);
        int[] right = solveThis(root.right);

        int size = 1 + left[0] + right[0];
        int coins = root.val + left[1] + right[1];
        res += Math.abs(size - coins);

        return new int[]{size, coins};

    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

