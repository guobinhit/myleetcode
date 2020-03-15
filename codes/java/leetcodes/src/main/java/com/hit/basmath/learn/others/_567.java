package com.hit.basmath.learn.others;

/**
 * 567. Permutation in String
 * <p>
 * Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, one of the first string's permutations is the substring of the second string.
 * <p>
 * Example 1:
 * <p>
 * Input: s1 = "ab" s2 = "eidbaooo"
 * Output: True
 * Explanation: s2 contains one permutation of s1 ("ba").
 * <p>
 * Example 2:
 * <p>
 * Input:s1= "ab" s2 = "eidboaoo"
 * Output: False
 * <p>
 * Note:
 * <p>
 * The input strings only contain lower case letters.
 * The length of both given strings is in range [1, 10,000].
 */
public class _567 {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int[] s1map = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1map[s1.charAt(i) - 'a']++;
        }
        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            int[] s2map = new int[26];
            for (int j = 0; j < s1.length(); j++) {
                s2map[s2.charAt(i + j) - 'a']++;
            }
            if (matches(s1map, s2map)) return true;
        }
        return false;
    }

    private boolean matches(int[] s1map, int[] s2map) {
        for (int i = 0; i < 26; i++) {
            if (s1map[i] != s2map[i])
                return false;
        }
        return true;
    }
}
