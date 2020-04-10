package com.hit.basmath.learn.others;

import java.util.Arrays;

/**
 * 564. Find the Closest Palindrome
 * <p>
 * Given an integer n, find the closest integer (not including itself), which is a palindrome.
 * <p>
 * The 'closest' is defined as absolute difference minimized between two integers.
 * <p>
 * Example 1:
 * <p>
 * Input: "123"
 * Output: "121"
 * <p>
 * Note:
 * <p>
 * The input n is a positive integer represented by string, whose length will not exceed 18.
 * If there is a tie, return the smaller one as answer.
 */
public class _564 {
    public String nearestPalindromic(String n) {
        Long number = Long.parseLong(n);
        Long big = findHigherPalindrome(number + 1);
        Long small = findLowerPalindrome(number - 1);
        return Math.abs(number - small) > Math.abs(big - number) ? String.valueOf(big) : String.valueOf(small);
    }

    private Long findHigherPalindrome(Long limit) {
        String n = Long.toString(limit);
        char[] s = n.toCharArray(); // limit
        int m = s.length;
        char[] t = Arrays.copyOf(s, m); // target
        for (int i = 0; i < m / 2; i++) {
            t[m - 1 - i] = t[i];
        }
        for (int i = 0; i < m; i++) {
            if (s[i] < t[i]) {
                return Long.parseLong(String.valueOf(t));
            } else if (s[i] > t[i]) {
                for (int j = (m - 1) / 2; j >= 0; j--) {
                    if (++t[j] > '9') {
                        t[j] = '0';
                    } else {
                        break;
                    }
                }
                // make it palindrome again
                for (int k = 0; k < m / 2; k++) {
                    t[m - 1 - k] = t[k];
                }
                return Long.parseLong(String.valueOf(t));
            }
        }
        return Long.parseLong(String.valueOf(t));
    }

    private Long findLowerPalindrome(Long limit) {
        String n = Long.toString(limit);
        char[] s = n.toCharArray();
        int m = s.length;
        char[] t = Arrays.copyOf(s, m);
        for (int i = 0; i < m / 2; i++) {
            t[m - 1 - i] = t[i];
        }
        for (int i = 0; i < m; i++) {
            if (s[i] > t[i]) {
                return Long.parseLong(String.valueOf(t));
            } else if (s[i] < t[i]) {
                for (int j = (m - 1) / 2; j >= 0; j--) {
                    if (--t[j] < '0') {
                        t[j] = '9';
                    } else {
                        break;
                    }
                }
                if (t[0] == '0') {
                    char[] a = new char[m - 1];
                    Arrays.fill(a, '9');
                    return Long.parseLong(String.valueOf(a));
                }
                // make it palindrome again
                for (int k = 0; k < m / 2; k++) {
                    t[m - 1 - k] = t[k];
                }
                return Long.parseLong(String.valueOf(t));
            }
        }
        return Long.parseLong(String.valueOf(t));
    }
}
