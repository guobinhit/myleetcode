package com.hit.basinfo.sort_algorithm;

import java.util.Arrays;

/**
 * author:Charies Gavin
 * date:2019/1/7,14:20
 * https:github.com/guobinhit
 * description: 冒泡排序
 */
public class BubbleSort {
    /**
     * 冒泡排序
     * <p>
     * 最好的时间复杂度为 O(n)
     * 最坏的时间复杂度为 O(n^2)
     * 平均的时间复杂度为 O(n^2)
     *
     * @param nums
     */
    public void bubbleSort(int[] nums) {
        // 参数校验
        if (nums != null &&
                nums.length > 1) {
            /**
             * 从 nums.length - 1 开始，对比次数依次递减，
             * 第一次要比 nums.length - 1 次，第二次要比 nums.length - 2 次 ...
             */
            for (int i = nums.length - 1; i > 0; i--) {
                for (int j = 0; j < i; j++) {
                    // 如果前一个元素比后一个元素大，则交互两个元素的顺序
                    if (nums[j] > nums[j + 1]) {
                        int temp = nums[j];
                        nums[j] = nums[j + 1];
                        nums[j + 1] = temp;
                    }
                }
            }
        }
    }
}
