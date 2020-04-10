package com.hit.basmath.learn.recursion_ii;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. Permutations
 * <p>
 * Given a collection of distinct integers, return all possible permutations.
 * <p>
 * Example:
 * <p>
 * Input: [1,2,3]
 * <p>
 * Output:
 * <p>
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 */
public class _46 {
    public List<List<Integer>> permute(int[] num) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (num.length == 0) return ans;
        List<Integer> l0 = new ArrayList<Integer>();
        l0.add(num[0]);
        ans.add(l0);
        for (int i = 1; i < num.length; ++i) {
            List<List<Integer>> new_ans = new ArrayList<List<Integer>>();
            for (int j = 0; j <= i; ++j) {
                for (List<Integer> l : ans) {
                    List<Integer> new_l = new ArrayList<Integer>(l);
                    new_l.add(j, num[i]);
                    new_ans.add(new_l);
                }
            }
            ans = new_ans;
        }
        return ans;
    }
}
