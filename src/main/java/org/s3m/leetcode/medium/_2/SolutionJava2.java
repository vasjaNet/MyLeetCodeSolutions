package org.s3m.leetcode.medium._2;

import java.util.Arrays;
import org.s3m.leetcode.utils.ListNode;

public class SolutionJava2 {

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
