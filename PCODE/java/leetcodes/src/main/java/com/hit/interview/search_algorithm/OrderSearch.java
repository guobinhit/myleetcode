package com.hit.interview.search_algorithm;

/**
 * author:Charies Gavin
 * date:2019/1/7,15:00
 * https:github.com/guobinhit
 * description: 顺序查找
 */
public class OrderSearch {
    public static void main(String[] args) {
        int[] nums = {0, -1, 9, -3, 3, 55, 5, 62, 20};
        System.out.println(orderSearch(nums, 5));
    }


    /**
     * 顺序排序
     *
     * @param nums
     * @param target
     * @return
     */
    public static int orderSearch(int[] nums, int target) {
        // 参数校验
        if (nums == null) {
            return -1;
        }
        if (nums.length < 2 &&
                nums[0] != target) {
            return -1;
        }

        // 声明变量，以便复用
        int i = 0;
        // 核心算法，实际上就是按顺序比较数组中的每个元素是否与目标元素相等而已
        for (; i < nums.length - 1; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 顺序排序(进阶版)
     *
     * @param nums
     * @param target
     * @return
     */
    public static int orderSearch_2(int[] nums, int target) {
        // 设置临时数组，其长度比 nums 长一位，用于存储监视哨兵
        int[] temp = new int[nums.length + 1];

        // 将数组 nums 中的元素全部存在临时数组中
        for (int i = 0; i < nums.length; i++) {
            temp[i] = nums[i];
        }

        // 设置监视哨
        temp[nums.length] = target;
        int result;
        for (int i = 0; ; i++) {
            if (temp[i] == target) {
                result = i;
                // 如果上述条件满足，则终止循环
                break;
            }
        }

        // 如果结果值小于 nums 数组的长度，则肯定是目标元素索引
        if (result < nums.length) {
            return result;
        } else {
            return -1;
        }
    }
}
