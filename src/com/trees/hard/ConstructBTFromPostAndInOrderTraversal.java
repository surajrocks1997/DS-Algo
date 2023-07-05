package com.trees.hard;

import com.trees.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBTFromPostAndInOrderTraversal {
    public static void main(String[] args) {
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};

        TreeNode root = solve(inorder, postorder);
        System.out.println(root.data);
    }

    private static TreeNode solve(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) map.put(inorder[i], i);
        return buildTree(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1, map);
    }

    private static TreeNode buildTree(int[] postorder, int postStart, int postEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> map) {
        if (postStart > postEnd || inStart > inEnd) return null;

        TreeNode root = new TreeNode(postorder[postEnd]);

        int inorderRoot = map.get(root.data);
        int leftNums = inorderRoot - inStart;

        root.left = buildTree(postorder, postStart, postStart + leftNums - 1, inorder, inStart, inorderRoot - 1, map);
        root.right = buildTree(postorder, postStart + leftNums, postEnd - 1, inorder, inorderRoot + 1, inEnd, map);

        return root;
    }
}
