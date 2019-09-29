package com.hit.basmath.learn.others;

/**
 * 97. Interleaving String
 * <p>
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 * <p>
 * Example 1:
 * <p>
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * Output: true
 * <p>
 * Example 2:
 * <p>
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * Output: false
 */
public class _97 {
    public boolean isInterleave(String s1, String s2, String s3) {

        if ((s1.length() + s2.length()) != s3.length()) return false;

        boolean[][] matrix = new boolean[s2.length() + 1][s1.length() + 1];

        matrix[0][0] = true;

        for (int i = 1; i < matrix[0].length; i++) {
            matrix[0][i] = matrix[0][i - 1] && (s1.charAt(i - 1) == s3.charAt(i - 1));
        }

        for (int i = 1; i < matrix.length; i++) {
            matrix[i][0] = matrix[i - 1][0] && (s2.charAt(i - 1) == s3.charAt(i - 1));
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                matrix[i][j] = (matrix[i - 1][j] && (s2.charAt(i - 1) == s3.charAt(i + j - 1)))
                        || (matrix[i][j - 1] && (s1.charAt(j - 1) == s3.charAt(i + j - 1)));
            }
        }

        return matrix[s2.length()][s1.length()];
    }
}
