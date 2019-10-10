package com.hit.basmath.learn.array_and_string;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. Pascal's Triangle
 * <p>
 * Given numRows, generate the first numRows of Pascal's triangle.
 * <p>
 * For example, given numRows = 5, return
 * <p>
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 */
public class _118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        if (numRows <= 0) {
            return triangle;
        }

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<Integer>();
            for (int j = 0; j < i + 1; j++) {
                // Besides first row is 1 only, others row's first and last element both 1
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    /**
                     * calculate element value:
                     *
                     * K(i)(j) = K(i-1)(j-1) + K(i-1)(j)
                     *
                     * except for the first and last element
                     */
                    row.add(triangle.get(i - 1).get(j - 1) + triangle.get(i - 1).get(j));
                }
            }
            triangle.add(row);
        }
        return triangle;
    }
}
