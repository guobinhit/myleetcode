package com.hit.basmath.learn.others;

/**
 * 837. New 21 Game
 * <p>
 * Alice plays the following game, loosely based on the card game "21".
 * <p>
 * Alice starts with 0 points, and draws numbers while she has less than K points.  During each draw, she gains an integer number of points randomly from the range [1, W], where W is an integer.  Each draw is independent and the outcomes have equal probabilities.
 * <p>
 * Alice stops drawing numbers when she gets K or more points.  What is the probability that she has N or less points?
 * <p>
 * Example 1:
 * <p>
 * Input: N = 10, K = 1, W = 10
 * Output: 1.00000
 * Explanation:  Alice gets a single card, then stops.
 * <p>
 * Example 2:
 * <p>
 * Input: N = 6, K = 1, W = 10
 * Output: 0.60000
 * Explanation:  Alice gets a single card, then stops.
 * In 6 out of W = 10 possibilities, she is at or below N = 6 points.
 * <p>
 * Example 3:
 * <p>
 * Input: N = 21, K = 17, W = 10
 * Output: 0.73278
 * <p>
 * Note:
 * <p>
 * 0 <= K <= N <= 10000
 * 1 <= W <= 10000
 * Answers will be accepted as correct if they are within 10^-5 of the correct answer.
 * The judging time limit has been reduced for this question.
 */
public class _837 {
    public double new21Game(int N, int K, int W) {
        if (K == 0 || K + W <= N) {
            return 1;
        }
        if (N < K) {
            return 0;
        }
        double base = 1.0 / W;
        double[] dp = new double[N + 1];
        double sum = 0;
        double res = 0;
        for (int i = 1; i <= N; ++i) {
            dp[i] = sum * base + (i <= W ? base : 0);
            if (i < K) {
                sum += dp[i];
            }
            if (i > W) {
                sum -= dp[i - W];
            }
            if (i >= K) {
                res += dp[i];
            }
        }
        return res;
    }
}
