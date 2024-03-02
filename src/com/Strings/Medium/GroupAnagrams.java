package com.Strings.Medium;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = solve(strs);
        System.out.println(result);
    }

    private static List<List<String>> solve(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] arr = new int[26];
            for (char ch : str.toCharArray())
                arr[ch - 'a']++;

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                if (arr[i] != 0)
                    sb.append(arr[i]).append((char) 'a' - i);
            }

            String key = sb.toString();
            if (!map.containsKey(key))
                map.put(key, new ArrayList<>());

            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
