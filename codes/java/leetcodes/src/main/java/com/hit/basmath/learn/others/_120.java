package com.hit.basmath.learn.others;

import java.util.List;

/**
 * 120. Triangle
 * <p>
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 * <p>
 * For example, given the following triangle
 * <p>
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * <p>
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * <p>
 * Note:
 * <p>
 * Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 */
public class _120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] ans = new int[triangle.size() + 1];
        for (int i = triangle.size() - 1; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                ans[j] = Math.min(ans[j], ans[j + 1]) + triangle.get(i).get(j);
            }
        }
        return ans[0];
    }
}
