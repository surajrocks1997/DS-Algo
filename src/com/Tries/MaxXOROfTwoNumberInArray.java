package com.Tries;

// https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/

public class MaxXOROfTwoNumberInArray {
    public static void main(String[] args) {
        int[] nums = {3, 10, 5, 25, 2, 8};

        int result = solve(nums);
        System.out.println(result);
    }

    private static int solve(int[] nums) {
        Trie_MaxXOROfTwoNumberInArray trie = new Trie_MaxXOROfTwoNumberInArray();
        for (int i = 0; i < nums.length; i++) {
            trie.insert(nums[i]);
        }

        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, trie.getMax(nums[i]));
        }

        return max;

    }
}

class Trie_MaxXOROfTwoNumberInArray {
    Node_MaxXOROfTwoNumberInArray root;

    public Trie_MaxXOROfTwoNumberInArray() {
        this.root = new Node_MaxXOROfTwoNumberInArray();
    }

    public void insert(int num) {
        Node_MaxXOROfTwoNumberInArray node = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (!node.containsKey(bit)) {
                node.put(bit, new Node_MaxXOROfTwoNumberInArray());
            }
            node = node.get(bit);
        }
    }

    public int getMax(int num) {
        Node_MaxXOROfTwoNumberInArray node = root;
        int maxNum = 0;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (node.containsKey(1 - bit)) {
                maxNum = maxNum | (1 << i);
                node = node.get(1 - bit);
            } else {
                node = node.get(bit);
            }
        }

        return maxNum;
    }
}

class Node_MaxXOROfTwoNumberInArray {

    Node_MaxXOROfTwoNumberInArray[] links = new Node_MaxXOROfTwoNumberInArray[2];

    public Node_MaxXOROfTwoNumberInArray() {
    }

    public boolean containsKey(int bit) {
        return links[bit] != null;
    }

    public Node_MaxXOROfTwoNumberInArray get(int bit) {
        return links[bit];
    }

    public void put(int bit, Node_MaxXOROfTwoNumberInArray node) {
        links[bit] = node;
    }
}