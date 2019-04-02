package graphsAndSearch.bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PlaceToPutChairI {
    public List<Integer> putChair(char[][] gym) {
        int M = gym.length;
        int N = gym[0].length;

        int[][] cost = new int[M][N];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (gym[i][j] == 'E') {
                    if (!addCost(cost, gym, i, j)) {
                        return Arrays.asList(-1, -1);
                    }
                }
            }
        }

        List<Integer> result = Arrays.asList(-1, -1);
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if(gym[i][j] != 'O' && gym[i][j] != 'E') {
                    if(result.get(0) == -1 || cost[i][j] < cost[result.get(0)][result.get(1)]) {
                        result.set(0, i);
                        result.set(1, j);
                    }
                }
            }
        }
        return result;
    }
    private boolean addCost(int[][] cost, char[][] gym, int i, int j) {
        boolean[][] visited = new boolean[gym.length][gym[0].length];
        int pathCost = 1;
        Queue<Pair> queue = new LinkedList<>();

        visited[i][j] = true;
        queue.offer(new Pair(i, j));
        while (queue.size() != 0) {
            int size = queue.size();
            for (int l = 0; l < size; l++) {
                Pair current = queue.poll();
                List<Pair> neighbers = getNeighbers(current, gym);
                for (Pair neighber: neighbers) {
                    if (!visited[neighber.i][neighber.j]) {
                        visited[neighber.i][neighber.j] = true;
                        cost[neighber.i][neighber.j] += pathCost;
                        queue.offer(neighber);
                    }
                }
            }
            pathCost++;
        }

        for (int l = 0; l < gym.length; l++) {
            for (int m = 0; m < gym[0].length; m++) {
                if (!visited[l][m] && gym[l][m] == 'E') {
                    return false;
                }
            }
        }
        return true;
    }

    private List<Pair> getNeighbers(Pair current, char[][] gym) {
        int x = current.i;
        int y = current.j;
        int M = gym.length;
        int N = gym[0].length;
        List<Pair> neighbors = new ArrayList<>();
        if (x + 1 < M && gym[x + 1][y] != 'O') {
            neighbors.add(new Pair(x + 1, y));
        }
        if (y + 1 < N && gym[x][y + 1] != 'O') {
            neighbors.add(new Pair(x, y + 1));
        }
        if (x - 1 >= 0 &&  gym[x - 1][y] != 'O') {
            neighbors.add(new Pair(x - 1, y));
        }

        if (y - 1 >= 0 &&  gym[x][y - 1] != 'O') {
            neighbors.add(new Pair(x, y - 1));
        }
        return neighbors;
    }
    static class Pair {
        int i;
        int j;

        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
