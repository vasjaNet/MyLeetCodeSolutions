package org.s3m.leetcode.easy._21;

import java.util.Arrays;
import org.s3m.leetcode.utils.ListNode;

public class SolutionJava21 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        ListNode result;
        ListNode second;
        if(list1.val <= list2.val) {
            result = list1;
            second = list2;
        } else {
            result = list2;
            second = list1;
        }
        ListNode curResult = result;
        while(curResult.next != null && second != null) {

            if(curResult.next.val < second.val) {
                curResult = curResult.next;
            } else {
                ListNode tmp = second;
                second = second.next;
                tmp.next = curResult.next;
                curResult.next = tmp;
            }
        }
        if(curResult.next == null) {
            curResult.next = second;
        }
        return result;
    }

    public static void main(String[] args) {

        // Example 1
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        System.out.println("Input:    " + list1 + ", " + list2);
        System.out.println("Output:   " + new SolutionJava21().mergeTwoLists(list1, list2));
        System.out.println("Expected: [1,1,2,3,4,4]");

        // Example 2
        list1 = new ListNode();
        list2 = new ListNode();
        System.out.println("Input:    " + list1 + ", " + list2);
        System.out.println("Output:   " + new SolutionJava21().mergeTwoLists(list1, list2));
        System.out.println("Expected: []");

        // Example 3
        list1 = new ListNode();
        list2 = new ListNode(0);
        System.out.println("Input:    " + list1 + ", " + list2);
        System.out.println("Output:   " + new SolutionJava21().mergeTwoLists(list1, list2));
        System.out.println("Expected: [0]");
        System.out.println("--------------------------------------------------");
        System.out.println("Input:    " + Arrays.toString(new ListNode[]{list1, list2}));
        System.out.println("Output:   " + new SolutionJava21().mergeTwoLists(list1, list2));
        System.out.println("Expected: [0]");

    }
}
