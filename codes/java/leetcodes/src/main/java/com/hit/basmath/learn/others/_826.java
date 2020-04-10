package com.hit.basmath.learn.others;

import java.util.Map;
import java.util.TreeMap;

/**
 * 826. Most Profit Assigning Work
 * <p>
 * We have jobs: difficulty[i] is the difficulty of the ith job, and profit[i] is the profit of the ith job.
 * <p>
 * Now we have some workers. worker[i] is the ability of the ith worker, which means that this worker can only complete a job with difficulty at most worker[i].
 * <p>
 * Every worker can be assigned at most one job, but one job can be completed multiple times.
 * <p>
 * For example, if 3 people attempt the same job that pays $1, then the total profit will be $3.  If a worker cannot complete any job, his profit is $0.
 * <p>
 * What is the most profit we can make?
 * <p>
 * Example 1:
 * <p>
 * Input: difficulty = [2,4,6,8,10], profit = [10,20,30,40,50], worker = [4,5,6,7]
 * Output: 100
 * Explanation: Workers are assigned jobs of difficulty [4,4,6,6] and they get profit of [20,20,30,30] seperately.
 * <p>
 * Notes:
 * <p>
 * 1 <= difficulty.length = profit.length <= 10000
 * 1 <= worker.length <= 10000
 * difficulty[i], profit[i], worker[i]  are in range [1, 10^5]
 */
public class _826 {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {

        TreeMap<Integer, Integer> tmap = new TreeMap<>();
        // in case two jobs have same difficulty but different profit, we want to count
        // the higher profit
        for (int i = 0; i < difficulty.length; i++) {
            tmap.put(difficulty[i], Math.max(profit[i], tmap.getOrDefault(difficulty[i], 0)));
        }

        int max = 0, res = 0;
        // maximum profit at this difficulty or below in case
        // lower difficulty job offers higher profit
        for (Integer key : tmap.keySet()) {
            max = Math.max(tmap.get(key), max);
            tmap.put(key, max);
        }

        Map.Entry<Integer, Integer> entry = null;
        for (int i = 0; i < worker.length; i++) {
            if (tmap.containsKey(worker[i])) {
                res += tmap.get(worker[i]);
            } else {
                entry = tmap.floorEntry(worker[i]);
                if (entry != null) {
                    res += entry.getValue();
                }
            }
        }
        return res;
    }
}
