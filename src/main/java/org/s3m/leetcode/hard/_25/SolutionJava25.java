package org.s3m.leetcode.hard._25;


import org.s3m.leetcode.utils.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionJava25 {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        while (prev != null) {
            ListNode curr = prev;
            for (int i = 0; i < k; i++) {
                curr = curr.next;
                if (curr == null) {
                    return dummy.next;
                }
            }
            ListNode node = prev.next;
            ListNode nxt = curr.next;
            curr.next = null;
            prev.next = reverse(node);
            node.next = nxt;
            prev = node;
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode dummy = new ListNode();
        ListNode cur = head;
        while (cur != null) {
            ListNode nxt = cur.next;
            cur.next = dummy.next;
            dummy.next = cur;
            cur = nxt;
        }
        return dummy.next;
    }



    public static void main(String[] args) {

        // Example 1
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println("Input:    " + head);
        System.out.println("Output:   " + new SolutionJava25().reverseKGroup(head, 2));
        System.out.println("Expected: [2,1,4,3,5]");

        // Example 2
        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println("Input:    " + head);
        System.out.println("Output:   " + new SolutionJava25().reverseKGroup(head, 3));
        System.out.println("Expected: [3,2,1,4,5]");

    }

}
