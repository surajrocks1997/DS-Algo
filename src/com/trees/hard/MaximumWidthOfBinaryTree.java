package com.trees.hard;

import com.trees.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumWidthOfBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.left.right = new TreeNode(5);

        int result = solve(root);
        System.out.println(result);
    }

    private static int solve(TreeNode root) {
        if (root == null) return 0;
        Queue<Pair> queue = new LinkedList<>();
        int width = 0;
        queue.add(new Pair(root, width));

        while (!queue.isEmpty()) {
            int size = queue.size();
            int mMin = queue.peek().num;

//            below first and last are required to calculate max width on that level
            int first = 0; //first node on that level
            int last = 0; // last node on that level

            for (int i = 0; i < size; i++) {
                int current = queue.peek().num - mMin;
                TreeNode node = queue.peek().node;
                queue.poll();
                if (i == 0) first = current;
                if (i == size - 1) last = current;
                if (node.left != null)
                    queue.add(new Pair(node.left, (current * 2) + 1));
                if (node.right != null)
                    queue.add(new Pair(node.right, (current * 2) + 2));
            }
            width = Math.max(width, last - first + 1);
        }

        return width;
    }
}

class Pair {

    TreeNode node;
    int num;

    public Pair(TreeNode node, int num) {
        this.node = node;
        this.num = num;
    }
}
