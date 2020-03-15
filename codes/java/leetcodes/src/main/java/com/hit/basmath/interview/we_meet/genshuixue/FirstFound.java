package com.hit.basmath.interview.we_meet.genshuixue;

/**
 * @author Charies Gavin
 * @github https:github.com/guobinhit
 * @date 2020/3/3,下午4:34
 * @description
 */
public class FirstFound {
    // {1,2,3,3,5,7}
    public int firstFound(int[] nums, int target) {
        if (nums == null || nums.length < 1) return -1;
        int index = binarySearch(nums, target);
        for (int i = index; i >= 0; i--) {
            if (nums[i] == nums[index]) {
                return i;
            }
        }
        return -1;
    }

    private int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] > target) {
                left = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

}
