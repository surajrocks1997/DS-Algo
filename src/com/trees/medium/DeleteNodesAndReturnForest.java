package com.trees.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://leetcode.com/problems/delete-nodes-and-return-forest/
public class DeleteNodesAndReturnForest {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        int[] to_delete = {3, 5};

        List<TreeNode> result = solve(root, to_delete);
        result.forEach(ele -> System.out.print(ele.val + " "));
    }

    private static List<TreeNode> solve(TreeNode root, int[] to_delete) {
        List<TreeNode> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int ele : to_delete)
            set.add(ele);

        helper(root, true, list, set);
        return list;
    }

    private static boolean helper(TreeNode root, boolean isValidRoot, List<TreeNode> list, Set<Integer> set) {
        if (root == null) return false;

        if (set.contains(root.val)) {
            if (root.left != null)
                helper(root.left, true, list, set);
            if (root.right != null)
                helper(root.right, true, list, set);

            return true;
        }

        boolean left = helper(root.left, false, list, set);
        boolean right = helper(root.right, false, list, set);

        if (left) root.left = null;
        if (right) root.right = null;

        if (isValidRoot) list.add(root);
        return false;
    }
}
