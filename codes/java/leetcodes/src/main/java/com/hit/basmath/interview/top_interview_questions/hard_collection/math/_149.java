package com.hit.basmath.interview.top_interview_questions.hard_collection.math;

import java.util.HashMap;

/**
 * 149. Max Points on a Line
 * <p>
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 * <p>
 * Example 1:
 * <p>
 * Input: [[1,1],[2,2],[3,3]]
 * Output: 3
 * <p>
 * Explanation:
 * <p>
 * ^
 * |
 * |        o
 * |     o
 * |  o
 * +------------->
 * 0  1  2  3  4
 * <p>
 * Example 2:
 * <p>
 * Input: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 * Output: 4
 * <p>
 * Explanation:
 * <p>
 * ^
 * |
 * |  o
 * |     o        o
 * |        o
 * |  o        o
 * +------------------->
 * 0  1  2  3  4  5  6
 * <p>
 * NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
 */
public class _149 {
    public int maxPoints(int[][] points) {
        if (points.length <= 2) return points.length;
        int max = 0;
        int localMax;
        for (int[] point : points) {
            HashMap<String, Integer> map = new HashMap<>();
            int overlap = 0;
            localMax = 0;
            for (int[] point1 : points) {
                if (point[0] == point1[0] && point[1] == point1[1]) {
                    overlap++;
                    continue;
                }
                int y = point1[1] - point[1];
                int x = point1[0] - point[0];
                int gcd = gcd(x, y);
                String slope = x / gcd + "@" + y / gcd;
                map.put(slope, map.getOrDefault(slope, 0) + 1);
                if (map.get(slope) > localMax) {
                    localMax = map.get(slope);
                }
            }
            localMax += overlap;
            max = Math.max(localMax, max);
        }
        return max;
    }

    private int gcd(int x, int y) {
        if (y == 0) return x;
        return gcd(y, x % y);
    }
}
