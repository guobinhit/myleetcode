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
    public static <T> String printObjectArray(T[] array) {
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
     * Print array
     *
     * @param nums
     * @return
     */
    public static void printIntArray(int[] nums) {
        if (nums == null) {
            System.out.println("This Array is null!");
            return;
        }
        System.out.print("[");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
            if (i < nums.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static void print2DArray(int[][] matrix) {
        if (matrix == null) {
            System.out.println("This 2D Array is null!");
            return;
        }
        for (int i = 0; i < matrix.length; i++) {
            System.out.print("[");
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
                if (j < matrix[i].length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }
    }
}
