package com.hit.basmath.interview.top_interview_questions.medium_collection.dynamic_programming;

/**
 * 55. Jump Game
 * <p>
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * <p>
 * Each element in the array represents your maximum jump length at that position.
 * <p>
 * Determine if you are able to reach the last index.
 * <p>
 * Example 1:
 * <p>
 * Input: [2,3,1,1,4]
 * Output: true
 * <p>
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * <p>
 * Example 2:
 * <p>
 * Input: [3,2,1,0,4]
 * Output: false
 * <p>
 * Explanation: You will always arrive at index 3 no matter what. Its maximum
 * jump length is 0, which makes it impossible to reach the last index.
 */
public class _55 {
    public boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > max) {
                return false;
            }
            max = Math.max(nums[i] + i, max);
        }
        return true;
    }
}
