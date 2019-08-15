package com.hit.math.recursion_i;

/**
 * 779. K-th Symbol in Grammar
 * <p>
 * On the first row, we write a 0. Now in every subsequent row, we look at the previous row and replace each occurrence of 0 with 01, and each occurrence of 1 with 10.
 * <p>
 * Given row N and index K, return the K-th indexed symbol in row N. (The values of K are 1-indexed.) (1 indexed).
 * <p>
 * Examples:
 * <p>
 * Input: N = 1, K = 1
 * Output: 0
 * <p>
 * Input: N = 2, K = 1
 * Output: 0
 * <p>
 * Input: N = 2, K = 2
 * Output: 1
 * <p>
 * Input: N = 4, K = 5
 * Output: 1
 * <p>
 * Explanation:
 * <p>
 * row 1: 0
 * row 2: 01
 * row 3: 0110
 * row 4: 01101001
 * <p>
 * Note:
 * <p>
 * 1. N will be an integer in the range [1, 30].
 * 2. K will be an integer in the range [1, 2^(N-1)].
 */
public class _779 {
    public int kthGrammar(int N, int K) {
        // N is useless, as the value of K index is static
        boolean flip = false;
        // count index from 0 to make it easy to calculate
        K--;

        while (K > 0) {
            if (K % 2 == 1) flip = !flip;
            K /= 2;
        }

        if (flip) {
            return 1;
        } else {
            return 0;
        }
    }
}
