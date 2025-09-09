package com.linkedlist;

// https://leetcode.com/problems/reorder-list/description/
public class ReorderList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        printAll(head);
        reorderList(head);

        printAll(head);

    }

    // find the mid point of linked list using slow and fast pointer
    // reverse the 2nd part of the linked list
    // create new linked list considering two separate LLs
    private static void reorderList(ListNode head) {
        if(head.next == null || head.next.next == null) return;
        ListNode mid = null;
        ListNode slow = head;
        ListNode fast = slow.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        mid = slow.next;

        System.out.println("Mid: " + mid.val);
        slow.next = reverse(slow.next);

        ListNode s = head;
        ListNode sn = s.next;
        ListNode c = slow.next;
        ListNode cn = c.next;

        slow.next = null;

        while (s != null && c != null) {
            s.next = c;
            s = sn;
            if (s == null) return;
            sn = sn.next;
            c.next = s;
            c = cn;
            if (c == null) return;
            cn = cn.next;
        }
    }

    private static ListNode reverse(ListNode mid) {
        ListNode dummy = null;
        ListNode curr = dummy;
        ListNode prev = dummy;
        ListNode next = mid;

        while (next != null) {
            curr = next;
            next = next.next;
            curr.next = prev;
            prev = curr;
        }
        return curr;
    }

    private static void printAll(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}
