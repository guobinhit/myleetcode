package com.hit.basmath.learn.others;

import java.util.HashSet;
import java.util.Set;

/**
 * 523. Continuous Subarray Sum
 * <p>
 * Given a list of non-negative numbers and a target integer k, write a function to check if the array has a continuous subarray of size at least 2 that sums up to a multiple of k, that is, sums up to n*k where n is also an integer.
 * <p>
 * Example 1:
 * <p>
 * Input: [23, 2, 4, 6, 7],  k=6
 * Output: True
 * Explanation: Because [2, 4] is a continuous subarray of size 2 and sums up to 6.
 * <p>
 * Example 2:
 * <p>
 * Input: [23, 2, 6, 4, 7],  k=6
 * Output: True
 * Explanation: Because [23, 2, 6, 4, 7] is an continuous subarray of size 5 and sums up to 42.
 * <p>
 * Note:
 * <p>
 * 1. The length of the array won't exceed 10,000.
 * 2. You may assume the sum of all the numbers is in the range of a signed 32-bit integer.
 */
public class _523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        k = k == 0 ? Integer.MAX_VALUE : (k < 0 ? -k : k); // make sure k is positive; if k is zero, we won't do mod at all
        if ((nums.length + 2) / 2 > k)
            return true; // we have (length + 1 > k * 2) prefix sum but k remainder and k positions that the same remainders next to each other, then there is at least two prefix with the same remainder and the distance is larger than one

        Set<Integer> set = new HashSet<>();
        int last = 0; // the prefix sum one element earlier
        for (int num : nums) {
            int cur = (last + num) % k; // get newest prefix sum mod k
            if (set.contains(cur)) return true;
            set.add(last); // add old prefix sum into HashSet
            last = cur; // update old prefix sum
        }
        return false;
    }
}
