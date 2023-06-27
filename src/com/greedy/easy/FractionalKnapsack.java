package com.greedy.easy;

import java.util.Arrays;
import java.util.Comparator;

class Item {
    int value, weight;

    Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }
}

public class FractionalKnapsack {

    public static void main(String[] args) {
        Item item1 = new Item(60, 10);
        Item item2 = new Item(100, 20);
        Item item3 = new Item(120, 30);
        Item[] arr = {item1, item2, item3};
        int n = 3;
        int w = 50;
        double result = solve(w, arr, n);
        System.out.println(result);
    }

    private static double solve(int w, Item[] arr, int n) {
        Arrays.sort(arr, new Comparator<Item>() {
            @Override
            public int compare(Item a, Item b) {
                double r1 = (double) (a.value) / (double) (a.weight);
                double r2 = (double) (b.value) / (double) (b.weight);
                return Double.compare(r2, r1);
            }
        });

        int currentWeight = 0;
        double finalValue = 0;
        for (Item item : arr) {
            if (currentWeight + item.weight <= w) {
                currentWeight += item.weight;
                finalValue += item.value;
            } else {
                int remain = w - currentWeight;
                finalValue += ((double) item.value / (double) item.weight) * (double) remain;
                break;
            }
        }

        return finalValue;
    }
}

