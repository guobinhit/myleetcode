package com.hit.basmath.learn.others;

/**
 * 415. Add Strings
 * <p>
 * Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
 * <p>
 * Note:
 * <p>
 * 1. The length of both num1 and num2 is < 5100.
 * 2. Both num1 and num2 contains only digits 0-9.
 * 3. Both num1 and num2 does not contain any leading zero.
 * 4. You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */
public class _415 {
    public String addStrings(String num1, String num2) {
        if (num1 == null || num1.length() == 0) return num2;
        if (num2 == null || num2.length() == 0) return num1;
        StringBuilder ans = new StringBuilder();
        int num1Length = num1.length() - 1;
        int num2Length = num2.length() - 1;
        int carry = 0;
        while (num1Length >= 0 || num2Length >= 0) {
            int x = num1Length >= 0 ? num1.charAt(num1Length) - '0' : 0;
            int y = num2Length >= 0 ? num2.charAt(num2Length) - '0' : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            ans.append(sum % 10);
            num1Length--;
            num2Length--;
        }
        if (carry == 1) ans.append(1);
        return ans.reverse().toString();
    }
}
