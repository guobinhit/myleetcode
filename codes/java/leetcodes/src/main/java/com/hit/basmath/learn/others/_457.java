package com.hit.basmath.learn.others;

/**
 * 457. Circular Array Loop
 * <p>
 * You are given a circular array nums of positive and negative integers. If a number k at an index is positive, then move forward k steps. Conversely, if it's negative (-k), move backward k steps. Since the array is circular, you may assume that the last element's next element is the first element, and the first element's previous element is the last element.
 * <p>
 * Determine if there is a loop (or a cycle) in nums. A cycle must start and end at the same index and the cycle's length > 1. Furthermore, movements in a cycle must all follow a single direction. In other words, a cycle must not consist of both forward and backward movements.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [2,-1,1,2,2]
 * Output: true
 * Explanation: There is a cycle, from index 0 -> 2 -> 3 -> 0. The cycle's length is 3.
 * <p>
 * Example 2:
 * <p>
 * Input: [-1,2]
 * Output: false
 * Explanation: The movement from index 1 -> 1 -> 1 ... is not a cycle, because the cycle's length is 1. By definition the cycle's length must be greater than 1.
 * <p>
 * Example 3:
 * <p>
 * Input: [-2,1,-1,-2,-2]
 * Output: false
 * Explanation: The movement from index 1 -> 2 -> 1 -> ... is not a cycle, because movement from index 1 -> 2 is a forward movement, but movement from index 2 -> 1 is a backward movement. All movements in a cycle must follow a single direction.
 * <p>
 * Note:
 * <p>
 * 1. -1000 ≤ nums[i] ≤ 1000
 * 2. nums[i] ≠ 0
 * 3. 1 ≤ nums.length ≤ 5000
 * <p>
 * Follow up:
 * <p>
 * Could you solve it in O(n) time complexity and O(1) extra space complexity?
 */
public class _457 {
    public boolean circularArrayLoop(int[] a) {
        if (checkLoop(a)) {
            return true;
        }

        reverseAndNegate(a);
        return checkLoop(a);

    }

    private boolean checkLoop(int[] a) {
        int n = a.length;
        int jumps[] = new int[n];

        for (int k = 0; k < 2; k++) {
            for (int i = n - 1; i >= 0; i--) {
                int j = (i + a[i]) % n;
                if (a[i] <= 0 || a[j] < 0 || jumps[j] < 0) {
                    jumps[i] = -1;
                    continue;
                }

                jumps[i] = a[i] + jumps[j];
            }
        }
        for (int i = 0; i < n; i++) {
            if (a[i] % n != 0 && jumps[i] % n == 0) {
                return true;
            }
        }

        return false;
    }

    private void reverseAndNegate(int a[]) {
        int i = 0;
        int j = a.length - 1;

        while (i < j) {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;

            a[i] = -a[i];
            a[j] = -a[j];

            i += 1;
            j -= 1;
        }
        if (i == j && i >= 0 && i < a.length) {
            a[i] = -a[i];
        }
    }
}
