package com.trees.traversals;

import com.trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class MorrisTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        List<Integer> result = inorder(root);
        System.out.println(result);
    }

    private static List<Integer> inorder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        TreeNode current = root;
        while (current != null) {
            if (current.left == null) {
                result.add(current.data);
                current = current.right;
            } else {
                TreeNode left = current.left;
                while (left.right != null && left.right != current)
                    left = left.right;

                if (left.right == null) {
                    left.right = current;
                    current = current.left;
                } else {
                    left.right = null;
                    result.add(current.data);
                    current = current.right;
                }
            }
        }

        return result;
    }
}
