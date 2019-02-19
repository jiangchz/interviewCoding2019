package graphs.bfs;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestInMatrix {
    public int kthSmallest(int[][] matrix, int k) {

        PriorityQueue<Node> toExplore = new PriorityQueue<Node>(2*k, new Comparator<Node>(){
            @Override
            public int compare(Node a, Node b) {
                return matrix[a.x][a.y] <= matrix[b.x][b.y] ? -1 : 1;
            }
        });

        toExplore.add(new Node(0, 0));
        int[][] visited = new int[matrix.length][matrix[0].length];

        for (int index = 0; index < k - 1; index++) {
            Node currentNode =  toExplore.poll();
            int currentX = currentNode.x;
            int currentY = currentNode.y;

            if (currentX  + 1 < matrix.length && visited[currentX + 1][currentY] == 0) {
                toExplore.add(new Node(currentX + 1, currentY));
                visited[currentX + 1][currentY] = 1;
            }

            if (currentY + 1 < matrix[0].length && visited[currentX][currentY + 1] == 0) {
                toExplore.add((new Node(currentX, currentY + 1)));
                visited[currentX][currentY + 1] = 1;
            }
        }
        return matrix[toExplore.peek().x][toExplore.peek().y];
    }

    private class Node {
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public int x;
        public int y;
    }
}
/*
做dfs的时候，只需要做到第K-1个元素就行了，返回min-heap root 节点
 */