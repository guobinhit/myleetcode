package com.hit.math.binary_search;

import java.util.ArrayList;
import java.util.List;

/**
 * 658. Find K Closest Elements
 * <p>
 * Given a sorted array, two integers k and x, find the k closest elements to x in the array. The result should also be sorted in ascending order. If there is a tie, the smaller elements are always preferred.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3,4,5], k=4, x=3
 * Output: [1,2,3,4]
 * <p>
 * Example 2:
 * <p>
 * Input: [1,2,3,4,5], k=4, x=-1
 * Output: [1,2,3,4]
 * <p>
 * Note:
 * <p>
 * 1. The value k is positive and will always be smaller than the length of the sorted array.
 * 2. Length of the given array is positive and will not exceed 104
 * 3. Absolute value of elements in the array and x will not exceed 104
 */
public class _658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length - 1;

        while (right - left >= k) {
            if (Math.abs(arr[left] - x) > Math.abs(arr[right] - x)) {
                left++;
            } else {
                right--;
            }
        }

        List<Integer> result = new ArrayList<Integer>(k);
        for (int i = left; i <= right; i++) {
            result.add(arr[i]);
        }
        return result;
    }
}
