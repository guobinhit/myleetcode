package com.hit.basmath.learn.others;

/**
 * 168. Excel Sheet Column Title
 * <p>
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 * <p>
 * For example:
 * <p>
 * 1 -> A
 * 2 -> B
 * 3 -> C
 * ...
 * 26 -> Z
 * 27 -> AA
 * 28 -> AB
 * ...
 * <p>
 * Example 1:
 * <p>
 * Input: 1
 * Output: "A"
 * <p>
 * Example 2:
 * <p>
 * Input: 28
 * Output: "AB"
 * <p>
 * Example 3:
 * <p>
 * Input: 701
 * Output: "ZY"
 */
public class _168 {
    public String convertToTitle(int n) {
        StringBuilder result = new StringBuilder();

        while (n > 0) {
            n--;
            result.insert(0, (char) ('A' + n % 26));
            n /= 26;
        }

        return result.toString();
    }
}
