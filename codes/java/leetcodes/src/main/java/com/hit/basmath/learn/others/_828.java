package com.hit.basmath.learn.others;

/**
 * 828. Unique Letter String
 * <p>
 * A character is unique in string S if it occurs exactly once in it.
 * <p>
 * For example, in string S = "LETTER", the only unique characters are "L" and "R".
 * <p>
 * Let's define UNIQ(S) as the number of unique characters in string S.
 * <p>
 * For example, UNIQ("LETTER") =  2.
 * <p>
 * Given a string S with only uppercases, calculate the sum of UNIQ(substring) over all non-empty substrings of S.
 * <p>
 * If there are two or more equal substrings at different positions in S, we consider them different.
 * <p>
 * Since the answer can be very large, return the answer modulo 10 ^ 9 + 7.
 * <p>
 * Example 1:
 * <p>
 * Input: "ABC"
 * Output: 10
 * Explanation: All possible substrings are: "A","B","C","AB","BC" and "ABC".
 * Evey substring is composed with only unique letters.
 * Sum of lengths of all substring is 1 + 1 + 1 + 2 + 2 + 3 = 10
 * <p>
 * Example 2:
 * <p>
 * Input: "ABA"
 * Output: 8
 * Explanation: The same as example 1, except uni("ABA") = 1.
 * <p>
 * Note: 0 <= S.length <= 10000.
 */
public class _828 {
    public int uniqueLetterString(String S) {

        int res = 0;
        if (S == null || S.length() == 0)
            return res;
        int[] showLastPosition = new int[128];
        int[] contribution = new int[128];
        int cur = 0;
        for (int i = 0; i < S.length(); i++) {
            char x = S.charAt(i);
            cur -= contribution[x];
            contribution[x] = (i - (showLastPosition[x] - 1));
            cur += contribution[x];
            showLastPosition[x] = i + 1;
            res += cur;
        }
        return res;
    }
}
