package com.trees.BST.medium;

import com.trees.TreeNode;

public class RecoverBST {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(13);
        root.left.right.left = new TreeNode(6);
        root.right = new TreeNode(12);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(14);
        root.right.right.left = new TreeNode(7);

        recoverBSTSolution solve = new recoverBSTSolution();
        solve.solve(root);
    }
}

class recoverBSTSolution {
    TreeNode prev;
    TreeNode first;
    TreeNode mid;
    TreeNode last;

    public void solve(TreeNode root) {
        first = mid = last = prev = null;
        prev = new TreeNode(Integer.MIN_VALUE);
        inorder(root);

        if (first != null && last != null) {
            int t = first.data;
            first.data = last.data;
            last.data = t;
        } else if (first != null && mid != null) {
            int t = first.data;
            first.data = mid.data;
            mid.data = t;
        }

    }

    private void inorder(TreeNode root) {
        if (root == null) return;

        inorder(root.left);
        if (prev != null && (root.data < prev.data)) {
            if (first == null) {
                first = prev;
                mid = root;
            } else last = root;
        }

        prev = root;
        inorder(root.right);
    }
}
