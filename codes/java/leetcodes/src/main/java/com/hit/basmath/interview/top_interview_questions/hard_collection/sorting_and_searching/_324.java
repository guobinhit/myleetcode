package com.hit.basmath.interview.top_interview_questions.hard_collection.sorting_and_searching;

import java.util.Arrays;

/**
 * 324. Wiggle Sort II
 * <p>
 * Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1, 5, 1, 1, 6, 4]
 * Output: One possible answer is [1, 4, 1, 5, 1, 6].
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [1, 3, 2, 2, 3, 1]
 * Output: One possible answer is [2, 3, 1, 3, 1, 2].
 * <p>
 * Note:
 * <p>
 * You may assume all input has valid answer.
 * <p>
 * Follow Up:
 * <p>
 * Can you do it in O(n) time and/or in-place with O(1) extra space?
 */
public class _324 {
    public void wiggleSort(int[] nums) {
        int[] temp = Arrays.copyOf(nums, nums.length);
        Arrays.sort(temp);
        int index = nums.length - 1;
        for (int i = 1; i < nums.length; i += 2)
            nums[i] = temp[index--];
        for (int i = 0; i < nums.length; i += 2)
            nums[i] = temp[index--];
    }
}
