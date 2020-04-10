package com.hit.basmath.learn.others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 679. 24 Game
 * <p>
 * You have 4 cards each containing a number from 1 to 9. You need to judge whether they could operated through *, /, +, -, (, ) to get the value of 24.
 * <p>
 * Example 1:
 * Input: [4, 1, 8, 7]
 * Output: True
 * Explanation: (8-4) * (7-1) = 24
 * <p>
 * Example 2:
 * <p>
 * Input: [1, 2, 1, 2]
 * Output: False
 * <p>
 * Note:
 * <p>
 * The division operator / represents real division, not integer division. For example, 4 / (1 - 2/3) = 12.
 * Every operation done is between two numbers. In particular, we cannot use - as a unary operator. For example, with [1, 1, 1, 1] as input, the expression -1 - 1 - 1 - 1 is not allowed.
 * You cannot concatenate numbers together. For example, if the input is [1, 2, 1, 2], we cannot write this as 12 + 12.
 */
public class _679 {
    private boolean res = false;
    private final double eps = 0.001;

    public boolean judgePoint24(int[] nums) {
        List<Double> arr = new ArrayList<>();
        for (int n : nums) arr.add((double) n);
        helper(arr);
        return res;
    }

    private void helper(List<Double> arr) {
        if (res) return;
        if (arr.size() == 1) {
            if (Math.abs(arr.get(0) - 24.0) < eps)
                res = true;
            return;
        }
        for (int i = 0; i < arr.size(); i++) {
            for (int j = 0; j < i; j++) {
                List<Double> next = new ArrayList<>();
                Double p1 = arr.get(i), p2 = arr.get(j);
                next.addAll(Arrays.asList(p1 + p2, p1 - p2, p2 - p1, p1 * p2));
                if (Math.abs(p2) > eps) next.add(p1 / p2);
                if (Math.abs(p1) > eps) next.add(p2 / p1);

                arr.remove(i);
                arr.remove(j);
                for (Double n : next) {
                    arr.add(n);
                    helper(arr);
                    arr.remove(arr.size() - 1);
                }
                arr.add(j, p2);
                arr.add(i, p1);
            }
        }
    }
}
