package com.trees.medium;

import com.trees.TreeNode;

public class LCAofBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode((7));

        TreeNode p = root.right.left;
        TreeNode q = root.left.right.left;

        TreeNode result = solve(root, p, q);
        System.out.println(result.data);
    }

    private static TreeNode solve(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q)
            return root;

        TreeNode left = solve(root.left, p, q);
        TreeNode right = solve(root.right, p, q);

        if (left == null) return right;
        else if (right == null) return left;
        else return root;
    }
}
