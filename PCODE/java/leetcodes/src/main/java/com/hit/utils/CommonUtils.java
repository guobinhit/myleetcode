package com.hit.utils;

import java.util.Collection;
import java.util.Iterator;

/**
 * author:Charies Gavin
 * date:2018/8/25,17:30
 * https:github.com/guobinhit
 * description: Common Util Methods
 */
public class CommonUtils {
    /**
     * Print Object Array
     *
     * @param array
     * @param <T>
     * @return
     */
    public static <T> void printObjectArray(T[] array) {
        if (array == null) {
            System.out.println("This Array is null!");
            return;
        }
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    /**
     * 打印 int 类型的一维数组
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

    /**
     * Print 2D Array
     *
     * @param matrix
     */
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

    public static void printCollection(Collection<?> param) {
        if (param == null) {
            System.out.println("This param is null!");
            return;
        }
        Iterator it = param.iterator();
        while (it.hasNext()) {
            System.out.print(it.next());
        }
    }

    /**
     * swap two element value of array
     *
     * @param nums
     * @param left
     * @param right
     */
    public static void swapElementInArray(int[] nums, int left, int right) {
        // 参数校验
        if (nums != null &&
                nums.length - 1 > left &&
                nums.length - 1 > right) {
            // 交换元素
            int temp = nums[right];
            nums[right] = nums[left];
            nums[left] = temp;
        }
    }
}
