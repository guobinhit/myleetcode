package com.hit.basmath.learn.others;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * 731. My Calendar II
 * <p>
 * Implement a MyCalendarTwo class to store your events. A new event can be added if adding the event will not cause a triple booking.
 * <p>
 * Your class will have one method, book(int start, int end). Formally, this represents a booking on the half open interval [start, end), the range of real numbers x such that start <= x < end.
 * <p>
 * A triple booking happens when three events have some non-empty intersection (ie., there is some time that is common to all 3 events.)
 * <p>
 * For each call to the method MyCalendar.book, return true if the event can be added to the calendar successfully without causing a triple booking. Otherwise, return false and do not add the event to the calendar.
 * <p>
 * Your class will be called like this: MyCalendar cal = new MyCalendar(); MyCalendar.book(start, end)
 * <p>
 * Example 1:
 * <p>
 * MyCalendar();
 * MyCalendar.book(10, 20); // returns true
 * MyCalendar.book(50, 60); // returns true
 * MyCalendar.book(10, 40); // returns true
 * MyCalendar.book(5, 15); // returns false
 * MyCalendar.book(5, 10); // returns true
 * MyCalendar.book(25, 55); // returns true
 * <p>
 * Explanation:
 * <p>
 * The first two events can be booked.  The third event can be double booked.
 * The fourth event (5, 15) can't be booked, because it would result in a triple booking.
 * The fifth event (5, 10) can be booked, as it does not use time 10 which is already double booked.
 * The sixth event (25, 55) can be booked, as the time in [25, 40) will be double booked with the third event;
 * the time [40, 50) will be single booked, and the time [50, 55) will be double booked with the second event.
 * <p>
 * Note:
 * <p>
 * The number of calls to MyCalendar.book per test case will be at most 1000.
 * In calls to MyCalendar.book(start, end), start and end are integers in the range [0, 10^9].
 */
public class _731 {
    class MyCalendarTwo {

        List<int[]> calendar;

        public MyCalendarTwo() {
            calendar = new ArrayList<>();
        }

        public boolean book(int start, int end) {
            TreeMap<Integer, Integer> overlaps = new TreeMap<>();

            for (int[] interval : calendar) {
                int[] overlap = getOverlap(interval, start, end);
                if (overlap[0] >= 0) {
                    if (hasOverlap(overlaps, overlap[0], overlap[1])) return false;
                    overlaps.put(overlap[0], overlap[1]);
                }
            }

            calendar.add(new int[]{start, end});
            return true;
        }

        private int[] getOverlap(int[] interval, int start, int end) {
            int[] res = new int[]{-1, -1};
            if (start >= interval[1] || end <= interval[0]) return res;
            res[0] = Math.max(start, interval[0]);
            res[1] = Math.min(end, interval[1]);
            return res;
        }

        private boolean hasOverlap(TreeMap<Integer, Integer> overlaps, int start, int end) {
            Integer floorKey = overlaps.floorKey(start);
            if (floorKey != null && overlaps.get(floorKey) > start) return true;
            Integer ceilingKey = overlaps.ceilingKey(start);
            if (ceilingKey != null && ceilingKey < end) return true;
            return false;
        }

    }
}
