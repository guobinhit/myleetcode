package com.hit.basmath.learn.others;

import java.util.Arrays;

/**
 * 735. Asteroid Collision
 * <p>
 * We are given an array asteroids of integers representing asteroids in a row.
 * <p>
 * For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.
 * <p>
 * Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * asteroids = [5, 10, -5]
 * Output: [5, 10]
 * Explanation:
 * The 10 and -5 collide resulting in 10.  The 5 and 10 never collide.
 * <p>
 * Example 2:
 * <p>
 * Input:
 * asteroids = [8, -8]
 * Output: []
 * Explanation:
 * The 8 and -8 collide exploding each other.
 * <p>
 * Example 3:
 * <p>
 * Input:
 * asteroids = [10, 2, -5]
 * Output: [10]
 * Explanation:
 * The 2 and -5 collide resulting in -5.  The 10 and -5 collide resulting in 10.
 * <p>
 * Example 4:
 * <p>
 * Input:
 * asteroids = [-2, -1, 1, 2]
 * Output: [-2, -1, 1, 2]
 * Explanation:
 * The -2 and -1 are moving left, while the 1 and 2 are moving right.
 * Asteroids moving the same direction never meet, so no asteroids will meet each other.
 * <p>
 * Note:
 * <p>
 * The length of asteroids will be at most 10000.
 * Each asteroid will be a non-zero integer in the range [-1000, 1000].
 */
public class _735 {
    public int[] asteroidCollision(int[] asteroids) {
        if (asteroids.length < 2) {
            return asteroids;
        }

        int index = 1;
        int end = 0;
        while (index < asteroids.length) {
            if (end == -1) {
                asteroids[0] = asteroids[index];
                end = 0;
                index++;
                continue;
            } else {
                if (asteroids[end] > 0 && asteroids[index] < 0) {
                    if (Math.abs(asteroids[end]) == Math.abs(asteroids[index])) {
                        end--;
                        index++;
                    } else if (Math.abs(asteroids[end]) > Math.abs(asteroids[index])) {
                        index++;
                    } else {
                        end--;
                    }
                } else {
                    end++;
                    asteroids[end] = asteroids[index];
                    index++;
                }

            }

        }

        return Arrays.copyOf(asteroids, end + 1);
    }
}
