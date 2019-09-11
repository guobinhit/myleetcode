package com.hit.basmath.learn.others;

/**
 * 633. Sum of Square Numbers
 * <p>
 * Given a non-negative integer c, your task is to decide whether there're two integers a and b such that a2 + b2 = c.
 * <p>
 * Example 1:
 * <p>
 * Input: 5
 * Output: True
 * Explanation: 1 * 1 + 2 * 2 = 5
 * <p>
 * Example 2:
 * <p>
 * Input: 3
 * Output: False
 */
public class _633 {
    public boolean judgeSquareSum(int c) {
        if (c < 0) {
            return false;
        }
        int left = 0, right = (int) Math.sqrt(c);
        while (left <= right) {
            int cur = left * left + right * right;
            if (cur < c) {
                left++;
            } else if (cur > c) {
                right--;
            } else {
                return true;
            }
        }
        return false;
    }
}
