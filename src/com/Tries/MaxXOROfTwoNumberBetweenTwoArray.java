package com.Tries;

public class MaxXOROfTwoNumberBetweenTwoArray {
    public static void main(String[] args) {
        int n = 2;
        int m = 3;
        int[] arr1 = {6, 8};
        int[] arr2 = {7, 8, 2};

        int result = solve(n, m, arr1, arr2);
        System.out.println(result);
    }

    private static int solve(int n, int m, int[] arr1, int[] arr2) {
        Trie_MaxXOROfTwoNumberBetweenTwoArray trie = new Trie_MaxXOROfTwoNumberBetweenTwoArray();
        for (int i = 0; i < arr1.length; i++)
            trie.insert(arr1[i]);

        int max = 0;

        for (int i = 0; i < arr2.length; i++) {
            max = Math.max(max, trie.getMax(arr2[i]));
        }
        return max;
    }
}

class Trie_MaxXOROfTwoNumberBetweenTwoArray {
    Node_MaxXOROfTwoNumberBetweenTwoArray root;

    public Trie_MaxXOROfTwoNumberBetweenTwoArray() {
        this.root = new Node_MaxXOROfTwoNumberBetweenTwoArray();
    }

    public void insert(int num) {    //num here is 32-bit number
        Node_MaxXOROfTwoNumberBetweenTwoArray node = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (!node.containsKey(bit)) {
                node.put(bit, new Node_MaxXOROfTwoNumberBetweenTwoArray());
            }
            node = node.get(bit);
        }
    }

    public int getMax(int num) {
        Node_MaxXOROfTwoNumberBetweenTwoArray node = root;
        int maxNum = 0;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (node.containsKey(1 - bit)) {
                maxNum = maxNum | (1 << i);     // creating the number bit by bit by maximizing number.
                                                // hence making bit 1 by turning on from left to right.
                node = node.get(1 - bit);
            } else {
                node = node.get(bit);
            }
        }

        return maxNum;
    }
}

class Node_MaxXOROfTwoNumberBetweenTwoArray {
    Node_MaxXOROfTwoNumberBetweenTwoArray[] links = new Node_MaxXOROfTwoNumberBetweenTwoArray[2];

    public Node_MaxXOROfTwoNumberBetweenTwoArray() {
    }

    public boolean containsKey(int bit) {
        return links[bit] != null;
    }

    public Node_MaxXOROfTwoNumberBetweenTwoArray get(int bit) {
        return links[bit];
    }

    void put(int bit, Node_MaxXOROfTwoNumberBetweenTwoArray node) {
        links[bit] = node;
    }
}
