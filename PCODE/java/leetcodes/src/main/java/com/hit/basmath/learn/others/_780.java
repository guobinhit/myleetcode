package com.hit.basmath.learn.others;

/**
 * 780. Reaching Points
 * <p>
 * A move consists of taking a point (x, y) and transforming it to either (x, x+y) or (x+y, y).
 * <p>
 * Given a starting point (sx, sy) and a target point (tx, ty), return True if and only if a sequence of moves exists to transform the point (sx, sy) to (tx, ty). Otherwise, return False.
 * <p>
 * Examples:
 * <p>
 * Input: sx = 1, sy = 1, tx = 3, ty = 5
 * Output: True
 * Explanation:
 * One series of moves that transforms the starting point to the target is:
 * (1, 1) -> (1, 2)
 * (1, 2) -> (3, 2)
 * (3, 2) -> (3, 5)
 * <p>
 * Input: sx = 1, sy = 1, tx = 2, ty = 2
 * Output: False
 * <p>
 * Input: sx = 1, sy = 1, tx = 1, ty = 1
 * Output: True
 * <p>
 * Note:
 * <p>
 * sx, sy, tx, ty will all be integers in the range [1, 10^9].
 */
public class _780 {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {

        while (sx < tx && sy < ty)
            if (tx < ty)
                ty %= tx;
            else
                tx %= ty;

        if (sx == tx && sy <= ty && (ty - sy) % sx == 0)
            return true;

        return sy == ty && sx <= tx && (tx - sx) % sy == 0;
    }
}
