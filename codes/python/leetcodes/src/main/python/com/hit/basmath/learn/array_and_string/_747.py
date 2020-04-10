"""
747. Largest Number At Least Twice of Others

In a given integer array nums, there is always exactly one largest element.

Find whether the largest element in the array is at least twice as much as every other number in the array.

If it is, return the index of the largest element, otherwise return -1.

Example 1:

Input: nums = [3, 6, 1, 0]
Output: 1
Explanation: 6 is the largest integer, and for every other number in the array x,
6 is more than twice as big as x.  The index of value 6 is 1, so we return 1.

Example 2:

Input: nums = [1, 2, 3, 4]
Output: -1
Explanation: 4 isn't at least as big as twice the value of 3, so we return -1.

Note:

1. nums will have a length in the range [1, 50].
2. Every nums[i] will be an integer in the range [0, 99].
"""
import sys


class Solution(object):
    def dominantIndex(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) == 0:
            return -1
        elif len(nums) == 1:
            return 0

        maxValue = (- sys.maxint) + 1
        maxValueIndex = 0
        secondMaxValue = - sys.maxint

        i = 0
        while i < len(nums):
            if nums[i] > maxValue:
                secondMaxValue = maxValue
                maxValue = nums[i]
                maxValueIndex = i
            elif nums[i] != maxValue and secondMaxValue < nums[i]:
                secondMaxValue = nums[i]

            i += 1

        if secondMaxValue * 2 <= maxValue:
            return maxValueIndex
        else:
            return -1
