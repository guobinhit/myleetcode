package com.hit.basmath.learn.others;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 893. Groups of Special-Equivalent Strings
 * <p>
 * You are given an array A of strings.
 * <p>
 * A move onto S consists of swapping any two even indexed characters of S, or any two odd indexed characters of S.
 * <p>
 * Two strings S and T are special-equivalent if after any number of moves onto S, S == T.
 * <p>
 * For example, S = "zzxy" and T = "xyzz" are special-equivalent because we may make the moves "zzxy" -> "xzzy" -> "xyzz" that swap S[0] and S[2], then S[1] and S[3].
 * <p>
 * Now, a group of special-equivalent strings from A is a non-empty subset of A such that:
 * <p>
 * Every pair of strings in the group are special equivalent, and;
 * The group is the largest size possible (ie., there isn't a string S not in the group such that S is special equivalent to every string in the group)
 * Return the number of groups of special-equivalent strings from A.
 * <p>
 * Example 1:
 * <p>
 * Input: ["abcd","cdab","cbad","xyzz","zzxy","zzyx"]
 * Output: 3
 * Explanation:
 * One group is ["abcd", "cdab", "cbad"], since they are all pairwise special equivalent, and none of the other strings are all pairwise special equivalent to these.
 * <p>
 * The other two groups are ["xyzz", "zzxy"] and ["zzyx"].  Note that in particular, "zzxy" is not special equivalent to "zzyx".
 * <p>
 * Example 2:
 * <p>
 * Input: ["abc","acb","bac","bca","cab","cba"]
 * Output: 3
 * <p>
 * Note:
 * <p>
 * 1 <= A.length <= 1000
 * 1 <= A[i].length <= 20
 * All A[i] have the same length.
 * All A[i] consist of only lowercase letters.
 */
public class _893 {
    public int numSpecialEquivGroups(String[] A) {
        Set<String> set = new HashSet<>();
        for (String s : A) {
            int[] odd = new int[26];
            int[] even = new int[26];
            for (int i = 0; i < s.length(); i++) {
                if (i % 2 == 1) odd[s.charAt(i) - 'a']++;
                else even[s.charAt(i) - 'a']++;
            }
            String sig = Arrays.toString(odd) + Arrays.toString(even);
            set.add(sig);
        }
        return set.size();
    }
}
