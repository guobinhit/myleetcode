package com.hit.basmath.learn.others;

/**
 * 915. Partition Array into Disjoint Intervals
 * <p>
 * Given an array A, partition it into two (contiguous) subarrays left and right so that:
 * <p>
 * Every element in left is less than or equal to every element in right.
 * left and right are non-empty.
 * left has the smallest possible size.
 * Return the length of left after such a partitioning.  It is guaranteed that such a partitioning exists.
 * <p>
 * Example 1:
 * <p>
 * Input: [5,0,3,8,6]
 * Output: 3
 * Explanation: left = [5,0,3], right = [8,6]
 * <p>
 * Example 2:
 * <p>
 * Input: [1,1,1,0,6,12]
 * Output: 4
 * Explanation: left = [1,1,1,0], right = [6,12]
 * <p>
 * Note:
 * <p>
 * 2 <= A.length <= 30000
 * 0 <= A[i] <= 10^6
 * It is guaranteed there is at least one way to partition A as described.
 */
public class _915 {
    public int partitionDisjoint(int[] a) {
        int localMax = a[0], partitionIdx = 0, max = localMax;
        for (int i = 1; i < a.length; i++)
            if (localMax > a[i]) {
                localMax = max;
                partitionIdx = i;
            } else {
                max = Math.max(max, a[i]);
            }
        return partitionIdx + 1;
    }
}
