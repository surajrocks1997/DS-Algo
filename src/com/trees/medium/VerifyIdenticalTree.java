package com.trees.medium;

import com.trees.TreeNode;

public class VerifyIdenticalTree {
    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);

        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(2);
        q.right = new TreeNode(3);

        System.out.println(solve(p, q));
    }

    private static boolean solve(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        else if (p == null || q == null) return false;
        else if (p.data != q.data) return false;
        else return solve(p.left, q.left) && solve(p.right, q.right);
    }
}
