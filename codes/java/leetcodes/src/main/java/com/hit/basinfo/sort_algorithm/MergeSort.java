package com.hit.basinfo.sort_algorithm;

/**
 * author:Charies Gavin
 * date:2019/11/11,18:30
 * https:github.com/guobinhit
 * description: Merge Sort
 */
public class MergeSort {
    /**
     * Merge Sort
     *
     * @param nums pending array
     */
    public void mergeSort(int[] nums) {
        sortArray(nums, 0, nums.length - 1);
    }

    /**
     * Sort Array
     *
     * @param nums  pending array
     * @param left  default value is 0
     * @param right default value is nums.length - 1
     */
    private void sortArray(int[] nums, int left, int right) {
        // single element direct return
        if (left == right) {
            return;
        }

        // calculate the total length of the array
        int sortSize = right - left + 1;
        // set split element
        int separate;

        if (sortSize % 2 == 0) {
            separate = left + sortSize / 2 - 1;
        } else {
            separate = left + sortSize / 2;
        }

        sortArray(nums, left, separate);
        sortArray(nums, separate + 1, right);

        mergeArray(nums, left, separate, right);
    }

    /**
     * Merge Array
     *
     * @param nums     pending array
     * @param left     default value is 0
     * @param separate default value is (left + right) / 2
     * @param right    default value is nums.length - 1
     */
    private void mergeArray(int[] nums, int left, int separate, int right) {
        int totalSize = right - left + 1;
        int size1 = separate - left + 1;
        int size2 = right - separate;

        // create an array with the same length as the two subgroups
        int[] arr1 = new int[size1];
        int[] arr2 = new int[size2];

        // store the elements in the two subgroups into the newly created two arrays
        for (int i = 0; i < size1; i++) {
            arr1[i] = nums[left + i];
        }
        for (int i = 0; i < size2; i++) {
            arr2[i] = nums[separate + 1 + i];
        }

        int mergeCount = 0;
        int index1 = 0;
        int index2 = 0;

        while (mergeCount < totalSize) {
            // first, check whether one of the arrays has been processed
            if (index1 == size1) {
                for (int i = index2; i < size2; i++) {
                    nums[left + mergeCount] = arr2[i];
                    mergeCount++;
                    index2++;
                }
            } else if (index2 == size2) {
                for (int i = index1; i < size1; i++) {
                    nums[left + mergeCount] = arr1[i];
                    mergeCount++;
                    index1++;
                }
            } else {
                // if both subgroups are not finished, do the following
                int value1 = arr1[index1];
                int value2 = arr2[index2];
                if (value1 == value2) {
                    nums[left + mergeCount] = value1;
                    nums[left + mergeCount + 1] = value1;
                    mergeCount += 2;
                    index1++;
                    index2++;
                } else if (value1 < value2) {
                    nums[left + mergeCount] = value1;
                    mergeCount++;
                    index1++;
                } else {
                    nums[left + mergeCount] = value2;
                    mergeCount++;
                    index2++;
                }
            }
        }
    }
}
