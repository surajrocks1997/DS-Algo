package com.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedList {
    public static void main(String[] args) {
        ListNode[] lists = new ListNode[3];
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(4);
        node1.next.next = new ListNode(5);

        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(3);
        node2.next.next = new ListNode(4);

        ListNode node3 = new ListNode(2);
        node3.next = new ListNode(6);

        lists[0] = node1;
        lists[1] = node2;
        lists[2] = node3;

        ListNode result = solve(lists);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }

    private static ListNode solve(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a,b) -> a.val - b.val);
        for(ListNode node: lists){
            if(node != null){
                minHeap.add(node);
            }
        }

        ListNode dummyNode = new ListNode(0);
        ListNode tail = dummyNode;

        while(!minHeap.isEmpty()){
            ListNode poll = minHeap.poll();
            tail.next = poll;
            tail = tail.next;

            if(poll.next != null){
                minHeap.add(poll.next);
            }
        }
        return dummyNode.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
