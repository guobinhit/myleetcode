package com.hit.basmath.learn.others;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 327. Count of Range Sum
 * <p>
 * Given an integer array nums, return the number of range sums that lie in [lower, upper] inclusive.
 * Range sum S(i, j) is defined as the sum of the elements in nums between indices i and j (i ≤ j), inclusive.
 * <p>
 * Note:
 * <p>
 * A naive algorithm of O(n2) is trivial. You MUST do better than that.
 * <p>
 * Example:
 * <p>
 * Input: nums = [-2,5,-1], lower = -2, upper = 2,
 * Output: 3
 * Explanation: The three ranges are : [0,0], [2,2], [0,2] and their respective sums are: -2, -1, 2.
 */
public class _327 {
    class SegmentTreeNode {
        SegmentTreeNode left;
        SegmentTreeNode right;
        int count;
        long min;
        long max;

        public SegmentTreeNode(long min, long max) {
            this.min = min;
            this.max = max;
        }
    }

    private SegmentTreeNode buildSegmentTree(Long[] valArr, int low, int high) {
        if (low > high) return null;
        SegmentTreeNode stn = new SegmentTreeNode(valArr[low], valArr[high]);
        if (low == high) return stn;
        int mid = (low + high) / 2;
        stn.left = buildSegmentTree(valArr, low, mid);
        stn.right = buildSegmentTree(valArr, mid + 1, high);
        return stn;
    }

    private void updateSegmentTree(SegmentTreeNode stn, Long val) {
        if (stn == null) return;
        if (val >= stn.min && val <= stn.max) {
            stn.count++;
            updateSegmentTree(stn.left, val);
            updateSegmentTree(stn.right, val);
        }
    }

    private int getCount(SegmentTreeNode stn, long min, long max) {
        if (stn == null) return 0;
        if (min > stn.max || max < stn.min) return 0;
        if (min <= stn.min && max >= stn.max) return stn.count;
        return getCount(stn.left, min, max) + getCount(stn.right, min, max);
    }

    public int countRangeSum(int[] nums, int lower, int upper) {

        if (nums == null || nums.length == 0) return 0;
        int ans = 0;
        Set<Long> valSet = new HashSet<Long>();
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += (long) nums[i];
            valSet.add(sum);
        }

        Long[] valArr = valSet.toArray(new Long[0]);

        Arrays.sort(valArr);
        SegmentTreeNode root = buildSegmentTree(valArr, 0, valArr.length - 1);

        for (int i = nums.length - 1; i >= 0; i--) {
            updateSegmentTree(root, sum);
            sum -= (long) nums[i];
            ans += getCount(root, (long) lower + sum, (long) upper + sum);
        }
        return ans;
    }

}
