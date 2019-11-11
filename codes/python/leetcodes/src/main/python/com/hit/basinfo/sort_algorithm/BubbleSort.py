"""
 author: Charies Gavin
 date: 11/11/19,10:40 AM
 https:github.com/guobinhit
 description: Bubble Sort
"""


def bubble_sort(nums):
    if len(nums) < 2:
        return

    for i in range(len(nums)):
        for j in range(0, len(nums) - i - 1):
            if nums[j] > nums[j + 1]:
                temp = nums[j]
                nums[j] = nums[j + 1]
                nums[j + 1] = temp
