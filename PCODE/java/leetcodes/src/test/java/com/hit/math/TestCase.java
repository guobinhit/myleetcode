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
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        int[] arr1 = {1};
        CommonUtils.printIntArray(arr);
        buddleSort(arr);
        CommonUtils.printIntArray(arr);
    }

    private static void buddleSort(int[] arr) {
        for (int i = arr.length -1; i > 0; i--) {
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
