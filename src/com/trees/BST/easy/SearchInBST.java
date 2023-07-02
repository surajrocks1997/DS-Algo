package com.trees.BST.easy;

import com.trees.TreeNode;

public class SearchInBST {
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

        int val = 15;
        TreeNode result = solve(root, val);
        if (result != null) System.out.println(result.data);
        else System.out.println("Null");
    }

    private static TreeNode solve(TreeNode root, int val) {
        if (root == null) return null;
        if (root.data == val) return root;

        if (val < root.data) return solve(root.left, val);
        else return solve(root.right, val);
    }
}
