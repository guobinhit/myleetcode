package com.hit.basmath.learn.queue_stack;

/**
 * 733. Flood Fill
 * <p>
 * An image is represented by a 2-D array of integers, each integer representing the pixel value of the image (from 0 to 65535).
 * <p>
 * Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, and a pixel value newColor, "flood fill" the image.
 * <p>
 * To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color as the starting pixel), and so on. Replace the color of all of the aforementioned pixels with the newColor.
 * <p>
 * At the end, return the modified image.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * <p>
 * image = [[1,1,1],[1,1,0],[1,0,1]]
 * sr = 1, sc = 1, newColor = 2
 * <p>
 * Output: [[2,2,2],[2,2,0],[2,0,1]]
 * <p>
 * Explanation:
 * <p>
 * From the center of the image (with position (sr, sc) = (1, 1)), all pixels connected
 * by a path of the same color as the starting pixel are colored with the new color.
 * Note the bottom corner is not colored 2, because it is not 4-directionally connected
 * to the starting pixel.
 * <p>
 * Note:
 * <p>
 * 1. The length of image and image[0] will be in the range [1, 50].
 * 2. The given starting pixel will satisfy 0 <= sr < image.length and 0 <= sc < image[0].length.
 * 3. The value of each color in image[i][j] and newColor will be an integer in [0, 65535].
 */
public class _733 {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) return image;
        fill(image, sr, sc, image[sr][sc], newColor);
        return image;
    }

    private void fill(int[][] image, int sr, int sc, int color, int newColor) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != color) return;
        image[sr][sc] = newColor;
        fill(image, sr + 1, sc, color, newColor);
        fill(image, sr - 1, sc, color, newColor);
        fill(image, sr, sc + 1, color, newColor);
        fill(image, sr, sc - 1, color, newColor);
    }
}
