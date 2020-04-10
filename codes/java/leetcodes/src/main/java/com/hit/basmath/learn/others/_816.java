package com.hit.basmath.learn.others;

import java.util.ArrayList;
import java.util.List;

/**
 * 816. Ambiguous Coordinates
 * <p>
 * We had some 2-dimensional coordinates, like "(1, 3)" or "(2, 0.5)".  Then, we removed all commas, decimal points, and spaces, and ended up with the string S.  Return a list of strings representing all possibilities for what our original coordinates could have been.
 * <p>
 * Our original representation never had extraneous zeroes, so we never started with numbers like "00", "0.0", "0.00", "1.0", "001", "00.01", or any other number that can be represented with less digits.  Also, a decimal point within a number never occurs without at least one digit occuring before it, so we never started with numbers like ".1".
 * <p>
 * The final answer list can be returned in any order.  Also note that all coordinates in the final answer have exactly one space between them (occurring after the comma.)
 * <p>
 * Example 1:
 * <p>
 * Input: "(123)"
 * Output: ["(1, 23)", "(12, 3)", "(1.2, 3)", "(1, 2.3)"]
 * <p>
 * Example 2:
 * <p>
 * Input: "(00011)"
 * Output:  ["(0.001, 1)", "(0, 0.011)"]
 * Explanation:
 * 0.0, 00, 0001 or 00.01 are not allowed.
 * <p>
 * Example 3:
 * <p>
 * Input: "(0123)"
 * Output: ["(0, 123)", "(0, 12.3)", "(0, 1.23)", "(0.1, 23)", "(0.1, 2.3)", "(0.12, 3)"]
 * <p>
 * Example 4:
 * <p>
 * Input: "(100)"
 * Output: [(10, 0)]
 * Explanation:
 * 1.0 is not allowed.
 * <p>
 * Note:
 * <p>
 * 4 <= S.length <= 12.
 * S[0] = "(", S[S.length - 1] = ")", and the other elements in S are digits.
 */
public class _816 {
    public List<String> ambiguousCoordinates(String S) {
        int n = S.length();
        List<String> res = new ArrayList<>();
        for (int i = 1; i < n - 2; ++i) {
            List<String> A = f(S.substring(1, i + 1)), B = f(S.substring(i + 1, n - 1));
            for (String a : A) for (String b : B) res.add("(" + a + ", " + b + ")");
        }
        return res;
    }

    private List<String> f(String S) {
        int n = S.length();
        List<String> res = new ArrayList<>();
        if (n == 0 || (n > 1 && S.charAt(0) == '0' && S.charAt(n - 1) == '0')) return res;
        if (n > 1 && S.charAt(0) == '0') {
            res.add("0." + S.substring(1));
            return res;
        }
        res.add(S);
        if (n == 1 || S.charAt(n - 1) == '0') return res;
        for (int i = 1; i < n; ++i) res.add(S.substring(0, i) + '.' + S.substring(i));
        return res;
    }
}
