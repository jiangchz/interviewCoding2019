package leetcode.dynamicPrograming;

public class LargestSubMatrixSum {
    //Method 0: O(n^6) brute force
    public static int LargestSubMatrixSum0(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int gobalMax = Integer.MIN_VALUE;

        //emulate all possible squres
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = i; k < m; k++) {
                    for (int l = j; l < n; l++) {
                        gobalMax = Math.max(gobalMax, getSubMatrixSum0(matrix, i, j, k ,l));
                    }
                }
            }
        }
        return gobalMax;
    }
    private static int getSubMatrixSum0(int[][] matrix, int row1, int col1, int row2, int col2) {
        int current = 0;
        for (int i = row1; i <= row2; i++) {
            for (int j = col1; j <= col2; j++) {
                current += matrix[i][j];
            }
        }
        return current;
    }


    //Method1 : 1 dimensional dp O(N^5)
    public int LargestSubMatrixSum1(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int gobalMax = Integer.MIN_VALUE;

        //pre-processing to store leetcode.prefixSum
        int[][] prefixSum = getPrefixSum(matrix, m, n);

        //emulate all possible squares
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = i; k < m; k++) {
                    for (int l = j; l < n; l++) {
                        gobalMax = Math.max(gobalMax,
                                getSubMatrixSum1(matrix, prefixSum, new Point(i, j), new Point(k, l)));
                    }
                }
            }
        }
        return gobalMax;
    }

    private static int[][] getPrefixSum(int[][] matrix, int m, int n) {
        int[][] result = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                   if (j != 0) {
                       result[i][j] = result[i][j - 1] + matrix[i][j];
                   } else {
                       result[i][j] = matrix[i][j];
                   }
            }
        }
        return result;
    }

    private static int getSubMatrixSum1(int[][] matrix,
                                        int[][] prefixSum,
                                        Point point1,
                                        Point point2) {
        int current = 0;
        for (int i = point1.x; i <= point2.x; i++) {
                current += (prefixSum[i][point2.y] - prefixSum[i][point1.y] + matrix[i][point1.y]);
        }
        return current;
    }

    //Method2 : 2 dimensional dp O(N^4)
    public int LargestSubMatrixSum2(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int gobalMax = Integer.MIN_VALUE;

        //pre-processing to store leetcode.prefixSum
        int[][] prefixSum = getPrefixSum2D(matrix, m, n);

        //emulate all possible squares
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = i; k < m; k++) {
                    for (int l = j; l < n; l++) {
                        gobalMax = Math.max(gobalMax,
                                getSubMatrixSum2(prefixSum, new Point(i, j), new Point(k, l)));
                    }
                }
            }
        }
        return gobalMax;
    }

    private int getSubMatrixSum2(int[][] prefixSum, Point point1, Point point2) {
        return prefixSum[point2.x] [point2.y] - getNumber(prefixSum, point1.x -1, point2.y)
                - getNumber(prefixSum , point2.x, point1.y - 1) + getNumber(prefixSum, point1.x - 1, point1.y - 1);
    }

    private int getNumber(int[][] prefixSum, int x, int y) {
        if (x < 0 || y < 0) {
            return 0;
        }
        return prefixSum[x][y];
    }


    private int[][] getPrefixSum2D(int[][] matrix, int m, int n) {
        int[][] result = new int[m][n];
        for (int i = 0; i < m; i++) {
            int currentRowSum = 0;
            for (int j = 0; j < n; j++) {
                currentRowSum += matrix[i][j];
                if (i != 0) {
                    result[i][j] = result[i - 1][j] + currentRowSum;
                } else {
                    result[i][j] = currentRowSum;
                }
            }
        }
        return result;
    }

    //method 3: 3 dimensional dp
    public int LargestSubMatrixSum3(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int gobalMax = Integer.MIN_VALUE;

        //pre-processing to store leetcode.prefixSum
        int[][] prefixSum = getPrefixSumForRows(matrix, m, n);

        //emulate all possible top & bottom line
        for (int top = 0; top < m; top++) {
            for (int bottom = top; bottom < m; bottom++) {
                gobalMax = Math.max(gobalMax,
                        getMaxSubMatrix(matrix, prefixSum, top, bottom));

            }
        }
        return gobalMax;
    }

    private int getMaxSubMatrix(int[][] matrix, int[][] prefixSum, int top, int bottom) {
        int max = Integer.MIN_VALUE;
        int currentSum = 0;
        for (int i = 0; i < matrix[0].length; i++) {
            int current = prefixSum[bottom][i] - prefixSum[top][i] + matrix[top][i];
            if (currentSum >= 0) {
                currentSum += current;
            } else {
                currentSum = current;
            }
            max = Math.max(currentSum, max);
        }
        return max;
    }

    private int[][] getPrefixSumForRows(int[][] matrix, int m, int n) {
        int[][] result = new int[m][n];
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                    result[i][j] = getNumber(result, i  - 1, j ) + matrix[i][j];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] input = new int[2][2];
        input[0][0] = 0;
        input[1][0] = 5;
        input[0][1] = -1;
        input[1][1] = 3;

        LargestSubMatrixSum largestSubMatrixSum = new LargestSubMatrixSum();
        System.out.println(largestSubMatrixSum.LargestSubMatrixSum3(input));
    }

    class Point{
        public final int x;
        public final int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
