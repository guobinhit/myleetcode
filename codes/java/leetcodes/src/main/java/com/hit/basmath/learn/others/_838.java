package com.hit.basmath.learn.others;

/**
 * 838. Push Dominoes
 * <p>
 * There are N dominoes in a line, and we place each domino vertically upright.
 * <p>
 * In the beginning, we simultaneously push some of the dominoes either to the left or to the right.
 * <p>
 * After each second, each domino that is falling to the left pushes the adjacent domino on the left.
 * <p>
 * Similarly, the dominoes falling to the right push their adjacent dominoes standing on the right.
 * <p>
 * When a vertical domino has dominoes falling on it from both sides, it stays still due to the balance of the forces.
 * <p>
 * For the purposes of this question, we will consider that a falling domino expends no additional force to a falling or already fallen domino.
 * <p>
 * Given a string "S" representing the initial state. S[i] = 'L', if the i-th domino has been pushed to the left; S[i] = 'R', if the i-th domino has been pushed to the right; S[i] = '.', if the i-th domino has not been pushed.
 * <p>
 * Return a string representing the final state.
 * <p>
 * Example 1:
 * <p>
 * Input: ".L.R...LR..L.."
 * Output: "LL.RR.LLRRLL.."
 * <p>
 * Example 2:
 * <p>
 * Input: "RR.L"
 * Output: "RR.L"
 * Explanation: The first domino expends no additional force on the second domino.
 * <p>
 * Note:
 * <p>
 * 0 <= N <= 10^5
 * String dominoes contains only 'L', 'R' and '.'
 */
public class _838 {
    public String pushDominoes(String dominoes) {
        char[] a = dominoes.toCharArray();
        int L = -1, R = -1;//positions of last seen L and R
        for (int i = 0; i <= dominoes.length(); i++)
            if (i == a.length || a[i] == 'R') {
                if (R > L)//R..R, turn all to R
                    while (R < i)
                        a[R++] = 'R';
                R = i;
            } else if (a[i] == 'L')
                if (L > R || (R == -1 && L == -1))//L..L, turn all to L
                    while (++L < i)
                        a[L] = 'L';
                else { //R...L
                    L = i;
                    int lo = R + 1, hi = L - 1;
                    while (lo < hi) { //one in the middle stays '.'
                        a[lo++] = 'R';
                        a[hi--] = 'L';
                    }
                }
        return new String(a);
    }
}
