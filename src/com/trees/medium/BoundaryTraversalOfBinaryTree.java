package com.trees.medium;

import com.trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BoundaryTraversalOfBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.left.right = new TreeNode(5);

        List<Integer> result = solve(root);
        System.out.println(result);
    }

    private static List<Integer> solve(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        if (!isLeaf(root)) result.add(root.data);
        addLeftBoundary(root, result);
        addLeaves(root, result);
        addRightBoundary(root, result);
        return result;
    }

    private static void addRightBoundary(TreeNode root, List<Integer> result) {
        TreeNode current = root.right;
        List<Integer> rightBoundary = new ArrayList<>();
        while (current != null) {
            if (!isLeaf(current)) rightBoundary.add(current.data);
            if (current.right != null) current = current.right;
            else current = current.left;
        }
        for (int i = rightBoundary.size() - 1; i >= 0; i--) {
            result.add(rightBoundary.get(i));
        }

    }

    private static void addLeaves(TreeNode root, List<Integer> result) {
        if (isLeaf(root)) {
            result.add(root.data);
            return;
        }
        if (root.left != null) addLeaves(root.left, result);
        if (root.right != null) addLeaves(root.right, result);
    }

    private static void addLeftBoundary(TreeNode root, List<Integer> result) {
        TreeNode current = root.left;
        while (current != null) {
            if (!isLeaf(current)) result.add(current.data);
            if (current.left != null) current = current.left;
            else current = current.right;
        }
    }

    private static boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }
}
