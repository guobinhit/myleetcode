package com.hit.basmath.learn.others;

/**
 * 456. 132 Pattern
 * <p>
 * Given a sequence of n integers a1, a2, ..., an, a 132 pattern is a subsequence ai, aj, ak such that i < j < k and ai < ak < aj. Design an algorithm that takes a list of n numbers as input and checks whether there is a 132 pattern in the list.
 * <p>
 * Note: n will be less than 15,000.
 * <p>
 * Example 1:
 * <p>
 * Input: [1, 2, 3, 4]
 * <p>
 * Output: False
 * <p>
 * Explanation: There is no 132 pattern in the sequence.
 * <p>
 * Example 2:
 * <p>
 * Input: [3, 1, 4, 2]
 * <p>
 * Output: True
 * <p>
 * Explanation: There is a 132 pattern in the sequence: [1, 4, 2].
 * <p>
 * Example 3:
 * <p>
 * Input: [-1, 3, 2, 0]
 * <p>
 * Output: True
 * <p>
 * Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1, 3, 0] and [-1, 2, 0].
 */
public class _456 {
    public boolean find132pattern(int[] nums) {
        if (nums == null || nums.length < 3)
            return false;
        int[] small = new int[nums.length];
        int[] middle = new int[nums.length];
        int smallValue = Integer.MAX_VALUE;
        int middleValue = Integer.MAX_VALUE;
        small[0] = smallValue;
        for (int i = 0; i <= nums.length - 2; i++) {
            if (nums[i] < smallValue) {
                smallValue = nums[i];
            }
            small[i + 1] = smallValue;
        }

        middle[middle.length - 1] = middleValue;
        for (int j = middle.length - 1; j >= 1; j--) {
            if (nums[j] > small[j - 1] && nums[j] < middle[j]) {
                middleValue = nums[j];
            }
            middle[j - 1] = middleValue;
        }

        for (int i = 1; i <= nums.length - 2; i++) {
            if (nums[i] > small[i] && nums[i] > middle[i] && middle[i] > small[i])
                return true;
        }
        return false;
    }
}
