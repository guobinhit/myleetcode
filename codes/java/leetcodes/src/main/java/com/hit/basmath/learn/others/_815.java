package com.hit.basmath.learn.others;

import java.util.*;

/**
 * 815. Bus Routes
 * <p>
 * We have a list of bus routes. Each routes[i] is a bus route that the i-th bus repeats forever. For example if routes[0] = [1, 5, 7], this means that the first bus (0-th indexed) travels in the sequence 1->5->7->1->5->7->1->... forever.
 * <p>
 * We start at bus stop S (initially not on a bus), and we want to go to bus stop T. Travelling by buses only, what is the least number of buses we must take to reach our destination? Return -1 if it is not possible.
 * <p>
 * Example:
 * <p>
 * Input:
 * routes = [[1, 2, 7], [3, 6, 7]]
 * S = 1
 * T = 6
 * Output: 2
 * Explanation:
 * The best strategy is take the first bus to the bus stop 7, then take the second bus to the bus stop 6.
 * <p>
 * Note:
 * <p>
 * 1 <= routes.length <= 500.
 * 1 <= routes[i].length <= 500.
 * 0 <= routes[i][j] < 10 ^ 6.
 */
public class _815 {
    public int numBusesToDestination(int[][] routes, int S, int T) {
        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        int ret = 0;

        if (S == T) return 0;

        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                ArrayList<Integer> buses = map.getOrDefault(routes[i][j], new ArrayList<>());
                buses.add(i);
                map.put(routes[i][j], buses);
            }
        }

        q.offer(S);
        while (!q.isEmpty()) {
            int len = q.size();
            ret++;
            for (int i = 0; i < len; i++) {
                int cur = q.poll();
                ArrayList<Integer> buses = map.get(cur);
                for (int bus : buses) {
                    if (visited.contains(bus)) continue;
                    visited.add(bus);
                    for (int j = 0; j < routes[bus].length; j++) {
                        if (routes[bus][j] == T) return ret;
                        q.offer(routes[bus][j]);
                    }
                }
            }
        }
        return -1;
    }
}
