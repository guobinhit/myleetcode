package com.hit.basmath.learn.others;

/**
 * 521. Longest Uncommon Subsequence I
 * <p>
 * Given a group of two strings, you need to find the longest uncommon subsequence of this group of two strings. The longest uncommon subsequence is defined as the longest subsequence of one of these strings and this subsequence should not be any subsequence of the other strings.
 * <p>
 * A subsequence is a sequence that can be derived from one sequence by deleting some characters without changing the order of the remaining elements. Trivially, any string is a subsequence of itself and an empty string is a subsequence of any string.
 * <p>
 * The input will be two strings, and the output needs to be the length of the longest uncommon subsequence. If the longest uncommon subsequence doesn't exist, return -1.
 * <p>
 * Example 1:
 * <p>
 * Input: "aba", "cdc"
 * Output: 3
 * <p>
 * Explanation: The longest uncommon subsequence is "aba" (or "cdc"),
 * because "aba" is a subsequence of "aba",
 * but not a subsequence of any other strings in the group of two strings.
 * <p>
 * Note:
 * <p>
 * 1. Both strings' lengths will not exceed 100.
 * 2. Only letters from a ~ z will appear in input strings.
 */
public class _521 {
    public int findLUSlength(String a, String b) {
        int lenA = a.length(), lenB = b.length();

        if (a.equals(b)) {
            return -1;
        } else {
            return Math.max(lenA, lenB);
        }
    }
}
