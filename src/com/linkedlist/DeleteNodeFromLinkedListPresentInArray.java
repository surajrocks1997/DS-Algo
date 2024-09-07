package com.linkedlist;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/linked-list-in-binary-tree/description/
public class DeleteNodeFromLinkedListPresentInArray {
    public static void main(String[] args) {
        int[] nums = {1};
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next.next.next = new ListNode(2);

        ListNode result = solve(nums, head);
        ListNode curr = result;
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println("null");

    }

    private static ListNode solve(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet<>();
        for (int ele : nums)
            set.add(ele);

        ListNode dummy = new ListNode(-1);
        ListNode lastValid = dummy;
        ListNode curr = head;
        while (curr != null) {
            if (set.contains(curr.val)) {
                if (curr == head) {
                    curr = curr.next;
                    head = curr;
                } else
                    curr = curr.next;
            } else {
                lastValid.next = curr;
                lastValid = lastValid.next;
                curr = curr.next;
            }
        }
        lastValid.next = curr;
        return dummy.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
