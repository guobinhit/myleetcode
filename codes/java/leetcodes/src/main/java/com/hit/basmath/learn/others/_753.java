package com.hit.basmath.learn.others;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * 753. Cracking the Safe
 * <p>
 * There is a box protected by a password. The password is a sequence of n digits where each digit can be one of the first k digits 0, 1, ..., k-1.
 * <p>
 * While entering a password, the last n digits entered will automatically be matched against the correct password.
 * <p>
 * For example, assuming the correct password is "345", if you type "012345", the box will open because the correct password matches the suffix of the entered password.
 * <p>
 * Return any password of minimum length that is guaranteed to open the box at some point of entering it.
 * <p>
 * Example 1:
 * <p>
 * Input: n = 1, k = 2
 * Output: "01"
 * Note: "10" will be accepted too.Example 2:
 * <p>
 * Input: n = 2, k = 2
 * Output: "00110"
 * Note: "01100", "10011", "11001" will be accepted too.
 * <p>
 * Note:
 * <p>
 * 1. n will be in the range [1, 4].
 * 2. k will be in the range [1, 10].
 * 3. k^n will be at most 4096.
 */
public class _753 {
    public String crackSafe(int n, int k) {
        // Initialize pwd to n repeated 0's as the start node of DFS.
        String strPwd = String.join("", Collections.nCopies(n, "0"));
        StringBuilder sbPwd = new StringBuilder(strPwd);

        Set<String> visitedComb = new HashSet<>();
        visitedComb.add(strPwd);

        int targetNumVisited = (int) Math.pow(k, n);

        crackSafeAfter(sbPwd, visitedComb, targetNumVisited, n, k);

        return sbPwd.toString();
    }

    private boolean crackSafeAfter(StringBuilder pwd, Set<String> visitedComb, int targetNumVisited, int n, int k) {
        // Base case: all n-length combinations among digits 0..k-1 are visited.
        if (visitedComb.size() == targetNumVisited) {
            return true;
        }

        String lastDigits = pwd.substring(pwd.length() - n + 1); // Last n-1 digits of pwd.
        for (char ch = '0'; ch < '0' + k; ch++) {
            String newComb = lastDigits + ch;
            if (!visitedComb.contains(newComb)) {
                visitedComb.add(newComb);
                pwd.append(ch);
                if (crackSafeAfter(pwd, visitedComb, targetNumVisited, n, k)) {
                    return true;
                }
                visitedComb.remove(newComb);
                pwd.deleteCharAt(pwd.length() - 1);
            }
        }

        return false;
    }
}
