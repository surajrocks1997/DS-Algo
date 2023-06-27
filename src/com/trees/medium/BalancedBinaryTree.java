package com.trees.medium;

import com.trees.Node;

public class BalancedBinaryTree {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(6);
        root.right.left.left = new Node(5);

        boolean result = solve(root);
        System.out.println("Is Balanced: " + result);
    }

    private static boolean solve(Node root) {
        return dfs(root) != -1;
    }

    private static int dfs(Node root) {
        if (root == null) return 0;

        int lh = dfs(root.left);
        if (lh == -1) return -1;

        int rh = dfs(root.right);
        if (rh == -1) return -1;

        if ((Math.abs(lh - rh)) > 1) return -1;

        return 1 + Math.max(lh, rh);
    }
}
