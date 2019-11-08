package com.hit.basinfo.search_algorithm;

/**
 * @author bin.guo
 * @Copyright 易宝支付(YeePay)
 * @date 11/8/19,2:48 PM
 * @description
 */
public class OrderSearchTest {
    public static void main(String[] args) {
        int[] nums = {0, -1, 9, -3, 3, 55, 5, 62, 20};
        System.out.println(new OrderSearch().orderSearch(nums, 5));
        System.out.println(new OrderSearch().orderSearch2(nums, 5));
    }
}
