package leetcode.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathinBinaryMatrix_LC1091 {
    private static int[][] directions = new int[][] {{0,1},{0,-1},{1,0},{-1,0},{1,-1},{-1,1},{-1,-1},{1,1}};
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if (grid[0][0] == 1 || grid[m - 1][n - 1] == 1) {
            return -1;
        }

        int[][] distance = new int[m][n];
        distance[0][0] = 1;
        Queue<int[]> toVisit = new LinkedList<>();
        toVisit.add(new int[] {0, 0});
        int level = 2;

        while(!toVisit.isEmpty()) {
            int size = toVisit.size();
            while (size-- > 0) {
                int[] current = toVisit.poll();
                int x = current[0];
                int y = current[1];
                for (int i = 0; i < 8; i++) {
                    int nextX = current[0] + directions[i][0];
                    int nextY = current[1] + directions[i][1];
                    if (nextX < 0 || nextY < 0 || nextX == m || nextY == n || distance[nextX][nextY] != 0 || grid[nextX][nextY] == 1) {
                        continue;
                    }

                    if (x == m - 1 && y == n - 1) {
                        return level;
                    }

                    distance[nextX][nextY] = level;
                    toVisit.add(new int[]{nextX, nextY});
                }
            }
            level++;
        }
        return distance[m - 1][n - 1] == 0 ? -1 :  distance[m - 1][n - 1];
    }
}

/**
 * Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix. If there is no clear path, return -1.
 *
 * A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the bottom-right cell (i.e., (n - 1, n - 1)) such that:
 *
 * All the visited cells of the path are 0.
 * All the adjacent cells of the path are 8-directionally connected (i.e., they are different and they share an edge or a corner).
 * The length of a clear path is the number of visited cells of this path.
 */