package com.hit.basinfo.search_algorithm;

import com.hit.basinfo.sort_algorithm.BubbleSort;

import java.util.Arrays;

/**
 * author:Charies Gavin
 * date:2019/11/8,16:28
 * https:github.com/guobinhit
 * description: Interpolation Search
 */
public class InterpolationSearchTest {
    public static void main(String[] args) {
        int[] nums = {0, -1, 9, -3, 3, 55, 5, 62, 20};
        System.out.println(Arrays.toString(nums));
        new BubbleSort().bubbleSort(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println(new InterpolationSearch().interpolationSearch(nums, 0, nums.length - 1, -3));
    }
}
