package com.Strings.Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class ReverseWords {
    public static void main(String[] args) {
        String s = "  hello world  ";
        String reverse = solve(s);
        System.out.println(reverse);
    }

    private static String solve(String s) {
        List<String> stringList = new ArrayList<>();
        Arrays.stream(s.split("\\s+"))
                .filter(ele -> !ele.equals(""))
                .forEach(stringList::add);

        Collections.reverse(stringList);

        StringBuilder sb = new StringBuilder();
        stringList.forEach(ele -> sb.append(ele).append(" "));
        return sb.subSequence(0, sb.length() - 1).toString();
    }
}
