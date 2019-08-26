package com.hit.basmath.learn.others;

/**
 * 402. Remove K Digits
 * <p>
 * Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.
 * <p>
 * Note:
 * <p>
 * The length of num is less than 10002 and will be ≥ k.
 * The given num does not contain any leading zero.
 * <p>
 * Example 1:
 * <p>
 * Input: num = "1432219", k = 3
 * Output: "1219"
 * Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
 * <p>
 * Example 2:
 * <p>
 * Input: num = "10200", k = 1
 * Output: "200"
 * Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
 * <p>
 * Example 3:
 * <p>
 * Input: num = "10", k = 2
 * Output: "0"
 * Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 */
public class _402 {
    public String removeKdigits(String num, int k) {
        int remain = num.length() - k;
        char[] numArray = num.toCharArray(), res = new char[remain];
        int index = 0;
        for (int i = 0; i < numArray.length; i++) {
            // (1)  (n - i > remain - index): have enough remaining digits to be compared
            // (2)  (res[index - 1] > nums[i]): at this time, the (index-1) is the newest added digit,
            //      compare this digit with the current num, if the res is greater and you have enough
            //      remaining digits to be compared, decrease the index(it ensures that the future added digit is
            //      always smaller than before and the size is remain) until get the right and 'safe' position
            while ((numArray.length - i > remain - index) && (index > 0 && numArray[i] < res[index - 1])) index--;
            if (index < remain) res[index++] = numArray[i];
        }

        // check leading zeroes
        index = -1;
        while (++index < remain) {
            if (res[index] != '0') break;
        }
        String s = new String(res).substring(index);

        return s.length() == 0 ? "0" : s;
    }
}
