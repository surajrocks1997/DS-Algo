package test;

import java.util.*;

// https://leetcode.com/problems/find-all-people-with-secret/description/
public class IDFC_First_Bank {
    public static void main(String[] args) {
        int n = 6;
        int[][] meetings = {
                {1, 5, 10},
                {2, 3, 5},
                {3, 4, 4},
                {1, 2, 5},
                {3, 5, 10}
        };
        List<Integer> result = solve(meetings, n);
        System.out.println(result);

    }

    private static List<Integer> solve(int[][] meetings, int n) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        Set<Integer> set = new HashSet<>();
        set.add(0);
        set.add(1);

        for (int[] meeting : meetings) {
            int time = meeting[2];
            int x = meeting[0];
            int y = meeting[1];

            List<Integer> list = map.getOrDefault(time, new ArrayList<>());
            list.add(x);
            list.add(y);
            map.put(time, list);
        }

        List<Integer> sortedKeyList = new ArrayList<>(map.keySet().stream().toList());
        sortedKeyList.sort((a, b) -> a - b);

        for (int key : sortedKeyList) {
            List<Integer> list = map.get(key);
            for (int ele : list) {
                if (set.contains(ele)) {
                    set.addAll(list);
                    break;
                }
            }
        }

        return set.stream().toList();

    }
}