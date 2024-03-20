package leetcode.array;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKArray {
    public int[] merge(int[][] arrayOfArrays) {
        PriorityQueue<Index> minHeap = new PriorityQueue<>(arrayOfArrays.length, new Comparator<Index>() {
            @Override
            public int compare(Index index1, Index index2) {
                return arrayOfArrays[index1.x][index1.y] - arrayOfArrays[index2.x][index2.y];
            }
        });
        int length = 0;
        for (int i = 0; i < arrayOfArrays.length; i++) {
            length += arrayOfArrays[i].length;
            if (arrayOfArrays[i].length != 0) {
                minHeap.offer(new Index(i, 0));
            }
        }
        int[] result = new int[length];
        for (int i = 0; !minHeap.isEmpty(); i++) {
            Index current = minHeap.poll();
            result[i] = arrayOfArrays[current.x][current.y];
            if (current.y < arrayOfArrays[current.x].length - 1) {
                minHeap.offer(new Index(current.x, current.y + 1));
            }
        }
        return result;
    }
    class Index {
        public int x;
        public int y;
        public Index(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
