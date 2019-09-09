package com.hit.basmath.learn.others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 587. Erect the Fence
 * <p>
 * There are some trees, where each tree is represented by (x,y) coordinate in a two-dimensional garden. Your job is to fence the entire garden using the minimum length of rope as it is expensive. The garden is well fenced only if all the trees are enclosed. Your task is to help find the coordinates of trees which are exactly located on the fence perimeter.
 * <p>
 * Example 1:
 * <p>
 * Input: [[1,1],[2,2],[2,0],[2,4],[3,3],[4,2]]
 * Output: [[1,1],[2,0],[4,2],[3,3],[2,4]]
 * <p>
 * Example 2:
 * <p>
 * Input: [[1,2],[2,2],[4,2]]
 * Output: [[1,2],[2,2],[4,2]]
 * <p>
 * Note:
 * <p>
 * 1. All trees should be enclosed together. You cannot cut the rope to enclose trees that will separate them in more than one group.
 * 2. All input integers will range from 0 to 100.
 * 3. The garden has at least one tree.
 * 4. All coordinates are distinct.
 * 5. Input points have NO order. No order required for output.
 * 6. input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
 */
public class _587 {
    public int[][] outerTrees(int[][] points) {
        int[][] res = null;
        int n = points.length;
        List<int[]> list = new ArrayList<>();
        if (n < 4) return points;
        int l = 0;
        int p = 0, q = 0;
        for (int i = 0; i < n; i++) {
            if (points[i][0] < points[l][0]) {
                l = i;
            }
        }
        p = l;
        do {
            list.add(points[p]);
            q = (p + 1) % n;

            //find q which is the most counterclock point from p
            for (int i = 0; i < n; i++) {
                if (orient(points[p], points[i], points[q]) == 2) {
                    q = i;
                }
            }
            System.out.println("p is " + Arrays.toString(points[p]));
            System.out.println("q is " + Arrays.toString(points[q]));
            //add any points directly between p and q
            for (int i = 0; i < n; i++) {
                if (i != p && i != q && orient(points[p], points[i], points[q]) == 0 && onSeg(points[p], points[q], points[i])) {
                    list.add(points[i]);
                }
            }

            //switch main to q
            p = q;

        } while (p != l);
        //System.out.println(list.size());
        res = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    //if r is on seg p,q
    private boolean onSeg(int[] p, int[] q, int[] r) {
        return r[0] >= Math.min(p[0], q[0]) && r[0] <= Math.max(p[0], q[0]) && r[1] >= Math.min(p[1], q[1]) && r[1] <= Math.max(p[1], q[1]);
    }

    private int orient(int[] p, int[] q, int[] r) {
        int v = (q[1] - p[1]) * (r[0] - q[0]) - (r[1] - q[1]) * (q[0] - p[0]);
        if (v == 0) return 0;
        return v > 0 ? 1 : 2;
    }
}
