package com.hit.basmath.learn.others;

/**
 * 849. Maximize Distance to Closest Person
 * <p>
 * In a row of seats, 1 represents a person sitting in that seat, and 0 represents that the seat is empty.
 * <p>
 * There is at least one empty seat, and at least one person sitting.
 * <p>
 * Alex wants to sit in the seat such that the distance between him and the closest person to him is maximized.
 * <p>
 * Return that maximum distance to closest person.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,0,0,0,1,0,1]
 * Output: 2
 * Explanation:
 * If Alex sits in the second open seat (seats[2]), then the closest person has distance 2.
 * If Alex sits in any other open seat, the closest person has distance 1.
 * Thus, the maximum distance to the closest person is 2.
 * <p>
 * Example 2:
 * <p>
 * Input: [1,0,0,0]
 * Output: 3
 * Explanation:
 * If Alex sits in the last seat, the closest person is 3 seats away.
 * This is the maximum distance possible, so the answer is 3.
 * <p>
 * Note:
 * <p>
 * 1 <= seats.length <= 20000
 * seats contains only 0s or 1s, at least one 0, and at least one 1.
 */
public class _849 {
    public int maxDistToClosest(int[] seats) {
        int left = -1, maxDis = 0;
        int len = seats.length;

        for (int i = 0; i < len; i++) {
            if (seats[i] == 0) continue;

            if (left == -1) {
                maxDis = Math.max(maxDis, i);
            } else {
                maxDis = Math.max(maxDis, (i - left) / 2);
            }
            left = i;
        }

        if (seats[len - 1] == 0) {
            maxDis = Math.max(maxDis, len - 1 - left);
        }

        return maxDis;
    }
}
