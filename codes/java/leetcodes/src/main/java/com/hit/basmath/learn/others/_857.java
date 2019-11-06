package com.hit.basmath.learn.others;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * 857. Minimum Cost to Hire K Workers
 * <p>
 * There are N workers.  The i-th worker has a quality[i] and a minimum wage expectation wage[i].
 * <p>
 * Now we want to hire exactly K workers to form a paid group.  When hiring a group of K workers, we must pay them according to the following rules:
 * <p>
 * Every worker in the paid group should be paid in the ratio of their quality compared to other workers in the paid group.
 * Every worker in the paid group must be paid at least their minimum wage expectation.
 * Return the least amount of money needed to form a paid group satisfying the above conditions.
 * <p>
 * Example 1:
 * <p>
 * Input: quality = [10,20,5], wage = [70,50,30], K = 2
 * Output: 105.00000
 * Explanation: We pay 70 to 0-th worker and 35 to 2-th worker.
 * <p>
 * Example 2:
 * <p>
 * Input: quality = [3,1,10,10,1], wage = [4,8,2,2,7], K = 3
 * Output: 30.66667
 * Explanation: We pay 4 to 0-th worker, 13.33333 to 2-th and 3-th workers seperately.
 * <p>
 * Note:
 * <p>
 * 1 <= K <= N <= 10000, where N = quality.length = wage.length
 * 1 <= quality[i] <= 10000
 * 1 <= wage[i] <= 10000
 * Answers within 10^-5 of the correct answer will be considered correct.
 */
public class _857 {
    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        int n = wage.length;
        double[][] val = new double[n][2];
        for (int i = 0; i < n; i++)
            val[i] = new double[]{(double) wage[i] / quality[i], wage[i] * 1.0, quality[i] * 1.0};
        Arrays.sort(val, (a, b) -> Double.compare(b[0], a[0]));
        LinkedList<double[]> pq = new LinkedList<>();
        Collections.addAll(pq, val);
        pq.sort(Comparator.comparingDouble(a -> a[2]));
        double res = Integer.MAX_VALUE;
        for (int cs = 0; cs <= n - K; cs++) {
            double r = val[cs][0], temp = val[cs][1];
            pq.remove(val[cs]);
            int sz = K - 1;
            for (double[] d : pq) {
                if (sz-- == 0) break;
                temp += r * d[2];
            }
            res = Math.min(res, temp);
        }
        return res;
    }
}
