package com.trees.medium;

import com.trees.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class HeightOfBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(5);

        int result = solveRecursive(root);
        System.out.println("Recursive: " + result);

        int ans = solveLevelOrder(root);
        System.out.println("BFS: " + ans);
    }

    private static int solveLevelOrder(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                root = queue.poll();
                if (root.left != null) queue.add(root.left);
                if (root.right != null) queue.add(root.right);
            }
            level++;
        }

        return level;
    }

    private static int solveRecursive(TreeNode root) {
        if (root == null) return 0;

        int lh = solveRecursive(root.left);
        int rh = solveRecursive(root.right);
        return 1 + Math.max(lh, rh);
    }
}
