package com.hit.basmath.interview.top_interview_questions.medium_collection.array_and_strings;

/**
 * 334. Increasing Triplet Subsequence
 * <p>
 * Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.
 * <p>
 * Formally the function should:
 * <p>
 * Return true if there exists i, j, k
 * such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
 * <p>
 * Note: Your algorithm should run in O(n) time complexity and O(1) space complexity.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3,4,5]
 * Output: true
 * <p>
 * Example 2:
 * <p>
 * Input: [5,4,3,2,1]
 * Output: false
 */
public class _334 {
    public boolean increasingTriplet(int[] nums) {
        int min = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= min) min = num;
            else if (num < secondMin) secondMin = num;
            else if (num > secondMin) return true;
        }
        return false;
    }
}
