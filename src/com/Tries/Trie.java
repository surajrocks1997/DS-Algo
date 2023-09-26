package com.Tries;

class Trie {
    private final Node root;

    //Initialize your data structure here
    public Trie() {
        root = new Node();
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
}

class Node {
    Node[] links = new Node[26];
    boolean flag = false;

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
        flag = true;
    }

    public boolean isEnd() {
        return flag;
    }
}