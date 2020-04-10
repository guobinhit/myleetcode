"""
 author: Charies Gavin
 date: 11/8/19,3:12 PM
 https:github.com/guobinhit
 description: binary search
"""


# tips nums must be sorted
def binary_search(nums, target):
    if len(nums) == 0:
        return -1
    elif len(nums) < 2 and nums[0] != target:
        return -1

    left = 0
    right = len(nums) - 1

    while left <= right:
        mid = (left + right) // 2
        if nums[mid] == target:
            return mid
        elif nums[mid] > target:
            right = mid - 1
        else:
            left = mid + 1

    return -1
