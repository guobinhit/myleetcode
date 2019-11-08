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

    /**
     * Order Search(Advanced Edition)
     *
     * @param nums   pending query array
     * @param target target element
     * @return target element index
     */
    public int orderSearch2(int[] nums, int target) {
        // set a temp array, length is nums.length + 1, in order to store sentry
        int[] temp = new int[nums.length + 1];

        // store all elements in the array nums in the temp array
        for (int i = 0; i < nums.length; i++) {
            temp[i] = nums[i];
        }

        // set up sentry
        temp[nums.length] = target;
        int result;
        for (int i = 0; ; i++) {
            if (temp[i] == target) {
                result = i;
                // If the above conditions are met, the cycle is terminated
                break;
            }
        }

        /**
         * If the result value is less than the length of the nums array,
         * it must be the target element index
         */
        if (result < nums.length) {
            return result;
        } else {
            return -1;
        }
    }
}
