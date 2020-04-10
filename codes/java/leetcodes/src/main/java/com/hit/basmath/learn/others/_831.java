package com.hit.basmath.learn.others;

/**
 * 831. Masking Personal Information
 * <p>
 * We are given a personal information string S, which may represent either an email address or a phone number.
 * <p>
 * We would like to mask this personal information according to the following rules:
 * <p>
 * 1. Email address:
 * <p>
 * We define a name to be a string of length ≥ 2 consisting of only lowercase letters a-z or uppercase letters A-Z.
 * <p>
 * An email address starts with a name, followed by the symbol '@', followed by a name, followed by the dot '.' and followed by a name.
 * <p>
 * All email addresses are guaranteed to be valid and in the format of "name1@name2.name3".
 * <p>
 * To mask an email, all names must be converted to lowercase and all letters between the first and last letter of the first name must be replaced by 5 asterisks '*'.
 * <p>
 * 2. Phone number:
 * <p>
 * A phone number is a string consisting of only the digits 0-9 or the characters from the set {'+', '-', '(', ')', ' '}. You may assume a phone number contains 10 to 13 digits.
 * <p>
 * The last 10 digits make up the local number, while the digits before those make up the country code. Note that the country code is optional. We want to expose only the last 4 digits and mask all other digits.
 * <p>
 * The local number should be formatted and masked as "***-***-1111", where 1 represents the exposed digits.
 * <p>
 * To mask a phone number with country code like "+111 111 111 1111", we write it in the form "+***-***-***-1111".  The '+' sign and the first '-' sign before the local number should only exist if there is a country code.  For example, a 12 digit phone number mask should start with "+**-".
 * <p>
 * Note that extraneous characters like "(", ")", " ", as well as extra dashes or plus signs not part of the above formatting scheme should be removed.
 * <p>
 * Return the correct "mask" of the information provided.
 * <p>
 * Example 1:
 * <p>
 * Input: "LeetCode@LeetCode.com"
 * Output: "l*****e@leetcode.com"
 * Explanation: All names are converted to lowercase, and the letters between the
 * first and last letter of the first name is replaced by 5 asterisks.
 * Therefore, "leetcode" -> "l*****e".
 * <p>
 * Example 2:
 * <p>
 * Input: "AB@qq.com"
 * Output: "a*****b@qq.com"
 * Explanation: There must be 5 asterisks between the first and last letter
 * of the first name "ab". Therefore, "ab" -> "a*****b".
 * <p>
 * Example 3:
 * <p>
 * Input: "1(234)567-890"
 * Output: "***-***-7890"
 * Explanation: 10 digits in the phone number, which means all digits make up the local number.
 * <p>
 * Example 4:
 * <p>
 * Input: "86-(10)12345678"
 * Output: "+**-***-***-5678"
 * Explanation: 12 digits, 2 digits for country code and 10 digits for local number.
 * <p>
 * Notes:
 * <p>
 * S.length <= 40.
 * Emails have length at least 8.
 * Phone numbers have length at least 10.
 */
public class _831 {
    public String maskPII(String S) {
        S = S.toLowerCase();
        StringBuilder str = null;
        int index = S.indexOf('@');
        if (index != -1) {
            str = new StringBuilder(S);
            str.replace(1, index - 1, "*****");
        } else {
            str = new StringBuilder();
            for (char ch : S.toCharArray()) {
                int d = ch - '0';
                if (d >= 0 && d <= 9) {
                    str.append(ch);
                }
            }
            if (str.length() > 10) {
                if (str.length() == 11) {
                    str.replace(0, str.length() - 4, "+*-***-***-");
                } else if (str.length() == 12) {
                    str.replace(0, str.length() - 4, "+**-***-***-");
                } else if (str.length() == 13) {
                    str.replace(0, str.length() - 4, "+***-***-***-");
                }
            } else {
                str.replace(0, str.length() - 4, "***-***-");
            }
        }
        return str.toString();
    }
}
