package com.hit.interview.sort_algorithm;

import com.hit.utils.CommonUtils;

import java.util.Arrays;

/**
 * author:Charies Gavin
 * date:2019/1/8,10:39
 * https:github.com/guobinhit
 * description: 快速排序
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] nums = {0, -1, 9, -3, 5, 3, 62, 20};
        System.out.println(Arrays.toString(nums));
        quickSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 快速排序
     *
     * @param nums
     */
    public static void quickSort(int[] nums) {
        // 参数校验
        if (nums == null ||
                nums.length < 2) {
            return;
        }
        // 初始化值
        int left = 0, right = nums.length - 1;
        // 调用重载函数
        quickSort(nums, left, right);
    }

    /**
     * 快速排序
     *
     * @param nums
     * @param left
     * @param right
     */
    public static void quickSort(int[] nums, int left, int right) {
        // 参数校验
        if (nums == null ||
                nums.length < 2) {
            return;
        }

        // 获取分割基准点，为分割后的 left 值
        int index = partition(nums, left, right);

        // 排序左半部分
        if (left < index - 1) {
            quickSort(nums, left, index - 1);
        }
        // 排序右半部分
        if (right > index) {
            quickSort(nums, index, right);
        }
    }

    /**
     * 获取分割基准点
     *
     * @param nums
     * @param left
     * @param right
     * @return
     */
    private static int partition(int[] nums, int left, int right) {
        // 默认数组中间的位置为基准点
        int pivot = nums[(left + right) / 2];

        /**
         * 当 left <= right 时，满足循环条件；
         * 当 当 left > right 时，意味着当前趟，处理完毕；
         */
        while (left <= right) {
            // 找出左边中应放到右边的元素
            while (nums[left] < pivot) {
                left++;
            }
            // 找出右边中应放到左边的元素
            while (nums[right] > pivot) {
                right--;
            }

            // 找到满足条件的元素，进行交换
            if (left <= right) {
                // 交换元素
                CommonUtils.swapElementInArray(nums, left, right);
                // 调整左右两边的索引值
                left++;
                right--;
            }
        }
        return left;
    }
}
