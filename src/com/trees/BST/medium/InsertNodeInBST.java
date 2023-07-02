package com.trees.BST.medium;

import com.trees.TreeNode;

public class InsertNodeInBST {
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

        TreeNode result = solve(root, 15);
        System.out.println(result.data);
    }

    private static TreeNode solve(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        while (true) {
            if (val > root.data) {
                if (root.right != null)
                    root = root.right;
                else {
                    root.right = new TreeNode(val);
                    break;
                }
            } else {
                if (root.left != null)
                    root = root.left;
                else {
                    root.left = new TreeNode(val);
                    break;
                }

            }
        }

        return root;
    }
}
