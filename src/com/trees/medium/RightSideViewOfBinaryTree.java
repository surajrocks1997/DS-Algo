package com.trees.medium;

import com.trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class RightSideViewOfBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode((7));

        List<Integer> result = solve(root);
        System.out.println(result);
    }

    private static List<Integer> solve(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        solve(root, result, 0);
        return result;
    }

    private static void solve(TreeNode node, List<Integer> result, int row) {
        if (node == null) return;

        if (result.size() == row) result.add(node.data);

        if (node.right != null) solve(node.right, result, row + 1);
        if (node.left != null) solve(node.left, result, row + 1);
    }
}
