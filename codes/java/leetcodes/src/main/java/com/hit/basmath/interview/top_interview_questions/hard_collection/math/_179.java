package com.hit.basmath.interview.top_interview_questions.hard_collection.math;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 179. Largest Number
 * <p>
 * Given a list of non negative integers, arrange them such that they form the largest number.
 * <p>
 * Example 1:
 * <p>
 * Input: [10,2]
 * Output: "210"
 * <p>
 * Example 2:
 * <p>
 * Input: [3,30,34,5,9]
 * Output: "9534330"
 * <p>
 * Note: The result may be very large, so you need to return a string instead of an integer.
 */
public class _179 {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0)
            return "";

        // Convert int array to String array, so we can sort later on
        String[] s_num = new String[nums.length];
        for (int i = 0; i < nums.length; i++)
            s_num[i] = String.valueOf(nums[i]);

        // Comparator to decide which string should come first in concatenation
        Comparator<String> comp = new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                String s1 = str1 + str2;
                String s2 = str2 + str1;
                return s2.compareTo(s1); // reverse order here, so we can do append() later
            }
        };

        Arrays.sort(s_num, comp);
        // An extreme edge case by lc, say you have only a bunch of 0 in your int array
        if (s_num[0].charAt(0) == '0')
            return "0";

        StringBuilder sb = new StringBuilder();
        for (String s : s_num)
            sb.append(s);

        return sb.toString();
    }
}
