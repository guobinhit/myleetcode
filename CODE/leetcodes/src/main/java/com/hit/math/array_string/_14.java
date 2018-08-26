package com.hit.math.array_string;

/**
 * 14. Longest Common Prefix
 * <p>
 * Write a function to find the longest common prefix string amongst an array of strings.
 * <p>
 * If there is no common prefix, return an empty string "".
 * <p>
 * Example 1:
 * <p>
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * <p>
 * Example 2:
 * <p>
 * Input: ["dog","racecar","car"]
 * Output: ""
 * <p>
 * Explanation: There is no common prefix among the input strings.
 * <p>
 * Note:
 * <p>
 * All given inputs are in lowercase letters a-z.
 */
public class _14 {
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        /**
         * Let first element of strs as a initial aim longest common prefix
         */
        String aimPrefix = strs[0];
        int i = 1;
        /**
         * Circle strs.length - 1 times
         */
        while (i < strs.length) {
            /**
             * This strs[i].indexOf(aimPrefix) != 0 condition means
             * both param have't same common prefix
             */
            while (strs[i].indexOf(aimPrefix) != 0) {
                /**
                 * Because common prefix is must be satisfied all element in strs,
                 * so, any two elements can decide this longest common prefix.
                 *
                 * If strs[i].indexOf(aimPrefix) != 0 is true,
                 * we can truncate aimPrefix many a time
                 */
                aimPrefix = aimPrefix.substring(0, aimPrefix.length() - 1);
            }

            /**
             * If the first cycle is completed, aimPrefix.length() == 0 is true
             * it's mean there is no longest prefix surely
             */
            if (aimPrefix.length() == 0) {
                return "";
            } else {
                /**
                 * i++ means this circle handled and begin next circle judgement
                 */
                i++;
            }
        }
        return aimPrefix;
    }

    public static void main(String[] args) {
        String[] strs = {"follow", "a", "fob"};
        String[] strs2 = {"follow", "fo", "fol"};
        System.out.println(_14.longestCommonPrefix(strs));
        System.out.println(_14.longestCommonPrefix(strs2));
    }
}
