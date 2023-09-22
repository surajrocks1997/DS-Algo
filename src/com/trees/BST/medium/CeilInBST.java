package com.trees.BST.medium;

import com.trees.TreeNode;

public class CeilInBST {
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

        int result = solve(root, 0);
        System.out.println(result);
    }

    private static int solve(TreeNode root, int val) {
        int ceil = -1;
        while (root != null) {
            if (root.data == val)
                return root.data;

            if (root.data > val) {
                ceil = root.data;
                root = root.left;
            } else
                root = root.right;
        }

        return ceil;
    }
}

// another working soluton

//    int ceil = -1;
//        while(root != null){
//                if(root.data >= x){
//                ceil = root.data;
//                root = root.left;
//                } else{
//                root = root.right;
//                }
//                }
//
//                return ceil;
