package com.hit.basmath.learn.others;

/**
 * 307. Range Sum Query - Mutable
 * <p>
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 * <p>
 * The update(i, val) function modifies nums by updating the element at index i to val.
 * <p>
 * Example:
 * <p>
 * Given nums = [1, 3, 5]
 * <p>
 * sumRange(0, 2) -> 9
 * update(1, 2)
 * sumRange(0, 2) -> 8
 * <p>
 * Note:
 * <p>
 * 1. The array is only modifiable by the update function.
 * 2. You may assume the number of calls to update and sumRange function is distributed evenly.
 */
public class _307 {
    class NumArray {

        int[] tree;
        int n;

        public NumArray(int[] nums) {
            n = nums.length;
            tree = new int[n << 1];
            buildTree(nums);
        }

        private void buildTree(int[] nums) {
            for (int i = n; i < n << 1; i++) {
                tree[i] = nums[i - n];
            }

            for (int i = n - 1; i > 0; i--) {
                tree[i] = tree[i << 1] + tree[i << 1 | 1];
            }
        }

        void update(int i, int val) {
            for (tree[i += n] = val; i > 0; i >>= 1) {
                tree[i >> 1] = tree[i] + tree[i ^ 1];
            }
        }

        public int sumRange(int i, int j) {
            int ret = 0;
            for (i += n, j += n; i <= j; i >>= 1, j >>= 1) {
                if ((i & 1) == 1) ret += tree[i++];
                if ((j & 1) == 0) ret += tree[j--];
            }
            return ret;
        }
    }
}
