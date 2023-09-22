package com.trees.medium;

import com.trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class RootToLeafPath {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode((7));

        List<List<Integer>> result = solve(root);
        System.out.println(result);
    }

    private static List<List<Integer>> solve(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        solve(root, result, new ArrayList<>());
        return result;
    }

    private static void solve(TreeNode root, List<List<Integer>> result, List<Integer> current) {
        if (root == null) return;
        current.add(root.data);
        if (isLeaf(root)) {
            result.add(new ArrayList<>(current));
            return;
        }

        solve(root.left, result, new ArrayList<>(current));
        solve(root.right, result, new ArrayList<>(current));

    }

    private static boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }
}
