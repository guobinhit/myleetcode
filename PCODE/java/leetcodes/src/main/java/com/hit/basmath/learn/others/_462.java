package com.hit.basmath.learn.others;

/**
 * 462. Minimum Moves to Equal Array Elements II
 * <p>
 * Given a non-empty integer array, find the minimum number of moves required to make all array elements equal, where a move is incrementing a selected element by 1 or decrementing a selected element by 1.
 * <p>
 * You may assume the array's length is at most 10,000.
 * <p>
 * Example:
 * <p>
 * Input:
 * [1,2,3]
 * <p>
 * Output:
 * 2
 * <p>
 * Explanation:
 * Only two moves are needed (remember each move increments or decrements one element):
 * <p>
 * [1,2,3]  =>  [2,2,3]  =>  [2,2,2]
 */
public class _462 {
    public int minMoves2(int[] A) {
        int sum = 0, median = quickselect(A, A.length / 2 + 1, 0, A.length - 1);
        for (int i = 0; i < A.length; i++) sum += Math.abs(A[i] - median);
        return sum;
    }

    private int quickselect(int[] A, int k, int start, int end) {
        int l = start, r = end, pivot = A[(l + r) / 2];
        while (l <= r) {
            while (A[l] < pivot) l++;
            while (A[r] > pivot) r--;
            if (l >= r) break;
            swap(A, l++, r--);
        }
        if (l - start + 1 > k) return quickselect(A, k, start, l - 1);
        if (l - start + 1 == k && l == r) return A[l];
        return quickselect(A, k - r + start - 1, r + 1, end);
    }

    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
