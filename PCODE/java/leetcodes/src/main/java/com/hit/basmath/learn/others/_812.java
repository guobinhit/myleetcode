package com.hit.basmath.learn.others;

/**
 * 812. Largest Triangle Area
 * <p>
 * You have a list of points in the plane. Return the area of the largest triangle that can be formed by any 3 of the points.
 * <p>
 * Example:
 * Input: points = [[0,0],[0,1],[1,0],[0,2],[2,0]]
 * Output: 2
 * Explanation:
 * The five points are show in the figure below. The red triangle is the largest.
 * <p>
 * Notes:
 * <p>
 * 3 <= points.length <= 50.
 * No points will be duplicated.
 * -50 <= points[i][j] <= 50.
 * Answers within 10^-6 of the true value will be accepted as correct.
 */
public class _812 {
    public double largestTriangleArea(int[][] points) {
        int n = points.length;
        double max = 0;

        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                for (int k = j + 1; k < n; ++k) {
                    double area = area(points, i, j, k);
                    if (area > max) {
                        max = area;
                    }
                }
            }
        }

        return max;
    }

    // triangle
    private double area(int[][] points, int i, int j, int k) {
        int[] p1 = points[i];
        int[] p2 = points[j];
        int[] p3 = points[k];

        double area = 0;
        area += area(p1, p2);
        area += area(p2, p3);
        area += area(p3, p1);

        return Math.abs(area);
    }

    // parallelogram
    private double area(int[] p1, int[] p2) {
        int w = p2[0] - p1[0];
        double h = (p1[1] + p2[1] + 200) / 2.0;
        return w * h;
    }
}
