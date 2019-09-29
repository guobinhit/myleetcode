package com.hit.basmath.learn.binary_search;

/**
 * 69. Sqrt(x)
 * <p>
 * Implement int sqrt(int x).
 * <p>
 * Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
 * <p>
 * Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.
 * <p>
 * Example 1:
 * <p>
 * Input: 4
 * Output: 2
 * Example 2:
 * <p>
 * Input: 8
 * Output: 2
 * <p>
 * Explanation: The square root of 8 is 2.82842..., and since
 * the decimal part is truncated, 2 is returned.
 */
public class _69 {
    /**
     * Binary Search Solution
     *
     * @param x
     * @return
     */
    public static int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int left = 1, right = Integer.MAX_VALUE;
        while (true) {
            int mid = left + (right - left) / 2;
            if (mid > x / mid) {
                right = mid - 1;
            } else {
                if (mid + 1 > x / (mid + 1)) {
                    return mid;
                } else {
                    left = mid + 1;
                }
            }
        }
    }

    /**
     * Newton Solution
     *
     * @param x
     * @return
     */
    public static int mySqrt2(int x) {
        if (x == 0) {
            return 0;
        }
        long i = x;
        while (i > x / i) {
            i = (i + x / i) / 2;
        }
        return (int) i;
    }

    /**
     * Brute Force Solution
     *
     * @param x
     * @return
     */
    public static int mySqrt3(int x) {
        if (x == 0) {
            return 0;
        }
        for (int i = 1; i <= x / i; i++) {
            // Look for the critical point: i*i <= x && (i+1)(i+1) > x
            if (i <= x / i && (i + 1) > x / (i + 1)) {
                return i;
            }
        }
        return -1;
    }
}
