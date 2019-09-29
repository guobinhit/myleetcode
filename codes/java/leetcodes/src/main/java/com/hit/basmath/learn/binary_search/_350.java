package com.hit.basmath.learn.binary_search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 350. Intersection of Two Arrays II
 * <p>
 * Given two arrays, write a function to compute their intersection.
 * <p>
 * Example 1:
 * <p>
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2,2]
 * <p>
 * Example 2:
 * <p>
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [4,9]
 * <p>
 * Note:
 * <p>
 * Each element in the result should appear as many times as it shows in both arrays.
 * The result can be in any order.
 * <p>
 * Follow up:
 * <p>
 * What if the given array is already sorted? How would you optimize your algorithm?
 * What if nums1's size is small compared to nums2's size? Which algorithm is better?
 * What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 */
public class _350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> res = new ArrayList<Integer>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        for (int i = 0, j = 0; i < nums1.length && j < nums2.length; ) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] == nums2[j]) {
                res.add(nums1[i]);
                i++;
                j++;
            } else {
                j++;
            }
        }
        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }
}
