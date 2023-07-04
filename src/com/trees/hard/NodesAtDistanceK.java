package com.trees.hard;

import com.trees.TreeNode;

import java.util.*;

public class NodesAtDistanceK {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(40);
        root.left = new TreeNode(10);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(30);
        root.right.right = new TreeNode(40);

        int k = 2;
        TreeNode target = root.left.left;
        List<Integer> result = solve(root, target, k);
        System.out.println(result);
    }

    private static List<Integer> solve(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        markParents(root, parentMap, target);

        Map<TreeNode, Boolean> visited = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(target);
        visited.put(target, true);
        int distance = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            if (distance == k) break;
            distance++;

            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();

                if (current.left != null && visited.get(current.left) == null) {
                    queue.add(current.left);
                    visited.put(current.left, true);
                }
                if (current.right != null && visited.get(current.right) == null) {
                    queue.add(current.right);
                    visited.put(current.right, true);
                }
                if (parentMap.get(current) != null && visited.get(parentMap.get(current)) == null) {
                    queue.add(parentMap.get(current));
                    visited.put(parentMap.get(current), true);
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            result.add(current.data);
        }

        return result;
    }

    private static void markParents(TreeNode root, Map<TreeNode, TreeNode> parentMap, TreeNode target) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current.left != null) {
                parentMap.put(current.left, current);
                queue.add(current.left);
            }
            if (current.right != null) {
                parentMap.put(current.right, current);
                queue.add(current.right);
            }
        }
    }
}