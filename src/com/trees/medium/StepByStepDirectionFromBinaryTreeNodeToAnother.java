package com.trees.medium;

public class StepByStepDirectionFromBinaryTreeNodeToAnother {

    static TreeNode startNode;
    static TreeNode endNode;
    static int[] total = new int[1];

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(8);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        String result = solve(root, 3, 8);
        System.out.println(result);
    }

    private static String solve(TreeNode root, int startValue, int destValue) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        dfs(root, sb1, startValue);
        dfs(root, sb2, destValue);

        int m = sb1.length();
        int n = sb2.length();

        String str1 = sb1.toString();
        String str2 = sb2.toString();

        int i = 0;
        int j = 0;

        while (i < m && j < n && str1.charAt(i) == str2.charAt(j)) {
            i++;
            j++;
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (i < m) {
            stringBuilder.append("U");
            i++;
        }

        while (j < n) {
            stringBuilder.append(str2.charAt(j));
            j++;
        }


        return stringBuilder.toString();
    }

    private static boolean dfs(TreeNode root, StringBuilder sb, int val) {
        if (root == null) {
            return false;
        }
        if (root.val == val)
            return true;

        if (root.left != null) {
            sb.append("L");
            if (dfs(root.left, sb, val)) return true;
        }
        if (root.right != null) {
            sb.append("R");
            if (dfs(root.right, sb, val)) return true;
        }

        sb.deleteCharAt(sb.length() - 1);

        return false;
    }
}