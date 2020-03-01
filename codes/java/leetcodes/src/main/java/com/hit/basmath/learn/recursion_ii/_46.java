package com.hit.basmath.learn.recursion_ii;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
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
    public List<List<Integer>> permute(int[] nums) {
        // init output list
        List<List<Integer>> output = new LinkedList<>();
        // convert nums into list since the output is a list of lists
        List<Integer> numsList = new ArrayList<>();
        for (int num : nums) numsList.add(num);
        int n = nums.length;
        backtrack(n, numsList, output, 0);
        return output;
    }

    private void backtrack(int n, List<Integer> nums, List<List<Integer>> output, int first) {
        // if all integers are used up
        if (first == n) output.add(new ArrayList<>(nums));
        for (int i = first; i < n; i++) {
            // place i-th integer first 
            // in the current permutation
            Collections.swap(nums, first, i);
            // use next integers to complete the permutations
            backtrack(n, nums, output, first + 1);
            // backtrack
            Collections.swap(nums, first, i);
        }
    }
}
