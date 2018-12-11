package com.hit.math;

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
        int[] arr = {-3, -2, -1, 1, 2, 3};
        int[] arr1 = {1};
        System.out.println(guessNumber(5));
    }

    /**
     * Binary Search Solution
     *
     * @param n
     * @return
     */
    public static int guessNumber(int n) {
        int left = 0, right = n;

        return left;
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
