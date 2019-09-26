package com.hit.basmath.learn.others;

import java.util.HashMap;
import java.util.Map;

/**
 * 781. Rabbits in Forest
 * <p>
 * In a forest, each rabbit has some color. Some subset of rabbits (possibly all of them) tell you how many other rabbits have the same color as them. Those answers are placed in an array.
 * <p>
 * Return the minimum number of rabbits that could be in the forest.
 * <p>
 * Examples:
 * <p>
 * Input: answers = [1, 1, 2]
 * Output: 5
 * Explanation:
 * The two rabbits that answered "1" could both be the same color, say red.
 * The rabbit than answered "2" can't be red or the answers would be inconsistent.
 * Say the rabbit that answered "2" was blue.
 * Then there should be 2 other blue rabbits in the forest that didn't answer into the array.
 * The smallest possible number of rabbits in the forest is therefore 5: 3 that answered plus 2 that didn't.
 * <p>
 * Input: answers = [10, 10, 10]
 * Output: 11
 * <p>
 * Input: answers = []
 * Output: 0
 * <p>
 * Note:
 * <p>
 * 1. answers will have length at most 1000.
 * 2. Each answers[i] will be an integer in the range [0, 999].
 */
public class _781 {
    public int numRabbits(int[] answers) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int answer : answers) {
            map.put(answer, map.getOrDefault(answer, 0) + 1);
        }
        for (Integer n : map.keySet()) {
            int group = map.get(n) / (n + 1);
            res += map.get(n) % (n + 1) != 0 ? (group + 1) * (n + 1) : group * (n + 1);
        }
        return res;
    }
}
