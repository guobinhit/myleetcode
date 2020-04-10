package com.hit.basmath.learn.array_and_string;

/**
 * 485. Max Consecutive Ones
 * <p>
 * Given a binary array, find the maximum number of consecutive 1s in this array.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,1,0,1,1,1]
 * <p>
 * Output: 3
 * <p>
 * Explanation: The first two digits or the last three digits are consecutive 1s.
 * The maximum number of consecutive 1s is 3.
 * <p>
 * Note:
 * <p>
 * The input array will only contain 0 and 1.
 * The length of input array is a positive integer and will not exceed 10,000
 */
public class _485 {
    public static int findMaxConsecutiveOnes(int[] nums) {
        int maxConsecutiveLength = 0;
        int tempConsecutiveLength = 0;
        /**
         * Iterate all element of nums
         */
        for (int num : nums) {
            /**
             * If num == 1 is true, let tempConsecutiveLength++
             * and let maxConsecutiveLength is the largest of maxConsecutiveLength and tempConsecutiveLength
             */
            if (num == 1) {
                tempConsecutiveLength++;
                maxConsecutiveLength = Math.max(maxConsecutiveLength, tempConsecutiveLength);
            } else {
                /**
                 * If num == 1 is false, it's mean num is 0,
                 * so let tempConsecutiveLength = 0 always
                 */
                tempConsecutiveLength = 0;
            }
        }
        return maxConsecutiveLength;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 1, 1, 1};
        int[] nums2 = {1, 0, 1, 1, 0, 1};
        System.out.println(_485.findMaxConsecutiveOnes(nums));
        System.out.println(_485.findMaxConsecutiveOnes(nums2));
    }
}
