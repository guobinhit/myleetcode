package com.hit.basmath.learn.others;

/**
 * 768. Max Chunks To Make Sorted II
 * <p>
 * This question is the same as "Max Chunks to Make Sorted" except the integers of the given array are not necessarily distinct, the input array could be up to length 2000, and the elements could be up to 10**8.
 * <p>
 * Given an array arr of integers (not necessarily distinct), we split the array into some number of "chunks" (partitions), and individually sort each chunk.  After concatenating them, the result equals the sorted array.
 * <p>
 * What is the most number of chunks we could have made?
 * <p>
 * Example 1:
 * <p>
 * Input: arr = [5,4,3,2,1]
 * Output: 1
 * Explanation:
 * Splitting into two or more chunks will not return the required result.
 * For example, splitting into [5, 4], [3, 2, 1] will result in [4, 5, 1, 2, 3], which isn't sorted.
 * <p>
 * Example 2:
 * <p>
 * Input: arr = [2,1,3,4,4]
 * Output: 4
 * Explanation:
 * We can split into two chunks, such as [2, 1], [3, 4, 4].
 * However, splitting into [2, 1], [3], [4], [4] is the highest number of chunks possible.
 * <p>
 * Note:
 * <p>
 * arr will have length in range [1, 2000].
 * arr[i] will be an integer in range [0, 10**8].
 */
public class _768 {
    public int maxChunksToSorted(int[] arr) {
        int n;
        if (arr == null || (n = arr.length) == 0) {
            return 0;
        }
        int[] maxLeft = new int[n];
        int[] minRight = new int[n];

        maxLeft[0] = arr[0];
        for (int i = 1; i < n; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], arr[i]);
        }

        minRight[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            minRight[i] = Math.min(minRight[i + 1], arr[i]);
        }

        int numOfInsertion = 0;
        for (int i = 0; i < n - 1; i++) {
            if (maxLeft[i] <= minRight[i + 1]) {
                numOfInsertion++;
            }
        }
        return numOfInsertion + 1;
    }
}
