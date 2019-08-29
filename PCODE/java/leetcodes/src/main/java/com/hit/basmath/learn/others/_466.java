package com.hit.basmath.learn.others;

import java.util.Arrays;

/**
 * 466. Count The Repetitions
 * <p>
 * Define S = [s,n] as the string S which consists of n connected strings s. For example, ["abc", 3] ="abcabcabc".
 * <p>
 * On the other hand, we define that string s1 can be obtained from string s2 if we can remove some characters from s2 such that it becomes s1. For example, “abc” can be obtained from “abdbec” based on our definition, but it can not be obtained from “acbbe”.
 * <p>
 * You are given two non-empty strings s1 and s2 (each at most 100 characters long) and two integers 0 ≤ n1 ≤ 106 and 1 ≤ n2 ≤ 106. Now consider the strings S1 and S2, where S1=[s1,n1] and S2=[s2,n2]. Find the maximum integer M such that [S2,M] can be obtained from S1.
 * <p>
 * Example:
 * <p>
 * Input:
 * s1="acb", n1=4
 * s2="ab", n2=2
 * <p>
 * Return:
 * 2
 */
public class _466 {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        int m1 = s1.length();
        int m2 = s2.length();
        if (m1 == 0 || m2 == 0)
            return 0;
        int i, j;
        // extra code to remove unnecessary characters in s1
        StringBuffer sb = new StringBuffer();
        boolean[] used = new boolean[26];
        int[] counts = new int[26]; // count of each character in s1
        for (i = 0; i < m2; i++) {
            j = s2.charAt(i) - 'a';
            used[j] = true;
        }
        for (i = 0; i < m1; i++) {
            j = s1.charAt(i) - 'a';
            if (used[j])
                sb.append(s1.charAt(i));
            counts[j]++;
        }
        for (i = 0; i < 26; i++) {
            if (used[i] && counts[i] == 0) // character in s2 not in s1
                return 0;
        }
        s1 = sb.toString();
        m1 = s1.length();

        // extra code to reduce s1 and s2 if it contains repeating pattern
        for (i = 1; i <= m1 / 2; i++) {
            if (m1 % i != 0)
                continue;
            if (repeatAtK(s1, i)) {
                s1 = s1.substring(0, i);
                n1 *= m1 / i;
                m1 = i;
                break;
            }
        }
        for (i = 1; i <= m2 / 2; i++) {
            if (m2 % i != 0)
                continue;
            if (repeatAtK(s2, i)) {
                s2 = s2.substring(0, i);
                n2 *= m2 / i;
                m2 = i;
                break;
            }
        }

        int[][] ocs = new int[26][m1]; // occurrences of each character in s1
        Arrays.fill(counts, 0);
        for (i = 0; i < m1; i++) {
            j = s1.charAt(i) - 'a';
            ocs[j][counts[j]] = i;
            counts[j]++;
        }

        // simple case
        if (m2 == 1) {
            j = s2.charAt(0) - 'a';
            return counts[j] * n1 / n2;
        }

        return getMaxRepetitionsProcessed(counts, ocs, n1, s2.toCharArray(), n2);
    }

    private int getMaxRepetitionsProcessed(int[] counts, int[][] ocs, int n1, char[] ca2, int n2) {
        int m1 = ocs[0].length;
        int m2 = ca2.length;
        // <i, j> pairs in slot mod m1/m2
        int[][][] r = new int[m1][m2][2];
        // pos[c][0] is the current index of character c in i,
        // pos[c][1] is which occurrence in s1
        int[][] pos = new int[26][2];
        int i, j, k, r1 = 0, r2 = 0;
        boolean found = false;
        for (i = 0; i < 26; i++) {
            pos[i][0] = ocs[i][0];
        }
        for (i = 0; i < m1; i++) {
            for (j = 0; j < m2; j++) {
                r[i][j][0] = -1;
            }
        }
        for (i = 0, j = 0; i < m1 * n1; i++, j++) {
            k = ca2[j % m2] - 'a';
            // move pos[k] to a position equal or after i by iterating k's occurrences
            while (pos[k][0] < i) {
                pos[k][1]++;
                if (pos[k][1] < counts[k]) {
                    pos[k][0] += ocs[k][pos[k][1]] - ocs[k][pos[k][1] - 1];
                } else {
                    pos[k][1] = 0;
                    pos[k][0] += ocs[k][0] + m1 - ocs[k][counts[k] - 1];
                }
            }
            i = pos[k][0];
            if (i >= m1 * n1) {
                return j / m2 / n2;
            }
            r1 = i % m1;
            r2 = j % m2;
            if (!found && r[r1][r2][0] < 0) {
                r[r1][r2][0] = i;
                r[r1][r2][1] = j;
            } else if (!found) { // push by mod trick here
                int d1 = i - r[r1][r2][0];
                int d2 = j - r[r1][r2][1];
                k = (m1 * n1 - i) / d1;
                i += k * d1;
                j += k * d2;
                for (r1 = 0; r1 < 26; r1++) { // update all pos[c] the same way as i
                    pos[r1][0] += k * d1;
                }
                found = true;
            }
        }
        return j / m2 / n2;
    }

    private boolean repeatAtK(String s, int k) { // check if s is repeated every k characters
        int m = s.length();
        int x = m / k;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < x; j++) {
                if (s.charAt(i) != s.charAt(j * k + i))
                    return false;
            }
        }
        return true;
    }
}
