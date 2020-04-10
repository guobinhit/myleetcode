package com.hit.basinfo.sort_algorithm;

/**
 * author:Charies Gavin
 * date:2019/1/8,11:36
 * https:github.com/guobinhit
 * description: Insert Sort
 */
public class InsertSort {
    /**
     * Direct Insert Sort
     *
     * @param nums pending array
     */
    public void insertSort(int[] nums) {
        // check parameters
        if (nums == null || nums.length < 2) {
            return;
        }

        // core algorithm
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j > 0; j--) {
                if (nums[j] < nums[j - 1]) {
                    int temp = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = temp;
                } else {
                    break;
                }
            }
        }
    }

    /**
     * Binary Insert Sort
     *
     * @param nums pending array
     */
    public void binaryInsertSort(int[] nums) {
        // check parameters
        if (nums == null || nums.length < 2) {
            return;
        }

        // core algorithm
        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i];
            int low = 0;
            int high = i - 1;

            while (low <= high) {
                int mid = (low + high) / 2;
                if (temp < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            for (int j = i; j >= low + 1; j--) {
                nums[j] = nums[j - 1];
            }
            nums[low] = temp;
        }
    }

    /**
     * Shell Insert Sort
     *
     * @param nums pending array
     */
    public void shellInsertSort(int[] nums) {
        // check parameters
        if (nums == null || nums.length < 2) {
            return;
        }

        int length = nums.length;
        // core algorithm
        do {
            // set the initial increment to half the array length
            length = length / 2;
            for (int x = 0; x < length; x++) {
                for (int i = x + length; i < nums.length; i = i + length) {
                    int temp = nums[i];
                    int j;
                    for (j = i - length; j >= 0 && nums[j] > temp; j = j - length) {
                        nums[j + length] = nums[j];
                    }
                    nums[j + length] = temp;
                }
            }

            // when the increment is 1, the sorting is complete
        } while (length != 1);
    }
}
