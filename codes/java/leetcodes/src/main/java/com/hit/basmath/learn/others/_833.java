package com.hit.basmath.learn.others;

import java.util.Arrays;

/**
 * 833. Find And Replace in String
 * <p>
 * To some string S, we will perform some replacement operations that replace groups of letters with new ones (not necessarily the same size).
 * <p>
 * Each replacement operation has 3 parameters: a starting index i, a source word x and a target word y.  The rule is that if x starts at position i in the original string S, then we will replace that occurrence of x with y.  If not, we do nothing.
 * <p>
 * For example, if we have S = "abcd" and we have some replacement operation i = 2, x = "cd", y = "ffff", then because "cd" starts at position 2 in the original string S, we will replace it with "ffff".
 * <p>
 * Using another example on S = "abcd", if we have both the replacement operation i = 0, x = "ab", y = "eee", as well as another replacement operation i = 2, x = "ec", y = "ffff", this second operation does nothing because in the original string S[2] = 'c', which doesn't match x[0] = 'e'.
 * <p>
 * All these operations occur simultaneously.  It's guaranteed that there won't be any overlap in replacement: for example, S = "abc", indexes = [0, 1], sources = ["ab","bc"] is not a valid test case.
 * <p>
 * Example 1:
 * <p>
 * Input: S = "abcd", indexes = [0,2], sources = ["a","cd"], targets = ["eee","ffff"]
 * Output: "eeebffff"
 * Explanation: "a" starts at index 0 in S, so it's replaced by "eee".
 * "cd" starts at index 2 in S, so it's replaced by "ffff".
 * <p>
 * Example 2:
 * <p>
 * Input: S = "abcd", indexes = [0,2], sources = ["ab","ec"], targets = ["eee","ffff"]
 * Output: "eeecd"
 * Explanation: "ab" starts at index 0 in S, so it's replaced by "eee".
 * "ec" doesn't starts at index 2 in the original S, so we do nothing.
 * <p>
 * Notes:
 * <p>
 * 0 <= indexes.length = sources.length = targets.length <= 100
 * 0 < indexes[i] < S.length <= 1000
 * All characters in given inputs are lowercase letters.
 */
public class _833 {
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        int n = S.length();
        int[] match = new int[n];
        Arrays.fill(match, -1);
        // Mark expected matching position with
        // its corresponding index in the replacement arrays
        for (int i = 0; i < indexes.length; i++) {
            match[indexes[i]] = i;
        }
        // Build output
        StringBuilder sb = new StringBuilder();
        int start = 0;
        for (int i = 0; i < n; i++) {
            if (match[i] == -1) continue;

            int j = match[i];  // index of replacement array
            int end = i + sources[j].length();
            String sub = S.substring(i, end);

            // If match found then replace
            if (sub.equals(sources[j])) {
                sb.append(S.substring(start, i));  // keep non-replace part
                sb.append(targets[j]);             // replace matching part
                start = end;
            }
        }
        sb.append(S.substring(start));    // remaining part
        return sb.toString();
    }
}
