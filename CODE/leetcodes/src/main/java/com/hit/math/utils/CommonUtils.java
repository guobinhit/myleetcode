package com.hit.math.utils;

/**
 * @author bin.guo
 * @Copyright 易宝支付(YeePay)
 * @date 8/24/18,10:29 AM
 * @description
 */
public class CommonUtils {
    /**
     * Print all element of array as a String
     *
     * @param array
     * @param <T>
     * @return
     */
    public static <T> String printObjectArray2String(T[] array) {
        if (array == null) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i != array.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * Print all element of array as a String
     *
     * @param nums
     * @return
     */
    public static String printIntArray2String(int[] nums) {
        if (nums == null) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < nums.length; i++) {
            sb.append(nums[i]);
            if (i != nums.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
