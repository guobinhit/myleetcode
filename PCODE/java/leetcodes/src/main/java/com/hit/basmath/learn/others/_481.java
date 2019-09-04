package com.hit.basmath.learn.others;

/**
 * 481. Magical String
 * <p>
 * A magical string S consists of only '1' and '2' and obeys the following rules:
 * <p>
 * The string S is magical because concatenating the number of contiguous occurrences of characters '1' and '2' generates the string S itself.
 * <p>
 * The first few elements of string S is the following: S = "1221121221221121122……"
 * <p>
 * If we group the consecutive '1's and '2's in S, it will be:
 * <p>
 * 1 22 11 2 1 22 1 22 11 2 11 22 ......
 * <p>
 * and the occurrences of '1's or '2's in each group are:
 * <p>
 * 1 2	2 1 1 2 1 2 2 1 2 2 ......
 * <p>
 * You can see that the occurrence sequence above is the S itself.
 * <p>
 * Given an integer N as input, return the number of '1's in the first N number in the magical string S.
 * <p>
 * Note: N will not exceed 100,000.
 * <p>
 * Example 1:
 * <p>
 * Input: 6
 * Output: 3
 * <p>
 * Explanation: The first 6 elements of magical string S is "12211" and it contains three 1's, so return 3.
 */
public class _481 {
    public int magicalString(int n) {
        if (n <= 0) return 0;
        if (n <= 3) return 1;

        int[] a = new int[n + 1];
        a[0] = 1;
        a[1] = 2;
        a[2] = 2;
        int head = 2, tail = 3, num = 1, result = 1;

        while (tail < n) {
            for (int i = 0; i < a[head]; i++) {
                a[tail] = num;
                if (num == 1 && tail < n) result++;
                tail++;
            }
            num = num ^ 3;
            head++;
        }

        return result;
    }
}
