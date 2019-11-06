package com.hit.basmath.learn.others;

/**
 * 859. Buddy Strings
 * <p>
 * Given two strings A and B of lowercase letters, return true if and only if we can swap two letters in A so that the result equals B.
 * <p>
 * Example 1:
 * <p>
 * Input: A = "ab", B = "ba"
 * Output: true
 * <p>
 * Example 2:
 * <p>
 * Input: A = "ab", B = "ab"
 * Output: false
 * <p>
 * Example 3:
 * <p>
 * Input: A = "aa", B = "aa"
 * Output: true
 * <p>
 * Example 4:
 * <p>
 * Input: A = "aaaaaaabc", B = "aaaaaaacb"
 * Output: true
 * <p>
 * Example 5:
 * <p>
 * Input: A = "", B = "aa"
 * Output: false
 * <p>
 * Note:
 * <p>
 * 0 <= A.length <= 20000
 * 0 <= B.length <= 20000
 * A and B consist only of lowercase letters.
 */
public class _859 {
    public boolean buddyStrings(String A, String B) {
        if (A == null || B == null || A.length() != B.length()) return false;
        int a = -1, b = -1, diff = 0;
        int[] count = new int[26];
        // check if able to switch with the same character.
        boolean canSwitch = false;
        for (int i = 0; i < A.length(); i++) {
            if (++count[A.charAt(i) - 'a'] >= 2) canSwitch = true;
            if (A.charAt(i) != B.charAt(i)) {
                diff++;
                if (a == -1) a = i;
                else if (b == -1) b = i;
            }
        }
        return (diff == 0 && canSwitch) || (diff == 2 && A.charAt(a) == B.charAt(b) && A.charAt(b) == B.charAt(a));
    }
}
