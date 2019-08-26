package com.hit.basmath.learn.others;

/**
 * 409. Longest Palindrome
 * <p>
 * Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.
 * <p>
 * This is case sensitive, for example "Aa" is not considered a palindrome here.
 * <p>
 * Note: Assume the length of given string will not exceed 1,010.
 * <p>
 * Example:
 * <p>
 * Input:
 * "abccccdd"
 * <p>
 * Output:
 * 7
 * <p>
 * Explanation:
 * One longest palindrome that can be built is "dccaccd", whose length is 7.
 */
public class _409 {
    public int longestPalindrome(String s) {
        int[] chars = new int[128];
        char[] t = s.toCharArray();
        for (char c : t) {
            chars[c]++;
        }
        int single = 0;
        for (int n : chars) {
            if (n % 2 != 0) {
                single++;
            }
        }
        return single > 1 ? t.length - single + 1 : t.length;
    }
}
