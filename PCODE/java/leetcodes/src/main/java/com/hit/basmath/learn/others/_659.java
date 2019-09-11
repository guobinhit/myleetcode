package com.hit.basmath.learn.others;

/**
 * 659. Split Array into Consecutive Subsequences
 * <p>
 * Given an array nums sorted in ascending order, return true if and only if you can split it into 1 or more subsequences such that each subsequence consists of consecutive integers and has length at least 3.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3,3,4,5]
 * Output: True
 * Explanation:
 * You can split them into two consecutive subsequences :
 * 1, 2, 3
 * 3, 4, 5
 * <p>
 * Example 2:
 * <p>
 * Input: [1,2,3,3,4,4,5,5]
 * Output: True
 * Explanation:
 * You can split them into two consecutive subsequences :
 * 1, 2, 3, 4, 5
 * 3, 4, 5
 * <p>
 * Example 3:
 * <p>
 * Input: [1,2,3,4,4,5]
 * Output: False
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 10000
 */
public class _659 {
    public boolean isPossible(int[] nums) {
        int pre = Integer.MIN_VALUE, p1 = 0, p2 = 0, p3 = 0;
        int cur = 0, cnt = 0, c1 = 0, c2 = 0, c3 = 0;

        for (int i = 0; i < nums.length; pre = cur, p1 = c1, p2 = c2, p3 = c3) {
            for (cur = nums[i], cnt = 0; i < nums.length && cur == nums[i]; cnt++, i++) ;

            if (cur != pre + 1) {
                if (p1 != 0 || p2 != 0) return false;
                c1 = cnt;
                c2 = 0;
                c3 = 0;

            } else {
                if (cnt < p1 + p2) return false;
                c1 = Math.max(0, cnt - (p1 + p2 + p3));
                c2 = p1;
                c3 = p2 + Math.min(p3, cnt - (p1 + p2));
            }
        }

        return (p1 == 0 && p2 == 0);
    }
}
