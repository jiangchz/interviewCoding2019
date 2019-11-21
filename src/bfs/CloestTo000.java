package bfs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class CloestTo000 {
    public List<Integer> closest(int[] a, int[] b, int[] c, int k) {
        PriorityQueue<List<Integer>> minHeap = new PriorityQueue<>(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> list1, List<Integer> list2) {
                return getDistance(list1, a, b, c) - getDistance(list2, a, b, c);
            }
        });
        Set<List<Integer>> visited = new HashSet<List<Integer>>();
        minHeap.add(Arrays.asList(0, 0, 0));

        while (minHeap.size() != 0 && k-- > 1) {
            List<Integer> current = minHeap.remove();
            visited.add(current);
            List<Integer> next = Arrays.asList(current.get(0) + 1, current.get(1), current.get(2));
            if (next.get(0) < a.length && visited.add(next)) {
                minHeap.offer(next);
            }

            next = Arrays.asList(current.get(0), current.get(1) + 1, current.get(2));
            if (next.get(1) < b.length && visited.add(next)) {
                minHeap.offer(next);
            }

            next = Arrays.asList(current.get(0), current.get(1), current.get(2) + 1);
            if (next.get(2) < c.length && visited.add(next)) {
                minHeap.offer(next);
            }
        }
        return Arrays.asList(a[minHeap.peek().get(0)],
                b[minHeap.peek().get(1)],
                c[minHeap.peek().get(2)]);
    }
    private int getDistance(List<Integer> list,int[] a, int[] b, int[] c) {
        return a[list.get(0)] * a[list.get(0)] + b[list.get(1)] * b[list.get(1)] + c[list.get(2)] * c[list.get(2)];
    }


    public static void main(String[] args) {
        CloestTo000 cloestTo000 = new CloestTo000();
        int[] a = {1,3,5};
        int[] b = {2,4,5};
        int[] c = {3,6};
        int k = 10;
        List<Integer> reuslt = cloestTo000.closest(a,b,c,k);
        for (int num : reuslt) {
            System.out.println(num);
        }
    }
}
