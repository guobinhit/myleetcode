package com.hit.basmath.interview.top_interview_questions.medium_collection.others;

/**
 * 371. Sum of Two Integers
 * <p>
 * Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
 * <p>
 * Example 1:
 * <p>
 * Input: a = 1, b = 2
 * Output: 3
 * <p>
 * Example 2:
 * <p>
 * Input: a = -2, b = 3
 * Output: 1
 */
public class _371 {
    public int getSum(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;

        while (b != 0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }

        return a;
    }
}
