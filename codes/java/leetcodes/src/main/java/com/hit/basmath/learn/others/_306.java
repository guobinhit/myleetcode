package com.hit.basmath.learn.others;

/**
 * 306. Additive Number
 * <p>
 * Additive number is a string whose digits can form additive sequence.
 * <p>
 * A valid additive sequence should contain at least three numbers. Except for the first two numbers, each subsequent number in the sequence must be the sum of the preceding two.
 * <p>
 * Given a string containing only digits '0'-'9', write a function to determine if it's an additive number.
 * <p>
 * Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.
 * <p>
 * Example 1:
 * <p>
 * Input: "112358"
 * Output: true
 * <p>
 * Explanation: The digits can form an additive sequence: 1, 1, 2, 3, 5, 8.
 * 1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
 * <p>
 * Example 2:
 * <p>
 * Input: "199100199"
 * Output: true
 * <p>
 * Explanation: The additive sequence is: 1, 99, 100, 199.
 * 1 + 99 = 100, 99 + 100 = 199
 * <p>
 * Follow up:
 * <p>
 * How would you handle overflow for very large input integers?
 */
public class _306 {
    public boolean isAdditiveNumber(String num) {
        int l = num.length();
        int maxl = num.length() / 2;
        for (int n1 = 1; n1 <= maxl; n1++) {
            if (num.charAt(n1) == '0') {
                if (isAdditiveStr(num.substring(0, n1), "0", num.substring(n1 + 1))) {
                    return true;
                }
                continue;
            }
            for (int n2 = 1; n2 <= maxl && (n1 + n2) < l; n2++) {
                if (num.charAt(n1 + n2) == '0') {
                    if (num.equals("000"))
                        return true;
                    continue;
                }
                if (isAdditiveStr(num.substring(0, n1), num.substring(n1, n1 + n2), num.substring(n1 + n2))) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isAdditiveStr(String num1, String num2, String str) {
        String num3 = addStr(num1, num2);
        while (str.startsWith(num3)) {
            str = str.substring(num3.length());
            if (str.length() == 0)
                return true;
            num1 = num2;
            num2 = num3;
            num3 = addStr(num1, num2);
        }
        return false;
    }

    private String addStr(String s1, String s2) {
        char[] res = new char[Integer.max(s1.length(), s2.length()) + 1];
        int extra = 0;
        int p1 = s1.length() - 1;
        int p2 = s2.length() - 1;
        int i = res.length - 1;
        while (p1 >= 0 || p2 >= 0) {
            int a = p1 >= 0 ? s1.charAt(p1) - '0' : 0;
            int b = p2 >= 0 ? s2.charAt(p2) - '0' : 0;
            int c = (extra + a + b) % 10;
            extra = (extra + a + b) / 10;
            res[i] = (char) (c + 48);
            i -= 1;
            p1 -= 1;
            p2 -= 1;
        }
        if (extra == 0)
            return new String(res, 1, res.length - 1);
        else {
            res[0] = (char) (extra + 48);
            return new String(res);
        }
    }
}
