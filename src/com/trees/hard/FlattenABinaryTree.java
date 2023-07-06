package com.trees.hard;

import com.trees.TreeNode;

import java.util.Stack;

public class FlattenABinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

//        solve(root);
//        TreeNode current = root;
//        while (current != null) {
//            System.out.print(current.data + " ");
//            current = current.right;
//        }
        
        solveUsingRecursion(root);
        TreeNode current = root;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.right;
        }

    }

    private static void solveUsingRecursion(TreeNode root) {
        if (root == null) return;

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = null;

        solveUsingRecursion(left);
        solveUsingRecursion(right);

        root.right = left;
        TreeNode cur = root;
        while (cur.right != null) cur = cur.right;
        cur.right = right;
    }

    private static void solve(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            if (current.right != null) stack.push(current.right);
            if (current.left != null) stack.push(current.left);

            if (!stack.isEmpty()) current.right = stack.peek();
            current.left = null;
        }
    }
}
