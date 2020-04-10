package com.hit.basmath.learn.recursion_ii;

import java.util.*;

/**
 * 218. The Skyline Problem
 * <p>
 * A city's skyline is the outer contour of the silhouette formed by all the buildings in that city when viewed from a distance. Now suppose you are given the locations and height of all the buildings as shown on a cityscape photo (Figure A), write a program to output the skyline formed by these buildings collectively (Figure B).
 * <p>
 * Buildings  Skyline Contour
 * <p>
 * The geometric information of each building is represented by a triplet of integers [Li, Ri, Hi], where Li and Ri are the x coordinates of the left and right edge of the ith building, respectively, and Hi is its height. It is guaranteed that 0 ≤ Li, Ri ≤ INT_MAX, 0 < Hi ≤ INT_MAX, and Ri - Li > 0. You may assume all buildings are perfect rectangles grounded on an absolutely flat surface at height 0.
 * <p>
 * For instance, the dimensions of all buildings in Figure A are recorded as: [ [2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8] ] .
 * <p>
 * The output is a list of "key points" (red dots in Figure B) in the format of [ [x1,y1], [x2, y2], [x3, y3], ... ] that uniquely defines a skyline. A key point is the left endpoint of a horizontal line segment. Note that the last key point, where the rightmost building ends, is merely used to mark the termination of the skyline, and always has zero height. Also, the ground in between any two adjacent buildings should be considered part of the skyline contour.
 * <p>
 * For instance, the skyline in Figure B should be represented as:[ [2 10], [3 15], [7 12], [12 0], [15 10], [20 8], [24, 0] ].
 * <p>
 * Notes:
 * <p>
 * The number of buildings in any input list is guaranteed to be in the range [0, 10000].
 * The input list is already sorted in ascending order by the left x position Li.
 * The output list must be sorted by the x position.
 * There must be no consecutive horizontal lines of equal height in the output skyline. For instance, [...[2 3], [4 5], [7 5], [11 5], [12 7]...] is not acceptable; the three lines of height 5 should be merged into one in the final output as such: [...[2 3], [4 5], [12 7], ...]
 */
public class _218 {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        // Create points from building start/end points and sort them by X coord
        List<Point> points = new ArrayList<>();
        for (int bi = 0; bi < buildings.length; bi++) {
            int[] b = buildings[bi];
            points.add(new Point(b[0], b[2], bi, true));
            points.add(new Point(b[1], b[2], bi, false));
        }

        points.sort(new PointComparator());

        List<List<Integer>> res = new ArrayList<>();

        // Keep track of current skyline height
        int currH = 0;

        // TreeSet contains building indices and ts.first() returns tallest building
        TreeSet<Integer> ts = new TreeSet<>(new BIComparator(buildings));

        for (int i = 0; i < points.size(); i++) {
            Point p = points.get(i);
            if (p.start) {
                ts.add(p.bi);
            } else {
                ts.remove(p.bi);
            }

            // Make sure we process all points at the same X coord
            // before we check whether height has changes
            if (i + 1 < points.size() && points.get(i + 1).x == p.x) continue;

            int newH = ts.isEmpty() ? 0 : buildings[ts.first()][2];
            if (newH != currH) {
                res.add(Arrays.asList(p.x, newH));
                currH = newH;
            }
        }
        return res;

    }

    // Compare building indices by building height (i.e. highest BI comes first)
    static class BIComparator implements Comparator<Integer> {

        private int[][] buildings;

        BIComparator(int[][] buildings) {
            this.buildings = buildings;
        }

        public int compare(Integer bi1, Integer bi2) {
            int cmp = ((Integer) buildings[bi2][2]).compareTo(buildings[bi1][2]);
            if (cmp != 0) return cmp;
            return bi1.compareTo(bi2);
        }
    }

    // Compare points based on X coordinate (i.e. smaller X comes first)
    class PointComparator implements Comparator<Point> {

        public int compare(Point p1, Point p2) {
            return ((Integer) p1.x).compareTo(p2.x);
        }

    }

    class Point {
        int x;
        int y;
        int bi;
        boolean start;

        Point(int x, int y, int bi, boolean start) {
            this.x = x;
            this.y = y;
            this.bi = bi;
            this.start = start;
        }
    }
}
