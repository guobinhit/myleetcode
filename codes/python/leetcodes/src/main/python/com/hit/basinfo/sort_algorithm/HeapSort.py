"""
 author: Charies Gavin
 date: 11/12/19,11:01 AM
 https:github.com/guobinhit
 description: Heap Sort
"""


def heap_sort(nums):
    heap_sort_by_type(nums, "MaxHeap")


def heap_sort_by_type(nums, type):
    if len(nums) == 1:
        return

    build_heap(nums, type)

    i = len(nums) - 1
    while i >= 1:
        swap_element_in_array(nums, 0, i)

        if type == "MaxHeap":
            max_heap(nums, i, 0)
        elif type == "MinHeap":
            min_heap(nums, i, 0)
        else:
            raise RuntimeError("heap type must be one of MaxHeap or MinHeap")
        i -= 1


def build_heap(nums, type):
    if len(nums) == 1:
        return

    cursor = len(nums) // 2

    i = cursor
    while i >= 0:
        if type == "MaxHeap":
            max_heap(nums, len(nums), i)
        elif type == "MinHeap":
            min_heap(nums, len(nums), i)
        else:
            raise RuntimeError("heap type must be one of MaxHeap or MinHeap")
        i -= 1


def max_heap(nums, heapSize, index):
    left = index * 2 + 1
    right = index * 2 + 2
    maxValue = index

    if right < heapSize and nums[left] > nums[maxValue]:
        maxValue = left

    if right < heapSize and nums[right] > nums[maxValue]:
        maxValue = right

    if maxValue != index:
        swap_element_in_array(nums, index, maxValue)
        max_heap(nums, heapSize, maxValue)


def min_heap(nums, heapSize, index):
    left = index * 2 + 1
    right = index * 2 + 2
    minValue = index

    if left < heapSize and nums[left] < nums[minValue]:
        minValue = left

    if right < heapSize and nums[right] < nums[minValue]:
        minValue = right

    if minValue != index:
        swap_element_in_array(nums, index, minValue)
        min_heap(nums, heapSize, minValue)


def swap_element_in_array(nums, left, right):
    temp = nums[left]
    nums[left] = nums[right]
    nums[right] = temp
