package com.hit.basmath.learn.others;

/**
 * 680. Valid Palindrome II
 * <p>
 * Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.
 * <p>
 * Example 1:
 * <p>
 * Input: "aba"
 * Output: True
 * <p>
 * Example 2:
 * <p>
 * Input: "abca"
 * Output: True
 * Explanation: You could delete the character 'c'.
 * <p>
 * Note:
 * <p>
 * The string will only contain lowercase characters a-z. The maximum length of the string is 50000.
 */
public class _680 {
    public boolean validPalindrome(String s) {
        int l = -1, r = s.length();
        while (++l < --r)
            if (s.charAt(l) != s.charAt(r)) return isPalindromic(s, l, r + 1) || isPalindromic(s, l - 1, r);
        return true;
    }

    private boolean isPalindromic(String s, int l, int r) {
        while (++l < --r)
            if (s.charAt(l) != s.charAt(r)) return false;
        return true;
    }
}
