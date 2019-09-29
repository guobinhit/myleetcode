package com.hit.basmath.learn.trie;

/**
 * 421. Maximum XOR of Two Numbers in an Array
 * <p>
 * Given a non-empty array of numbers, a0, a1, a2, … , an-1, where 0 ≤ ai < 231.
 * <p>
 * Find the maximum result of ai XOR aj, where 0 ≤ i, j < n.
 * <p>
 * Could you do this in O(n) runtime?
 * <p>
 * Example:
 * <p>
 * Input: [3, 10, 5, 25, 2, 8]
 * <p>
 * Output: 28
 * <p>
 * Explanation: The maximum result is 5 ^ 25 = 28.
 */
public class _421 {
    class Trie {
        Trie[] children;

        Trie() {
            children = new Trie[2];
        }
    }

    public int findMaximumXOR(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // Init Trie.
        Trie root = new Trie();
        for (int num : nums) {
            Trie curNode = root;
            for (int i = 31; i >= 0; i--) {
                int curBit = (num >>> i) & 1;
                if (curNode.children[curBit] == null) {
                    curNode.children[curBit] = new Trie();
                }
                curNode = curNode.children[curBit];
            }
        }
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            Trie curNode = root;
            int curSum = 0;
            for (int i = 31; i >= 0; i--) {
                int curBit = (num >>> i) & 1;
                if (curNode.children[curBit ^ 1] != null) {
                    curSum += (1 << i);
                    curNode = curNode.children[curBit ^ 1];
                } else {
                    curNode = curNode.children[curBit];
                }
            }
            max = Math.max(curSum, max);
        }
        return max;
    }
}
