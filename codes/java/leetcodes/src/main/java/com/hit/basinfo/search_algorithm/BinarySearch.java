package com.hit.basinfo.search_algorithm;

/**
 * author:Charies Gavin
 * date:2019/1/7,14:31
 * https:github.com/guobinhit
 * description: binary search
 */
public class BinarySearch {
    /**
     * Binary Search
     * <p>
     * tips：pending query array must be sorted
     *
     * @param nums   pending query array
     * @param target target element
     * @return target element index
     */
    public int binarySearch(int[] nums, int target) {
        // check parameters
        if (nums == null) {
            return -1;
        }
        if (nums.length < 2 && nums[0] != target) {
            return -1;
        }

        // declare variables
        int left = 0, right = nums.length - 1, mid;

        // core algorithm
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
