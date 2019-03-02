package dynamicPrograming;

public class LargestSquareOf1s {
    public int largest(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] result = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            result[i][0] = 0;
        }
        for (int i = 0; i <= n; i++) {
            result[0][i] = 0;
        }
        int gobalMax = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <=n; j++) {
                if (matrix[i - 1][j - 1] == 1) {
                    result[i][j] = Math.min(Math.min(result[i - 1][j - 1], result[i - 1][j]),
                            result[i][j - 1]) + 1;
                    gobalMax = Math.max(result[i][j], gobalMax);
                } else {
                    result[i][j] = 0;
                }
            }
        }
        return gobalMax;
    }
}

