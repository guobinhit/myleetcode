package com.hit.basmath.interview.we_meet.huawei;

/**
 * @author Charies Gavin
 * @github https:github.com/guobinhit
 * @date 2020/3/2,下午3:11
 * @description
 */
public class MaxSubArray {
    public int subMaxArray(int[] nums) {
        int ans = 0, anchor = 1;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i - 1] < nums[i]) {
                ans = Math.max(ans, ++anchor);
            } else {
                anchor = 1;
            }
        }
        return ans;
    }
}
