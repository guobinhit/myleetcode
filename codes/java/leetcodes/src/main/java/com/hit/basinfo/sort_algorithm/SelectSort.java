package com.hit.basinfo.sort_algorithm;

import java.util.Arrays;

/**
 * author:Charies Gavin
 * date:2019/1/7,15:16
 * https:github.com/guobinhit
 * description: 选择排序
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] nums = {0, -1, 9, -3, 3, 5, 3, 62, 20};
        System.out.println(Arrays.toString(nums));
        selectSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 选择排序
     *
     * @param nums
     */
    public static void selectSort(int[] nums) {
        // 参数校验
        if (nums != null &&
                nums.length > 1) {
            // 倒序，循环处理数组中的每一个元素
            for (int i = nums.length - 1; i > 0; i--) {
                // 假设 i 是最大元素的下角标
                int maxIndex = i;

                // 依次将前 i-1 个元素同第 i 个元素相比较
                for (int j = 0; j < i; j++) {
                    if (nums[maxIndex] < nums[j]) {
                        maxIndex = j;
                    }
                }

                // 如果最大元素的下角标不等于 i，则将其进行交换
                if (maxIndex != i) {
                    int temp = nums[i];
                    nums[i] = nums[maxIndex];
                    nums[maxIndex] = temp;
                }
            }
        }
    }
}
