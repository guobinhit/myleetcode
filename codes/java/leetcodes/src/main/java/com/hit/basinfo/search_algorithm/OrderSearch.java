package com.hit.basinfo.search_algorithm;

/**
 * author:Charies Gavin
 * date:2019/1/7,15:00
 * https:github.com/guobinhit
 * description: Order Search
 */
public class OrderSearch {
    /**
     * Order Search
     *
     * @param nums   pending query array
     * @param target target element
     * @return target element index
     */
    public int orderSearch(int[] nums, int target) {
        // check parameters
        if (nums == null) {
            return -1;
        }
        if (nums.length < 2 && nums[0] != target) {
            return -1;
        }

        // declare variables
        int i = 0;
        /**
         * core algorithm
         * actually only compare every element in array with order to target number
         */
        for (; i < nums.length - 1; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
