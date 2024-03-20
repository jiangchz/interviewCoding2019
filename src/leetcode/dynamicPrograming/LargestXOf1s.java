package leetcode.dynamicPrograming;

public class LargestXOf1s {
    public static int largest(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        final int m = matrix.length;
        final int n = matrix[0].length;
        int[][] leftUp = leftUpScan(matrix, m, n);
        int[][] rightDown = rightDownScan(matrix, m, n);
        leftUp = merge(leftUp, rightDown);

        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, leftUp[i][j]);
            }
        }
        return max;
    }

    private static int[][] merge(int[][] matrix1, int [][] matrix2) {
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                matrix1[i][j] = Math.min(matrix1[i][j],matrix2[i][j]);
            }
        }
        return matrix1;
    }

    private static int[][] leftUpScan(int[][] matrix, int m, int n) {
        int[][] left = new int[m][n];
        int[][] up = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] != 0) {
                    left[i][j] = getNumber(left, m, n, i - 1, j - 1) + 1;
                    up[i][j] = getNumber(up, m, n, i - 1, j + 1) + 1;
                }
            }
        }
        return merge(left, up);
    }

    private static int[][] rightDownScan(int[][] matrix, int m, int n) {
        int[][] right = new int[m][n];
        int[][] down = new int[m][n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >=0; j--) {
                if (matrix[i][j] != 0) {
                    right[i][j] = getNumber(right, m, n, i + 1, j + 1) + 1;
                    down[i][j] = getNumber(down, m, n, i + 1, j - 1) + 1;
                }
            }
        }
        return merge(right, down);
    }
    private static int getNumber(int[][] matrix, int m, int n, int i, int j) {
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return 0;
        }
        return matrix[i][j];
    }
}
