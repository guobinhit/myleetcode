package com.hit.basmath.learn.others;

import java.util.LinkedList;
import java.util.List;

/**
 * 282. Expression Add Operators
 * <p>
 * Given a string that contains only digits 0-9 and a target value, return all possibilities to add binary operators (not unary) +, -, or * between the digits so they evaluate to the target value.
 * <p>
 * Example 1:
 * <p>
 * Input: num = "123", target = 6
 * Output: ["1+2+3", "1*2*3"]
 * <p>
 * Example 2:
 * <p>
 * Input: num = "232", target = 8
 * Output: ["2*3+2", "2+3*2"]
 * <p>
 * Example 3:
 * <p>
 * Input: num = "105", target = 5
 * Output: ["1*0+5","10-5"]
 * <p>
 * Example 4:
 * <p>
 * Input: num = "00", target = 0
 * Output: ["0+0", "0-0", "0*0"]
 * <p>
 * Example 5:
 * <p>
 * Input: num = "3456237490", target = 9191
 * Output: []
 */
public class _282 {
    public List<String> addOperators(String num, int target) {
        List<String> ret = new LinkedList<>();
        if (num.length() == 0) return ret;
        char[] path = new char[num.length() * 2 - 1];
        char[] digits = num.toCharArray();
        long n = 0;
        for (int i = 0; i < digits.length; i++) {
            n = n * 10 + digits[i] - '0';
            path[i] = digits[i];
            dfs(ret, path, i + 1, 0, n, digits, i + 1, target);
            if (n == 0) break;
        }
        return ret;
    }

    private void dfs(List<String> ret, char[] path, int len, long left, long cur, char[] digits, int pos, int target) {
        if (pos == digits.length) {
            if (left + cur == target) ret.add(new String(path, 0, len));
            return;
        }
        long n = 0;
        int j = len + 1;
        for (int i = pos; i < digits.length; i++) {
            n = n * 10 + digits[i] - '0';
            path[j++] = digits[i];
            path[len] = '+';
            dfs(ret, path, j, left + cur, n, digits, i + 1, target);
            path[len] = '-';
            dfs(ret, path, j, left + cur, -n, digits, i + 1, target);
            path[len] = '*';
            dfs(ret, path, j, left, cur * n, digits, i + 1, target);
            if (digits[pos] == '0') break;
        }
    }
}
