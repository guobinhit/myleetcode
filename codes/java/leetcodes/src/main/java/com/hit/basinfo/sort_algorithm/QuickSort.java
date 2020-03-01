package com.hit.basinfo.sort_algorithm;

/**
 * author:Charies Gavin
 * date:2019/1/8,10:39
 * https:github.com/guobinhit
 * description: Quick Sort
 */
public class QuickSort {
    /**
     * Quick Sort
     *
     * @param nums pending array
     */
    public void quickSort(int[] nums) {
        // check parameters
        if (nums == null || nums.length < 2) return;
        // initial value
        int left = 0, right = nums.length - 1;
        // call overload method
        quickSort(nums, left, right);
    }

    /**
     * Quick Sort
     *
     * @param nums  pending array
     * @param left  default value is 0
     * @param right default value is nums.length - 1
     */
    private void quickSort(int[] nums, int left, int right) {
        // check parameters
        if (nums == null || nums.length < 2) return;
        // obtain the division datum point, which is the left value after the division
        int index = partition(nums, left, right);
        // sort left half
        if (left < index - 1) {
            quickSort(nums, left, index - 1);
        }
        // sort right half
        if (right > index) {
            quickSort(nums, index, right);
        }
    }

    /**
     * obtain the division datum point
     *
     * @param nums  pending array
     * @param left  default value is 0
     * @param right default value is nums.length - 1
     * @return left value
     */
    private int partition(int[] nums, int left, int right) {
        // the position in the middle of the default array is the reference point
        int pivot = nums[(left + right) / 2];
        /**
         * when left < = right, the cycle condition is satisfied
         * when left > right, it means that the current trip is completed
         */
        while (left <= right) {
            // find the elements on the left that should be placed on the right
            while (nums[left] < pivot) {
                left++;
            }
            // find the elements on the right that should be placed on the left
            while (nums[right] > pivot) {
                right--;
            }
            // find the elements that meet the conditions and exchange them
            if (left <= right) {
                // exchange element
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;

                // adjust left and right index values
                left++;
                right--;
            }
        }
        return left;
    }
}
