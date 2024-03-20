package leetcode.dynamicPrograming;

public class LargestSquareOf1s {

    //不是特别优雅，因为在填边界的时候也要同时更新max，边界的时候可能包含max的解
    //dp[i, j] 是指以 i，j坐标为底点的最大正方形长度
    //可以改进到用1个for循环，添加if条件来判断
    public int maximalSquareV1(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int max = 0;
        for (int i = 0; i < m; i++) {
            dp[i][0] = matrix[i][0] - '0';
            max = Math.max(max, dp[i][0]);
        }

        for (int j = 0; j < n; j++) {
            dp[0][j] = matrix[0][j] - '0';
            max = Math.max(max, dp[0][j]);
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1;
                    max = Math.max(max, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return max * max;
    }

    //把第一个版本的3个for循环压缩到了1个
    public int maximalSquareV2(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int max = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = matrix[i][j] - '0';
                } else if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1;
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max * max;
    }

    //另外一种dp写法
    //dp[i][j]的物理意义是以第i个和第j个点为底的正方形的最大变长
    //dp[i][j] map to index i - 1, j - 1
    //这种做法的好处是处理边界点的时候不需要特殊对待
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
        int globalMax = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <=n; j++) {
                if (matrix[i - 1][j - 1] == 1) {
                    result[i][j] = Math.min(Math.min(result[i - 1][j - 1], result[i - 1][j]),
                            result[i][j - 1]) + 1;
                    globalMax = Math.max(result[i][j], globalMax);
                } else {
                    result[i][j] = 0;
                }
            }
        }
        return globalMax;
    }

    //迷之骚气写法
    public int largest2(int[][] matrix) {
        // Write your solution here.
        int max = 0;

        for (int i = 0; i < matrix.length; i ++) {
            for (int j = 0; j < matrix[0].length; j ++) {
                if(i != 0 && j != 0) {
                    matrix[i][j] = matrix[i][j] == 1 ? Math.min(Math.min(matrix[i-1][j-1], matrix[i-1][j]), matrix[i][j-1]) + 1 : 0;
                }
                max = Math.max(matrix[i][j], max);
            }
        }
        return max;
    }
}

