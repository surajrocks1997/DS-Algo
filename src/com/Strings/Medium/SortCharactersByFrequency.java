package com.Strings.Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SortCharactersByFrequency {

    public static void main(String[] args) {
        String s = "Aabb";
        String res = solve(s);
        System.out.println(res);
    }

    private static String solve(String s) {
        if (s.length() < 3) return s;
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        List<Character> chars = new ArrayList<>(map.keySet());
        chars.sort((a, b) -> map.get(b) - map.get(a));

        StringBuilder sb = new StringBuilder();
        chars.forEach(ele -> {
            int occurrence = map.get(ele);
            while (occurrence != 0) {
                sb.append(ele);
                occurrence--;
            }
        });

        return sb.toString();
    }
}
