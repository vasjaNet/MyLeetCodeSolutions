package org.s3m.leetcode.easy._58;

public class SolutionJava58 {
    public int lengthOfLastWord(String s) {
        int n = s.length() - 1;
        int lwe = 0;
        int lws = -1;
        for(int i = n; i>=0; i--) {
            Character curChar = s.charAt(i);
            if(lwe == 0 && Character.isAlphabetic(curChar)) {
                lwe = i;
            }
            if(lwe != 0 && !Character.isAlphabetic(curChar)) {
                lws = i;
                break;
            }
        }
        return lwe-lws;
    }

    static void main() {

    }
}
