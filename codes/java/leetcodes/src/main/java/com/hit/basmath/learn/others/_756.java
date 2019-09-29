package com.hit.basmath.learn.others;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 756. Pyramid Transition Matrix
 * <p>
 * We are stacking blocks to form a pyramid. Each block has a color which is a one letter string.
 * <p>
 * We are allowed to place any color block C on top of two adjacent blocks of colors A and B, if and only if ABC is an allowed triple.
 * <p>
 * We start with a bottom row of bottom, represented as a single string. We also start with a list of allowed triples allowed. Each allowed triple is represented as a string of length 3.
 * <p>
 * Return true if we can build the pyramid all the way to the top, otherwise false.
 * <p>
 * Example 1:
 * <p>
 * Input: bottom = "BCD", allowed = ["BCG", "CDE", "GEA", "FFF"]
 * Output: true
 * Explanation:
 * We can stack the pyramid like this:
 * A
 * / \
 * G   E
 * / \ / \
 * B   C   D
 * <p>
 * We are allowed to place G on top of B and C because BCG is an allowed triple.  Similarly, we can place E on top of C and D, then A on top of G and E.
 * <p>
 * Example 2:
 * <p>
 * Input: bottom = "AABA", allowed = ["AAA", "AAB", "ABA", "ABB", "BAC"]
 * Output: false
 * Explanation:
 * We can't stack the pyramid to the top.
 * Note that there could be allowed triples (A, B, C) and (A, B, D) with C != D.
 * <p>
 * Note:
 * <p>
 * 1. bottom will be a string with length in range [2, 8].
 * 2. allowed will have length in range [0, 200].
 * 3. Letters in all strings will be chosen from the set {'A', 'B', 'C', 'D', 'E', 'F', 'G'}.
 */
public class _756 {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : allowed) {
            String key = s.substring(0, 2);
            if (!map.containsKey(key)) map.put(key, new ArrayList<String>());
            map.get(key).add(s.substring(2));
        }

        return helper(bottom, map);
    }

    private boolean helper(String bottom, Map<String, List<String>> map) {
        if (bottom.length() == 1) return true;
        for (int i = 0; i < bottom.length() - 1; i++) {
            if (!map.containsKey(bottom.substring(i, i + 2))) return false;
        }
        List<String> ls = new ArrayList<>();
        getList(bottom, 0, new StringBuilder(), ls, map);
        for (String s : ls) {
            if (helper(s, map)) return true;
        }
        return false;
    }

    private void getList(String bottom, int idx, StringBuilder sb, List<String> ls, Map<String, List<String>> map) {
        if (idx == bottom.length() - 1) {
            ls.add(sb.toString());
            return;
        }
        for (String s : map.get(bottom.substring(idx, idx + 2))) {
            sb.append(s);
            getList(bottom, idx + 1, sb, ls, map);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
