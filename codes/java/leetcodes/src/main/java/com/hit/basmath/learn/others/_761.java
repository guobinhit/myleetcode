package com.hit.basmath.learn.others;

import java.util.PriorityQueue;

/**
 * 761. Special Binary String
 * <p>
 * Special binary strings are binary strings with the following two properties:
 * <p>
 * The number of 0's is equal to the number of 1's.
 * Every prefix of the binary string has at least as many 1's as 0's.
 * <p>
 * Given a special string S, a move consists of choosing two consecutive, non-empty, special substrings of S, and swapping them. (Two strings are consecutive if the last character of the first string is exactly one index before the first character of the second string.)
 * <p>
 * At the end of any number of moves, what is the lexicographically largest resulting string possible?
 * <p>
 * Example 1:
 * <p>
 * Input: S = "11011000"
 * Output: "11100100"
 * Explanation:
 * The strings "10" [occuring at S[1]] and "1100" [at S[3]] are swapped.
 * This is the lexicographically largest string possible after some number of swaps.
 * <p>
 * Note:
 * <p>
 * 1. S has length at most 50.
 * 2. S is guaranteed to be a special binary string as defined above.
 */
public class _761 {
    public String makeLargestSpecial(String S) {
        return visit(0, S);
    }

    private String visit(int index, String s) {
        if (s.charAt(index) == '0') return "";
        PriorityQueue<String> tokens = new PriorityQueue<>();
        while (index < s.length() && s.charAt(index) == '1') {
            String token = "1" + visit(index + 1, s) + "0";
            index += token.length();
            tokens.offer(token);
        }
        String result = "";
        while (tokens.size() > 0) result = tokens.poll() + result;
        return result;
    }
}
