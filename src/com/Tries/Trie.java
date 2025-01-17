package com.Tries;

class Trie {
    private Node root;

    //Initialize your data structure here
    public Trie() {
        root = new Node();
    }

    public Node getRoot() {
        return root;
    }

    //Inserts a word into the trie
    public void insert(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (!node.containsKey(word.charAt(i))) {
                node.put(word.charAt(i), new Node());
            }
            node = node.get(word.charAt(i));
        }
        node.setEnd();
    }

    //Returns if the word is in the trie
    public boolean search(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (!node.containsKey(word.charAt(i))) {
                return false;
            }
            node = node.get(word.charAt(i));
        }
        return node.isEnd();
    }


    //Returns if there is any word in the trie that starts with the given prefix
    public boolean startsWith(String prefix) {
        Node node = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (!node.containsKey(prefix.charAt(i))) {
                return false;
            }
            node = node.get(prefix.charAt(i));
        }
        return true;
    }

    public boolean prefixExist(String word) {
        boolean flag = true;
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (node.containsKey(word.charAt(i))) {
                node = node.get(word.charAt(i));
                if (!node.isEnd()) return false;
            } else return false;
        }
        return flag;
    }
}

class Node {
    Node[] links = new Node[26];
    boolean isEnd = false;

    public Node() {
    }

    public boolean containsKey(char ch) {
        return (links[ch - 'a'] != null);
    }

    public Node get(char ch) {
        return links[ch - 'a'];
    }

    public void put(char ch, Node node) {
        links[ch - 'a'] = node;
    }

    public void setEnd() {
        isEnd = true;
    }

    public boolean isEnd() {
        return isEnd;
    }
}