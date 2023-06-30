package com.trees.medium;

import com.trees.TreeNode;

import java.util.*;

public class BottomViewOfBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.left.right = new TreeNode(5);

        List<Integer> result = solve(root);
        System.out.println(result);
    }

    private static List<Integer> solve(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<Pair>();
        queue.add(new Pair(0, root));
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pair poll = queue.poll();
                map.put(poll.column, poll.node.data);

                if (poll.node.left != null)
                    queue.add(new Pair(poll.column - 1, poll.node.left));
                if (poll.node.right != null)
                    queue.add(new Pair(poll.column + 1, poll.node.right));
            }
        }

        result.addAll(map.values());
        return result;
    }
}
