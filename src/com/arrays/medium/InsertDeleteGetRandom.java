package com.arrays.medium;

import java.util.*;

public class InsertDeleteGetRandom {
    public static void main(String[] args) {
        RandomizedSet rs = new RandomizedSet();
        System.out.println(rs.insert(1));
        System.out.println(rs.remove(2));
        System.out.println(rs.insert(2));
        System.out.println(rs.getRandom());
        System.out.println(rs.remove(1));
        System.out.println(rs.insert(2));
        System.out.println(rs.getRandom());
    }
}

class RandomizedSet {

    List<Integer> mySet;
    Map<Integer, Integer> map; // value, index
    Random random;

    public RandomizedSet() {
        mySet = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (!map.containsKey(val)) {
            mySet.add(val);
            map.put(val, mySet.size() - 1);
            return true;
        }
        return false;
    }

    public boolean remove(int val) {
        if (map.containsKey(val)) {
            int index = map.get(val);
            int lastElement = mySet.get(mySet.size() - 1);

            mySet.set(index, lastElement);
            map.put(lastElement, index);

            mySet.remove(mySet.size() - 1);
            map.remove(val);
            return true;
        }
        return false;
    }

    public int getRandom() {
        return mySet.get(random.nextInt(mySet.size()));
    }
}
