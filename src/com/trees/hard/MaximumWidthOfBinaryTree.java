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
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));
        int width = -1;

        while(!queue.isEmpty()){
            int size = queue.size();
            int min = queue.peek().index;

            int first = 0;
            int last = 0;

            for(int i = 0; i < size; i++){
                Pair poll = queue.poll();
                int current = poll.index - min;

                if(i == 0) first = current;
                if(i == size-1) last = current;

                if(poll.node.left != null) queue.add(new Pair(poll.node.left, (2 * current) + 1));
                if(poll.node.right != null) queue.add(new Pair(poll.node.right, (2 * current) + 2));
            }

            width = Math.max(width, last-first+1);
        }
        return width;
    }
}

class Pair {

    TreeNode node;
    int index;

    public Pair(TreeNode node, int index) {
        this.node = node;
        this.index = index;
    }
}
