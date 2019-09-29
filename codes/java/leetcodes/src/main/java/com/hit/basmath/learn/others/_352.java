package com.hit.basmath.learn.others;

import java.util.ArrayList;
import java.util.List;

/**
 * 352. Data Stream as Disjoint Intervals
 * <p>
 * Given a data stream input of non-negative integers a1, a2, ..., an, ..., summarize the numbers seen so far as a list of disjoint intervals.
 * <p>
 * For example, suppose the integers from the data stream are 1, 3, 7, 2, 6, ..., then the summary will be:
 * <p>
 * [1, 1]
 * [1, 1], [3, 3]
 * [1, 1], [3, 3], [7, 7]
 * [1, 3], [7, 7]
 * [1, 3], [6, 7]
 * <p>
 * Follow up:
 * <p>
 * What if there are lots of merges and the number of disjoint intervals are small compared to the data stream's size?
 */
public class _352 {
    class SummaryRanges {

        private List<int[]> intervals;

        /**
         * Initialize your data structure here.
         */
        public SummaryRanges() {
            intervals = new ArrayList<int[]>();

        }

        public void addNum(int val) {
            // Do a binary search to see where we can add new val in intervals.
            // if we succesfully append to an interval, check if new append can merge
            if (intervals.size() == 0) {
                intervals.add(new int[]{val, val});
                return;
            }
            addToIntervals(val, 0, intervals.size() - 1);
        }

        private void addToIntervals(int val, int start, int end) {
            if (start > end) {
                intervals.add(start, new int[]{val, val});
                return;
            }
            int mid = start + (end - start) / 2;
            int[] currInterval = intervals.get(mid);
            if (currInterval[0] - 1 == val) {
                // left merge and check
                currInterval[0] = val;
                intervals.remove(mid);
                intervals.add(mid, currInterval);
                if (mid > 0) {
                    int[] lastInterval = intervals.get(mid - 1);
                    if (lastInterval[1] == currInterval[0] || lastInterval[1] + 1 == currInterval[0]) {
                        int[] newInterval = new int[]{lastInterval[0], currInterval[1]};
                        intervals.remove(mid - 1);
                        intervals.remove(mid - 1);
                        intervals.add(mid - 1, newInterval);
                    }
                }
            } else if (currInterval[1] + 1 == val) {
                //right merge and check
                currInterval[1] = val;
                if (mid < intervals.size() - 1) {
                    System.out.println(mid + 1);
                    int[] nextInterval = intervals.get(mid + 1);
                    if (nextInterval[0] == currInterval[1] || nextInterval[0] - 1 == currInterval[1]) {
                        int[] newInterval = new int[]{currInterval[0], nextInterval[1]};
                        intervals.remove(mid);
                        intervals.remove(mid);
                        intervals.add(mid, newInterval);
                    }
                }
            } else if (currInterval[0] > val) {
                // search to the left
                addToIntervals(val, start, mid - 1);
            } else if (currInterval[1] < val) {
                addToIntervals(val, mid + 1, end);
            }
            // last case is falls in interval, so do nothi
        }

        public int[][] getIntervals() {
            int[][] ans = new int[intervals.size()][2];
            for (int i = 0; i < intervals.size(); i++) {
                ans[i] = intervals.get(i);
            }
            return ans;
        }
    }
}
