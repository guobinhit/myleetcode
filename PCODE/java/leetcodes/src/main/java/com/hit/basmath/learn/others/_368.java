package com.hit.basmath.learn.others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 368. Largest Divisible Subset
 * <p>
 * Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies:
 * <p>
 * Si % Sj = 0 or Sj % Si = 0.
 * <p>
 * If there are multiple solutions, return any subset is fine.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3]
 * Output: [1,2] (of course, [1,3] will also be ok)
 * <p>
 * Example 2:
 * <p>
 * Input: [1,2,4,8]
 * Output: [1,2,4,8]
 */
public class _368 {

    // cache or memo. For each number in nums this stores the longest
    // subset ending in that number. Note that I don't see this as a matrix, I
    // see this as an array of arrays
    private int[][] cache;

    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums.length == 0) {
            return Collections.emptyList();
        }

        // instantiating an array of arrays with "nums.length" length and "null" throughout
        cache = new int[nums.length][];
        Arrays.sort(nums);
        cache[0] = new int[]{nums[0]};

        int[] longestSubset = new int[0];
        // starting from the largest number, lookup the longest subset
        // ending in that number. Next, go to the second largest number,
        // and so on.
        for (int i = nums.length - 1; i >= 0; i--) {
            int[] subset = largetDivisibleSubset(nums, i);

            // if the subset ending in nums[i] is larger than the previous
            // one, promote the subset as the new longest
            if (subset.length > longestSubset.length) {
                longestSubset = subset;
            }
        }

        // return the longest subset
        List<Integer> list = new ArrayList<>(longestSubset.length);
        for (int num : longestSubset) {
            list.add(num);
        }
        return list;
    }

    private int[] largetDivisibleSubset(int[] nums, int index) {
        int[] subset = cache[index];
        if (subset != null) {
            return subset;
        }

        int largestNumber = nums[index];
        int[] longestSubset = new int[0];

        for (int i = index - 1; i >= 0; i--) {
            // if nums[i] is not a multiple of the largest number, discard it
            if (largestNumber % nums[i] != 0) {
                continue;
            }

            // nums[i] is multiple. Let's get the largest subset ending in nums[i]
            subset = largetDivisibleSubset(nums, i);
            if (subset.length > longestSubset.length) {
                // this is larger than the current "longest" so we promote it
                longestSubset = subset;
            }
        }

        // let's copy the longest/largest subset and append "largestNumber" to it
        int[] result = new int[longestSubset.length + 1];
        System.arraycopy(longestSubset, 0, result, 0, longestSubset.length);
        result[result.length - 1] = largestNumber;

        cache[index] = result;
        return result;
    }
}
