package com.Tries;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://leetcode.com/problems/word-search-ii/
public class WordSearchII {
    public static void main(String[] args) {
        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };
        String[] words = {"oath", "eat"};
        List<String> result = solve(board, words);
        System.out.println(result);
    }

    private static List<String> solve(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words)
            trie.insert(word);

        Set<String> result = new HashSet<>();
        int m = board.length;
        int n = board[0].length;

        int[][] vis = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(i, j, result, trie.getRoot(), vis, board, new StringBuilder());
            }
        }
        return result.stream().toList();
    }

    private static void dfs(int row, int col, Set<String> result, Node root, int[][] vis, char[][] board, StringBuilder sb) {

        if (row < 0 || row == board.length || col < 0 || col == board[0].length ||
                vis[row][col] == 1 || root.links[board[row][col] - 'a'] == null)
            return;


        vis[row][col] = 1;
        sb.append(board[row][col]);
        root = root.links[board[row][col] - 'a'];

        if (root.isEnd)
            result.add(sb.toString());

        dfs(row + 1, col, result, root, vis, board, sb);
        dfs(row - 1, col, result, root, vis, board, sb);
        dfs(row, col + 1, result, root, vis, board, sb);
        dfs(row, col - 1, result, root, vis, board, sb);

        vis[row][col] = 0;
        sb.deleteCharAt(sb.length() - 1);
    }
}