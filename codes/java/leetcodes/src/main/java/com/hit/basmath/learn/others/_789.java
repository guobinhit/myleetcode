package com.hit.basmath.learn.others;

/**
 * 789. Escape The Ghosts
 * <p>
 * You are playing a simplified Pacman game. You start at the point (0, 0), and your destination is (target[0], target[1]). There are several ghosts on the map, the i-th ghost starts at (ghosts[i][0], ghosts[i][1]).
 * <p>
 * Each turn, you and all ghosts simultaneously *may* move in one of 4 cardinal directions: north, east, west, or south, going from the previous point to a new point 1 unit of distance away.
 * <p>
 * You escape if and only if you can reach the target before any ghost reaches you (for any given moves the ghosts may take.)  If you reach any square (including the target) at the same time as a ghost, it doesn't count as an escape.
 * <p>
 * Return True if and only if it is possible to escape.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * ghosts = [[1, 0], [0, 3]]
 * target = [0, 1]
 * Output: true
 * Explanation:
 * You can directly reach the destination (0, 1) at time 1, while the ghosts located at (1, 0) or (0, 3) have no way to catch up with you.
 * <p>
 * Example 2:
 * <p>
 * Input:
 * ghosts = [[1, 0]]
 * target = [2, 0]
 * Output: false
 * Explanation:
 * You need to reach the destination (2, 0), but the ghost at (1, 0) lies between you and the destination.
 * <p>
 * Example 3:
 * <p>
 * Input:
 * ghosts = [[2, 0]]
 * target = [1, 0]
 * Output: false
 * Explanation:
 * The ghost can reach the target at the same time as you.
 * <p>
 * Note:
 * <p>
 * All points have coordinates with absolute value <= 10000.
 * The number of ghosts will not exceed 100.
 */
public class _789 {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int myDist = Math.abs(target[0] - 0) + Math.abs(target[1] - 0);
        int ghostDist = Integer.MAX_VALUE;
        for (int[] ghost : ghosts) {
            ghostDist = Math.abs(target[0] - ghost[0]) + Math.abs(target[1] - ghost[1]);
            if (ghostDist <= myDist) {
                return false;
            }
        }
        return true;
    }
}
