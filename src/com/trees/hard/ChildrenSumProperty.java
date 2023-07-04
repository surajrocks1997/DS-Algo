package com.trees.hard;

import com.trees.TreeNode;

public class ChildrenSumProperty {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(40);
        root.left = new TreeNode(10);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(30);
        root.right.right = new TreeNode(40);

        TreeNode result = solve(root);
        System.out.println(result.data);
    }

    private static TreeNode solve(TreeNode root) {
        solveIt(root);
        return root;
    }

    private static void solveIt(TreeNode root) {
        if (root == null) return;
        int child = 0;
        if (root.left != null) child += root.left.data;
        if (root.right != null) child += root.right.data;

        if (child >= root.data) root.data = child;
        else {
            if (root.left != null) root.left.data = root.data;
            if (root.right != null) root.right.data = root.data;
        }

        solve(root.left);
        solve(root.right);

        int total = 0;
        if (root.left != null) total += root.left.data;
        if (root.right != null) total += root.right.data;
        if (root.left != null || root.right != null) root.data = total;

    }
}
