package com.hit.basmath.learn.others;

/**
 * 845. Longest Mountain in Array
 * <p>
 * Let's call any (contiguous) subarray B (of A) a mountain if the following properties hold:
 * <p>
 * B.length >= 3
 * <p>
 * There exists some 0 < i < B.length - 1 such that B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1]
 * (Note that B could be any subarray of A, including the entire array A.)
 * <p>
 * Given an array A of integers, return the length of the longest mountain.
 * <p>
 * Return 0 if there is no mountain.
 * <p>
 * Example 1:
 * <p>
 * Input: [2,1,4,7,3,2,5]
 * Output: 5
 * Explanation: The largest mountain is [1,4,7,3,2] which has length 5.
 * <p>
 * Example 2:
 * <p>
 * Input: [2,2,2]
 * Output: 0
 * Explanation: There is no mountain.
 * <p>
 * Note:
 * <p>
 * 0 <= A.length <= 10000
 * 0 <= A[i] <= 10000
 * <p>
 * Follow up:
 * <p>
 * Can you solve it using only one pass?
 * Can you solve it in O(1) space?
 */
public class _845 {
    public int longestMountain(int[] A) {
        int longestMountain = 0;
        for (int i = 1; i < A.length - 1; i++) {
            if (A[i - 1] < A[i] && A[i + 1] < A[i]) {
                int l = i - 1;
                int r = i + 1;
                while (l > 0 && A[l - 1] < A[l]) {
                    l--;
                }
                while (r < A.length - 1 && A[r + 1] < A[r]) {
                    r++;
                }
                longestMountain = Math.max(longestMountain, (r - l + 1));
            }
        }
        return longestMountain;
    }
}
