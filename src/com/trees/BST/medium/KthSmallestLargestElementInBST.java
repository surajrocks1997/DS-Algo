package com.trees.BST.medium;

import com.trees.TreeNode;

public class KthSmallestLargestElementInBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(6);

        int k = 2;
        int result = KthSmallest(root, k);
        System.out.println(result);

        result = KthLargest(root, 2);
        System.out.println(result);
    }

    private static int KthSmallest(TreeNode root, int k) {
        int[] arr = new int[2];
        KthSmallestElement(root, k, arr);
        return arr[1];
    }

    private static void KthSmallestElement(TreeNode root, int k, int[] arr) {
        if (root == null) return;

        if (root.left != null) KthSmallestElement(root.left, k, arr);
        arr[0] += 1;
        System.out.println("Count: " + arr[0] + " : " + root.data + " : " + k);
        if (arr[0] == k) {
            arr[1] = root.data;
            return;
        }
        if (root.right != null) KthSmallestElement(root.right, k, arr);
    }

    private static int KthLargest(TreeNode root, int k) {
        int[] arr = new int[2];
        KthLargestElement(root, k, arr);
        return arr[1];
    }

    private static void KthLargestElement(TreeNode root, int k, int[] arr) {
        if (root == null) return;

        if (root.right != null) KthLargestElement(root.right, k, arr);
        arr[0] += 1;
        System.out.println("Count: " + arr[0] + " : " + root.data + " : " + k);
        if (arr[0] == k) {
            arr[1] = root.data;
            return;
        }
        if (root.left != null) KthLargestElement(root.left, k, arr);
    }
}
