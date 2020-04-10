package com.hit.basmath.learn.others;

/**
 * 423. Reconstruct Original Digits from English
 * <p>
 * Given a non-empty string containing an out-of-order English representation of digits 0-9, output the digits in ascending order.
 * <p>
 * Note:
 * <p>
 * 1. Input contains only lowercase English letters.
 * 2. Input is guaranteed to be valid and can be transformed to its original digits. That means invalid inputs such as "abc" or "zerone" are not permitted.
 * 3. Input length is less than 50,000.
 * <p>
 * Example 1:
 * <p>
 * Input: "owoztneoer"
 * <p>
 * Output: "012"
 * <p>
 * Example 2:
 * <p>
 * Input: "fviefuro"
 * <p>
 * Output: "45"
 */
public class _423 {
    public String originalDigits(String s) {
        int[] table = new int[26];
        for (char c : s.toCharArray()) {
            table[c - 'a']++;
        }
        int[] temp = new int[10];
        char[] identifiers = new char[]{'z', 'w', 'u', 'f', 'o', 'x', 's', 'g', 't', 'i'};
        int[] indexes = new int[]{0, 2, 4, 5, 1, 6, 7, 8, 3, 9};
        String[] strs = new String[]{"zero", "two", "four", "five", "one", "six", "seven", "eight", "three", "nine"};
        for (int i = 0; i < 10; i++) {
            char iden = identifiers[i];
            int index = indexes[i];
            String str = strs[i];
            int fre = table[iden - 'a'];
            if (fre > 0) {
                temp[index] = fre;
                for (char c : str.toCharArray()) {
                    table[c - 'a'] -= fre;
                }
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < temp[i]; j++) {
                result.append(i);
            }
        }
        return result.toString();
    }
}
