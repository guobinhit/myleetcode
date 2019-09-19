package com.hit.basmath.learn.others;

/**
 * 709. To Lower Case
 * <p>
 * Implement function ToLowerCase() that has a string parameter str, and returns the same string in lowercase.
 * <p>
 * Example 1:
 * <p>
 * Input: "Hello"
 * Output: "hello"
 * <p>
 * Example 2:
 * <p>
 * Input: "here"
 * Output: "here"
 * <p>
 * Example 3:
 * <p>
 * Input: "LOVELY"
 * Output: "lovely"
 */
public class _709 {
    public String toLowerCase(String str) {
        char[] a = str.toCharArray();
        for (int i = 0; i < a.length; i++)
            if ('A' <= a[i] && a[i] <= 'Z')
                a[i] = (char) (a[i] - 'A' + 'a');
        return new String(a);
    }
}
