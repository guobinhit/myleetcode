package com.hit.basmath.learn.others;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 871. Minimum Number of Refueling Stops
 * <p>
 * A car travels from a starting position to a destination which is target miles east of the starting position.
 * <p>
 * Along the way, there are gas stations.  Each station[i] represents a gas station that is station[i][0] miles east of the starting position, and has station[i][1] liters of gas.
 * <p>
 * The car starts with an infinite tank of gas, which initially has startFuel liters of fuel in it.  It uses 1 liter of gas per 1 mile that it drives.
 * <p>
 * When the car reaches a gas station, it may stop and refuel, transferring all the gas from the station into the car.
 * <p>
 * What is the least number of refueling stops the car must make in order to reach its destination?  If it cannot reach the destination, return -1.
 * <p>
 * Note that if the car reaches a gas station with 0 fuel left, the car can still refuel there.  If the car reaches the destination with 0 fuel left, it is still considered to have arrived.
 * <p>
 * Example 1:
 * <p>
 * Input: target = 1, startFuel = 1, stations = []
 * Output: 0
 * Explanation: We can reach the target without refueling.
 * <p>
 * Example 2:
 * <p>
 * Input: target = 100, startFuel = 1, stations = [[10,100]]
 * Output: -1
 * Explanation: We can't reach the target (or even the first gas station).
 * <p>
 * Example 3:
 * <p>
 * Input: target = 100, startFuel = 10, stations = [[10,60],[20,30],[30,30],[60,40]]
 * Output: 2
 * Explanation:
 * We start with 10 liters of fuel.
 * We drive to position 10, expending 10 liters of fuel.  We refuel from 0 liters to 60 liters of gas.
 * Then, we drive from position 10 to position 60 (expending 50 liters of fuel),
 * and refuel from 10 liters to 50 liters of gas.  We then drive to and reach the target.
 * We made 2 refueling stops along the way, so we return 2.
 * <p>
 * Note:
 * <p>
 * 1 <= target, startFuel, stations[i][1] <= 10^9
 * 0 <= stations.length <= 500
 * 0 < stations[0][0] < stations[1][0] < ... < stations[stations.length-1][0] < target
 */
public class _871 {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        Queue<Integer> queue = new PriorityQueue<>();
        long dist = startFuel;
        int res = 0;
        int idx = 0;
        while (true) {
            while (idx < stations.length && stations[idx][0] <= dist) {
                queue.offer(-stations[idx][1]);
                idx++;
            }

            if (dist >= target) return res;
            if (queue.isEmpty()) return -1;
            dist += -queue.poll();
            res++;
        }

    }
}
