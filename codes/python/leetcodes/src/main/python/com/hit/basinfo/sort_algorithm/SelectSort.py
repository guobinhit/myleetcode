"""
 author: Charies Gavin
 date: 11/11/19,11:20 AM
 https:github.com/guobinhit
 description: Select Sort
"""


def select_sort(nums):
    if len(nums) < 2:
        return

    maxIndex = len(nums) - 1

    while maxIndex > 0:
        pause = maxIndex
        for i in range(maxIndex):
            if nums[maxIndex] < nums[i]:
                maxIndex = i

        if maxIndex != pause:
            temp = nums[maxIndex]
            nums[maxIndex] = nums[pause]
            nums[pause] = temp

        maxIndex = pause - 1
