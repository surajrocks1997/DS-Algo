package com.greedy.medium;

import java.util.Arrays;
import java.util.Comparator;

public class JobSequencing {
    public static void main(String[] args) {
        Job[] arr = {
                new Job(1, 2, 100),
                new Job(2, 1, 19),
                new Job(3, 2, 27),
                new Job(4, 1, 25),
                new Job(5, 1, 15)
        };
        int[] ans = solve(arr);
        Arrays.stream(ans).forEach(ele -> System.out.print(ele + " "));

    }

    private static int[] solve(Job[] arr) {
        Arrays.sort(arr, (a, b) -> Integer.compare(b.profit, a.profit));
        Job maxDeadlineJob = Arrays.stream(arr).max(Comparator.comparingInt(Job::getDeadline)).get();
        int[] res = new int[maxDeadlineJob.getDeadline()];
        Arrays.fill(res, -1);

        int totalProfit = 0;

        for (Job job : arr) {
            if (res[job.deadline - 1] != -1) {
                int index = job.deadline - 1;
                while (index >= 0 && res[index] != -1)
                    index--;
                if (index >= 0) {
                    res[index] = job.id;
                    totalProfit += job.profit;
                }
            } else {
                res[job.deadline - 1] = job.id;
                totalProfit += job.profit;
            }
        }

        int count = (int) Arrays.stream(res).filter(ele -> ele != -1).count();

        return new int[]{count, totalProfit};
    }
}

class Job {
    int id, profit, deadline;

    Job(int id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }

    public int getId() {
        return id;
    }

    public int getProfit() {
        return profit;
    }

    public int getDeadline() {
        return deadline;
    }
}