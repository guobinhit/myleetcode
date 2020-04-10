package com.hit.basmath.learn.others;

import java.util.Arrays;

/**
 * 473. Matchsticks to Square
 * <p>
 * Remember the story of Little Match Girl? By now, you know exactly what matchsticks the little match girl has, please find out a way you can make one square by using up all those matchsticks. You should not break any stick, but you can link them up, and each matchstick must be used exactly one time.
 * <p>
 * Your input will be several matchsticks the girl has, represented with their stick length. Your output will either be true or false, to represent whether you could make one square using all the matchsticks the little match girl has.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,1,2,2,2]
 * Output: true
 * <p>
 * Explanation: You can form a square with length 2, one side of the square came two sticks with length 1.
 * <p>
 * Example 2:
 * <p>
 * Input: [3,3,3,3,4]
 * Output: false
 * <p>
 * Explanation: You cannot find a way to form a square with all the matchsticks.
 * <p>
 * Note:
 * <p>
 * 1. The length sum of the given matchsticks is in the range of 0 to 10^9.
 * 2. The length of the given matchstick array will not exceed 15.
 */
public class _473 {
    public boolean makesquare(int[] nums) {
        if (nums.length == 0) return false;
        Arrays.sort(nums);
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // First jude sum can divide by 4
        if (sum % 4 != 0) {
            return false;
        }
        int width = sum / 4;
        // If any num bigger than width, return false
        for (int num : nums) {
            if (num > width) return false;
        }
        boolean[] used = new boolean[nums.length];
        return dfs(nums, used, 0, 0, width, 0);
    }

    private boolean dfs(int[] nums, boolean[] used, int acc, int start, int target, int count) {
        if (count == 4) {
            // Judge if we use all the nums
            for (boolean anUsed : used) {
                if (!anUsed) return false;
            }
            return true;
        } else if (acc > target) {
            return false;
        } else if (acc == target) {
            return dfs(nums, used, 0, 0, target, count + 1);
        } else {
            for (int i = start; i < nums.length; i++) {
                if (!used[i]) {
                    used[i] = true;
                    if (dfs(nums, used, acc + nums[i], i + 1, target, count)) return true;
                    used[i] = false;
                }
            }
            return false;
        }
    }
}
