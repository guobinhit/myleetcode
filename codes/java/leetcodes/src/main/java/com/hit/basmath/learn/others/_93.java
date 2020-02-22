package com.hit.basmath.learn.others;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 93. Restore IP Addresses
 * <p>
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 * <p>
 * Example:
 * <p>
 * Input: "25525511135"
 * Output: ["255.255.11.135", "255.255.111.35"]
 */
public class _93 {
    private int n;
    private String s;
    private LinkedList<String> segments = new LinkedList<String>();
    private ArrayList<String> output = new ArrayList<String>();

    public List<String> restoreIpAddresses(String s) {
        this.n = s.length();
        this.s = s;
        backtrack(-1, 3);
        return output;
    }

    private boolean valid(String segment) {
        /*
        Check if the current segment is valid :
        1. less or equal to 255
        2. the first character could be '0'
        only if the segment is equal to '0'
        */
        int m = segment.length();
        return m <= 3 && ((segment.charAt(0) != '0') ? (Integer.valueOf(segment) <= 255) : (m == 1));
    }

    private void updateOutput(int curr_pos) {
        /*
        Append the current list of segments
        to the list of solutions
        */
        String segment = s.substring(curr_pos + 1, n);
        if (valid(segment)) {
            segments.add(segment);
            output.add(String.join(".", segments));
            segments.removeLast();
        }
    }

    private void backtrack(int prev_pos, int dots) {
        /*
        prev_pos : the position of the previously placed dot
        dots : number of dots to place
        */
        // The current dot curr_pos could be placed
        // in a range from prev_pos + 1 to prev_pos + 4.
        // The dot couldn't be placed
        // after the last character in the string.
        int max_pos = Math.min(n - 1, prev_pos + 4);
        for (int curr_pos = prev_pos + 1; curr_pos < max_pos; curr_pos++) {
            String segment = s.substring(prev_pos + 1, curr_pos + 1);
            if (valid(segment)) {
                segments.add(segment);  // place dot
                if (dots - 1 == 0)      // if all 3 dots are placed
                    updateOutput(curr_pos);  // add the solution to output
                else
                    backtrack(curr_pos, dots - 1);  // continue to place dots
                segments.removeLast();  // remove the last placed dot
            }
        }
    }
}
