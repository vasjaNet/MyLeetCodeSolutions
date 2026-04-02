package org.s3m.leetcode.medium._19;

import org.s3m.leetcode.utils.ListNode;

public class SolutionJava19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next == null) return null;
        ListNode end = head;
        for(int i = 1; i <= n; i++) {
            end = end.next;
        }
        if(end == null) {
            return head.next;
        }

        ListNode prev = head;
        while(end.next != null) {
            prev = prev.next;
            end = end.next;
        }
        prev.next = prev.next.next;
        return head;
    }



    public static void main(String[] args) {

        // Example 1
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        int n = 2;
        System.out.println("Input:    " + head + ", " + n);
        System.out.println("Output:   " + new SolutionJava19().removeNthFromEnd(head, n));
        System.out.println("Expected: [1,2,3,5]");

        // Example 2
        head = new ListNode(1);
        n = 1;
        System.out.println("Input:    " + head + ", " + n);
        System.out.println("Output:   " + new SolutionJava19().removeNthFromEnd(head, n));
        System.out.println("Expected: []");
    }
}
