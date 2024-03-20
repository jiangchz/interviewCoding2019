package leetcode.dynamicPrograming;

public class LongestCrossOf1s {
    public int largest(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        final int m = matrix.length;
        final int n = matrix[0].length;
        int[][] leftToRight = new int[m][n];
        int[][] rightToLeft = new int[m][n];
        int[][] upToDown = new int[m][n];
        int[][] downToUp = new int[m][n];

        leftToRightLinerScan(leftToRight, matrix);
        rightToLeftLinerScan(rightToLeft, matrix);
        upToDownLinerScan(upToDown, matrix);
        downToUpLinerScan(downToUp, matrix);

        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int currentMax = Math.min(
                        Math.min(leftToRight[i][j], rightToLeft[i][j]),
                        Math.min(upToDown[i][j], downToUp[i][j]));
                max = Math.max(max, currentMax);
            }
        }
        return max;
    }
    private static void leftToRightLinerScan(int[][] leftToRight, int [][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            int current = 0;
            for (int j = matrix[0].length - 1; j >= 0; j--) {
                current = matrix[i][j] == 0 ? 0 : current + 1;
                leftToRight[i][j] = current;
            }
        }
    }

    private static void rightToLeftLinerScan(int[][] RightToleft, int [][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            int current = 0;
            for (int j = 0; j < matrix[0].length; j++) {
                current = matrix[i][j] == 0 ? 0 : current + 1;
                RightToleft[i][j] = current;
            }

        }
    }
    private static void downToUpLinerScan(int[][] downToUp, int [][] matrix) {
        for (int i = 0; i < matrix[0].length; i++) {
            int current = 0;
            for (int j = 0; j < matrix.length; j++) {
                current = matrix[j][i] == 0 ? 0 : current + 1;
                downToUp[j][i] = current;
            }
        }
    }
    private static void upToDownLinerScan(int[][] upToDown, int [][] matrix) {
        for (int i = 0; i < matrix[0].length; i++) {
            int current = 0;
            for (int j = matrix.length - 1; j >= 0; j--) {
                current = matrix[j][i] == 0 ? 0 : current + 1;
                upToDown[j][i] = current;
            }
        }
    }
}
