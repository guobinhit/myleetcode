package com.hit.math.binary_search;

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
    public int[] twoSum(int[] numbers, int target) {
        int[] indice = new int[2];
        if (numbers == null || numbers.length < 2) return indice;
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int twoSumValue = numbers[left] + numbers[right];
            if (twoSumValue == target) {
                indice[0] = left + 1;
                indice[1] = right + 1;
                break;
            } else if (twoSumValue > target) {
                right--;
            } else {
                left++;
            }
        }
        return indice;
    }
}
