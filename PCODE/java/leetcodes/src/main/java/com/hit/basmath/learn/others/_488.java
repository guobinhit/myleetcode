package com.hit.basmath.learn.others;

/**
 * 488. Zuma Game
 * <p>
 * Think about Zuma Game. You have a row of balls on the table, colored red(R), yellow(Y), blue(B), green(G), and white(W). You also have several balls in your hand.
 * <p>
 * Each time, you may choose a ball in your hand, and insert it into the row (including the leftmost place and rightmost place). Then, if there is a group of 3 or more balls in the same color touching, remove these balls. Keep doing this until no more balls can be removed.
 * <p>
 * Find the minimal balls you have to insert to remove all the balls on the table. If you cannot remove all the balls, output -1.
 * <p>
 * Examples:
 * <p>
 * Input: "WRRBBW", "RB"
 * Output: -1
 * Explanation: WRRBBW -> WRR[R]BBW -> WBBW -> WBB[B]W -> WW
 * <p>
 * Input: "WWRRBBWW", "WRBRW"
 * Output: 2
 * Explanation: WWRRBBWW -> WWRR[R]BBWW -> WWBBWW -> WWBB[B]WW -> WWWW -> empty
 * <p>
 * Input:"G", "GGGGG"
 * Output: 2
 * Explanation: G -> G[G] -> GG[G] -> empty
 * <p>
 * Input: "RBYYBBRRB", "YRBGB"
 * Output: 3
 * Explanation: RBYYBBRRB -> RBYY[Y]BBRRB -> RBBBRRB -> RRRB -> B -> B[B] -> BB[B] -> empty
 * <p>
 * Note:
 * <p>
 * 1. You may assume that the initial row of balls on the table won’t have any 3 or more consecutive balls with the same color.
 * 2. The number of balls on the table won't exceed 20, and the string represents these balls is called "board" in the input.
 * 3. The number of balls in your hand won't exceed 5, and the string represents these balls is called "hand" in the input.
 * 4. Both input strings will be non-empty and only contain characters 'R','Y','B','G','W'.
 */
public class _488 {
    private int MAXCOUNT = 6;   // the max balls you need will not exceed 6 since "The number of balls in your hand won't exceed 5"

    public int findMinStep(String board, String hand) {
        int[] handCount = new int[26];
        for (int i = 0; i < hand.length(); ++i) ++handCount[hand.charAt(i) - 'A'];
        int rs = helper(board + "#", handCount);  // append a "#" to avoid special process while j==board.length, make the code shorter.
        return rs == MAXCOUNT ? -1 : rs;
    }

    private int helper(String s, int[] h) {
        s = removeConsecutive(s);
        if (s.equals("#")) return 0;
        int rs = MAXCOUNT, need = 0;
        for (int i = 0, j = 0; j < s.length(); ++j) {
            if (s.charAt(j) == s.charAt(i)) continue;
            need = 3 - (j - i);     //balls need to remove current consecutive balls.
            if (h[s.charAt(i) - 'A'] >= need) {
                h[s.charAt(i) - 'A'] -= need;
                rs = Math.min(rs, need + helper(s.substring(0, i) + s.substring(j), h));
                h[s.charAt(i) - 'A'] += need;
            }
            i = j;
        }
        return rs;
    }

    //remove consecutive balls longer than 3
    private String removeConsecutive(String board) {
        for (int i = 0, j = 0; j < board.length(); ++j) {
            if (board.charAt(j) == board.charAt(i)) continue;
            if (j - i >= 3) return removeConsecutive(board.substring(0, i) + board.substring(j));
            else i = j;
        }
        return board;
    }
}
