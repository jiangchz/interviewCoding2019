package leetcode.Grid2D;

public class IsToeplitzMatrix {
    public boolean isToeplitzMatrix(int[][] matrix) {
        //check if current value matches with the top left value
        for (int i = 1; i < matrix.length; i++){
            for (int j = 1; j <matrix[i].length; j++){
                if (matrix[i][j] != matrix[i-1][j-1]){
                    return false;
                }
            }
        }
        return true;
    }
}

/**
 * 检查是否对角线对称
 * Given an m x n matrix, return true if the matrix is Toeplitz. Otherwise, return false.
 *
 * A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same elements.
 */
