package com.hit.basmath.learn.others;

import java.util.Arrays;
import java.util.Stack;

/**
 * 757. Set Intersection Size At Least Two
 * <p>
 * An integer interval [a, b] (for integers a < b) is a set of all consecutive integers from a to b, including a and b.
 * <p>
 * Find the minimum size of a set S such that for every integer interval A in intervals, the intersection of S with A has size at least 2.
 * <p>
 * Example 1:
 * <p>
 * Input: intervals = [[1, 3], [1, 4], [2, 5], [3, 5]]
 * Output: 3
 * Explanation:
 * Consider the set S = {2, 3, 4}.  For each interval, there are at least 2 elements from S in the interval.
 * Also, there isn't a smaller size set that fulfills the above condition.
 * Thus, we output the size of this set, which is 3.
 * <p>
 * Example 2:
 * <p>
 * Input: intervals = [[1, 2], [2, 3], [2, 4], [4, 5]]
 * Output: 5
 * Explanation:
 * An example of a minimum sized set is {1, 2, 3, 4, 5}.
 * <p>
 * Note:
 * <p>
 * 1. intervals will have length in range [1, 3000].
 * 2. intervals[i] will have length 2, representing some integer interval.
 * 3. intervals[i][j] will be an integer in [0, 10^8].
 */
public class _757 {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> ((a[0] == b[0]) ? (-a[1] + b[1]) : (a[0] - b[0])));
        Stack<int[]> st = new Stack<>();
        for (int[] in : intervals) {
            while (!st.isEmpty() && st.peek()[1] >= in[1]) st.pop();
            st.push(in);
        }
        int n = st.size();
        int[][] a = new int[n][2];
        for (int i = n - 1; i >= 0; i--) {
            a[i][0] = st.peek()[0];
            a[i][1] = st.pop()[1];
        }
        int ans = 2;
        int p1 = a[0][1] - 1, p2 = a[0][1];
        for (int i = 1; i < n; i++) {
            boolean bo1 = (p1 >= a[i][0] && p1 <= a[i][1]), bo2 = (p2 >= a[i][0] && p2 <= a[i][1]);
            if (bo1 && bo2) continue;
            if (bo2) {
                p1 = p2;
                p2 = a[i][1];
                ans++;
                continue;
            }
            p1 = a[i][1] - 1;
            p2 = a[i][1];
            ans += 2;
        }
        return ans;
    }
}
