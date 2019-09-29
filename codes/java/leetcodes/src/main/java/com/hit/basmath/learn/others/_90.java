package com.hit.basmath.learn.others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 90. Subsets II
 * <p>
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
 * <p>
 * Note: The solution set must not contain duplicate subsets.
 * <p>
 * Example:
 * <p>
 * Input: [1,2,2]
 * <p>
 * Output:
 * [
 * [2],
 * [1],
 * [1,2,2],
 * [2,2],
 * [1,2],
 * []
 * ]
 */
public class _90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        dfs(nums, 0, new ArrayList<Integer>(), result);
        return result;
    }

    private void dfs(int[] nums, int index, List<Integer> path, List<List<Integer>> result) {
        result.add(path);
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) continue;
            List<Integer> nPath = new ArrayList<>(path);
            nPath.add(nums[i]);
            dfs(nums, i + 1, nPath, result);
        }
    }
}
