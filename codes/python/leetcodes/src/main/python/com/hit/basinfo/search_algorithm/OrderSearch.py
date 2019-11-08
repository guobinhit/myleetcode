"""
 author: Charies Gavin
 date: 11/8/19,3:46 PM
 https:github.com/guobinhit
 description: Order Search
"""


def order_search(nums, target):
    if len(nums) == 0:
        return -1
    elif len(nums) < 2 and nums[0] != target:
        return -1

    index = 0
    while index < len(nums):
        if nums[index] == target:
            return index
        index += 1

    return -1


nums = [-1, 0, 1, 2, 3]
target = -1
print order_search(nums, target)
