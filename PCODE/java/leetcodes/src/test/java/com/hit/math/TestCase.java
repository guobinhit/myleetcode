package com.hit.math;

import com.hit.math.utils.CommonUtils;
import com.hit.math.utils.ListNode;

import java.math.BigInteger;

/**
 * author:Charies Gavin
 * date:2018/8/25,17:00
 * https:github.com/guobinhit
 * description: Test Case Class
 */
public class TestCase {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1};
//        int[] arr1 = {1};
//        CommonUtils.printIntArray(arr);
//        buddleSort(arr);
//        CommonUtils.printIntArray(arr);

//        System.out.println(findPeakElement(arr));
    }

//    private static int[] searchRange(int[] nums, int target) {
//        if (nums == null || nums.length == 0) {
//            return new int[]{-1, -1};
//        }
//
//        int left = 0, right = nums.length - 1;
//        while (left + 1 < right) {
//            int mid = left + (right - left) / 2;
//            if (nums[mid] == target) {
//
//            }
//            if (nums[mid] > target) {
//                left = mid + 1;
//            } else {
//                right = mid;
//            }
//        }
//        if (nums[left] > nums[right]) {
//            return nums[right];
//        }
//        return nums[left];
//    }


    private static void buddleSort(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j + 1] < arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    private static boolean isBadVersion(int n) {
        return false;
    }

}
