"""
53. Maximum Subarray

Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Follow up:

If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
"""


def maxSubArray(self, nums):
    """
    :type nums: List[int]
    :rtype: int
    """
    numsLen = len(nums)
    dp = [nums[0]]
    maxSubSum = nums[0]

    i = 1
    while i < numsLen:
        if dp[i - 1] > 0:
            temp = dp[i - 1]
        else:
            temp = 0

        dp.append(nums[i] + temp)

        if maxSubSum < dp[i]:
            maxSubSum = dp[i]

        i += 1

    return maxSubSum
