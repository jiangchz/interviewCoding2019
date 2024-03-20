package leetcode.prefixSum;

/**
 *  https://leetcode.com/problems/range-sum-query-2d-mutable/
 *
 *  Trick1: 2 way to do prefix sum
 *          Sum(i - j) = Sum(0 - j) - Sum(0 - i) + val(i)
 *
 *    Or    Sum(i - j) = Sum(0 - j) - previousValue
 *          previousValue =  i == 0 ? 0 :  Sum(0 - (i - 1))
 *
 *  trick2: calculate current value and base on the diff to update remaining part
 */
public class Range_Sum_Query_2D_LC308 {
    private int[][] prefixMatrix;

    public Range_Sum_Query_2D_LC308(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {//bug
            return;
        }

        prefixMatrix = new int[matrix.length][matrix[0].length];

        //initialize prefix matrix
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < prefixMatrix[0].length; j++) {
                if (j == 0) {
                    prefixMatrix[i][j] = matrix[i][j];
                } else {
                    prefixMatrix[i][j] = matrix[i][j] + prefixMatrix[i][j - 1];
                }
            }
        }

    }

    public void update(int row, int col, int val) {
        //calculate previous value (!trick2 to calculate current value and base on the diff to update remaining part )
        int previousValue = col == 0 ? prefixMatrix[row][col] : prefixMatrix[row][col] - prefixMatrix[row][col - 1];
        int diff = val - previousValue;

        //update the following values on the same row
        for (int j = col; j < prefixMatrix[0].length; j++) {
            prefixMatrix[row][j] += diff;
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int total = 0;
        for (int rowNum = row1; rowNum <= row2; rowNum++) {
            int previousValue = col1 == 0 ? 0 : prefixMatrix[rowNum][col1 - 1];
            int rowSum = prefixMatrix[rowNum][col2] - previousValue;
            total += rowSum;
        }
        return total;
    }
}




/*
Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).

Range Sum Query 2D
The above rectangle (with the red border) is defined by (row1, col1) = (2, 1) and (row2, col2) = (4, 3), which contains sum = 8.

Example:
Given matrix = [
  [3, 0, 1, 4, 2],
  [5, 6, 3, 2, 1],
  [1, 2, 0, 1, 5],
  [4, 1, 0, 1, 7],
  [1, 0, 3, 0, 5]
]

sumRegion(2, 1, 4, 3) -> 8
update(3, 2, 2)
sumRegion(2, 1, 4, 3) -> 10
Note:
The matrix is only modifiable by the update function.
You may assume the number of calls to update and sumRegion function is distributed evenly.
You may assume that row1 ≤ row2 and col1 ≤ col2.
 */