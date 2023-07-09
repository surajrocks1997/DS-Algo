package com.trees.BST.medium;

import com.trees.TreeNode;

public class InorderSuccessorInBST {
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

        TreeNode p = root.right.left;

        TreeNode result = solve(root, p);
        System.out.println(result.data);
    }

    private static TreeNode solve(TreeNode root, TreeNode p) {
        TreeNode successor = null;
        while (root != null) {
            if (p.data >= root.data)
                root = root.right;
            else {
                successor = root;
                root = root.left;
            }
        }
        return successor;
    }
}
