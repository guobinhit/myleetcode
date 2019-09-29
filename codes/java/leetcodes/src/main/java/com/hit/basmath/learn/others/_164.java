package com.hit.basmath.learn.others;

import java.util.Arrays;

/**
 * 164. Maximum Gap
 * <p>
 * Given an unsorted array, find the maximum difference between the successive elements in its sorted form.
 * <p>
 * Return 0 if the array contains less than 2 elements.
 * <p>
 * Example 1:
 * <p>
 * Input: [3,6,9,1]
 * Output: 3
 * Explanation: The sorted form of the array is [1,3,6,9], either (3,6) or (6,9) has the maximum difference 3.
 * <p>
 * Example 2:
 * <p>
 * Input: [10]
 * Output: 0
 * Explanation: The array contains less than 2 elements, therefore return 0.
 * <p>
 * Note:
 * <p>
 * You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.
 * Try to solve it in linear time/space.
 */
public class _164 {
    public int maximumGap(int[] num) {
        if (num == null || num.length < 2)
            return 0;
        // get the max and min value of the array
        int min = num[0];
        int max = num[0];
        for (int i : num) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        // the minimum possibale gap, ceiling of the integer division
        int gap = (int) Math.ceil((double) (max - min) / (num.length - 1));
        int[] bucketsMIN = new int[num.length - 1]; // store the min value in that bucket
        int[] bucketsMAX = new int[num.length - 1]; // store the max value in that bucket
        Arrays.fill(bucketsMIN, Integer.MAX_VALUE);
        Arrays.fill(bucketsMAX, Integer.MIN_VALUE);
        // put numbers into buckets
        for (int i : num) {
            if (i == min || i == max)
                continue;
            int idx = (i - min) / gap; // index of the right position in the buckets
            bucketsMIN[idx] = Math.min(i, bucketsMIN[idx]);
            bucketsMAX[idx] = Math.max(i, bucketsMAX[idx]);
        }
        // scan the buckets for the max gap
        int maxGap = Integer.MIN_VALUE;
        int previous = min;
        for (int i = 0; i < num.length - 1; i++) {
            if (bucketsMIN[i] == Integer.MAX_VALUE && bucketsMAX[i] == Integer.MIN_VALUE)
                // empty bucket
                continue;
            // min value minus the previous value is the current gap
            maxGap = Math.max(maxGap, bucketsMIN[i] - previous);
            // update previous bucket value
            previous = bucketsMAX[i];
        }
        maxGap = Math.max(maxGap, max - previous); // updata the final max value gap
        return maxGap;
    }
}
