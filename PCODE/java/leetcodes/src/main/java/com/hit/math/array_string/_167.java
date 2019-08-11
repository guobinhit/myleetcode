package com.hit.math.array_string;

import java.util.Arrays;

/**
 * 167. Two Sum II - Input array is sorted
 * <p>
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
 * <p>
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
 * <p>
 * Note:
 * <p>
 * Your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution and you may not use the same element twice.
 * <p>
 * Example:
 * <p>
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * <p>
 * Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
 */
public class _167 {
    public static int[] twoSum(int[] numbers, int target) {
        int[] indices = new int[2];
        /**
         * Handle wrong param
         */
        if (numbers == null || numbers.length < 2) {
            return indices;
        }
        int left = 0, right = numbers.length - 1;
        /**
         * Use while loop for handle this question,
         * if left < right is true, it's mean normal condition
         * else it's mean all element in numbers has handled and no qualified data
         */
        while (left < right) {
            int triedSum = numbers[left] + numbers[right];
            if (triedSum == target) {
                indices[0] = left + 1;
                indices[1] = right + 1;
                break;
            } else if (triedSum > target) {
                /**
                 * Because nums is sorted, so if triedSum > target is true,
                 * it's mean numbers[right] is too large, we should let right down and try again
                 */
                right--;
            } else {
                /**
                 * Ditto, if triedSum >= target is false,
                 * it's mean numbers[left] is too small, we should let left up and try again
                 */
                left++;
            }
        }
        return indices;
    }

    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(_167.twoSum(numbers, target)));
    }
}
