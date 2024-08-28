package com.graph.shortestPathAlgorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

// https://leetcode.com/problems/path-with-maximum-probability/description/
public class PathWithMaxProbability {

    public static void main(String[] args) {
        int n = 3;
        int[][] edges = {
                {0, 1},
                {1, 2},
                {0, 2}
        };

        double[] succProb = {0.5, 0.5, 0.2};
        int start = 0;
        int end = 2;

        double result = solve(n, edges, succProb, start, end);
        System.out.println(result);
    }

    private static double solve(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<List<Node>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(new Node(succProb[i], edges[i][1]));
            adj.get(edges[i][1]).add(new Node(succProb[i], edges[i][0]));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> Double.compare(b.prob, a.prob));
        pq.add(new Node(1, start_node));
        double[] prob = new double[n];
        prob[start_node] = 1;

        while (!pq.isEmpty()) {
            Node pollNode = pq.poll();
            if (pollNode.v == end_node) return pollNode.prob;

            for (Node node : adj.get(pollNode.v)) {
                if (prob[node.v] < pollNode.prob * node.prob) {
                    prob[node.v] = pollNode.prob * node.prob;
                    pq.add(new Node(prob[node.v], node.v));
                }
            }
        }

        return 0;
    }
}

class Node {
    double prob;
    int v;

    public Node(double prob, int v) {
        this.prob = prob;
        this.v = v;
    }
}