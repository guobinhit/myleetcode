package com.hit.interview.search_algorithm;

import com.hit.interview.sort_algorithm.BubbleSort;
import com.hit.math.utils.CommonUtils;

/**
 * author:Charies Gavin
 * date:2019/1/7,14:31
 * https:github.com/guobinhit
 * description: 二分查找
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {0, -1, 9, -3, 3, 55, 5, 62, 20};
        CommonUtils.printIntArray(nums);
        BubbleSort.bubbleSort(nums);
        CommonUtils.printIntArray(nums);
        System.out.println(binarySearch(nums, 0));
    }

    /**
     * 二分查找
     * <p>
     * 前提：待查数组必须是有序的
     *
     * @param nums
     * @param target
     * @return 目标元素索引
     */
    public static int binarySearch(int[] nums, int target) {
        // 参数校验
        if (nums == null) {
            return -1;
        }
        if (nums.length < 2 &&
                nums[0] != target) {
            return -1;
        }

        // 声明变量
        int left = 0, right = nums.length - 1, mid;

        // 核心算法
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
