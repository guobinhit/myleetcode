package com.hit.basmath.interview.top_interview_questions.easy_collection.strings;

/**
 * 242. Valid Anagram
 * <p>
 * Given two strings s and t , write a function to determine if t is an anagram of s.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * <p>
 * Example 2:
 * <p>
 * Input: s = "rat", t = "car"
 * Output: false
 * <p>
 * Note:
 * <p>
 * You may assume the string contains only lowercase alphabets.
 * <p>
 * Follow up:
 * <p>
 * What if the inputs contain unicode characters? How would you adapt your solution to such case?
 */
public class _242 {
    public boolean isAnagram(String s, String t) {
        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i++) alphabet[s.charAt(i) - 'a']++;
        for (int i = 0; i < t.length(); i++) alphabet[t.charAt(i) - 'a']--;
        for (int i : alphabet) if (i != 0) return false;
        return true;
    }
}
