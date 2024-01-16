package design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/time-based-key-value-store/description/
public class TimeBasedKeyValueStore {
    public static void main(String[] args) {
        TimeMap map = new TimeMap();
//        map.set("foo", "bar", 1);
//        System.out.println(map.get("foo", 1));
//        System.out.println(map.get("foo", 3));
//        map.set("foo", "bar2", 4);
//        System.out.println(map.get("foo", 4));
//        System.out.println(map.get("foo", 5));

        map.set("love", "high", 10);
        map.set("love", "low", 20);
        System.out.println(map.get("love", 5));
        System.out.println(map.get("love", 10));
        System.out.println(map.get("love", 15));
        System.out.println(map.get("love", 20));
        System.out.println(map.get("love", 25));
    }
}

class TimeMap {

    Map<String, List<Pair>> map;

    public TimeMap() {
        this.map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key))
            map.put(key, new ArrayList<>());

        map.get(key).add(new Pair(value, timestamp));
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key))
            return null;
        else if (map.get(key).size() == 1) {
            int myTimeStamp = map.get(key).get(0).timeStamp;
            if (myTimeStamp > timestamp)
                return null;
            else return map.get(key).get(0).value;
        } else {
            int minTimeStamp = map.get(key).get(0).timeStamp;
            if (minTimeStamp > timestamp) return "";

            int low = 0;
            int high = map.get(key).size() - 1;
            List<Pair> list = map.get(key);

            while (low <= high) {
                int mid = low + (high - low) / 2;

                if (list.get(mid).timeStamp == timestamp){
                    return list.get(mid).value;
                }
                else if (list.get(mid).timeStamp > timestamp) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            return list.get(high).value;
        }
    }
}

class Pair {
    String value;
    int timeStamp;

    public Pair(String value, int timeStamp) {
        this.value = value;
        this.timeStamp = timeStamp;
    }
}
