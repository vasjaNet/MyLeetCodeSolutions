package org.s3m.leetcode.medium;


import org.s3m.leetcode.utils.ListNode;


/**
 * Partition List
 * <p>
 * Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * <p>
 * Example 1:
 * Input: head = [1,4,3,2,5,2], x = 3
 * Output: [1,2,2,4,3,5]
 * Example 2:
 * Input: head = [2,1], x = 2
 * Output: [1,2]
 */
public class Solution86 {

    public ListNode partition(ListNode head, int x) {
        if(head == null) return head;
        if(head.next == null) return head;
        ListNode dummy = new ListNode(-101);
        dummy.next = head;
        ListNode l1 = dummy;
        ListNode cur = head;
        while(cur != null) {
            if(cur.val >= x) {
                break;
            }
            l1 = cur;
            cur = cur.next;
        }
        if(cur == null) return head;
        ListNode l2 = cur;
        ListNode r1 = cur;
        ListNode r2 = cur.next;
        while(r2 != null) {
            if(r2.val < x) {
                r1.next = r2.next;
                l1.next = r2;
                r2.next = l2;
                l1 = l1.next;
            }
            r1 = r2;
            r2 = r2.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {

        // Example 1
        ListNode head = new ListNode(1, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(5, new ListNode(2))))));
        System.out.println("Input:    " + head);
        System.out.println("Output:   " + new Solution86().partition(head, 3));
        System.out.println("Expected: [1,2,2,4,3,5]");

        // Example 2
        head = new ListNode(2, new ListNode(1));
        System.out.println("Input:    " + head);
        System.out.println("Output:   " + new Solution86().partition(head, 2));
        System.out.println("Expected: [1,2]");


    }
}
