package org.s3m.leetcode.hard;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Text Justification
 * <p>
 * Given an array of strings words and a width maxWidth, format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.
 * You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.
 * Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line does not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
 * For the last line of text, it should be left-justified, and no extra space is inserted between words.
 * Note:
 * A word is defined as a character sequence consisting of non-space characters only.
 * Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
 * The input array words contains at least one word.
 * <p>
 * Example 1:
 * Input: words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
 * Output:
 * [
 *    "This    is    an",
 *    "example  of text",
 *    "justification.  "
 * ]
 * Example 2:
 * Input: words = ["What","must","be","acknowledgment","shall","be"], maxWidth = 16
 * Output:
 * [
 *   "What   must   be",
 *   "acknowledgment  ",
 *   "shall be        "
 * ]
 * Explanation: Note that the last line is "shall be    " instead of "shall     be", because the last line must be left-justified instead of fully-justified.
 * Note that the second line is also left-justified because it contains only one word.
 * Example 3:
 * Input: words = ["Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"], maxWidth = 20
 * Output:
 * [
 *   "Science  is  what we",
 *   "understand      well",
 *   "enough to explain to",
 *   "a  computer.  Art is",
 *   "everything  else  we",
 *   "do                  "
 * ]
 */
public class Solution68 {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> justifiedLines = new ArrayList<>();
        List<String> tmpLine = new ArrayList<>();
        int j = 0;
        int currentLineLength = 0;
        boolean lineReady = false;
        for (int i = 0; i < words.length; i++) {
            if(currentLineLength + words[i].length() + (i-j) <= maxWidth) {
                tmpLine.add(words[i]);
                currentLineLength += words[i].length();
            } else {
                lineReady = true;
            }

            if(lineReady) {
                justifiedLines.add(justifyLine(tmpLine, maxWidth, currentLineLength, false));
                j = i;
                tmpLine.clear();
                tmpLine.add(words[i]);
                currentLineLength = words[i].length();
                lineReady = false;
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
        System.out.println("Output:   " + new Solution68().fullJustify(words, maxWidth));
        System.out.println("Expected: [\"This    is    an\", \"example  of text\", \"justification.  \"]");

        // Example 2
        words = new String[]{"What","must","be","acknowledgment","shall","be"};
        maxWidth = 16;
        System.out.println("Input:    " + Arrays.toString(words) + ", maxWidth = " + maxWidth);
        System.out.println("Output:   " + new Solution68().fullJustify(words, maxWidth));
        System.out.println("Expected: [\"What   must   be\", \"acknowledgment  \", \"shall be        \"]");

        // Example 3
        words = new String[]{"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"};
        maxWidth = 20;
        System.out.println("Input:    " + Arrays.toString(words) + ", maxWidth = " + maxWidth);
        System.out.println("Output:   " + new Solution68().fullJustify(words, maxWidth));
        System.out.println("Expected: [\"Science  is  what we\", \"understand      well\", \"enough to explain to\", \"a  computer.  Art is\", \"everything  else  we\", \"do                  \"]");

    }

}
