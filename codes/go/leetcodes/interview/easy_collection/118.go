package easy_collection

/**
 * 118. Pascal's Triangle
 * <p>
 * Given numRows, generate the first numRows of Pascal's triangle.
 * <p>
 * For example, given numRows = 5, return
 * <p>
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 */

func generate(numRows int) [][]int {
	var triangle [][]int
	if numRows <= 0 {
		return triangle
	}
	for i := 0; i < numRows; i++ {
		var row []int
		for j := 0; j < i+1; j++ {
			if j == 0 || j == i {
				row = append(row, 1)
			} else {
				/**
				 * calculate element value:
				 *
				 * K(i)(j) = K(i-1)(j-1) + K(i-1)(j)
				 *
				 * except for the first and last element
				 */
				row = append(row, triangle[i-1][j-1]+triangle[i-1][j])
			}
		}
		triangle = append(triangle, row)
	}
	return triangle
}
