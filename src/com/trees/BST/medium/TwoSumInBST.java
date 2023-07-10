package com.trees.BST.medium;

import com.trees.TreeNode;

import java.util.Stack;

public class TwoSumInBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(7);
        root.left.right.left = new TreeNode(6);
        root.right = new TreeNode(12);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(14);
        root.right.right.left = new TreeNode(13);

        int k = 17;
        boolean result = solve(root, k);
        System.out.println(result);
    }

    private static boolean solve(TreeNode root, int k) {
        if (root == null) return false;
        BSTIterator_TwoSumOptimized left = new BSTIterator_TwoSumOptimized(root, false);
        BSTIterator_TwoSumOptimized right = new BSTIterator_TwoSumOptimized(root, true);

        int i = left.next();
        int j = right.next();

        while (i < j) {
            if (i + j == k) return true;
            else if (i + j < k) i = left.next();
            else j = right.next();
        }

        return false;
    }
}

class BSTIterator_TwoSumOptimized {
    final Stack<TreeNode> stack;
    private final boolean reverse;

    public BSTIterator_TwoSumOptimized(TreeNode root, boolean reverse) {
        stack = new Stack<>();
        this.reverse = reverse;
        pushAll(root);

    }

    private void pushAll(TreeNode root) {
        while (root != null) {
            stack.push(root);
            if (reverse)
                root = root.right;
            else root = root.left;
        }
    }

    public int next() {
        TreeNode temp = stack.pop();
        if (!reverse) pushAll(temp.right);
        else pushAll(temp.left);
        return temp.data;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
