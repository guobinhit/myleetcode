package com.hit.basmath.learn.others;

/**
 * 459. Repeated Substring Pattern
 * <p>
 * Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together. You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.
 * <p>
 * Example 1:
 * <p>
 * Input: "abab"
 * Output: True
 * Explanation: It's the substring "ab" twice.
 * <p>
 * Example 2:
 * <p>
 * Input: "aba"
 * Output: False
 * <p>
 * Example 3:
 * <p>
 * Input: "abcabcabcabc"
 * Output: True
 * Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
 */
public class _459 {
    public boolean repeatedSubstringPattern(String s) {
        int l = s.length();
        for (int i = l / 2; i >= 1; i--) {
            if (l % i == 0) {
                int m = l / i;
                String subS = s.substring(0, i);
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < m; j++) {
                    sb.append(subS);
                }
                if (sb.toString().equals(s)) return true;
            }
        }
        return false;
    }
}
