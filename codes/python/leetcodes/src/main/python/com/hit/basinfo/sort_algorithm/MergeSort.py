"""
 author: Charies Gavin
 date: 11/12/19,10:31 AM
 https:github.com/guobinhit
 description: Merge Sort
"""


def merge_sort(nums):
    sort_array(nums, 0, len(nums) - 1)


def sort_array(nums, left, right):
    if left == right:
        return

    sortSize = right - left + 1

    if sortSize % 2 == 0:
        separate = left + sortSize // 2 - 1
    else:
        separate = left + sortSize // 2

    sort_array(nums, left, separate)
    sort_array(nums, separate + 1, right)

    merge_array(nums, left, separate, right)


def merge_array(nums, left, separate, right):
    totalSize = right - left + 1
    size1 = separate - left + 1
    size2 = right - separate

    arr1 = []
    arr2 = []

    for i in range(size1):
        arr1.append(nums[left + i])

    for i in range(size2):
        arr2.append(nums[separate + 1 + i])

    mergeCount = 0
    index1 = 0
    index2 = 0

    while mergeCount < totalSize:
        if index1 == size1:
            i = index2
            while i < size2:
                nums[left + mergeCount] = arr2[i]
                mergeCount += 1
                index2 += 1
                i += 1
        elif index2 == size2:
            i = index1
            while i < size1:
                nums[left + mergeCount] = arr1[i]
                mergeCount += 1
                index1 += 1
                i += 1
        else:
            value1 = arr1[index1]
            value2 = arr2[index2]

            if value1 == value2:
                nums[left + mergeCount] = value1
                nums[left + mergeCount + 1] = value1
                mergeCount += 2
                index1 += 1
                index2 += 1
            elif value1 < value2:
                nums[left + mergeCount] = value1
                mergeCount += 1
                index1 += 1
            else:
                nums[left + mergeCount] = value2
                mergeCount += 1
                index2 += 1
