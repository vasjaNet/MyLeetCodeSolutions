package org.s3m.leetcode.hard._68;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionJava68 {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> justifiedLines = new ArrayList<>();
        List<String> tmpLine = new ArrayList<>();
        int j = 0;
        int currentLineLength = 0;
        for (int i = 0; i < words.length; i++) {
            if(currentLineLength + words[i].length() + (i-j) <= maxWidth) {
                tmpLine.add(words[i]);
                currentLineLength += words[i].length();
            } else {
                justifiedLines.add(justifyLine(tmpLine, maxWidth, currentLineLength, false));
                j = i;
                tmpLine.clear();
                tmpLine.add(words[i]);
                currentLineLength = words[i].length();
            }
        }
        justifiedLines.add(justifyLine(tmpLine, maxWidth, currentLineLength, true));
        return justifiedLines;
    }

    private String justifyLine(List<String> words, int maxWidth, int currentLineLength, boolean isLastLine) {
        int wordCount = words.size();
        int spaceCount = maxWidth - currentLineLength;
        int evenSpaceCount =
                wordCount == 1 ? spaceCount : spaceCount / (wordCount-1);
        int extraSpaceCount = wordCount == 1 ? 0 : spaceCount % (wordCount-1);
        StringBuilder justifiedLine = new StringBuilder();
        if (isLastLine) {
            evenSpaceCount = 1;
            extraSpaceCount = 0;
        }
        for(int i = 0; i < wordCount; i++) {
            justifiedLine.append(words.get(i));
            if(i < wordCount-1) {
                justifiedLine.append(" ".repeat(Math.max(0, evenSpaceCount)));
                if(extraSpaceCount > 0) {
                    justifiedLine.append(' ');
                    extraSpaceCount--;
                }
            }
        }
        if(isLastLine || wordCount == 1) {
            justifiedLine.append(" ".repeat(Math.max(0, spaceCount - (wordCount-1))));
        }
        return justifiedLine.toString();

    }

    public static void main(String[] args) {
        // Example 1
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;
        System.out.println("Input:    " + Arrays.toString(words) + ", maxWidth = " + maxWidth);
        System.out.println("Output:   " + new SolutionJava68().fullJustify(words, maxWidth));
        System.out.println("Expected: [\"This    is    an\", \"example  of text\", \"justification.  \"]");

        // Example 2
        words = new String[]{"What","must","be","acknowledgment","shall","be"};
        maxWidth = 16;
        System.out.println("Input:    " + Arrays.toString(words) + ", maxWidth = " + maxWidth);
        System.out.println("Output:   " + new SolutionJava68().fullJustify(words, maxWidth));
        System.out.println("Expected: [\"What   must   be\", \"acknowledgment  \", \"shall be        \"]");

        // Example 3
        words = new String[]{"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"};
        maxWidth = 20;
        System.out.println("Input:    " + Arrays.toString(words) + ", maxWidth = " + maxWidth);
        System.out.println("Output:   " + new SolutionJava68().fullJustify(words, maxWidth));
        System.out.println("Expected: [\"Science  is  what we\", \"understand      well\", \"enough to explain to\", \"a  computer.  Art is\", \"everything  else  we\", \"do                  \"]");

    }

}
