package com.hit.basmath.learn.others;

/**
 * 477. Total Hamming Distance
 * <p>
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 * <p>
 * Now your job is to find the total Hamming distance between all pairs of the given numbers.
 * <p>
 * Example:
 * <p>
 * Input: 4, 14, 2
 * Output: 6
 * <p>
 * Explanation: In binary representation, the 4 is 0100, 14 is 1110, and 2 is 0010 (just
 * showing the four bits relevant in this case). So the answer will be:
 * HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.
 * <p>
 * Note:
 * <p>
 * 1. Elements of the given array are in the range of 0 to 10^9
 * 2. Length of the array will not exceed 10^4.
 */
public class _477 {
    public int totalHammingDistance(int[] nums) {
        int total = 0, n = nums.length;
        for (int j = 0; j < 32; j++) {
            int bitCount = 0;
            for (int num : nums) bitCount += (num >> j) & 1;
            total += bitCount * (n - bitCount);
        }
        return total;
    }
}
