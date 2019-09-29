package com.hit.basmath.learn.others;

/**
 * 541. Reverse String II
 * <p>
 * Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting from the start of the string. If there are less than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and left the other as original.
 * <p>
 * Example:
 * <p>
 * Input: s = "abcdefg", k = 2
 * Output: "bacdfeg"
 * <p>
 * Restrictions:
 * <p>
 * The string consists of lower English letters only.
 * Length of the given string and k will in the range [1, 10000]
 */
public class _541 {
    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int i = 0;
        while (i < n) {
            int j = Math.min(i + k - 1, n - 1);
            swap(arr, i, j);
            i += 2 * k;
        }
        return String.valueOf(arr);
    }

    private void swap(char[] arr, int l, int r) {
        while (l < r) {
            char temp = arr[l];
            arr[l++] = arr[r];
            arr[r--] = temp;
        }
    }
}
