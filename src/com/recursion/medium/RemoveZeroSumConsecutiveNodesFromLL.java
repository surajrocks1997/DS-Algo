package com.recursion.medium;

public class RemoveZeroSumConsecutiveNodesFromLL {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(-3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(1);

        ListNode result = solve(head);

        ListNode curr = result;
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println("null");

    }

    private static ListNode solve(ListNode head) {
        return depth_first_search(head);
    }

    public static ListNode depth_first_search(ListNode head) {

        if (head == null)
            return head;

        int sum_value = 0;

        for (ListNode node = head; (node != null); node = node.next) {
            sum_value += node.val;

            if (sum_value == 0)
                head = node.next;
        }

        if (head != null) {
            head.next = depth_first_search(head.next);
        }

        return head;
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