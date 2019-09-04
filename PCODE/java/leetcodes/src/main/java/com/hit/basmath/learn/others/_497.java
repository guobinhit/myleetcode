package com.hit.basmath.learn.others;

import java.util.Random;

/**
 * 497. Random Point in Non-overlapping Rectangles
 * <p>
 * Given a list of non-overlapping axis-aligned rectangles rects, write a function pick which randomly and uniformily picks an integer point in the space covered by the rectangles.
 * <p>
 * Note:
 * <p>
 * 1. An integer point is a point that has integer coordinates.
 * 2. A point on the perimeter of a rectangle is included in the space covered by the rectangles.
 * 3. i th rectangle = rects[i] = [x1,y1,x2,y2], where [x1, y1] are the integer coordinates of the bottom-left corner, and [x2, y2] are the integer coordinates of the top-right corner.
 * 4. length and width of each rectangle does not exceed 2000.
 * 5. 1 <= rects.length <= 100
 * 6. pick return a point as an array of integer coordinates [p_x, p_y]
 * 7. pick is called at most 10000 times.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * ["Solution","pick","pick","pick"]
 * [[[[1,1,5,5]]],[],[],[]]
 * <p>
 * Output:
 * [null,[4,1],[4,1],[3,3]]
 * <p>
 * Example 2:
 * <p>
 * Input:
 * ["Solution","pick","pick","pick","pick","pick"]
 * [[[[-2,-2,-1,-1],[1,0,3,0]]],[],[],[],[],[]]
 * <p>
 * Output:
 * [null,[-1,-2],[2,0],[-2,-1],[3,0],[-2,-2]]
 * <p>
 * Explanation of Input Syntax:
 * <p>
 * The input is two lists: the subroutines called and their arguments. Solution's constructor has one argument, the array of rectangles rects. pick has no arguments. Arguments are always wrapped with a list, even if there aren't any.
 */
public class _497 {
    class Solution {

        private Random random;
        private int[] sums;
        private int[][] rects;

        public Solution(int[][] rects) {
            random = new Random();
            this.rects = rects;
            sums = new int[rects.length];
            for (int i = 0; i < rects.length; i++) {
                sums[i] = i == 0
                        ? (rects[i][2] - rects[i][0] + 1) * (rects[i][3] - rects[i][1] + 1)
                        : (rects[i][2] - rects[i][0] + 1) * (rects[i][3] - rects[i][1] + 1) + sums[i - 1];
            }
        }

        public int[] pick() {
            int index = random.nextInt(sums[sums.length - 1]) + 1;
            int left = 0, right = sums.length, mid = 0;
            while (left < right) {
                mid = ((right - left) >> 1) + left;
                if (sums[mid] < index) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            if (left == sums.length) left--;

            int count = left == 0 ? sums[left] : sums[left] - sums[left - 1];
            int rect_index = random.nextInt(count);
            int rect_long = rects[left][2] - rects[left][0] + 1;
            return new int[]{rects[left][0] + rect_index % rect_long, rects[left][1] + rect_index / rect_long};
        }
    }
}
