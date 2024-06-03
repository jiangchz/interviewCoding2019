package leetcode.Grid2D;

public class DiagonalTraverse {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[] {};
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[] result = new int[m * n];
        int x = 0;
        int y = 0;
        int flag = 0;
        int[][] directions = {{-1, 1}, {1, -1}}; //upright, leftDown

        for (int i = 0; i < m * n; i++) {
            result[i] = matrix[x][y];
            x += directions[flag][0];
            y += directions[flag][1];

            //hit the buttom boundary, move it to down, down right end
            if (x >= m) {
                x = m - 1; //buttom end
                y += 2; //right, right
                flag = flipFlag(flag);
            }

            //hit the right boundary, move it to down, down right end
            if (y >= n) {
                x += 2; //down down
                y = n - 1; //right end
                flag = flipFlag(flag);
            }

            //hit the top boundary, we need to move it back to first line
            if (x < 0) {
                x = 0;
                flag = flipFlag(flag);
            }

            //hit the left boundary, we need to move it back to first row
            if (y < 0) {
                y = 0;
                flag = flipFlag(flag);
            }
        }
        return result;

    }

    //flipFlag between 1 and 0
    private int flipFlag(int flag) {
        return 1 - flag;
    }
}

/**
 * Given an m x n matrix mat, return an array of all the elements of the array in a diagonal order.
 * Example 1:
 *
 *
 * Input: mat = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,2,4,7,5,3,6,8,9]
 * Example 2:
 *
 * Input: mat = [[1,2],[3,4]]
 * Output: [1,2,3,4]
 */
