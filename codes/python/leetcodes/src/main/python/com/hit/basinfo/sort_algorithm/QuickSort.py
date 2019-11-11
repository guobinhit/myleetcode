"""
 author: Charies Gavin
 date: 11/11/19,3:19 PM
 https:github.com/guobinhit
 description: Quick Sort
"""


def quick_sort(nums):
    if len(nums) < 2:
        return

    left = 0
    right = len(nums) - 1

    inner_quick_sort(nums, left, right)


def inner_quick_sort(nums, left, right):
    if len(nums) < 2:
        return

    index = partition(nums, left, right)

    if left < index - 1:
        inner_quick_sort(nums, left, index - 1)

    if right > index:
        inner_quick_sort(nums, index, right)


def partition(nums, left, right):
    pivot = nums[(left + right) // 2]

    while left <= right:
        while nums[left] < pivot:
            left = left + 1

        while nums[right] > pivot:
            right = right - 1

        if left <= right:
            temp = nums[right]
            nums[right] = nums[left]
            nums[left] = temp

            left = left + 1
            right = right - 1

    return left
