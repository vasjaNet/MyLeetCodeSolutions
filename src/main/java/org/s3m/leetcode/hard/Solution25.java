package org.s3m.leetcode.hard;


import org.s3m.leetcode.utils.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Reverse Nodes in k-Group
 * <p>
 * Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
 * You may not alter the values in the list's nodes, only nodes themselves may be changed.
 * <p>
 * Example 1:
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [2,1,4,3,5]
 * Example 2:
 * Input: head = [1,2,3,4,5], k = 3
 * Output: [3,2,1,4,5]
 */
public class Solution25 {

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
        System.out.println("Output:   " + new Solution25().reverseKGroup(head, 2));
        System.out.println("Expected: [2,1,4,3,5]");

        // Example 2
        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println("Input:    " + head);
        System.out.println("Output:   " + new Solution25().reverseKGroup(head, 3));
        System.out.println("Expected: [3,2,1,4,5]");

    }

}
