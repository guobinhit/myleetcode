package com.hit.basmath.learn.others;

import java.util.Random;

/**
 * 478. Generate Random Point in a Circle
 * <p>
 * Given the radius and x-y positions of the center of a circle, write a function randPoint which generates a uniform random point in the circle.
 * <p>
 * Note:
 * <p>
 * 1. input and output values are in floating-point.
 * 2. radius and x-y position of the center of the circle is passed into the class constructor.
 * 3. a point on the circumference of the circle is considered to be in the circle.
 * 4. randPoint returns a size 2 array containing x-position and y-position of the random point, in that order.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * ["Solution","randPoint","randPoint","randPoint"]
 * [[1,0,0],[],[],[]]
 * <p>
 * Output: [null,[-0.72939,-0.65505],[-0.78502,-0.28626],[-0.83119,-0.19803]]
 * <p>
 * Example 2:
 * <p>
 * Input:
 * ["Solution","randPoint","randPoint","randPoint"]
 * [[10,5,-7.5],[],[],[]]
 * <p>
 * Output: [null,[11.52438,-8.33273],[2.46992,-16.21705],[11.13430,-12.42337]]
 * <p>
 * Explanation of Input Syntax:
 * <p>
 * The input is two lists: the subroutines called and their arguments. Solution's constructor has three arguments, the radius, x-position of the center, and y-position of the center of the circle. randPoint has no arguments. Arguments are always wrapped with a list, even if there aren't any.
 */
public class _478 {
    class Solution {

        double radius;
        double x_center;
        double y_center;
        Random r;

        public Solution(double radius, double x_center, double y_center) {
            this.radius = radius;
            this.x_center = x_center;
            this.y_center = y_center;
            r = new Random();
        }

        public double[] randPoint() {
            double[] ans = new double[2];

            double x = Math.random();
            double y = Math.random();

            while (x * x + y * y > 1) {
                x = Math.random();
                y = Math.random();
            }
            int flagx = r.nextInt(2) == 0 ? 1 : -1;
            int flagy = r.nextInt(2) == 0 ? 1 : -1;

            ans[0] = x_center + flagx * radius * x;
            ans[1] = y_center + flagy * radius * y;

            return ans;
        }
    }
}
