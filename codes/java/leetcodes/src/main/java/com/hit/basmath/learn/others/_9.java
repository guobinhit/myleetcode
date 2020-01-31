package com.hit.basmath.learn.others;

/**
 * 9. Palindrome Number
 * <p>
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 * <p>
 * Example 1:
 * <p>
 * Input: 121
 * Output: true
 * <p>
 * Example 2:
 * <p>
 * Input: -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * <p>
 * Example 3:
 * <p>
 * Input: 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 * <p>
 * Follow up:
 * <p>
 * Could you solve it without converting the integer to a string?
 */
public class _9 {
    public boolean isPalindrome(int x) {
        String reversedStr = (new StringBuilder(x + "")).reverse().toString();
        return (x + "").equals(reversedStr);
    }

    public boolean isPalindrome2(int x) {
        if (x < 0)
            return false;

        int div = 1;

        while (x / div >= 10)
            div *= 10;

        while (x > 0) {
            int left = x/ div;
            int right = x % 10;
            if (left != right) {
                return false;
            }
            x = (x % div) / 10;
            div /= 100;
        }
        return true;
    }

    public boolean isPalindrome3(int x) {
        // negative and 10 times numbers is not a palindrome
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }

        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x = x / 10;
        }

        return (x == revertedNumber || x == revertedNumber / 10);
    }
}
