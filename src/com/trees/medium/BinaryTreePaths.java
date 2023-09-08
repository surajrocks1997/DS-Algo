package com.trees.medium;

import com.trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode((7));

        List<String> result = solve(root);
        System.out.println(result);
    }

    private static List<String> solve(TreeNode root) {
        List<String> result = new ArrayList<>();
        solve(root, result, "");
        return result;
    }

    private static void solve(TreeNode root, List<String> result, String str) {
        str += root.data;

        if (root.left == null && root.right == null) {
            result.add(str);
            return;
        }

        if (root.left != null) solve(root.left, result, str + "->");
        if (root.right != null) solve(root.right, result, str + "->");


    }
}
