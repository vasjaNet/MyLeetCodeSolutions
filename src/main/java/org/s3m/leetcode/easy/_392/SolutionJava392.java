package org.s3m.leetcode.easy._392;



public class SolutionJava392 {

    public boolean isSubsequence(String s, String t) {
        int tn = t.length();
        int sn = s.length();
        if(tn < sn) return false;
        if(sn ==0) return true;
        int si = 0;
        for(int i = 0; i < tn; i++) {
            if(t.charAt(i) == s.charAt(si)) {
                si++;
            }
            if(si == sn) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // Example 1
        String s = "abc";
        String t = "ahbgdc";
        System.out.println("Input:    " + s + ", " + t);
        System.out.println("Output:   " + new SolutionJava392().isSubsequence(s, t));
        System.out.println("Expected: true");

        // Example 2
        s = "axc";
        t = "ahbgdc";
        System.out.println("Input:    " + s + ", " + t);
        System.out.println("Output:   " + new SolutionJava392().isSubsequence(s, t));
        System.out.println("Expected: false");

        // Example 2
        s = "b";
        t = "c";
        System.out.println("Input:    " + s + ", " + t);
        System.out.println("Output:   " + new SolutionJava392().isSubsequence(s, t));
        System.out.println("Expected: false");

    }
}
