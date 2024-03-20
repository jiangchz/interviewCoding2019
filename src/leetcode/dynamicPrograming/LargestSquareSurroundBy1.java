package leetcode.dynamicPrograming;
/*

在由0/1组成的二维数组里找最大的由1围绕的正方形。
 */

public class LargestSquareSurroundBy1 {
    public static void main(String[] args) {
        int[][] matrix = new int[5][5];
        matrix[0] = new int[]{1, 0, 1, 1, 1};
        matrix[1] = new int[]{1, 1, 1, 1, 1};
        matrix[2] = new int[]{1, 1, 0, 1, 0};
        matrix[3] = new int[]{1, 1, 1, 1, 1};
        matrix[4] = new int[]{1, 1, 1, 0, 0};
        System.out.println(findMaxMatrixLength(matrix));
    }
    private static int findMaxMatrixLength(int[][] matrix) {
        int[][] rightToLeft = rightToLeftScan(matrix);
        int[][] downToUp = downToUpScan(matrix);
        return searchMaxLength(matrix, rightToLeft, downToUp);
    }

    private static int searchMaxLength(int[][] matrix,
                                       int[][] rightToLeft,
                                       int[][] downToUp) {
        int max = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == 0) {
                    continue;
                }
                matrix[i][j] = 1;
                int length = Math.min(rightToLeft[i][j], downToUp[i][j]);
                for (int k = length; k > max; k--) {
                    if (rightToLeft[i + k - 1][j] >= k && downToUp[i][j + k - 1] >= k) {
                        max = k;
                    }
                }
            }
        }
        return max;
    }

    private static int[][] rightToLeftScan(int[][] matrix) {
        int[][] result = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = matrix[0].length - 1; j >= 0; j--) {
                if (j == matrix[0].length - 1) {
                    result[i][j] = matrix[i][j];
                } else if (matrix[i][j] == 0){
                    result[i][j] = 0;
                } else {
                    result[i][j] = result[i][j + 1] + 1;
                }
            }
        }
        return result;
    }

    private static int[][] downToUpScan(int[][] matrix) {
        int[][] result = new int[matrix.length][matrix[0].length];
        for (int j = 0; j < matrix[0].length; j++) {
            for (int i = matrix.length - 1; i >= 0; i--) {
                if (i == matrix.length - 1) {
                    result[i][j] = matrix[i][j];
                } else if (matrix[i][j] == 0){
                    result[i][j] = 0;
                } else {
                    result[i][j] = result[i + 1][j] + 1;
                }
            }
        }
        return result;
    }
}
