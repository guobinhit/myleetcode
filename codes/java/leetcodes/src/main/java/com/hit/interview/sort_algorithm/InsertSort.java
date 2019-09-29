package com.hit.interview.sort_algorithm;

import java.util.Arrays;

/**
 * author:Charies Gavin
 * date:2019/1/8,11:36
 * https:github.com/guobinhit
 * description: 插入排序
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] nums = {0, -1, 9, -3, 5, 3, 62, 20};
        System.out.println(Arrays.toString(nums));
        insertSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 直接插入排序
     *
     * @param nums
     */
    public static void insertSort(int[] nums) {
        // 参数校验
        if (nums == null ||
                nums.length < 2) {
            return;
        }

        // 核心算法
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i; j > 0; j--) {
                if (nums[j] < nums[j - 1]) {
                    int temp = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = temp;
                } else {
                    break;
                }
            }
        }
    }

    /**
     * 二分插入排序
     *
     * @param nums
     */
    public static void binaryInsertSort(int[] nums) {
        // 参数校验
        if (nums == null ||
                nums.length < 2) {
            return;
        }

        // 折半排序核心算法
        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i];
            int low = 0;
            int high = i - 1;

            while (low <= high) {
                int mid = (low + high) / 2;
                if (temp < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            for (int j = i; j >= low + 1; j--) {
                nums[j] = nums[j - 1];
            }
            nums[low] = temp;
        }
    }

    /**
     * 希尔插入排序
     *
     * @param nums
     */
    public static void shellInsertSort(int[] nums) {
        // 参数校验
        if (nums == null ||
                nums.length < 2) {
            return;
        }

        int d = nums.length;
        // 希尔排序核心算法
        while (true) {
            // 设置初始增量为数组长度的一半
            d = d / 2;
            for (int x = 0; x < d; x++) {
                for (int i = x + d; i < nums.length; i = i + d) {
                    int temp = nums[i];
                    int j;
                    for (j = i - d; j >= 0 && nums[j] > temp; j = j - d) {
                        nums[j + d] = nums[j];
                    }
                    nums[j + d] = temp;
                }
            }

            // 增量为 1 时，排序完成
            if (d == 1) {
                break;
            }
        }
    }
}
