package com.trees.BST.medium;

import com.trees.TreeNode;

public class BSTFromPreorderTraversal {
    public static void main(String[] args) {
        int[] preorder = {8, 5, 1, 7, 10, 12};
        TreeNode root = solve(preorder);
        System.out.println(root.data);
    }

    private static TreeNode solve(int[] preorder) {
        return createBST(preorder, Integer.MAX_VALUE, new int[]{0});
    }

    private static TreeNode createBST(int[] preorder, int bound, int[] i) {
        if (i[0] >= preorder.length || preorder[i[0]] > bound) return null;
        TreeNode root = new TreeNode(preorder[i[0]]);
        i[0]++;
        root.left = createBST(preorder, root.data, i);
        root.right = createBST(preorder, bound, i);
        return root;
    }
}
