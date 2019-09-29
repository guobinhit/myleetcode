package com.hit.basmath.learn.others;

/**
 * 713. Subarray Product Less Than K
 * <p>
 * Your are given an array of positive integers nums.
 * <p>
 * Count and print the number of (contiguous) subarrays where the product of all the elements in the subarray is less than k.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [10, 5, 2, 6], k = 100
 * Output: 8
 * Explanation: The 8 subarrays that have product less than 100 are: [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6].
 * Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
 * <p>
 * Note:
 * <p>
 * 0 < nums.length <= 50000.
 * 0 < nums[i] < 1000.
 * 0 <= k < 10^6.
 */
public class _713 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        long p = 1l;
        int i = 0;
        int j = 0;
        int total = 0;
        while (j < n) {
            p *= nums[j];
            while (i <= j && p >= k) {
                p /= nums[i];
                i++;
            }
            total += (j - i + 1);
            j++;
        }
        return total;
    }
}
