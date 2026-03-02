package org.s3m.leetcode.medium;


import java.util.Arrays;

/**
 * Remove Duplicates from Sorted List II
 * <p>
 * Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well.
 * <p>
 * Example 1:
 * Input: head = [1,2,3,3,4,4,5]
 * Output: [1,2,5]
 * Example 2:
 * Input: head = [1,1,1,2,3]
 * Output: [2,3]
 */
public class Solution82 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

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
        System.out.println("Output:   " + new Solution82().deleteDuplicates(head));
        System.out.println("Expected: [1,2,5]");

        // Example 2
        head = new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3)))));
        System.out.println("Input:    " + head);
        System.out.println("Output:   " + new Solution82().deleteDuplicates(head));
        System.out.println("Expected: [2,3]");
    }
}
