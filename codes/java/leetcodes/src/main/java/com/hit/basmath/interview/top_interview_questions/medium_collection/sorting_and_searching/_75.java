package com.hit.basmath.interview.top_interview_questions.medium_collection.sorting_and_searching;

/**
 * 75. Sort Colors
 * <p>
 * Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 * <p>
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * <p>
 * Note: You are not suppose to use the library's sort function for this problem.
 * <p>
 * Example:
 * <p>
 * Input: [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * <p>
 * Follow up:
 * <p>
 * A rather straight forward solution is a two-pass algorithm using counting sort.
 * First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
 * Could you come up with a one-pass algorithm using only constant space?
 */
public class _75 {
    public void sortColors(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return;
        }

        int l = 0;
        int r = nums.length - 1;
        int counter = 0;

        while (counter < nums.length && l < r) {
            if (nums[counter] == 0) {
                swap(nums, l, counter);
                l++;
                counter++;
            } else if (nums[counter] == 2 && counter < r) {
                swap(nums, r, counter);
                r--;
            } else {
                counter++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
