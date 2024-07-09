package com.greedy.medium;

public class AvgWaitingTime {

    public static void main(String[] args) {
        int[][] customers = {
                {5, 2},
                {5, 4},
                {10, 3},
                {20, 1}
        };
        double result = solve(customers);
        System.out.println(result);
    }

    private static double solve(int[][] customers) {
        double total_waiting_time = 0;
        int current_time = 0;

        for (int[] customer : customers) {
            int arrival = customer[0];
            int service = customer[1];
            if (current_time < arrival) {
                current_time = arrival;
            }
            int waiting_time = current_time - arrival + service;
            total_waiting_time += waiting_time;
            current_time += service;
        }

        return total_waiting_time / customers.length;
    }

}
