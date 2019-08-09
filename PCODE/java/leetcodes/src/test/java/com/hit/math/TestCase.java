package com.hit.math;

import com.hit.utils.CommonUtils;
import com.hit.utils.ListNode;

import java.math.BigInteger;

/**
 * author:Charies Gavin
 * date:2018/8/25,17:00
 * https:github.com/guobinhit
 * description: Test Case Class
 */
public class TestCase {
    public static void main(String[] args) {
    }


    public boolean isPerfectSquare(int num) {

        int[] arr = new int[num];

        int temp = 1;

        for (int i = 0; i < num; i++) {
            arr[0] = temp + i;
        }

        int middle = arr[num / 2];

        return (middle * 2) == num;
    }



}
