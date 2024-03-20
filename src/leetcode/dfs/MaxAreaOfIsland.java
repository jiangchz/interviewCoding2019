package leetcode.dfs;

public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int max = 0;
        int[] directions = {-1, 0, 1, 0, -1};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid [i][j] != 0) {
                    max = Math.max(max, dfs(grid, directions, i, j));
                }

            }
        }
        return max;
    }

    private int dfs(int[][] grid, int[] directions, int x, int y) {
        int result = 1;
        grid[x][y] = 0;
        for (int i = 0; i < 4; i++) {
            int nextX = x + directions[i];
            int nextY = y + directions[i + 1];
            if (nextX < 0 || nextY < 0 || nextX >= grid.length || nextY >= grid[0].length) {
                continue;
            }
            if (grid[nextX][nextY] == 0) {
                continue;//bug forget to check whether need to search next direction
            }
            result += dfs(grid, directions, nextX, nextY);
        }
        return result;
    }
}
