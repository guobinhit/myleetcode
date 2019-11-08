package com.hit.basinfo.search_algorithm;

/**
 * author:Charies Gavin
 * date:2019/11/8,16:28
 * https:github.com/guobinhit
 * description: Interpolation Search
 */
public class InterpolationSearch {
    /**
     * Interpolation Search
     *
     * @param nums   pending query array
     * @param left   low index
     * @param right  high index, initial value is nums.length -1
     * @param target target element
     * @return target element index
     */
    public int interpolationSearch(int[] nums, int left, int right, int target) {
        // check parameters
        if (left > right || target < nums[left] || target > nums[right]) {
            return -1;
        }

        // calculate adaptive middle value
        int mid = left + (right - left) * (target - nums[left]) / (nums[right] - nums[left]);

        // recursion method
        if (target > nums[mid]) {
            return interpolationSearch(nums, mid + 1, right, target);
        } else if (target < nums[mid]) {
            return interpolationSearch(nums, left, mid - 1, target);
        } else {
            return mid;
        }
    }
}
