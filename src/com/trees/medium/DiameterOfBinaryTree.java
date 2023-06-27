package com.trees.medium;

import com.trees.Node;

public class DiameterOfBinaryTree {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(6);
        root.right.left.left = new Node(5);

        int[] max = new int[1];
        solve(root, max);
        System.out.println("Diameter: " + max[0]);
    }

    private static int solve(Node root, int[] max) {
        if (root == null) return 0;

        int lh = solve(root.left, max);
        int rh = solve(root.right, max);
        max[0] = Math.max(lh + rh, max[0]);
        return 1 + Math.max(lh, rh);
    }
}
