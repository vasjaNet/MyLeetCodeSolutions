package org.s3m.leetcode.medium._92;

import org.s3m.leetcode.utils.ListNode;

public class SolutionJava92 {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        int count = 1;
        ListNode lb = head;
        ListNode l = head.next;
        ListNode cur = head;
        while(count < right) {
            if (count < left) {
                lb = cur;
                cur = cur.next;
            } else {
                if (lb == null) {
                  l = null;

                } else {
                    l = lb.next;
                    lb.next = cur.next;
                    cur.next = cur.next.next;
                    lb.next.next = l;
                }
            }
            count++;
        }
        return head;
    }



    public static void main(String[] args) {

        // Example 1
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        int left = 2, right = 4;
        System.out.println("Input:    " + head + ", " + left + ", " + right);
        System.out.println("Output:   " + new SolutionJava92().reverseBetween(head, left, right));
        System.out.println("Expected: [1,4,3,2,5]");

        // Example 2
        head = new ListNode(5);
        left = 1;
        right = 1;
        System.out.println("Input:    " + head + ", " + left + ", " + right);
        System.out.println("Output:   " + new SolutionJava92().reverseBetween(head, left, right));
        System.out.println("Expected: [5]");

        // Example 3
        head = new ListNode(3, new ListNode(5));
        left = 1;
        right = 2;
        System.out.println("Input:    " + head + ", " + left + ", " + right);
        System.out.println("Output:   " + new SolutionJava92().reverseBetween(head, left, right));
        System.out.println("Expected: [5,3]");

    }
}
