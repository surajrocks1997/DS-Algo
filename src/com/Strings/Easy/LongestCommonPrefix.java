package com.Strings.Easy;

import java.util.Arrays;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] str = {"flower", "flow", "flight"};
        String res = solve(str);
        System.out.println(res);

    }

    private static String solve(String[] str) {
        Arrays.sort(str);

        String str1 = str[0];
        String str2 = str[str.length - 1];
        int index = 0;

        while (index < str1.length() && index < str2.length()) {
            if (str1.charAt(index) == str2.charAt(index))
                index++;
            else break;
        }

        return str1.substring(0, index);
    }

//    private static String solve(String[] str) {
//        int min = Arrays.stream(str).mapToInt(String::length).min().orElse(0);
//
//        StringBuilder sb = new StringBuilder();
//
//        for (int i = 0; i < min; i++) {
//            char ch = str[0].charAt(i);
//            for (String s : str) {
//                if (s.charAt(i) != ch) return sb.toString();
//            }
//            sb.append(ch);
//        }
//
//
//        return sb.toString();
//    }
}
