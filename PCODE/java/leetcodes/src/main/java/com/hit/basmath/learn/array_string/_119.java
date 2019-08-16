package com.hit.basmath.learn.array_string;

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
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < rowIndex + 1; i++) {
            /**
             * Every iteration set 1 at a position that index is 0
             */
            list.add(0, 1);
            for (int j = 1; j < list.size() - 1; j++) {
                list.set(j, list.get(j) + list.get(j + 1));
            }
        }
        return list;
    }

    public static List<Integer> getRow2(int rowIndex) {
        Integer[] rowArr = new Integer[rowIndex + 1];
        Arrays.fill(rowArr, 0);
        rowArr[0] = 1;
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = i; j > 0; j--) {
                rowArr[j] = rowArr[j] + rowArr[j - 1];
            }
        }
        return Arrays.asList(rowArr);
    }

    public static void main(String[] args) {
        System.out.println(_119.getRow(3));
        System.out.println(_119.getRow2(3));
    }
}
