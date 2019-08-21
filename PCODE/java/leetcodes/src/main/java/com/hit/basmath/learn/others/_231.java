package com.hit.basmath.learn.others;

/**
 * 231. Power of Two
 * <p>
 * Given an integer, write a function to determine if it is a power of two.
 * <p>
 * Example 1:
 * <p>
 * Input: 1
 * Output: true
 * Explanation: 20 = 1
 * <p>
 * Example 2:
 * <p>
 * Input: 16
 * Output: true
 * Explanation: 24 = 16
 * <p>
 * Example 3:
 * <p>
 * Input: 218
 * Output: false
 */
public class _231 {
    public boolean isPowerOfTwo(int n) {
        return ((n & (n - 1)) == 0 && n > 0);
    }
}
