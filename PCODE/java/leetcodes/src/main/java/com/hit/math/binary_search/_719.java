package com.hit.math.binary_search;

import java.util.Arrays;

/**
 * 719. Find K-th Smallest Pair Distance
 * <p>
 * Given an integer array, return the k-th smallest distance among all the pairs. The distance of a pair (A, B) is defined as the absolute difference between A and B.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * nums = [1,3,1]
 * k = 1
 * Output: 0
 * <p>
 * Explanation:
 * <p>
 * Here are all the pairs:
 * <p>
 * (1,3) -> 2
 * (1,1) -> 0
 * (3,1) -> 2
 * <p>
 * Then the 1st smallest distance pair is (1,1), and its distance is 0.
 * <p>
 * Note:
 * <p>
 * 2 <= len(nums) <= 10000.
 * 0 <= nums[i] < 1000000.
 * 1 <= k <= len(nums) * (len(nums) - 1) / 2.
 */
public class _719 {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);

        int n = nums.length;
        int left = 0;
        int right = nums[n - 1] - nums[0];

        for (int cnt = 0; left < right; cnt = 0) {
            int mid = left + (right - left) / 2;

            for (int i = 0, j = 0; i < n; i++) {
                while (j < n && nums[j] <= nums[i] + mid) j++;
                cnt += j - i - 1;
            }

            if (cnt < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}
