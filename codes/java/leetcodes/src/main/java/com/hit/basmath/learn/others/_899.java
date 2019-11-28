package com.hit.basmath.learn.others;

import java.util.Arrays;

/**
 * 899. Orderly Queue
 * <p>
 * A string S of lowercase letters is given.  Then, we may make any number of moves.
 * <p>
 * In each move, we choose one of the first K letters (starting from the left), remove it, and place it at the end of the string.
 * <p>
 * Return the lexicographically smallest string we could have after any number of moves.
 * <p>
 * Example 1:
 * <p>
 * Input: S = "cba", K = 1
 * Output: "acb"
 * Explanation:
 * In the first move, we move the 1st character ("c") to the end, obtaining the string "bac".
 * In the second move, we move the 1st character ("b") to the end, obtaining the final result "acb".
 * <p>
 * Example 2:
 * <p>
 * Input: S = "baaca", K = 3
 * Output: "aaabc"
 * Explanation:
 * In the first move, we move the 1st character ("b") to the end, obtaining the string "aacab".
 * In the second move, we move the 3rd character ("c") to the end, obtaining the final result "aaabc".
 * <p>
 * Note:
 * <p>
 * 1 <= K <= S.length <= 1000
 * S consists of lowercase letters only.
 */
public class _899 {
    public String orderlyQueue(String S, int K) {
        if (K > 1) {
            char[] S2 = S.toCharArray();
            Arrays.sort(S2);
            return new String(S2);
        }
        String res = S;
        for (int i = 1; i < S.length(); i++) {
            String tmp = S.substring(i) + S.substring(0, i);
            if (res.compareTo(tmp) > 0) res = tmp;
        }
        return res;
    }
}
