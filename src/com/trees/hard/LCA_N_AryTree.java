package com.trees.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LCA_N_AryTree {
    public static void main(String[] args) {
        Node root = new Node(1);
        Node rootChild1 = new Node(2);
        Node rootChild2 = new Node(3);
        Node rootChild3 = new Node(4);
        root.list.addAll(Arrays.asList(rootChild1, rootChild2, rootChild3));

        Node rootChild1_1 = new Node(5);
        Node rootChild1_2 = new Node(6);
        rootChild1.list.addAll(Arrays.asList(rootChild1_1, rootChild1_2));
        rootChild1_2.list.add(new Node(11));

        rootChild2.list.add(new Node(7));

        Node rootChild3_1 = new Node(8);
        Node rootChild3_2 = new Node(9);
        Node rootChild3_3 = new Node(10);
        rootChild3.list.addAll(Arrays.asList(rootChild3_1, rootChild3_2, rootChild3_3));
        rootChild3_1.list.add(new Node(12));

        rootChild3_3.list.addAll(Arrays.asList(new Node(13), new Node(14)));

        int V = 14;

        int result = solve(root, 12, 14, V);
        System.out.println(result);
    }

    private static int solve(Node root, int p, int q, int V) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        createAdj(adj, root);
        List<List<Integer>> result = new ArrayList<>();
        dfs(adj, root.val, new ArrayList<>(), p, q, result);

        List<Integer> lca1 = result.get(0);
        List<Integer> lca2 = result.get(1);
        int i = 0;
        while(lca1.get(i).equals(lca2.get(i))){
            i++;
        }

        return lca1.get(i-1);
    }

    private static void dfs(List<List<Integer>> adj, int node, List<Integer> curr, int p, int q, List<List<Integer>> result) {
        if (node == p || node == q) {
            curr.add(node);
            result.add(new ArrayList<>(curr));
            return;
        }
        curr.add(node);

        for (int it : adj.get(node)) {
            dfs(adj, it, new ArrayList<>(curr), p, q, result);
        }
    }

    private static void createAdj(List<List<Integer>> adj, Node root) {
        List<Node> nodeList = root.list;
        for (Node node : nodeList) {
            adj.get(root.val).add(node.val);
            createAdj(adj, node);
        }
    }
}

class Node {
    int val;
    List<Node> list;

    public Node(int val) {
        this.val = val;
        this.list = new ArrayList<>();
    }
}