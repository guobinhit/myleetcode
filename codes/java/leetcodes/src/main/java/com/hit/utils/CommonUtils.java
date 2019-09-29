package com.hit.utils;

/**
 * author:Charies Gavin
 * date:2018/8/25,17:30
 * https:github.com/guobinhit
 * description: Common Util Methods
 */
public class CommonUtils {

    /**
     * swap two element value of array
     *
     * @param nums  pending array
     * @param left  left index
     * @param right right index
     */
    public static void swapElementInArray(int[] nums, int left, int right) {
        // validate param
        if (nums != null &&
                nums.length - 1 > left &&
                nums.length - 1 > right) {
            // swap element of two index
            int temp = nums[right];
            nums[right] = nums[left];
            nums[left] = temp;
        }
    }
}
