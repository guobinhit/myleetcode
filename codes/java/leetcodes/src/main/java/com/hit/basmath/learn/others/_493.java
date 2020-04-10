package com.hit.basmath.learn.others;

/**
 * 493. Reverse Pairs
 * <p>
 * Given an array nums, we call (i, j) an important reverse pair if i < j and nums[i] > 2*nums[j].
 * <p>
 * You need to return the number of important reverse pairs in the given array.
 * <p>
 * Example1:
 * <p>
 * Input: [1,3,2,3,1]
 * Output: 2
 * <p>
 * Example2:
 * <p>
 * Input: [2,4,3,5,1]
 * Output: 3
 * <p>
 * Note:
 * <p>
 * 1. The length of the given array will not exceed 50,000.
 * 2. All the numbers in the input array are in the range of 32-bit integer.
 */
public class _493 {
    public int ret;

    public int reversePairs(int[] nums) {
        ret = 0;
        mergeSort(nums, 0, nums.length - 1);
        return ret;
    }

    private void mergeSort(int[] nums, int left, int right) {
        if (right <= left) {
            return;
        }
        int middle = left + (right - left) / 2;
        mergeSort(nums, left, middle);
        mergeSort(nums, middle + 1, right);

        //count elements
        int count = 0;
        for (int l = left, r = middle + 1; l <= middle; ) {
            if (r > right || (long) nums[l] <= 2 * (long) nums[r]) {
                l++;
                ret += count;
            } else {
                r++;
                count++;
            }
        }

        //merge sort
        int[] temp = new int[right - left + 1];
        for (int l = left, r = middle + 1, k = 0; l <= middle || r <= right; ) {
            if (l <= middle && ((r > right) || nums[l] < nums[r])) {
                temp[k++] = nums[l++];
            } else {
                temp[k++] = nums[r++];
            }
        }
        System.arraycopy(temp, 0, nums, left + 0, temp.length);
    }
}
