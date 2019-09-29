package com.hit.basmath.learn.others;

/**
 * 765. Couples Holding Hands
 * <p>
 * N couples sit in 2N seats arranged in a row and want to hold hands. We want to know the minimum number of swaps so that every couple is sitting side by side. A swap consists of choosing any two people, then they stand up and switch seats.
 * <p>
 * The people and seats are represented by an integer from 0 to 2N-1, the couples are numbered in order, the first couple being (0, 1), the second couple being (2, 3), and so on with the last couple being (2N-2, 2N-1).
 * <p>
 * The couples' initial seating is given by row[i] being the value of the person who is initially sitting in the i-th seat.
 * <p>
 * Example 1:
 * <p>
 * Input: row = [0, 2, 1, 3]
 * Output: 1
 * Explanation: We only need to swap the second (row[1]) and third (row[2]) person.
 * <p>
 * Example 2:
 * <p>
 * Input: row = [3, 2, 0, 1]
 * Output: 0
 * Explanation: All couples are already seated side by side.
 * <p>
 * Note:
 * <p>
 * 1. len(row) is even and in the range of [4, 60].
 * 2. row is guaranteed to be a permutation of 0...len(row)-1.
 */
public class _765 {
    public int minSwapsCouples(int[] row) {
        int n = row.length, count = 0;
        int[] map = new int[n];
        for (int i = 0; i < n; i++) {
            map[row[i]] = i;
        }
        //compare two, if not couple, swap the closer one
        for (int i = 0; i < n; i += 2) {
            int min = Math.min(row[i], row[i + 1]), max = Math.max(row[i], row[i + 1]);
            if (min % 2 != 0 || max - min != 1) {
                int index1 = row[i] % 2 == 0 ? map[row[i] + 1] : map[row[i] - 1];
                int index2 = row[i + 1] % 2 == 0 ? map[row[i + 1] + 1] : map[row[i + 1] - 1];
                if (index1 - 1 >= index2) {
                    map[row[i]] = index2;
                    map[row[index2]] = i;
                    swap(row, i, index2);
                } else {
                    map[row[i + 1]] = index1;
                    map[row[index1]] = i + 1;
                    swap(row, i + 1, index1);
                }
                count++;
            }
        }
        return count;
    }


    private void swap(int[] row, int i, int j) {
        int temp = row[i];
        row[i] = row[j];
        row[j] = temp;
    }
}
