package com.trees.medium;

public class NumberOfGoodLeafNodePairs {
    static int pairs = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        int distance = 3;
        int count = solve(root, distance);
        System.out.println(count);
    }

    private static int solve(TreeNode root, int distance) {
        dfs(root, distance);
        return pairs;
    }

    private static int[] dfs(TreeNode root, int distance) {
        if (root == null) return new int[]{};

        if (root.left == null && root.right == null)
            return new int[]{1};

        int[] leftDist = dfs(root.left, distance);
        int[] rightDist = dfs(root.right, distance);

        for (int ele1 : leftDist) {
            for (int ele2 : rightDist) {
                if (ele1 + ele2 <= distance)
                    pairs++;
            }
        }

        int[] allDist = new int[leftDist.length + rightDist.length];
        int i = 0;
        while (i < leftDist.length)
            allDist[i] = leftDist[i++] + 1;

        while (i < rightDist.length + leftDist.length) {
            allDist[i] = rightDist[i - leftDist.length] + 1;
            i++;
        }

        return allDist;
    }
}