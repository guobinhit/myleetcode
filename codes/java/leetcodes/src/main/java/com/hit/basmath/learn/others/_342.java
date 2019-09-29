package com.hit.basmath.learn.others;

/**
 * 342. Power of Four
 * <p>
 * Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
 * <p>
 * Example 1:
 * <p>
 * Input: 16
 * Output: true
 * <p>
 * Example 2:
 * <p>
 * Input: 5
 * Output: false
 * <p>
 * Follow up: Could you solve it without loops/recursion?
 */
public class _342 {
    public boolean isPowerOfFour(int num) {

        /**
         * 0x55555555 is to get rid of those power of 2 but not power of 4
         * so that the single 1 bit always appears at the odd position
         */
        return num > 0 && (num & (num - 1)) == 0 && (num & 0x55555555) != 0;
    }
}
