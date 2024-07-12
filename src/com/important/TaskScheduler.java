package com.important;

import java.util.*;

// https://leetcode.com/problems/task-scheduler/description/
public class TaskScheduler {

    public static void main(String[] args) {
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'C', 'C'};
        int n = 3;
        int result = solve(tasks, n);
        System.out.println(result);
    }

    private static int solve(char[] tasks, int n) {
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((a, b) -> b.occurrence - a.occurrence);
        Map<Character, Integer> map = new HashMap<>();
        Queue<Tuple> q = new LinkedList<>();

        for (char ch : tasks)
            map.put(ch, map.getOrDefault(ch, 0) + 1);

        for (char ele : map.keySet())
            pq.add(new Pair(ele, map.get(ele)));

        int t = 0;
        while (!pq.isEmpty() || !q.isEmpty()) {
            while (!q.isEmpty() && q.peek().nextAvail <= t)
                pq.add(q.poll().p);

            if (!pq.isEmpty()) {
                Pair p = pq.poll();
                p.occurrence -= 1;
                t++;
                if (p.occurrence > 0) {
                    q.add(new Tuple(p, t + n));
                }
            } else if (!q.isEmpty()) {
                t += q.peek().nextAvail - t;
            }
        }

        return t;
    }
}

class Pair {
    char ch;
    int occurrence;

    public Pair(char ch, int occurrence) {
        this.ch = ch;
        this.occurrence = occurrence;
    }
}

class Tuple {
    Pair p;
    int nextAvail;

    public Tuple(Pair p, int nextAvail) {
        this.p = p;
        this.nextAvail = nextAvail;
    }
}