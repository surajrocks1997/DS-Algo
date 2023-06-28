package com.trees.traversals;

import com.trees.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Traversal_Iterative {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        List<Integer> inOrder = inOrder(root);
        System.out.println("InOrder " + inOrder);

        List<Integer> preOrder = preOrder(root);
        System.out.println("PreOrder " + preOrder);

        List<Integer> postOrder2 = postOrder2Stack(root);
        System.out.println("PostOrder 2 Stack " + postOrder2);

        List<Integer> postOrder1 = postOrder1Stack(root);
        System.out.println("PostOrder 1 Stack " + postOrder1);
    }

    private static List<Integer> postOrder1Stack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> postOrder1 = new ArrayList<>();
        if (root == null) return postOrder1;

        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode temp = stack.peek().right;
                if (temp == null) {
                    temp = stack.peek();
                    stack.pop();
                    postOrder1.add(temp.data);

                    while (!stack.isEmpty() && temp == stack.peek().right) {
                        temp = stack.peek();
                        stack.pop();
                        postOrder1.add(temp.data);
                    }
                } else root = temp;
            }
        }

        return postOrder1;
    }

    private static List<Integer> postOrder2Stack(TreeNode root) {
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        List<Integer> postOrder2 = new ArrayList<>();

        if (root == null) return postOrder2;
        stack1.push(root);
        while (!stack1.isEmpty()) {
            root = stack1.pop();
            stack2.add(root);
            if (root.left != null) stack1.add(root.left);
            if (root.right != null) stack1.add(root.right);
        }

        while (!stack2.isEmpty())
            postOrder2.add(stack2.pop().data);

        return postOrder2;
    }

    private static List<Integer> preOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> preOrder = new ArrayList<>();
        if (root == null) return preOrder;
        stack.add(root);

        while (!stack.isEmpty()) {
            root = stack.pop();
            preOrder.add(root.data);
            if(root.right != null) stack.push(root.right);
            if(root.left != null) stack.push(root.left);
        }
        return preOrder;
    }

    private static List<Integer> inOrder(TreeNode root) {
        List<Integer> inOrder = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode node = root;
        while (true) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                if (stack.isEmpty()) break;
                node = stack.pop();
                inOrder.add(node.data);
                node = node.right;
            }
        }
        return inOrder;
    }
}
