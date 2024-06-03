package leetcode.dfs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MakingALargeIsland_LC827 {
    private static final int[] directions = {-1, 0, 1, 0, -1};

    public int largestIsland(int[][] grid) {
        //Step1: find all island by dfs
        int m = grid.length;
        int n = grid[0].length;
        int islandId = 1;  //islands id autoincrease from 1, -1 means water
        int[][] islandIds = new int[m][n];
        Map<Integer, Integer> islandSize = new HashMap<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (islandIds[i][j] != 0) {
                    continue;
                }
                if (grid[i][j] == 0) {
                    islandIds[i][j] = -1;
                } else {
                    dfs(grid, islandIds, i, j, islandId, islandSize);
                    islandId++;
                }
            }
        }

        //Step 2: check all the water location and connect the islands to see the size
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Set<Integer> addedIsland = new HashSet<>();
                if (grid[i][j] == 0) {

                    int combinedSize = 1;
                    for (int k = 0; k < 4; k++) {
                        int nextX = i + directions[k];
                        int nextY = j + directions[k + 1];

                        if (nextX < 0 || nextY < 0 || nextX == grid.length || nextY == grid[0].length) {
                            continue;
                        }
                        int currentIsland = islandIds[nextX][nextY];
                        if (grid[nextX][nextY] == 1 && !addedIsland.contains(currentIsland)) {
                            combinedSize += islandSize.get(currentIsland);
                            addedIsland.add(currentIsland);
                        }
                    }
                    res = Math.max(res, combinedSize);
                }
            }
        }
        return res == 0 ? m * n : res;
    }

    private void dfs(int[][] grid, int[][] islandIds, int x, int y, int islandId, Map<Integer, Integer> islandSize) {
        //islandIds -1 means water not need to expanding, islandId > 0 means already expanded
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || islandIds[x][y] != 0) {
            return;
        }

        if (grid[x][y] == 0 && islandIds[x][y] == 0) {
            islandIds[x][y] = -1;
            return;
        }

        //mark island with size 1
        islandSize.put(islandId, islandSize.getOrDefault(islandId, 0) + 1);
        islandIds[x][y] = islandId;
        for (int i = 0; i < 4; i++) {
            int nextX = x + directions[i];
            int nextY = y + directions[i + 1];
            dfs(grid, islandIds, nextX, nextY, islandId, islandSize);
        }
    }
}
