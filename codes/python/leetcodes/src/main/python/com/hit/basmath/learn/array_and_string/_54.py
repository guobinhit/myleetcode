"""
54. Spiral Matrix

Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

Example 1:

Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output: [1,2,3,6,9,8,7,4,5]

Example 2:

Input:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
"""


class Solution(object):
    def spiralOrder(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: List[int]
        """
        targetList = []

        if len(matrix) == 0:
            return targetList

        rowBegin = 0
        rowEnd = len(matrix) - 1
        colBegin = 0
        colEnd = len(matrix[0]) - 1

        while rowBegin <= rowEnd and colBegin <= colEnd:
            i = colBegin
            while i <= colEnd:
                targetList.append(matrix[rowBegin][i])
                i += 1

            rowBegin += 1

            j = rowBegin
            while j <= rowEnd:
                targetList.append(matrix[j][colEnd])
                j += 1

            colEnd -= 1

            if rowBegin <= rowEnd:
                k = colEnd
                while k >= colBegin:
                    targetList.append(matrix[rowEnd][k])
                    k -= 1

            rowEnd -= 1

            if colBegin <= colEnd:
                m = rowEnd
                while m >= rowBegin:
                    targetList.append(matrix[m][colBegin])
                    m -= 1

            colBegin += 1

        return targetList
