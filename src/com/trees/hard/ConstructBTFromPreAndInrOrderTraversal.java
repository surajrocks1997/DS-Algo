package com.trees.hard;

import com.trees.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBTFromPreAndInrOrderTraversal {
    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        TreeNode result = solve(preorder, inorder);
        System.out.println(result.data);
    }

    private static TreeNode solve(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);

        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
    }

    private static TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> map) {
        if (preStart > preEnd || inStart > inEnd) return null;

        TreeNode root = new TreeNode(preorder[preStart]);
        int inorderRoot = map.get(root.data);
        int leftNums = inorderRoot - inStart;

        root.left = buildTree(preorder, preStart + 1, preStart + leftNums, inorder, inStart, inorderRoot - 1, map);
        root.right = buildTree(preorder, preStart + leftNums + 1, preEnd, inorder, inorderRoot + 1, inEnd, map);

        return root;
    }
}
