package com.hit.math.binary_search;

/**
 * 374. Guess Number Higher or Lower
 * <p>
 * We are playing the Guess Game. The game is as follows:
 * <p>
 * I pick a number from 1 to n. You have to guess which number I picked.
 * <p>
 * Every time you guess wrong, I'll tell you whether the number is higher or lower.
 * <p>
 * You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):
 * <p>
 * -1 : My number is lower
 * 1 : My number is higher
 * 0 : Congrats! You got it!
 * <p>
 * Example :
 * <p>
 * Input: n = 10, pick = 6
 * Output: 6
 */
public class _374 {
    public static int guessNumber(int n) {
        int left = 0, right = n;
        while (left < right) {
            int mid = (left & right) + ((left ^ right) >> 1);
            int cmp = guess(mid);
            if (cmp == 0) {
                return mid;
            } else if (cmp == 1) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private static  int guess(int n) {
        return 0;
    }
}
