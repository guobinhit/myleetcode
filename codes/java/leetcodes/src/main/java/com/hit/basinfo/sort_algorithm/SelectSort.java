package com.hit.basinfo.sort_algorithm;

/**
 * author:Charies Gavin
 * date:2019/1/7,15:16
 * https:github.com/guobinhit
 * description: Select Sort
 */
public class SelectSort {
    /**
     * Select Sort
     *
     * @param nums pending array
     */
    public void selectSort(int[] nums) {
        // check parameters
        if (nums != null && nums.length > 1) {
            // reverse, loop through every element in the array
            for (int i = nums.length - 1; i > 0; i--) {
                // suppose i is the subscript of the largest element
                int maxIndex = i;

                // compare the first i-1 element with the i element in turn
                for (int j = 0; j < i; j++) {
                    if (nums[maxIndex] < nums[j]) {
                        maxIndex = j;
                    }
                }

                // If the subscript of the largest element is not equal to i, exchange it
                if (maxIndex != i) {
                    int temp = nums[i];
                    nums[i] = nums[maxIndex];
                    nums[maxIndex] = temp;
                }
            }
        }
    }
}
