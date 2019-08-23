package com.hit.basmath.learn.others;

/**
 * 338. Counting Bits
 * <p>
 * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.
 * <p>
 * Example 1:
 * <p>
 * Input: 2
 * Output: [0,1,1]
 * <p>
 * Example 2:
 * <p>
 * Input: 5
 * Output: [0,1,1,2,1,2]
 * <p>
 * Follow up:
 * <p>
 * 1. It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
 * 2. Space complexity should be O(n).
 * 3. Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.
 */
public class _338 {
    public int[] countBits(int num) {
        int[] ret = new int[num + 1];
        ret[0] = 0;
        int pow = 1;
        for (int i = 1, t = 0; i <= num; i++, t++) {
            if (i == pow) {
                pow *= 2;
                t = 0;
            }
            ret[i] = ret[t] + 1;
        }
        return ret;
    }
}
