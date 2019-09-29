package com.hit.basmath.interview.top_interview_questions.hard_collection.array_and_strings;

/**
 * 41. First Missing Positive
 * <p>
 * Given an unsorted integer array, find the smallest missing positive integer.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,0]
 * Output: 3
 * <p>
 * Example 2:
 * <p>
 * Input: [3,4,-1,1]
 * Output: 2
 * <p>
 * Example 3:
 * <p>
 * Input: [7,8,9,11,12]
 * Output: 1
 * <p>
 * Note:
 * <p>
 * Your algorithm should run in O(n) time and uses constant extra space.
 */
public class _41 {
    public int firstMissingPositive(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == i + 1 || nums[i] <= 0 || nums[i] > nums.length) i++;
            else if (nums[nums[i] - 1] != nums[i]) swap(nums, i, nums[i] - 1);
            else i++;
        }
        i = 0;
        while (i < nums.length && nums[i] == i + 1) i++;
        return i + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
