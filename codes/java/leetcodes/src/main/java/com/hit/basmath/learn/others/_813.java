package com.hit.basmath.learn.others;

/**
 * 813. Largest Sum of Averages
 * <p>
 * We partition a row of numbers A into at most K adjacent (non-empty) groups, then our score is the sum of the average of each group. What is the largest score we can achieve?
 * <p>
 * Note that our partition must use every number in A, and that scores are not necessarily integers.
 * <p>
 * Example:
 * <p>
 * Input:
 * A = [9,1,2,3,9]
 * K = 3
 * Output: 20
 * Explanation:
 * The best choice is to partition A into [9], [1, 2, 3], [9]. The answer is 9 + (1 + 2 + 3) / 3 + 9 = 20.
 * We could have also partitioned A into [9, 1], [2], [3, 9], for example.
 * That partition would lead to a score of 5 + 2 + 6 = 13, which is worse.
 * <p>
 * Note:
 * <p>
 * 1 <= A.length <= 100.
 * 1 <= A[i] <= 10000.
 * 1 <= K <= A.length.
 * Answers within 10^-6 of the correct answer will be accepted as correct.
 */
public class _813 {
    public double largestSumOfAverages(int[] A, int K) {
        if (K == 0 || A.length == 0) {
            return 0;
        }
        int l = A.length;
        double[][] f = new double[l][K + 1];
        double[] s = new double[l + 1];
        for (int i = 1; i <= l; i++) {
            s[i] = s[i - 1] + A[i - 1];
            f[i - 1][1] = s[i] / i;
        }
        for (int j = 2; j <= K; j++) {
            for (int i = 0; i < l; i++) {
                double max = Double.MIN_VALUE;
                for (int p = 0; p < i; p++) {
                    double sum = f[p][j - 1] + (s[i + 1] - s[p + 1]) / (i - p);
                    max = Double.max(sum, max);
                }
                f[i][j] = max;
            }
        }
        return f[l - 1][K];
    }
}
