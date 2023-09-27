package com.trees.BST.medium;

import com.trees.TreeNode;

public class LargestBSTinBT {
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

        int result = solve(root);
        System.out.println(result);
    }

    private static int solve(TreeNode root) {
        return largestBSTSubtreeHelper(root).maxSize;
    }

    private static NodeMetaData largestBSTSubtreeHelper(TreeNode root) {
        if (root == null) return new NodeMetaData(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);

        NodeMetaData left = largestBSTSubtreeHelper(root.left);
        NodeMetaData right = largestBSTSubtreeHelper(root.right);

        if (root.data > left.max && root.data < right.min)
            return new NodeMetaData(Math.min(root.data, left.min),
                    Math.max(root.data, right.max), left.maxSize + right.maxSize + 1);
        else return new NodeMetaData(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.maxSize, right.maxSize));
    }
}

class NodeMetaData {
    public int min, max, maxSize;

    public NodeMetaData(int min, int max, int maxSize) {
        this.min = min;
        this.max = max;
        this.maxSize = maxSize;
    }
}
