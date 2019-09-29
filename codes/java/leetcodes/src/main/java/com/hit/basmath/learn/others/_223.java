package com.hit.basmath.learn.others;

/**
 * 223. Rectangle Area
 * <p>
 * Find the total area covered by two rectilinear rectangles in a 2D plane.
 * <p>
 * Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.
 * <p>
 * Rectangle Area
 * <p>
 * Example:
 * <p>
 * Input: A = -3, B = 0, C = 3, D = 4, E = 0, F = -1, G = 9, H = 2
 * Output: 45
 * <p>
 * Note:
 * <p>
 * Assume that the total area is never beyond the maximum possible value of int.
 */
public class _223 {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {

        int areaOfSqrA = (C - A) * (D - B);
        int areaOfSqrB = (G - E) * (H - F);

        int left = Math.max(A, E);
        int right = Math.min(G, C);
        int bottom = Math.max(F, B);
        int top = Math.min(D, H);

        //If overlap
        int overlap = 0;
        if (right > left && top > bottom) {
            overlap = (right - left) * (top - bottom);
        }

        return areaOfSqrA + areaOfSqrB - overlap;
    }

}
