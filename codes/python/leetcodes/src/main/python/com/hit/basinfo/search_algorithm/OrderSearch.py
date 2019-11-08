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


def order_search_2(nums, target):
    if len(nums) == 0:
        return -1
    elif len(nums) < 2 and nums[0] != target:
        return -1

    nums2 = []
    for num in nums:
        nums2.append(num)

    nums2.append(target)

    index = 0
    while index < len(nums):
        if nums2[index] == target:
            break
        index += 1

    if index < len(nums):
        return index
    else:
        return -1
