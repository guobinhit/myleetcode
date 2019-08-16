package com.hit.basmath.interview.top_interview_questions.easy_collection.math;

/**
 * 326. Power of Three
 * <p>
 * Given an integer, write a function to determine if it is a power of three.
 * <p>
 * Example 1:
 * <p>
 * Input: 27
 * Output: true
 * <p>
 * Example 2:
 * <p>
 * Input: 0
 * Output: false
 * <p>
 * Example 3:
 * <p>
 * Input: 9
 * Output: true
 * <p>
 * Example 4:
 * <p>
 * Input: 45
 * Output: false
 * <p>
 * Follow up:
 * <p>
 * Could you do it without using any loop / recursion?
 */
public class _326 {
    public boolean isPowerOfThree(int n) {
        // 1162261467 is 3^19,  3^20 is bigger than int
        return (n > 0 && 1162261467 % n == 0);
    }
}
