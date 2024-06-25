package com.trees.BST.medium;

public class BinarySearchTreeToGreaterSumTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(3);
        root.right = new TreeNode(6);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(8);

        TreeNode resRoot = solve(root);
        System.out.println(resRoot.val);
    }

    private static TreeNode solve(TreeNode root) {
        int[] sum = {0};
        solve(root, sum);
        return root;
    }

    private static int solve(TreeNode root, int[] sum) {
        if (root == null) return 0;

        int right = solve(root.right, sum);
        root.val += sum[0];
        sum[0] = root.val;

        int left = solve(root.left, sum);

        return sum[0];
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
