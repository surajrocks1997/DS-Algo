package com.linkedlist;

// https://leetcode.com/problems/split-linked-list-in-parts/description/
public class SplitLinkedListInParts {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
//        head.next.next.next.next.next = new ListNode(6);
//        head.next.next.next.next.next.next = new ListNode(7);
//        head.next.next.next.next.next.next.next = new ListNode(8);
//        head.next.next.next.next.next.next.next.next = new ListNode(9);
//        head.next.next.next.next.next.next.next.next.next = new ListNode(10);
        int k = 5;

        ListNode[] result = solve(head, k);
        for (ListNode curr : result) {
            while (curr != null) {
                System.out.print(curr.val + " ");
                curr = curr.next;
            }
            System.out.println();
        }
    }

    private static ListNode[] solve(ListNode head, int k) {
        ListNode curr = head;
        int size = 0;
        while (curr != null) {
            curr = curr.next;
            size++;
        }

        int mod = size % k;
        int bucket = size / k;

        ListNode nextHead = curr = head;
        ListNode prev = null;

        ListNode[] result = new ListNode[k];
        for (int i = 0; i < k; i++) {
            result[i] = curr = nextHead;

            int index = 0;
            while (curr != null && index < bucket) {
                prev = curr;
                curr = curr.next;
                index++;
            }

            if (mod > 0) {
                prev = curr;
                curr = curr.next;
                mod--;
            }

            if (curr != null) {
                prev.next = null;
                nextHead = curr;
            } else nextHead = null;
        }

        return result;

    }
}
