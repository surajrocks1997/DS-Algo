package com.bitManipulation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PowerSet {
    public static void main(String[] args) {
        String s = "abc";
        List<String> result = solve(s);
        System.out.println(result);
    }

    private static List<String> solve(String s) {
        List<String> result = new ArrayList<>();
        for (int num = 0; num < (1 << s.length()); num++) {
            StringBuilder sub = new StringBuilder();

            for (int i = 0; i < s.length(); i++) {

                System.out.println(num + " & " + "(1 << " + i + ")" + " = " + (num & (1 << i)));

                if ((num & (1 << i)) != 0) {
                    sub.append(s.charAt(i));
                }
            }
            if (sub.length() > 0)
                result.add(sub.toString());
        }

        Collections.sort(result);
        return result;
    }

}
