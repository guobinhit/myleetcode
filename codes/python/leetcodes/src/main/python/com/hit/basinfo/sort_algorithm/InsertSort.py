"""
 author: Charies Gavin
 date: 11/11/19,2:50 PM
 https:github.com/guobinhit
 description: Insert Sort
"""


def insert_sort(nums):
    if len(nums) < 2:
        return

    length = 0

    while length < len(nums):
        innerLength = length
        while innerLength > 0:
            if nums[innerLength] < nums[innerLength - 1]:
                temp = nums[innerLength]
                nums[innerLength] = nums[innerLength - 1]
                nums[innerLength - 1] = temp
            else:
                break

            innerLength = innerLength - 1

        length = length + 1
