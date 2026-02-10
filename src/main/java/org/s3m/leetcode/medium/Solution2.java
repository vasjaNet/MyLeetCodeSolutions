package org.s3m.leetcode.medium;


import java.util.Arrays;

/**
 * Add Two Numbers
 * <p>
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Example 1:
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 * Example 2:
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 * Example 3:
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 */
public class Solution2 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int overflov = 0;
        ListNode result = new ListNode(0);
        ListNode tmp = result;
        do {
            int val1 = 0;
            int val2 = 0;
            if (l1 != null) {
                val1 = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                val2 = l2.val;
                l2 = l2.next;
            }

            int val = val1 + val2 + overflov;
            overflov = val/10 ;
            val = val%10 ;
            var current = new ListNode(val);
            tmp.next = current;
            tmp = current;
        } while(l1 != null || l2 != null );
        if(overflov == 1) {
            tmp.next =  new ListNode(1);
        }
        return result.next;
    }

    public static void main(String[] args) {

        // Example 1
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        System.out.println("Input:    " + Arrays.toString(new ListNode[]{l1, l2}));
        System.out.println("Output:   " + addTwoNumbers(l1, l2));
        System.out.println("Expected: [7,0,8]");

        //  Example 2
        l1 = new ListNode(0);
        l2 = new ListNode(0);
        System.out.println("Input:    " + Arrays.toString(new ListNode[]{l1, l2}));
        System.out.println("Output:   " + addTwoNumbers(l1, l2));
        System.out.println("Expected: [0]");

        //  Example 3
        l1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
        l2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
        System.out.println("Input:    " + Arrays.toString(new ListNode[]{l1, l2}));
        System.out.println("Output:   " + addTwoNumbers(l1, l2));
        System.out.println("Expected: [8,9,9,9,0,0,0,1]");
    }
}
