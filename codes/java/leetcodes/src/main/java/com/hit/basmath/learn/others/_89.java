package com.hit.basmath.learn.others;

import java.util.ArrayList;
import java.util.List;

/**
 * 89. Gray Code
 * <p>
 * The gray code is a binary numeral system where two successive values differ in only one bit.
 * <p>
 * Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.
 * <p>
 * Example 1:
 * <p>
 * Input: 2
 * Output: [0,1,3,2]
 * <p>
 * Explanation:
 * <p>
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 * <p>
 * For a given n, a gray code sequence may not be uniquely defined.
 * For example, [0,2,3,1] is also a valid gray code sequence.
 * <p>
 * 00 - 0
 * 10 - 2
 * 11 - 3
 * 01 - 1
 * <p>
 * Example 2:
 * <p>
 * Input: 0
 * Output: [0]
 * <p>
 * Explanation: We define the gray code sequence to begin with 0.
 * A gray code sequence of n has size = 2^n, which for n = 0 the size is 2^0 = 1.
 * Therefore, for n = 0 the gray code sequence is [0].
 */
public class _89 {
    public List<Integer> grayCode(int n) {
        List<Integer> gray = new ArrayList<Integer>();
        //初始化 n = 0 的解
        gray.add(0);
        for (int i = 0; i < n; i++) {
            int add = 1 << i; //要加的数
            //倒序遍历，并且将上一个值添加到结果中
            for (int j = gray.size() - 1; j >= 0; j--) {
                gray.add(gray.get(j) + add);
            }
        }
        return gray;
    }
}
