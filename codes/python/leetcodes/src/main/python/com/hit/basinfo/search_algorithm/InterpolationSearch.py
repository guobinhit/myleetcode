"""
 author: Charies Gavin
 date: 11/8/19,4:55 PM
 https:github.com/guobinhit
 description: Interpolation Search
"""


# tips nums must be sorted
def interpolation_search(nums, left, right, target):
    if left > right or target < nums[left] or target > nums[right]:
        return -1

    mid = left + (right - left) * (target - nums[left]) // (nums[right] - nums[left])

    if target > nums[mid]:
        interpolation_search(nums, mid + 1, right, target)
    elif target < nums[mid]:
        interpolation_search(nums, left, mid - 1, target)
    else:
        return mid
