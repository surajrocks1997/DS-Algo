package com.graph.minSpanningTreeDisjointSet;

import java.util.*;

public class AccountsMerge {
    public static void main(String[] args) {
        List<List<String>> accounts = new ArrayList<>();
        accounts.add(new ArrayList<>(Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com")));
        accounts.add(new ArrayList<>(Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com")));
        accounts.add(new ArrayList<>(Arrays.asList("Mary", "mary@mail.com")));
        accounts.add(new ArrayList<>(Arrays.asList("John", "johnnybravo@mail.com")));

        List<List<String>> result = solve(accounts);
        System.out.println(result);
    }

    private static List<List<String>> solve(List<List<String>> accounts) {
        DisjointSet_Class ds = new DisjointSet_Class(accounts.size());
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < accounts.size(); i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                if (map.containsKey(accounts.get(i).get(j))) {
                    ds.unionBySize(map.get(accounts.get(i).get(j)), i);
                    continue;
                }
                map.put(accounts.get(i).get(j), i);
            }
        }

        Map<Integer, List<String>> mergedMail = new HashMap<>();
        for (int i = 0; i < accounts.size(); i++) {
            mergedMail.put(i, new ArrayList<>());
        }

        for (Map.Entry<String, Integer> it : map.entrySet()) {
            int ultimateParent = ds.findUltimateParent(it.getValue());
            mergedMail.get(ultimateParent).add(it.getKey());
        }

        List<List<String>> result = new ArrayList<>();

        for (int i = 0; i < accounts.size(); i++) {
            if (mergedMail.get(i).size() == 0) continue;
            Collections.sort(mergedMail.get(i));

            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            temp.addAll(mergedMail.get(i));

            result.add(temp);
        }

        return result;
    }
}
