package com.linkedlist;

// https://leetcode.com/problems/linked-list-in-binary-tree/
public class LinkedListInBinaryTree {
    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(8);

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(2);
        root.right.left.left = new TreeNode(6);
        root.right.left.right = new TreeNode(8);
        root.right.left.right.left = new TreeNode(1);
        root.right.left.right.right = new TreeNode(3);

        boolean res = isSubPath(head, root);
        System.out.println(res);

    }

    private static boolean isSubPath(ListNode head, TreeNode root) {
        if (helper(head, root))
            return true;

        if (root == null) return false;
        return isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    private static boolean helper(ListNode head, TreeNode root) {
        if (head == null) return true;
        if (root == null) return false;
        if (head.val != root.val) return false;

        return helper(head.next, root.left) || helper(head.next, root.right);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
