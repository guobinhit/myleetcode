package com.hit.math;

import com.hit.math.utils.ListNode;

/**
 * author:Charies Gavin
 * date:2018/8/25,17:00
 * https:github.com/guobinhit
 * description: Test Case Class
 */
public class TestCase {
    public static void main(String[] args) {
        int[] arr = {-3, -2, -1, 1, 2, 3};
        int[] arr1 = {1};
        System.out.println(mySqrt(9));
    }

    public static int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int left = 1, right = Integer.MAX_VALUE;
        while (true) {
            int mid = left + (right - left) / 2;
            if (mid > x / mid) {
                right = mid - 1;
            } else {
                if (mid + 1 > x / (mid + 1)) {
                    return mid;
                } else {
                    left = mid + 1;
                }
            }
        }
    }

    private static void printArray(int[] arr) {
        System.out.print("{");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("}");
    }

}
