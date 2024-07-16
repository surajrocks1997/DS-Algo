package com.trees.medium;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/create-binary-tree-from-descriptions/
public class CreateBinaryTreeFromDescriptions {

    public static void main(String[] args) {
        int[][] descriptions = {
                {20, 15, 1},
                {20, 17, 0},
                {50, 20, 1},
                {50, 80, 0},
                {80, 19, 1}
        };

        TreeNode_CreateBinaryTreeFromDescriptions result = solve(descriptions);
        System.out.println(result.val);
    }

    private static TreeNode_CreateBinaryTreeFromDescriptions solve(int[][] descriptions) {
        Map<Integer, Pair_CreateBinaryTreeFromDescriptions> map = new HashMap<>();
        for (int[] row : descriptions) {
            Pair_CreateBinaryTreeFromDescriptions p = map.getOrDefault(row[0], new Pair_CreateBinaryTreeFromDescriptions(new TreeNode_CreateBinaryTreeFromDescriptions(row[0]), false));
            map.put(row[0], map.getOrDefault(row[0], p));
            if (row[2] == 1) {
                Pair_CreateBinaryTreeFromDescriptions leftChild = map.getOrDefault(row[1], new Pair_CreateBinaryTreeFromDescriptions(new TreeNode_CreateBinaryTreeFromDescriptions(row[1]), true));
                leftChild.setIsChild(true);
                map.put(row[1], leftChild);
                p.node.left = leftChild.node;
            } else {
                Pair_CreateBinaryTreeFromDescriptions rightChild = map.getOrDefault(row[1], new Pair_CreateBinaryTreeFromDescriptions(new TreeNode_CreateBinaryTreeFromDescriptions(row[1]), true));
                rightChild.setIsChild(true);
                map.put(row[1], rightChild);
                p.node.right = rightChild.node;
            }
        }

        List<Pair_CreateBinaryTreeFromDescriptions> collect = map.values().stream().filter(ele -> !ele.isChild).toList();
        return collect.get(0).getNode();
    }
}

class Pair_CreateBinaryTreeFromDescriptions {
    TreeNode_CreateBinaryTreeFromDescriptions node;
    boolean isChild;

    public Pair_CreateBinaryTreeFromDescriptions(TreeNode_CreateBinaryTreeFromDescriptions node, boolean isChild) {
        this.node = node;
        this.isChild = isChild;
    }

    public TreeNode_CreateBinaryTreeFromDescriptions getNode() {
        return node;
    }

    public void setNode(TreeNode_CreateBinaryTreeFromDescriptions node) {
        this.node = node;
    }

    public boolean isChild() {
        return isChild;
    }

    public void setIsChild(boolean child) {
        isChild = child;
    }
}

class TreeNode_CreateBinaryTreeFromDescriptions {
    TreeNode_CreateBinaryTreeFromDescriptions left;
    TreeNode_CreateBinaryTreeFromDescriptions right;
    int val;

    public TreeNode_CreateBinaryTreeFromDescriptions(int val) {
        this.val = val;
    }
}