package com.hit.basmath.interview.top_interview_questions.medium_collection.dynamic_programming;

/**
 * 322. Coin Change
 * <p>
 * You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 * <p>
 * Example 1:
 * <p>
 * Input: coins = [1, 2, 5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * <p>
 * Example 2:
 * <p>
 * Input: coins = [2], amount = 3
 * Output: -1
 * <p>
 * Note:
 * <p>
 * You may assume that you have an infinite number of each kind of coin.
 */
public class _322 {
    public int coinChange(int[] coins, int amount) {
        if (amount < 1) return 0;
        int[] dp = new int[amount + 1];
        int sum = 0;

        while (++sum <= amount) {
            int min = -1;
            for (int coin : coins) {
                if (sum >= coin && dp[sum - coin] != -1) {
                    int temp = dp[sum - coin] + 1;
                    min = min < 0 ? temp : (temp < min ? temp : min);
                }
            }
            dp[sum] = min;
        }
        return dp[amount];
    }
}
