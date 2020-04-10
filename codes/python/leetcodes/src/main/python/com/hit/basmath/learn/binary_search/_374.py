"""
374. Guess Number Higher or Lower

We are playing the Guess Game. The game is as follows:

I pick a number from 1 to n. You have to guess which number I picked.

Every time you guess wrong, I'll tell you whether the number is higher or lower.

You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):

-1 : My number is lower
 1 : My number is higher
 0 : Congrats! You got it!

Example :

Input: n = 10, pick = 6
Output: 6
"""


def guessNumber(n):
    left = 0
    right = n
    while left <= right:
        mid = (left + right) // 2
        """ wirte as Solution.guess way is in order to defend error tips """
        cmp = guess(mid)

        if cmp == 0:
            return mid
        elif cmp == 1:
            left = mid + 1
        else:
            right = mid - 1
    return -1


""" Below function is not real guess """


def guess(num):
    return 1
