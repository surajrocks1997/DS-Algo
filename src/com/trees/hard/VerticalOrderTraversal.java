package com.trees.hard;

import com.trees.TreeNode;

import java.util.*;

public class VerticalOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.left.right = new TreeNode(5);

        List<List<Integer>> result = solve(root);
        System.out.println(result);
    }

    private static List<List<Integer>> solve(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> queue = new LinkedList<>();
        queue.add(new Tuple(root, 0, 0));
        while (!queue.isEmpty()) {
            Tuple tuple = queue.poll();
            TreeNode node = tuple.node;
            int row = tuple.row;
            int col = tuple.col;

            if (!map.containsKey(col))
                map.put(col, new TreeMap<>());
            if (!map.get(col).containsKey(row))
                map.get(col).put(row, new PriorityQueue<>());

            map.get(col).get(row).add(node.data);

            if (node.left != null)
                queue.add(new Tuple(node.left, row + 1, col - 1));
            if (node.right != null)
                queue.add(new Tuple(node.right, row + 1, col + 1));
        }

        List<List<Integer>> result = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<Integer>> col : map.values()) {
            List<Integer> current = new ArrayList<>();
            for (PriorityQueue<Integer> treeNodes : col.values()) {
                while (!treeNodes.isEmpty()) {
                    current.add(treeNodes.poll());
                }
            }
            result.add(current);
        }
        return result;
    }
}

class Tuple {
    TreeNode node;
    int row;
    int col;

    public Tuple(TreeNode node, int row, int col) {
        this.node = node;
        this.row = row;
        this.col = col;
    }
}
