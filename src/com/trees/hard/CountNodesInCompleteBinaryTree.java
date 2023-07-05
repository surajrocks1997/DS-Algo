package com.trees.hard;

import com.trees.TreeNode;

public class CountNodesInCompleteBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(40);
        root.left = new TreeNode(10);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(30);
        root.right.right = new TreeNode(40);

        int result = solve(root);
        System.out.println(result);
    }

    private static int solve(TreeNode root) {
        if (root == null) return 0;
        int left = findLeftHeight(root);
        int right = findRightHeight(root);

        if (left == right) return (int) (Math.pow(2, left + 1) - 1);
        else
            return 1 + solve(root.left) + solve(root.right);
    }

    private static int findRightHeight(TreeNode root) {
        int count = 0;
        while (root.right != null) {
            count++;
            root = root.right;
        }
        return count;
    }

    private static int findLeftHeight(TreeNode root) {
        int count = 0;
        while (root.left != null) {
            count++;
            root = root.left;
        }
        return count;
    }
}
