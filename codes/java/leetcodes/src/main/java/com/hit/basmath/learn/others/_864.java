package com.hit.basmath.learn.others;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 864. Shortest Path to Get All Keys
 * <p>
 * We are given a 2-dimensional grid. "." is an empty cell, "#" is a wall, "@" is the starting point, ("a", "b", ...) are keys, and ("A", "B", ...) are locks.
 * <p>
 * We start at the starting point, and one move consists of walking one space in one of the 4 cardinal directions.  We cannot walk outside the grid, or walk into a wall.  If we walk over a key, we pick it up.  We can't walk over a lock unless we have the corresponding key.
 * <p>
 * For some 1 <= K <= 6, there is exactly one lowercase and one uppercase letter of the first K letters of the English alphabet in the grid.  This means that there is exactly one key for each lock, and one lock for each key; and also that the letters used to represent the keys and locks were chosen in the same order as the English alphabet.
 * <p>
 * Return the lowest number of moves to acquire all keys.  If it's impossible, return -1.
 * <p>
 * Example 1:
 * <p>
 * Input: ["@.a.#","###.#","b.A.B"]
 * Output: 8
 * Example 2:
 * <p>
 * Input: ["@..aA","..B#.","....b"]
 * Output: 6
 * <p>
 * Note:
 * <p>
 * 1 <= grid.length <= 30
 * 1 <= grid[0].length <= 30
 * grid[i][j] contains only '.', '#', '@', 'a'-'f' and 'A'-'F'
 * The number of keys is in [1, 6].  Each key has a different letter and opens exactly one lock.
 */
public class _864 {
    class State {
        int keys, i, j;

        State(int keys, int i, int j) {
            this.keys = keys;
            this.i = i;
            this.j = j;
        }
    }

    public int shortestPathAllKeys(String[] grid) {
        int x = -1, y = -1, m = grid.length, n = grid[0].length(), max = -1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = grid[i].charAt(j);
                if (c == '@') {
                    x = i;
                    y = j;
                }
                if (c >= 'a' && c <= 'f') {
                    max = Math.max(c - 'a' + 1, max);
                }
            }
        }
        State start = new State(0, x, y);
        Queue<State> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        visited.add(0 + " " + x + " " + y);
        q.offer(start);
        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                State cur = q.poll();
                if (cur.keys == (1 << max) - 1) {
                    return step;
                }
                for (int[] dir : dirs) {
                    int i = cur.i + dir[0];
                    int j = cur.j + dir[1];
                    int keys = cur.keys;
                    if (i >= 0 && i < m && j >= 0 && j < n) {
                        char c = grid[i].charAt(j);
                        if (c == '#') {
                            continue;
                        }
                        if (c >= 'a' && c <= 'f') {
                            keys |= 1 << (c - 'a');
                        }
                        if (c >= 'A' && c <= 'F' && ((keys >> (c - 'A')) & 1) == 0) {
                            continue;
                        }
                        if (!visited.contains(keys + " " + i + " " + j)) {
                            visited.add(keys + " " + i + " " + j);
                            q.offer(new State(keys, i, j));
                        }
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
