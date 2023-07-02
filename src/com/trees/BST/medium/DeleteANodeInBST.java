package com.trees.BST.medium;

import com.trees.TreeNode;

public class DeleteANodeInBST {
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

        TreeNode result = helper(root, 15);
        System.out.println(result.data);
    }

    private static TreeNode helper(TreeNode root, int val) {
        if (root == null) return null;
        if (root.data == val) return helper(root);

        TreeNode dummyRoot = root;
        while (root != null) {
            if (root.data > val) {
                if (root.left != null && root.left.data == val) {
                    root.left = helper(root.left);
                    break;
                } else root = root.left;
            } else {
                if (root.right != null && root.right.data == val) {
                    root.right = helper(root.right);
                    break;
                } else root = root.right;
            }
        }
        return dummyRoot;
    }

    private static TreeNode helper(TreeNode root) {
        if (root.left == null) return root.right;
        else if (root.right == null) return root.left;

        TreeNode rightChild = root.right;
        TreeNode lastRight = findLastRight(root.left);
        lastRight.right = rightChild;
        return root.left;
    }

    private static TreeNode findLastRight(TreeNode root) {
        if (root.right == null) return root;
        return findLastRight(root.right);
    }
}
