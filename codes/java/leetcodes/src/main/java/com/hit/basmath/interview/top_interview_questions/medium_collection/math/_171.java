package com.hit.basmath.interview.top_interview_questions.medium_collection.math;

/**
 * 171. Excel Sheet Column Number
 * <p>
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 * <p>
 * For example:
 * <p>
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 * <p>
 * Example 1:
 * <p>
 * Input: "A"
 * Output: 1
 * <p>
 * Example 2:
 * <p>
 * Input: "AB"
 * Output: 28
 * <p>
 * Example 3:
 * <p>
 * Input: "ZY"
 * Output: 701
 */
public class _171 {
    public int titleToNumber(String s) {
        // 判空
        if (s == null || "".equals(s)) {
            return -1;
        }
        // 将字符串转换为字符数组
        char[] strArr = s.toCharArray();
        // 指数
        int exp = 0;
        // 行数
        int col = 0;
        for (int i = strArr.length - 1; i >= 0; i--) {
            col += (strArr[i] - 'A' + 1) * Math.pow(26, exp);
            exp++;
        }
        return col;
    }
}
