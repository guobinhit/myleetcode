package com.hit.basmath.learn.others;

import java.util.HashMap;
import java.util.Map;

/**
 * 914. X of a Kind in a Deck of Cards
 * <p>
 * In a deck of cards, each card has an integer written on it.
 * <p>
 * Return true if and only if you can choose X >= 2 such that it is possible to split the entire deck into 1 or more groups of cards, where:
 * <p>
 * Each group has exactly X cards.
 * All the cards in each group have the same integer.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3,4,4,3,2,1]
 * Output: true
 * Explanation: Possible partition [1,1],[2,2],[3,3],[4,4]
 * <p>
 * Example 2:
 * <p>
 * Input: [1,1,1,2,2,2,3,3]
 * Output: false
 * Explanation: No possible partition.
 * <p>
 * Example 3:
 * <p>
 * Input: [1]
 * Output: false
 * Explanation: No possible partition.
 * <p>
 * Example 4:
 * <p>
 * Input: [1,1]
 * Output: true
 * Explanation: Possible partition [1,1]
 * <p>
 * Example 5:
 * <p>
 * Input: [1,1,2,2,2,2]
 * Output: true
 * Explanation: Possible partition [1,1],[2,2],[2,2]
 * <p>
 * Note:
 * <p>
 * 1 <= deck.length <= 10000
 * 0 <= deck[i] < 10000
 */
public class _914 {
    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> count = new HashMap<>();
        int res = 0;
        for (int i : deck) count.put(i, count.getOrDefault(i, 0) + 1);
        for (int i : count.values()) res = gcd(i, res);
        return res > 1;
    }

    private int gcd(int a, int b) {
        return b > 0 ? gcd(b, a % b) : a;
    }
}
