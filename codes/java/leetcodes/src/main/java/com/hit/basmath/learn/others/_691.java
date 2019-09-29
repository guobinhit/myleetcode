package com.hit.basmath.learn.others;

/**
 * 691. Stickers to Spell Word
 * <p>
 * We are given N different types of stickers. Each sticker has a lowercase English word on it.
 * <p>
 * You would like to spell out the given target string by cutting individual letters from your collection of stickers and rearranging them.
 * <p>
 * You can use each sticker more than once if you want, and you have infinite quantities of each sticker.
 * <p>
 * What is the minimum number of stickers that you need to spell out the target? If the task is impossible, return -1.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * <p>
 * ["with", "example", "science"], "thehat"
 * Output: 3
 * Explanation:
 * <p>
 * We can use 2 "with" stickers, and 1 "example" sticker.
 * After cutting and rearrange the letters of those stickers, we can form the target "thehat".
 * Also, this is the minimum number of stickers necessary to form the target string.
 * <p>
 * Example 2:
 * <p>
 * Input:
 * <p>
 * ["notice", "possible"], "basicbasic"
 * Output: -1
 * Explanation:
 * <p>
 * We can't form the target "basicbasic" from cutting letters from the given stickers.
 * <p>
 * Note:
 * <p>
 * stickers has length in the range [1, 50].
 * stickers consists of lowercase English words (without apostrophes).
 * target has length in the range [1, 15], and consists of lowercase English letters.
 * In all test cases, all words were chosen randomly from the 1000 most common US English words, and the target was chosen as a concatenation of two random words.
 * The time limit may be more challenging than usual. It is expected that a 50 sticker test case can be solved within 35ms on average.
 */
public class _691 {
    public int minStickers(String[] stickers, String target) {
        int n = target.length(), m = 1 << n; // if target has n chars, there will be m=2^n subset of characters in target
        int[] dp = new int[m];
        for (int i = 0; i < m; i++)
            dp[i] = Integer.MAX_VALUE; // use index 0 - 2^n as bitmaps to represent each subset of all chars in target
        dp[0] = 0; // first thing we know is : dp[empty set] requires 0 stickers,
        for (int i = 0; i < m; i++) { // for every subset i, start from 000...000
            if (dp[i] == Integer.MAX_VALUE) continue;
            for (String s : stickers) { // try use each sticker as an char provider to populate 1 of its superset, to do that:
                int sup = i;
                for (char c : s.toCharArray()) { // for each char in the sticker, try apply it on a missing char in the subset of target
                    for (int r = 0; r < n; r++) {
                        if (target.charAt(r) == c && ((sup >> r) & 1) == 0) {
                            sup |= 1 << r;
                            break;
                        }
                    }
                }
                // after you apply all possible chars in a sticker, you get an superset that take 1 extra sticker than subset
                // would take, so you can try to update the superset's minsticker number with dp[sub]+1;
                dp[sup] = Math.min(dp[sup], dp[i] + 1);
            }
        }
        return dp[m - 1] != Integer.MAX_VALUE ? dp[m - 1] : -1;
    }
}
