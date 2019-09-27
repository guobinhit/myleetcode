package com.hit.basmath.learn.others;

/**
 * 790. Domino and Tromino Tiling
 * <p>
 * We have two types of tiles: a 2x1 domino shape, and an "L" tromino shape. These shapes may be rotated.
 * <p>
 * XX  <- domino
 * <p>
 * XX  <- "L" tromino
 * X
 * <p>
 * Given N, how many ways are there to tile a 2 x N board? Return your answer modulo 10^9 + 7.
 * <p>
 * (In a tiling, every square must be covered by a tile. Two tilings are different if and only if there are two 4-directionally adjacent cells on the board such that exactly one of the tilings has both squares occupied by a tile.)
 * <p>
 * Example:
 * <p>
 * Input: 3
 * Output: 5
 * Explanation:
 * The five different ways are listed below, different letters indicates different tiles:
 * XYZ XXZ XYY XXY XYY
 * XYZ YYZ XZZ XYY XXY
 * <p>
 * Note:
 * <p>
 * N  will be in range [1, 1000].
 */
public class _790 {
    public int numTilings(int N) {
        int a = 0, b = 1, c = 1, c2, mod = 1000000007;
        while (--N > 0) {
            c2 = (c * 2 % mod + a) % mod;
            a = b;
            b = c;
            c = c2;
        }
        return c;
    }
}
