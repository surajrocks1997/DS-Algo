package com.trees.BST.medium;

import java.util.ArrayList;
import java.util.List;

public class BalanceABinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(4);

        TreeNode result = solve(root);
        System.out.println(result.val);
    }

    private static TreeNode solve(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        return solve(list, 0, list.size() - 1);
    }

    private static TreeNode solve(List<Integer> list, int low, int high) {
        if (low > high) return null;
        int mid = low + (high - low) / 2;
        if (low == mid && mid == high) return new TreeNode(list.get(mid));

        TreeNode root = new TreeNode(list.get(mid));
        root.left = solve(list, low, mid - 1);
        root.right = solve(list, mid + 1, high);
        return root;
    }

    private static void inorder(TreeNode root, List<Integer> list) {
        if (root == null) return;

        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}