package com.hit.basmath.learn.others;

import java.util.List;

/**
 * 539. Minimum Time Difference
 * <p>
 * Given a list of 24-hour clock time points in "Hour:Minutes" format, find the minimum minutes difference between any two time points in the list.
 * <p>
 * Example 1:
 * <p>
 * Input: ["23:59","00:00"]
 * Output: 1
 * <p>
 * Note:
 * <p>
 * The number of time points in the given list is at least 2 and won't exceed 20000.
 * The input time is legal and ranges from 00:00 to 23:59.
 */
public class _539 {
    private static final int DAY_MINUTES = 1440;

    public int findMinDifference(List<String> timePoints) {
        boolean[] bkt = new boolean[DAY_MINUTES];
        int first = DAY_MINUTES + 1; //first minutes
        int last = 0; //last minutes
        for (String tp : timePoints) {
            int mins = Integer.parseInt(tp.substring(0, 2)) * 60
                    + Integer.parseInt(tp.substring(3, 5));
            if (bkt[mins]) return 0; // same minutes
            bkt[mins] = true;
            if (first > mins) first = mins;
            if (last < mins) last = mins;
        }
        int minDif = Math.min(last - first, first + DAY_MINUTES - last); //compare first and last minutes
        int mins = first + 1;
        int pre = first;
        while (mins <= last) {
            while (!bkt[mins]) mins++;
            int cur = mins;
            minDif = Math.min(minDif, Math.min(cur - pre, pre + DAY_MINUTES - cur));
            pre = mins++;
        }
        return minDif;
    }
}
