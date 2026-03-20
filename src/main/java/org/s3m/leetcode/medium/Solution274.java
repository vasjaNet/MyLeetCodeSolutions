package org.s3m.leetcode.medium;


/**
 * H-Index
 * <p>
 * Given an array of integers citations where citations[i] is the number of citations a researcher received for their ith paper, return the researcher's h-index.
 * According to the definition of h-index on Wikipedia: The h-index is defined as the maximum value of h such that the given researcher has published at least h papers that have each been cited at least h times.
 * <p>
 * Example 1:
 * Input: citations = [3,0,6,1,5]
 * Output: 3
 * Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively.
 * Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, their h-index is 3.
 * Example 2:
 * Input: citations = [1,3,1]
 * Output: 1
 */
public class Solution274 {

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
        System.out.println("Output:   " + new Solution274().hIndex(citations));
        System.out.println("Expected: 3");

        // Example 2
        citations = new int[]{1,3,1};
        System.out.println("Input:    " + citations);
        System.out.println("Output:   " + new Solution274().hIndex(citations));
        System.out.println("Expected: 1");



    }
}
