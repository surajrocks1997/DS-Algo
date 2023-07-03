package com.trees.medium;

import com.trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class RootToNodePath {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode((7));

        int val = 6;
        List<Integer> result = solve(root, val);
        System.out.println(result);
    }

    private static List<Integer> solve(TreeNode root, int val) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        solve(root, val, result);
        return result;
    }

    private static boolean solve(TreeNode root, int val, List<Integer> result) {
        if (root == null) return false;
        result.add(root.data);
        if (root.data == val) return true;

        if (solve(root.left, val, result) || solve(root.right, val, result))
            return true;

        result.remove(result.size() - 1);

        return false;
    }
}
