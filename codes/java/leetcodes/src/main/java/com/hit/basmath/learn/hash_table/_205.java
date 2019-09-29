package com.hit.basmath.learn.hash_table;

/**
 * 205. Isomorphic Strings
 * <p>
 * Given two strings s and t, determine if they are isomorphic.
 * <p>
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * <p>
 * All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "egg", t = "add"
 * Output: true
 * <p>
 * Example 2:
 * <p>
 * Input: s = "foo", t = "bar"
 * Output: false
 * <p>
 * Example 3:
 * <p>
 * Input: s = "paper", t = "title"
 * Output: true
 * <p>
 * Note:
 * <p>
 * You may assume both s and t have the same length.
 */
public class _205 {
    public boolean isIsomorphic(String s, String t) {
        int[] m = new int[512];
        for (int i = 0; i < s.length(); i++) {
            if (m[s.charAt(i)] != m[t.charAt(i) + 256]) return false;
            m[s.charAt(i)] = m[t.charAt(i) + 256] = i + 1;
        }
        return true;
    }
}
