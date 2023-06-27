package com.trees.medium;

import com.trees.Node;

public class MaxPathSumOfBinaryTree {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(6);
        root.right.left.left = new Node(5);

        int max = solve(root);
        System.out.println(max);
    }

    private static int solve(Node root) {
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        solve(root, max);
        return max[0];
    }

    private static int solve(Node root, int[] max) {
        if (root == null) return 0;
        int left = Math.max(0, solve(root.left, max));
        int right = Math.max(0, solve(root.right, max));
        max[0] = Math.max(max[0], left + right + root.data);
        return root.data + Math.max(left, right);
    }
}
