package leetcode.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistanceFromAllBuildings_LC317 {
    private static int[] directions =  {-1, 0, 1, 0, -1};

    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;
        int[][] distance = new int[m][n]; //total distance to all buildings
        int[][] reach = new int[m][n];//total building able to reach
        int buildingCount = 0;

        Queue<int[]> buildings = new LinkedList<>();
        //Do BFS from each building to update totalDistance and number of building can reach
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    buildings.offer(new int[]{i, j});
                    bfs(buildings, grid, distance, reach);
                    buildingCount++;
                }
            }
        }

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // WARNING: DO NOT FORGET to check whether current point is 0 and whether current point can reach all buildings
                if (grid[i][j] == 0 && reach[i][j] == buildingCount) {
                    result = Math.min(result, distance[i][j]);
                }
            }
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }

    public void bfs(Queue<int[]> buildings, int[][] grid, int[][] distance, int[][] reach) {
        int level = 1;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        while(!buildings.isEmpty()) {
            int size = buildings.size();
            for (int i = 0; i < size; i++) {
                int[] currentPoint = buildings.poll();
                int x = currentPoint[0];
                int y = currentPoint[1];
                for (int j = 0; j < 4 ; j++) {
                    int nextX = x + directions[j];
                    int nextY = y + directions[j + 1];

                    if (nextX < 0 || nextY < 0 || nextX == m || nextY == n || grid[nextX][nextY] != 0 || visited[nextX][nextY]) {
                        continue;
                    }
                    buildings.offer(new int[] {nextX, nextY});
                    visited[nextX][nextY] = true;
                    distance[nextX][nextY] += level;
                    reach[nextX][nextY]++;
                }
            }
            level++;
        }
    }
}

/**
 * You are given an m x n grid grid of values 0, 1, or 2, where:
 *
 * each 0 marks an empty land that you can pass by freely,
 * each 1 marks a building that you cannot pass through, and
 * each 2 marks an obstacle that you cannot pass through.
 * You want to build a house on an empty land that reaches all buildings in the shortest total travel distance. You can only move up, down, left, and right.
 *
 * Return the shortest travel distance for such a house. If it is not possible to build such a house according to the above rules, return -1.
 *
 * The total travel distance is the sum of the distances between the houses of the friends and the meeting point.
 *
 * The distance is calculated using Manhattan Distance, where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: grid = [[1,0,2,0,1],[0,0,0,0,0],[0,0,1,0,0]]
 * Output: 7
 * Explanation: Given three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2).
 * The point (1,2) is an ideal empty land to build a house, as the total travel distance of 3+3+1=7 is minimal.
 * So return 7.
 * Example 2:
 *
 * Input: grid = [[1,0]]
 * Output: 1
 * Example 3:
 *
 * Input: grid = [[1]]
 * Output: -1
 */
