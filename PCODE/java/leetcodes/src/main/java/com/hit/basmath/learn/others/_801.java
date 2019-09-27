package com.hit.basmath.learn.others;

/**
 * 801. Minimum Swaps To Make Sequences Increasing
 * <p>
 * We have two integer sequences A and B of the same non-zero length.
 * <p>
 * We are allowed to swap elements A[i] and B[i].  Note that both elements are in the same index position in their respective sequences.
 * <p>
 * At the end of some number of swaps, A and B are both strictly increasing.  (A sequence is strictly increasing if and only if A[0] < A[1] < A[2] < ... < A[A.length - 1].)
 * <p>
 * Given A and B, return the minimum number of swaps to make both sequences strictly increasing.  It is guaranteed that the given input always makes it possible.
 * <p>
 * Example:
 * <p>
 * Input: A = [1,3,5,4], B = [1,2,3,7]
 * Output: 1
 * Explanation:
 * Swap A[3] and B[3].  Then the sequences are:
 * A = [1, 3, 5, 7] and B = [1, 2, 3, 4]
 * which are both strictly increasing.
 * <p>
 * Note:
 * <p>
 * A, B are arrays with the same length, and that length will be in the range [1, 1000].
 * A[i], B[i] are integer values in the range [0, 2000].
 */
public class _801 {
    public int minSwap(int[] A, int[] B) {
        int swapRecord = 1, fixRecord = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i - 1] >= B[i] || B[i - 1] >= A[i]) {
                // In this case, the ith manipulation should be same as the i-1th manipulation
                // fixRecord = fixRecord;
                swapRecord++;
            } else if (A[i - 1] >= A[i] || B[i - 1] >= B[i]) {
                // In this case, the ith manipulation should be the opposite of the i-1th manipulation
                int temp = swapRecord;
                swapRecord = fixRecord + 1;
                fixRecord = temp;
            } else {
                // Either swap or fix is OK. Let's keep the minimum one
                int min = Math.min(swapRecord, fixRecord);
                swapRecord = min + 1;
                fixRecord = min;
            }
        }
        return Math.min(swapRecord, fixRecord);
    }
}
