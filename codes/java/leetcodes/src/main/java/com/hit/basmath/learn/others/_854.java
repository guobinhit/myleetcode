package com.hit.basmath.learn.others;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 854. K-Similar Strings
 * <p>
 * Strings A and B are K-similar (for some non-negative integer K) if we can swap the positions of two letters in A exactly K times so that the resulting string equals B.
 * <p>
 * Given two anagrams A and B, return the smallest K for which A and B are K-similar.
 * <p>
 * Example 1:
 * <p>
 * Input: A = "ab", B = "ba"
 * Output: 1
 * <p>
 * Example 2:
 * <p>
 * Input: A = "abc", B = "bca"
 * Output: 2
 * <p>
 * Example 3:
 * <p>
 * Input: A = "abac", B = "baca"
 * Output: 2
 * <p>
 * Example 4:
 * <p>
 * Input: A = "aabc", B = "abca"
 * Output: 2
 * <p>
 * Note:
 * <p>
 * 1 <= A.length == B.length <= 20
 * A and B contain only lowercase letters from the set {'a', 'b', 'c', 'd', 'e', 'f'}
 */
public class _854 {
    public int kSimilarity(String A, String B) {
        if (A.equals(B)) return 0;
        Set<String> vis = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.add(A);
        vis.add(A);
        int res = 0;
        while (!q.isEmpty()) {
            res++;
            for (int sz = q.size(); sz > 0; sz--) {
                String s = q.poll();
                int i = 0;
                while (s.charAt(i) == B.charAt(i)) i++;
                for (int j = i + 1; j < s.length(); j++) {
                    if (s.charAt(j) == B.charAt(j) || s.charAt(j) != B.charAt(i)) continue;
                    String temp = swap(s, i, j);
                    if (temp.equals(B)) return res;
                    if (vis.add(temp)) q.add(temp);
                }
            }
        }
        return res;
    }

    public String swap(String s, int i, int j) {
        char[] ca = s.toCharArray();
        char temp = ca[i];
        ca[i] = ca[j];
        ca[j] = temp;
        return new String(ca);
    }
}
