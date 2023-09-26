package com.Tries;

public class CountDistinctSubstring {
    public static void main(String[] args) {
        String str = "abab";

        int result = solve(str);
        System.out.println(result);
    }

    private static int solve(String str) {
        Node_CountDistinctSubstring root = new Node_CountDistinctSubstring();
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            Node_CountDistinctSubstring node = root;
            for (int j = i; j < str.length(); j++) {
                if (!node.containsKey(str.charAt(j))) {
                    count++;
                    node.put(str.charAt(j), new Node_CountDistinctSubstring());
                }
                node = node.get(str.charAt(j));
            }
        }
        return count + 1;   // +1 because empty substring
    }
}

class Node_CountDistinctSubstring {
    Node_CountDistinctSubstring[] links = new Node_CountDistinctSubstring[26];

    public boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    public void put(char ch, Node_CountDistinctSubstring node) {
        links[ch - 'a'] = node;
    }

    public Node_CountDistinctSubstring get(char ch) {
        return links[ch - 'a'];
    }
}
