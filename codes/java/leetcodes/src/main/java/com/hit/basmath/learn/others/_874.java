package com.hit.basmath.learn.others;

import java.util.HashSet;
import java.util.Set;

/**
 * 874. Walking Robot Simulation
 * <p>
 * A robot on an infinite grid starts at point (0, 0) and faces north.  The robot can receive one of three possible types of commands:
 * <p>
 * -2: turn left 90 degrees
 * -1: turn right 90 degrees
 * 1 <= x <= 9: move forward x units
 * <p>
 * Some of the grid squares are obstacles.
 * <p>
 * The i-th obstacle is at grid point (obstacles[i][0], obstacles[i][1])
 * <p>
 * If the robot would try to move onto them, the robot stays on the previous grid square instead (but still continues following the rest of the route.)
 * <p>
 * Return the square of the maximum Euclidean distance that the robot will be from the origin.
 * <p>
 * Example 1:
 * <p>
 * Input: commands = [4,-1,3], obstacles = []
 * Output: 25
 * Explanation: robot will go to (3, 4)
 * <p>
 * Example 2:
 * <p>
 * Input: commands = [4,-1,4,-2,4], obstacles = [[2,4]]
 * Output: 65
 * Explanation: robot will be stuck at (1, 4) before turning left and going to (1, 8)
 * <p>
 * Note:
 * <p>
 * 0 <= commands.length <= 10000
 * 0 <= obstacles.length <= 10000
 * -30000 <= obstacle[i][0] <= 30000
 * -30000 <= obstacle[i][1] <= 30000
 * The answer is guaranteed to be less than 2 ^ 31.
 */
public class _874 {
    public int robotSim(int[] commands, int[][] obstacles) {
        if (commands == null || commands.length == 0)
            return 0;
        Set<String> obstacleSet = new HashSet<>();
        for (int[] o : obstacles)
            obstacleSet.add(o[0] + "," + o[1]);
        int maxVal = 0, direction = 0, x = 0, y = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int command : commands) {
            if (command == -1) {
                direction = (direction + 1) % 4;
            } else if (command == -2) {
                direction = (direction - 1) % 4;
                if (direction < 0)
                    direction += 4;
            } else if (command >= 1 && command <= 9) {
                for (int i = 0; i < command; ++i) {
                    int xnext = x + directions[direction][0];
                    int ynext = y + directions[direction][1];
                    if (obstacleSet.contains(xnext + "," + ynext))
                        break;
                    x += directions[direction][0];
                    y += directions[direction][1];
                    maxVal = Math.max(maxVal, x * x + y * y);
                }
            }
        }
        return maxVal;
    }
}
