package com.hit.basmath.learn.others;

/**
 * 365. Water and Jug Problem
 * <p>
 * You are given two jugs with capacities x and y litres. There is an infinite amount of water supply available. You need to determine whether it is possible to measure exactly z litres using these two jugs.
 * <p>
 * If z liters of water is measurable, you must have z liters of water contained within one or both buckets by the end.
 * <p>
 * Operations allowed:
 * <p>
 * Fill any of the jugs completely with water.
 * Empty any of the jugs.
 * Pour water from one jug into another till the other jug is completely full or the first jug itself is empty.
 * <p>
 * Example 1: (From the famous "Die Hard" example in https://www.youtube.com/watch?v=BVtQNK_ZUJg)
 * <p>
 * Input: x = 3, y = 5, z = 4
 * Output: True
 * <p>
 * Example 2:
 * <p>
 * Input: x = 2, y = 6, z = 5
 * Output: False
 */
public class _365 {
    public boolean canMeasureWater(int x, int y, int z) {
        //limit brought by the statement that water is finallly in one or both buckets
        if (x + y < z) return false;
        //case x or y is zero
        if (x == z || y == z || x + y == z) return true;

        //get GCD, then we can use the property of Bézout's identity
        return z % GCD(x, y) == 0;
    }

    private int GCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
