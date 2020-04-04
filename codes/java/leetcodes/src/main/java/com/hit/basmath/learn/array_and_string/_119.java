package com.hit.basmath.learn.array_and_string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 119. Pascal's Triangle II
 * <p>
 * Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
 * <p>
 * Note that the row index starts from 0.
 * <p>
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 * <p>
 * Example:
 * <p>
 * Input: 3
 * <p>
 * Output: [1,3,3,1]
 * <p>
 * Follow up:
 * <p>
 * Could you optimize your algorithm to use only O(k) extra space?
 */
public class _119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < rowIndex + 1; i++) {
            /**
             * Every iteration set 1 at a position that index is 0
             */
            ans.add(0, 1);
            for (int j = 1; j < ans.size() - 1; j++) {
                ans.set(j, ans.get(j) + ans.get(j + 1));
            }
        }
        return ans;
    }
}
