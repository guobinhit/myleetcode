package com.hit.basmath.learn.others;

import java.util.Arrays;
import java.util.Random;

/**
 * 528. Random Pick with Weight
 * <p>
 * Given an array w of positive integers, where w[i] describes the weight of index i, write a function pickIndex which randomly picks an index in proportion to its weight.
 * <p>
 * Note:
 * <p>
 * 1 <= w.length <= 10000
 * 1 <= w[i] <= 10^5
 * pickIndex will be called at most 10000 times.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * ["Solution","pickIndex"]
 * [[[1]],[]]
 * <p>
 * Output: [null,0]
 * <p>
 * Example 2:
 * <p>
 * Input:
 * ["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
 * [[[1,3]],[],[],[],[],[]]
 * <p>
 * Output: [null,0,1,1,1,0]
 * <p>
 * Explanation of Input Syntax:
 * <p>
 * The input is two lists: the subroutines called and their arguments. Solution's constructor has one argument, the array w. pickIndex has no arguments. Arguments are always wrapped with a list, even if there aren't any.
 */
public class _528 {
    class Solution {
        private int[] weight;
        private Random random = new Random();

        public Solution(int[] w) {
            weight = new int[w.length];
            weight[0] = w[0];
            for (int i = 1; i < w.length; i++) {
                weight[i] = weight[i - 1] + w[i];
            }
        }

        public int pickIndex() {
            int index = random.nextInt(weight[weight.length - 1]);
            int ret = Arrays.binarySearch(weight, index);
            //System.out.printf("index = %d, ret = %d\n", index, ret);
            ret = ret < 0 ? Math.abs(ret) - 1 : ret;
            if (weight[ret] == index) ret++;
            return ret;
        }
    }
}
