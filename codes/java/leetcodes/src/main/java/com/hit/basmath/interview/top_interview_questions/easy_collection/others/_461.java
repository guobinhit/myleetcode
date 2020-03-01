package com.hit.basmath.interview.top_interview_questions.easy_collection.others;

/**
 * 461. Hamming Distance
 * <p>
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 * <p>
 * Given two integers x and y, calculate the Hamming distance.
 * <p>
 * Note:
 * <p>
 * 0 ≤ x, y < 2^31.
 * <p>
 * Example:
 * <p>
 * Input: x = 1, y = 4
 * <p>
 * Output: 2
 * <p>
 * Explanation:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 * ↑   ↑
 * <p>
 * The above arrows point to positions where the corresponding bits are different.
 */
public class _461 {
    public int hammingDistance(int x, int y) {
        int curr = x ^ y, count = 0;
        while (curr != 0) {
            count++;
            curr = curr & (curr - 1);
        }
        return count;
    }
}
