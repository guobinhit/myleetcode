package com.hit.basmath.learn.others;

import java.util.HashMap;
import java.util.Map;

/**
 * 447. Number of Boomerangs
 * <p>
 * Given n points in the plane that are all pairwise distinct, a "boomerang" is a tuple of points (i, j, k) such that the distance between i and j equals the distance between i and k (the order of the tuple matters).
 * <p>
 * Find the number of boomerangs. You may assume that n will be at most 500 and coordinates of points are all in the range [-10000, 10000] (inclusive).
 * <p>
 * Example:
 * <p>
 * Input:
 * [[0,0],[1,0],[2,0]]
 * <p>
 * Output:
 * 2
 * <p>
 * Explanation:
 * The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]
 */
public class _447 {
    public int numberOfBoomerangs(int[][] points) {
        int n = points.length;
        if (n == 0) return 0;
        int count = 0;
        for (int[] point : points) {
            Map<Double, Integer> map = new HashMap<>();
            for (int[] point1 : points) {
                if (map.containsKey(distance(point, point1))) {
                    int value = map.get(distance(point, point1));
                    count += 2 * value;
                    map.put(distance(point, point1), value + 1);
                } else {
                    map.put(distance(point, point1), 1);
                }
            }
        }
        return count;
    }

    private Double distance(int[] a, int[] b) {
        return Math.sqrt(Math.pow(a[0] - b[0], 2) + Math.pow(a[1] - b[1], 2));
    }
}
