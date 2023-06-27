package com.StacksAndQueues.hard;

import java.util.HashMap;
import java.util.Map;

public class LFUCache {
    public static void main(String[] args) {

        LFU cache = new LFU(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));

    }
}

class LFU {

    static class DLLNode {
        int key;
        int val;
        int frequency;
        DLLNode prev, next;

        public DLLNode(int key, int val) {
            this.key = key;
            this.val = val;
            this.frequency = 1;
        }
    }

    static class DoubleLinkedList {
        int listSize;
        DLLNode head, tail;

        public DoubleLinkedList() {
            this.listSize = 0;
            this.head = new DLLNode(0, 0);
            this.tail = new DLLNode(0, 0);
            this.head.next = tail;
            this.tail.prev = head;
        }

        public void addNode(DLLNode currentNode) {
            DLLNode nextNode = head.next;
            currentNode.next = nextNode;
            currentNode.prev = head;
            head.next = currentNode;
            nextNode.prev = currentNode;
            listSize++;
        }

        public void removeNode(DLLNode currentNode) {
            DLLNode prevNode = currentNode.prev;
            DLLNode nextNode = currentNode.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            listSize--;
        }
    }

    Map<Integer, DLLNode> cache;
    Map<Integer, DoubleLinkedList> frequencyMap;

    final int capacity;
    int currentSize;
    int minFrequency;

    public LFU(int capacity) {
        this.capacity = capacity;
        currentSize = 0;
        minFrequency = 0;
        frequencyMap = new HashMap<Integer, DoubleLinkedList>();
        cache = new HashMap<Integer, DLLNode>();
    }

    public int get(int key) {
        DLLNode currentNode = cache.get(key);
        if (currentNode == null) return -1;
        updateNode(currentNode);
        return currentNode.val;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;
        if (cache.containsKey(key)) {
            DLLNode currentNode = cache.get(key);
            currentNode.val = value;
            updateNode(currentNode);
        } else {
            currentSize++;
            if (currentSize > capacity) {
                DoubleLinkedList minFreqList = frequencyMap.get(minFrequency);
                cache.remove(minFreqList.tail.prev.key);
                minFreqList.removeNode(minFreqList.tail.prev);
                currentSize--;
            }
            minFrequency = 1;
            DLLNode newNode = new DLLNode(key, value);
            DoubleLinkedList currentList = frequencyMap.getOrDefault(1, new DoubleLinkedList());
            currentList.addNode(newNode);
            frequencyMap.put(1, currentList);
            cache.put(key, newNode);
        }
    }

    private void updateNode(DLLNode currentNode) {
        int currentFreq = currentNode.frequency;
        DoubleLinkedList currentList = frequencyMap.get(currentFreq);
        currentList.removeNode(currentNode);
        if (currentFreq == minFrequency && currentList.listSize == 0)
            minFrequency++;

        currentNode.frequency++;
        DoubleLinkedList newList = frequencyMap.getOrDefault(currentNode.frequency, new DoubleLinkedList());
        newList.addNode(currentNode);
        frequencyMap.put(currentNode.frequency, newList);
    }


}
