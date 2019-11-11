package com.hit.basinfo.sort_algorithm;

/**
 * author:Charies Gavin
 * date:2019/1/7,14:20
 * https:github.com/guobinhit
 * description: Bubble Sort
 */
public class BubbleSort {
    /**
     * Bubble Sort
     *
     * @param nums pending array
     */
    public void bubbleSort(int[] nums) {
        // check parameters
        if (nums != null && nums.length > 1) {
            /**
             * Starting from nums.length - 1, the number of comparisons decreases successively,
             * The first time is nums. length - 1 times, the second time is nums. length - 2 times ...
             */
            for (int i = nums.length - 1; i > 0; i--) {
                for (int j = 0; j < i; j++) {
                    /**
                     * If the former element is larger than the latter,
                     * the order of the two elements is interactive
                     */
                    if (nums[j] > nums[j + 1]) {
                        int temp = nums[j];
                        nums[j] = nums[j + 1];
                        nums[j + 1] = temp;
                    }
                }
            }
        }
    }
}
