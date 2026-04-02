package org.s3m.leetcode.medium._82;

import org.s3m.leetcode.utils.ListNode;

public class SolutionJava82 {

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        ListNode dummy = new ListNode(head.val-1, head);
        ListNode cur = head;
        ListNode prev = dummy;
        while(cur != null && cur.next != null) {
            if(cur.next.val == prev.next.val) {
                while(cur.next != null && cur.next.val == prev.next.val) {
                    cur = cur.next;
                }
                prev.next = cur.next;
            } else {
                prev = prev.next;
            }
            cur = prev.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {

        // Example 1
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(4, new ListNode(4, new ListNode(5)))))));
        System.out.println("Input:    " + head);
        System.out.println("Output:   " + new SolutionJava82().deleteDuplicates(head));
        System.out.println("Expected: [1,2,5]");

        // Example 2
        head = new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3)))));
        System.out.println("Input:    " + head);
        System.out.println("Output:   " + new SolutionJava82().deleteDuplicates(head));
        System.out.println("Expected: [2,3]");
    }
}
