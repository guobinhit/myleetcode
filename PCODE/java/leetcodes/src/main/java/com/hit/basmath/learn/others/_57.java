package com.hit.basmath.learn.others;

/**
 * 57. Insert Interval
 * <p>
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 * <p>
 * You may assume that the intervals were initially sorted according to their start times.
 * <p>
 * Example 1:
 * <p>
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 * <p>
 * Example 2:
 * <p>
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]]
 * <p>
 * Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 * NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
 */
public class _57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int i = 0;
        int j = 0;

        for (i = 0; i < intervals.length; i++) {
            if (intervals[i][1] >= newInterval[0]) {
                break;
            }
        }

        for (j = 0; j < intervals.length; j++) {
            if (intervals[j][0] > newInterval[1]) {
                break;
            }
        }

        j = j - 1;

        if (i <= j) {
            intervals[i][0] = Math.min(intervals[i][0], newInterval[0]);
            intervals[i][1] = Math.max(intervals[j][1], newInterval[1]);
            int[][] result = new int[intervals.length - (j - i)][2];
            System.arraycopy(intervals, 0, result, 0, i + 1);
            System.arraycopy(intervals, j + 1, result, i + 1, intervals.length - j - 1);
            return result;
        } else {
            int[][] result = new int[intervals.length + 1][2];
            System.arraycopy(intervals, 0, result, 0, i);
            result[i] = newInterval;
            System.arraycopy(intervals, i, result, i + 1, intervals.length - i);
            return result;
        }
    }
}
