package com.trees.hard;

import com.trees.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SerialIzeAndDeserializeBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(40);
        root.left = new TreeNode(10);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(40);
        root.right.right.left = new TreeNode(30);

        Codec codec = new Codec();
        String serialize = codec.serialize(root);
        System.out.println(serialize.equals("") ? "null" : serialize);

        TreeNode deserialize = codec.deserialize(serialize);
        System.out.println(deserialize != null ? deserialize.data : 0);
    }
}

class Codec {

    public String serialize(TreeNode root) {
        if (root == null) return "";
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder str = new StringBuilder();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode node = queue.poll();

            if (node == null) {
                str.append("n ");
                continue;
            }

            str.append(node.data).append(" ");
            queue.add(node.left);
            queue.add(node.right);
        }

        return str.toString();
    }

    public TreeNode deserialize(String data) {
        if (data.equals("")) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        String[] str = data.split(" ");

        TreeNode root = new TreeNode(Integer.parseInt(str[0]));
        queue.add(root);

        for (int i = 1; i < str.length; i++) {
            TreeNode parent = queue.poll();
            if (!str[i].equals("n")) {
                TreeNode left = new TreeNode(Integer.parseInt(str[i]));
                parent.left = left;
                queue.add(left);
            }

            if (!str[++i].equals("n")) {
                TreeNode right = new TreeNode(Integer.parseInt(str[i]));
                parent.right = right;
                queue.add(right);
            }
        }

        return root;
    }
}
