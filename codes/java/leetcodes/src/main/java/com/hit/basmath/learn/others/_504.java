package com.hit.basmath.learn.others;

/**
 * 504. Base 7
 * <p>
 * Given an integer, return its base 7 string representation.
 * <p>
 * Example 1:
 * <p>
 * Input: 100
 * Output: "202"
 * <p>
 * Example 2:
 * <p>
 * Input: -7
 * Output: "-10"
 * <p>
 * Note: The input will be in range of [-1e7, 1e7].
 */
public class _504 {
    public String convertToBase7(int n) {
        if (n < 0) return "-" + convertToBase7(-n);
        if (n < 7) return Integer.toString(n);
        return convertToBase7(n / 7) + Integer.toString(n % 7);
    }
}
