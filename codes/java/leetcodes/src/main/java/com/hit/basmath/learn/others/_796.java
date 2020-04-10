package com.hit.basmath.learn.others;

/**
 * 796. Rotate String
 * <p>
 * We are given two strings, A and B.
 * <p>
 * A shift on A consists of taking string A and moving the leftmost character to the rightmost position. For example, if A = 'abcde', then it will be 'bcdea' after one shift on A. Return True if and only if A can become B after some number of shifts on A.
 * <p>
 * Example 1:
 * <p>
 * Input: A = 'abcde', B = 'cdeab'
 * Output: true
 * <p>
 * Example 2:
 * <p>
 * Input: A = 'abcde', B = 'abced'
 * Output: false
 * <p>
 * Note:
 * <p>
 * A and B will have length at most 100.
 */
public class _796 {
    public boolean rotateString(String A, String B) {
        if (A == null || B == null || A.length() != B.length())
            return false;
        if (A.length() == 0)
            return true;

        char start = A.charAt(0);

        for (int i = 0; i < B.length(); i++) {

            int j = i;
            while (j < B.length() && B.charAt(j) != start)
                j++;

            if (j >= B.length())
                return false;

            for (int n = 0; n < B.length(); n++) {
                if (A.charAt(n) != B.charAt((n + j) % B.length()))
                    break;
                if (n == B.length() - 1)
                    return true;
            }

            i = j;
        }

        return false;
    }
}
