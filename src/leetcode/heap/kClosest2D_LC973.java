package leetcode.heap;

import java.util.PriorityQueue;

public class kClosest2D_LC973 {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> pq = new PriorityQueue<>(k, (p1, p2) -> p2.value - p1.value);

        for (int[] current : points) {
            pq.offer(new Point(current[0], current[1]));

            if (pq.size() > k) {
                pq.poll();
            }
        }


        int[][] result = new int[k][2];

        while (k > 0) {
            Point current = pq.poll();
            result[--k][0] = current.x;
            result[k][1] = current.y;

        }
        return result;
    }


    private static class Point{
        public int x;
        public int y;
        public int value;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
            this.value = (x*x) +(y*y);
        }
    }
}
