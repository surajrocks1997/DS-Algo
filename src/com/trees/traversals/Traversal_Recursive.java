package com.trees.traversals;

import com.trees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Traversal_Recursive {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        solve(root);
    }

    private static void solve(TreeNode root) {
        List<Integer> preOrder = new ArrayList<>();
        preOrderTraversal(root, preOrder);
        System.out.println("PreOrder " + preOrder);

        List<Integer> postOrder = new ArrayList<>();
        postOrderTraversal(root, postOrder);
        System.out.println("PostOrder " + postOrder);

        List<Integer> inOrder = new ArrayList<>();
        inOrderTraversal(root, inOrder);
        System.out.println("InOrder " + inOrder);

        List<List<Integer>> levelOrder = new ArrayList<>();
        levelOrderTraversal(root, levelOrder);
        System.out.println("LevelOrder " + levelOrder);
    }

    private static void levelOrderTraversal(TreeNode root, List<List<Integer>> levelOrder) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return;
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                if (queue.peek().left != null) queue.add(queue.peek().left);
                if (queue.peek().right != null) queue.add(queue.peek().right);
                list.add(queue.poll().data);
            }
            levelOrder.add(list);
        }
    }

    private static void inOrderTraversal(TreeNode root, List<Integer> inOrder) {
        if (root == null) return;

        inOrderTraversal(root.left, inOrder);
        inOrder.add(root.data);
        inOrderTraversal(root.right, inOrder);
    }

    private static void postOrderTraversal(TreeNode root, List<Integer> postOrder) {
        if (root == null) return;

        postOrderTraversal(root.left, postOrder);
        postOrderTraversal(root.right, postOrder);
        postOrder.add(root.data);

    }

    private static void preOrderTraversal(TreeNode root, List<Integer> preOrder) {
        if (root == null) return;

        preOrder.add(root.data);
        preOrderTraversal(root.left, preOrder);
        preOrderTraversal(root.right, preOrder);
    }

}

