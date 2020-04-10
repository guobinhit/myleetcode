package com.hit.basmath.learn.others;

/**
 * 746. Min Cost Climbing Stairs
 * <p>
 * On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).
 * <p>
 * Once you pay the cost, you can either climb one or two steps. You need to find minimum cost to reach the top of the floor, and you can either start from the step with index 0, or the step with index 1.
 * <p>
 * Example 1:
 * <p>
 * Input: cost = [10, 15, 20]
 * Output: 15
 * Explanation: Cheapest is start on cost[1], pay that cost and go to the top.
 * <p>
 * Example 2:
 * <p>
 * Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 * Output: 6
 * Explanation: Cheapest is start on cost[0], and only step on 1s, skipping cost[3].
 * <p>
 * Note:
 * <p>
 * 1. cost will have a length in the range [2, 1000].
 * 2. Every cost[i] will be an integer in the range [0, 999].
 */
public class _746 {
    public int minCostClimbingStairs(int[] cost) {
        int[] mc = new int[cost.length + 1];
        mc[0] = cost[0];
        mc[1] = cost[1];

        for (int i = 2; i <= cost.length; i++) {
            int costV = (i == cost.length) ? 0 : cost[i];
            mc[i] = Math.min(mc[i - 1] + costV, mc[i - 2] + costV);
        }
        return mc[cost.length];
    }
}
