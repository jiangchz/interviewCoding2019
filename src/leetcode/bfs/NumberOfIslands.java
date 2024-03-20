package leetcode.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int currentIsland = 0;
        final int[] diff = {-1, 0, 1, 0 , -1};
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    currentIsland++;
                    bfs(grid, diff, i, j);
                }
            }
        }
        return currentIsland;
    }
    private void bfs(char[][] grid, int[] diff, int x, int y) {
        Queue<Node> toExpand = new LinkedList<>();
        toExpand.add(new Node(x, y));
        while (toExpand.size() != 0) {
            Node currentNode = toExpand.remove();
            grid[currentNode.x][currentNode.y] = '0';
            for (int i = 0; i < 4; i++) {
                int nextX = currentNode.x + diff[i];
                int nextY = currentNode.y + diff[i + 1];
                if (nextX < 0 || nextX >= grid.length || nextY < 0 || nextY >= grid[0].length) {
                    continue;
                }
                if (grid[nextX][nextY] == '0') {
                    continue;
                }
                toExpand.add(new Node(nextX, nextY));
            }
        }

    }
    class Node {
        public int x;
        public int y;
        public Node (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
