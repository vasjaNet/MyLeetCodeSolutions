package org.s3m.leetcode.medium;


import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Minimum Genetic Mutation
 * <p>
 * A gene string can be represented by an 8-character long string, with choices from 'A', 'C', 'G', and 'T'.
 * Suppose we need to investigate a mutation from a gene string startGene to a gene string endGene where one mutation is defined as one single character changed in the gene string.
 * For example, "AACCGGTT" --> "AACCGGTA" is one mutation.
 * There is also a gene bank bank that records all the valid gene mutations. A gene must be in bank to make it a valid gene string.
 * Given the two gene strings startGene and endGene and the gene bank bank, return the minimum number of mutations needed to mutate from startGene to endGene. If there is no such a mutation, return -1.
 * Note that the starting point is assumed to be valid, so it might not be included in the bank
 * <p>
 * Example 1:
 * Input: startGene = "AACCGGTT", endGene = "AACCGGTA", bank = ["AACCGGTA"]
 * Output: 1
 * Example 2:
 * Input: startGene = "AACCGGTT", endGene = "AAACGGTA", bank = ["AACCGGTA","AACCGCTA","AAACGGTA"]
 * Output: 2
 */
public class Solution433 {

    public int minMutation(String startGene, String endGene, String[] bank) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        visited.add(startGene);
        queue.offer(startGene);
        int count = 0;
        while(!queue.isEmpty()) {
            for (int m = queue.size(); m > 0; --m) {
                String gene = queue.poll();
                if (gene.equals(endGene)) {
                    return count;
                }
                for (String bankGene : bank) {
                    int diff = 0;
                    for (int i = 0; i < 8 && diff < 2; i++) {
                        if (gene.charAt(i) != bankGene.charAt(i)) {
                            diff++;
                        }
                    }
                    if (diff < 2 && !visited.contains(bankGene)) {
                        queue.offer(bankGene);
                        visited.add(bankGene);
                    }
                }
            }
            count++;
        }
        return -1;
    }



    public static void main(String[] args) {

        // Example 1
        String[] bank = {"AACCGGTA"};
        String startGene = "AACCGGTT";
        String endGene = "AACCGGTA";
        System.out.println("Input:    " + startGene + ", " + endGene + ", " + bank);
        System.out.println("Output:   " + new Solution433().minMutation(startGene, endGene, bank));
        System.out.println("Expected: 1");

        // Example 2
        startGene = "AACCGGTT";
        endGene = "AAACGGTA";
        bank = new String[]{"AACCGGTA","AACCGCTA","AAACGGTA"};
        System.out.println("Input:    " + startGene + ", " + endGene + ", " + bank);
        System.out.println("Output:   " + new Solution433().minMutation(startGene, endGene, bank));
        System.out.println("Expected: 2");

    }
}
