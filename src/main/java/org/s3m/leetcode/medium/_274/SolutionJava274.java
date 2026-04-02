package org.s3m.leetcode.medium._274;


public class SolutionJava274 {

    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] dp = new int[n + 1];
        for (int citation : citations) {
            dp[Math.min(citation, n)]++;
        }
        int count = 0;
        for (int i = n; i >= 0; i--) {
            count += dp[i];
            if(count  >= i) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {

        // Example 1
        int[] citations = {3,0,6,1,5};
        System.out.println("Input:    " + citations);
        System.out.println("Output:   " + new SolutionJava274().hIndex(citations));
        System.out.println("Expected: 3");

        // Example 2
        citations = new int[]{1,3,1};
        System.out.println("Input:    " + citations);
        System.out.println("Output:   " + new SolutionJava274().hIndex(citations));
        System.out.println("Expected: 1");



    }
}
