package org.s3m.leetcode.medium;

import org.s3m.leetcode.utils.ListNode;

/**
 * Sort List
 * <p>
 * Given the head of a linked list, return the list after sorting it in ascending order.
 * <p>
 * Example 1:
 * Input: head = [4,2,1,3]
 * Output: [1,2,3,4]
 * Example 2:
 * Input: head = [-1,5,3,4,0]
 * Output: [-1,0,3,4,5]
 * Example 3:
 * Input: head = []
 * Output: []
 */
public class Solution148 {

    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        return sort(head);
    }

    private ListNode sort(ListNode head) {
        ListNode midle = getMiddleNode(head);
        ListNode l1 = head;
        if(head.next != null) {
            l1 = sort(head);
        }
        ListNode l2 = midle;
        if(midle.next != null) {
            l2 = sort(midle);
        }
        return merge(l1, l2);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 == null ? l2 : l1;
        return dummy.next;
    }

    private ListNode getMiddleNode(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode midle = head;
        ListNode fast = head;
        ListNode prev = head;
        while(fast != null && fast.next != null) {
            prev = midle;
            midle = midle.next;
            fast = fast.next.next;
        }
        prev.next = null;
        return midle;
    }



    public static void main(String[] args) {

        // Example 1
        ListNode head = new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3))));
        System.out.println("Input:    " + head);
        System.out.println("Output:   " + new Solution148().sortList(head));
        System.out.println("Expected: [1,2,3,4]");

        // Example 2
        head = new ListNode(-1, new ListNode(5, new ListNode(3, new ListNode(4, new ListNode(0)))));
        System.out.println("Input:    " + head);
        System.out.println("Output:   " + new Solution148().sortList(head));
        System.out.println("Expected: [-1,0,3,4,5]");

        // Example 3
        head = new ListNode();
        System.out.println("Input:    " + head);
        System.out.println("Output:   " + new Solution148().sortList(head));
        System.out.println("Expected: []");


    }
}
