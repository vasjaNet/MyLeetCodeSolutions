package org.s3m.leetcode.hard._502;


import java.util.*;

public class SolutionJava502 {

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        Queue<int[]> capProfQ = new PriorityQueue<>((a, b) -> (a[0] - b[0]) == 0 ? (a[1] - b[1]) : (a[0] - b[0]));
        for(int i = 0; i < n; i++) {
            capProfQ.offer(new int[]{capital[i], profits[i]});
        }
        Queue<Integer> maxProfit = new PriorityQueue<>((a, b) -> b - a);
        for(int i = 0; i < k; i++) {
            while(!capProfQ.isEmpty() && capProfQ.peek()[0] <= w) {
                maxProfit.offer(capProfQ.poll()[1]);
            }
            if(!maxProfit.isEmpty()) {
                w += maxProfit.poll();
            } else {
                break;
            }
        }
        return w;
    }



    public static void main(String[] args) {
        // Example 1
        int k = 2;
        int w = 0;
        int[] profits = {1,2,3};
        int[] capital = {0,1,1};
        System.out.println("Input:    " + k + ", " + w + ", " + Arrays.toString(profits) + ", " + Arrays.toString(capital));
        System.out.println("Output:   " + new SolutionJava502().findMaximizedCapital(k, w, profits, capital));
        System.out.println("Expected: 4");

        // Example 2
        k = 3;
        w = 0;
        profits = new int[]{1,2,3};
        capital = new int[]{0,1,2};
        System.out.println("Input:    " + k + ", " + w + ", " + Arrays.toString(profits) + ", " + Arrays.toString(capital));
        System.out.println("Output:   " + new SolutionJava502().findMaximizedCapital(k, w, profits, capital));
        System.out.println("Expected: 6");

    }

}
