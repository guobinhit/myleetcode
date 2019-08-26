package com.hit.basmath.learn.others;

import java.util.Random;

/**
 * 398. Random Pick Index
 * <p>
 * Given an array of integers with possible duplicates, randomly output the index of a given target number. You can assume that the given target number must exist in the array.
 * <p>
 * Note:
 * <p>
 * The array size can be very large. Solution that uses too much extra space will not pass the judge.
 * <p>
 * Example:
 * <p>
 * int[] nums = new int[] {1,2,3,3,3};
 * Solution solution = new Solution(nums);
 * <p>
 * // pick(3) should return either index 2, 3, or 4 randomly. Each index should have equal probability of returning.
 * solution.pick(3);
 * <p>
 * // pick(1) should return 0. Since in the array only nums[0] is equal to 1.
 * solution.pick(1);
 */
public class _398 {
    class Solution {
        private Random rd;
        private int[] n;

        public Solution(int[] nums) {
            this.n = nums;
            this.rd = new Random();
        }

        public int pick(int target) {
            int idx = -1;
            do {
                idx = rd.nextInt(n.length);
            } while (n[idx] != target);

            return idx;
        }
    }
}
