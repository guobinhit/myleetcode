package com.hit.basmath.interview.top_interview_questions.hard_collection.sorting_and_searching;

/**
 * 378. Kth Smallest Element in a Sorted Matrix
 * <p>
 * Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.
 * <p>
 * Note that it is the kth smallest element in the sorted order, not the kth distinct element.
 * <p>
 * Example:
 * <p>
 * matrix = [
 * [ 1,  5,  9],
 * [10, 11, 13],
 * [12, 13, 15]
 * ],
 * k = 8,
 * <p>
 * return 13.
 * <p>
 * Note:
 * <p>
 * You may assume k is always valid, 1 ≤ k ≤ n^2.
 */
public class _378 {
    public int kthSmallest(int[][] matrix, int k) {
        int length = matrix.length;
        int low = matrix[0][0], high = matrix[length - 1][length - 1];
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int count = getLessEqual(matrix, mid);
            if (count < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    private int getLessEqual(int[][] matrix, int val) {
        int ans = 0;
        int length = matrix.length, i = length - 1, j = 0;
        while (i >= 0 && j < length) {
            if (matrix[i][j] > val) {
                i--;
            } else {
                ans += i + 1;
                j++;
            }
        }
        return ans;
    }
}
