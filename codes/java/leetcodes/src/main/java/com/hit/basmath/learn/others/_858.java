package com.hit.basmath.learn.others;

/**
 * 858. Mirror Reflection
 * <p>
 * There is a special square room with mirrors on each of the four walls.  Except for the southwest corner, there are receptors on each of the remaining corners, numbered 0, 1, and 2.
 * <p>
 * The square room has walls of length p, and a laser ray from the southwest corner first meets the east wall at a distance q from the 0th receptor.
 * <p>
 * Return the number of the receptor that the ray meets first.  (It is guaranteed that the ray will meet a receptor eventually.)
 * <p>
 * Example 1:
 * <p>
 * Input: p = 2, q = 1
 * Output: 2
 * Explanation: The ray meets receptor 2 the first time it gets reflected back to the left wall.
 * <p>
 * Note:
 * <p>
 * 1 <= p <= 1000
 * 0 <= q <= p
 */
public class _858 {
    public int mirrorReflection(int p, int q) {
        while (p % 2 == 0 && q % 2 == 0) {
            p /= 2;
            q /= 2;
        }
        if (p % 2 == 0) {
            return 2;
        } else if (q % 2 == 0) {
            return 0;
        } else {
            return 1;
        }
    }
}
