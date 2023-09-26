package com.Tries;

public class Trie_II {
    NodeII root;

    public Trie_II() {
        this.root = new NodeII();
    }

    public void insert(String word) {
        NodeII node = root;
        for (int i = 0; i < word.length(); i++) {
            if (!node.containsKey(word.charAt(i))) {
                node.put(word.charAt(i), new NodeII());
            }
            node = node.get(word.charAt(i));
            node.increaseCountPrefix();
        }

        node.increaseEnd();
    }

    public int countWordsEqualTo(String word) {
        NodeII node = root;
        for (int i = 0; i < word.length(); i++) {
            if (node.containsKey(word.charAt(i))) {
                node = node.get(word.charAt(i));
            } else return 0;
        }
        return node.getCountPrefix();
    }

    public int countWordsStartingWith(String word) {
        NodeII node = root;
        for (int i = 0; i < word.length(); i++) {
            if (node.containsKey(word.charAt(i))) {
                node = node.get(word.charAt(i));
            } else return 0;
        }
        return node.getCountPrefix();
    }

    public void erase(String word) {
        NodeII node = root;
        for (int i = 0; i < word.length(); i++) {
            if (node.containsKey(word.charAt(i))) {
                node = node.get(word.charAt(i));
                node.reduceCountPrefix();
            } else return;
        }
        node.reduceEnd();
    }

}

class NodeII {
    NodeII[] links = new NodeII[26];
    int countEndWith = 0;
    int countPrefix = 0;

    public NodeII() {
    }

    public boolean containsKey(char c) {
        return links[c - 'a'] != null;
    }

    public void put(char c, NodeII node) {
        links[c - 'a'] = node;
    }

    public NodeII get(char c) {
        return links[c - 'a'];
    }

    void increaseEnd() {
        countEndWith++;
    }

    void increaseCountPrefix() {
        countPrefix++;
    }

    void reduceEnd() {
        countEndWith--;
    }

    void reduceCountPrefix() {
        countPrefix--;
    }

    int getCountEndWith() {
        return countEndWith;
    }

    int getCountPrefix() {
        return countPrefix;
    }
}
