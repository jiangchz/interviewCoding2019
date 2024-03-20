package leetcode.dynamicPrograming;

public class KnightProbabilityInChessBoard {
    public double knightProbability1(int N, int K, int r, int c) {
        // Use double because of overflow
        // dp[k][i][j] number of ways to move to (i, j) after k moves
        double[][] dp = new double[N][N];
        int[][] dirs = {{2, -1}, {2, 1}, {-2, 1}, {-2, -1}, {1, -2}, {1, 2}, {-1, 2}, {-1, -2}};
        dp[r][c] = 1;
        double count = 0;
        for (int k = 0; k < K; k++) {
            double[][] dp2 = new double[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    for (int[] dir: dirs) {
                        int x = i + dir[0];
                        int y = j + dir[1];
                        if (x < 0 || x >= N || y < 0 || y >= N) continue;
                        dp2[i][j] += dp[x][y];
                        // dp2[x][y] += dp[i][j]; also works
                    }
                }
            }
            dp = dp2;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                count += dp[i][j];
            }
        }
        return count / (Math.pow(8, K));
    }
}


/*

On an NxN chessboard, a knight starts at the r-th row and c-th column and attempts to make exactly K moves.
The rows and columns are 0 indexed, so the top-left square is (0, 0),
and the bottom-right square is (N-1, N-1).

A chess knight has 8 possible moves it can make, as illustrated below. Each move is two squares in a cardinal direction,
 then one square in an orthogonal direction.


Each time the knight is to move, it chooses one of eight possible moves uniformly at random
 (even if the piece would go off the chessboard) and moves there.

The knight continues moving until it has made exactly K moves or has moved off the chessboard.
Return the probability that the knight remains on the board after it has stopped moving.

Example:

Input: 3, 2, 0, 0
Output: 0.0625
Explanation: There are two moves (to (1,2), (2,1)) that will keep the knight on the board.
From each of those positions, there are also two moves that will keep the knight on the board.
The total probability the knight stays on the board is 0.0625.


Note:

N will be between 1 and 25.
K will be between 0 and 100.
The knight always initially starts on the board.

 */