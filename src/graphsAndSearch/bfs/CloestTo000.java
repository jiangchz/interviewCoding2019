package graphsAndSearch.bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class CloestTo000 {
    public List<Integer> closest(int[] a, int[] b, int[] c, int k) {

        int lengthA = a.length;
        int lengthB = b.length;
        int lengthC = c.length;
        List<Integer> result = new ArrayList<>();
        PriorityQueue<Node> nodes = new PriorityQueue<>(11, new Comparator<Node>(){
            @Override
            public int compare(Node node1, Node node2) {
                return node1.distance - node2.distance;
            }
        });

        nodes.offer(new Node(0, 0, 0, calculateDistance(a[0], b[0], c[0])));
        while (k-- > 1) {
            Node currentNode = nodes.poll();
            int currentX = currentNode.x;
            int currentY = currentNode.y;
            int currentZ = currentNode.z;
            if (currentX  + 1 < lengthA) {
                nodes.add(new Node(currentX + 1, currentY, currentZ, calculateDistance(a[currentX + 1],
                        b[currentY],
                        c[currentZ] )));
            }
            if (currentY  + 1 < lengthB) {
                nodes.add(new Node(currentX, currentY + 1, currentZ, calculateDistance(a[currentX],
                        b[currentY + 1],
                        c[currentZ] )));
            }

            if (currentZ  + 1 < lengthC) {
                nodes.add(new Node(currentX, currentY, currentZ + 1, calculateDistance(a[currentX],
                        b[currentY],
                        c[currentZ + 1] )));
            }
        }
        result.add(nodes.peek().x);
        result.add(nodes.peek().y);
        result.add(nodes.peek().z);
        return result;
    }
    private static int calculateDistance(int x, int y, int z){
        return x * x + y * y + z * z;
    }
    class Node {
        public int x;
        public int y;
        public int z;
        public int distance;
        public Node (int x, int y, int z, int distance) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.distance = distance;
        }
    }

    public List<Integer> closest2(int[] a, int[] b, int[] c, int k) {
        PriorityQueue<List<Integer>> minHeap = new PriorityQueue<>(11, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> list1, List<Integer> list2) {
                long d1 = distance(list1, a, b, c);
                long d2 = distance(list2, a, b, c);
                return (int)(d1 - d2);
            }
        });
        Set<List<Integer>> visited = new HashSet<>();

        List<Integer> current = Arrays.asList(0, 0, 0);
        visited.add(current);
        minHeap.offer(current);

        while (k-- > 0) {
            current = minHeap.poll();
            List<Integer> nextCandidate =
                    Arrays.asList(current.get(0) + 1, current.get(1), current.get(2));
            if (nextCandidate.get(0) < a.length && visited.add(nextCandidate)) {
                minHeap.offer(nextCandidate);
            }
            nextCandidate = Arrays.asList(current.get(0), current.get(1) + 1, current.get(2));
            if (nextCandidate.get(1) < b.length && visited.add(nextCandidate)) {
                minHeap.offer(nextCandidate);
            }
            nextCandidate = Arrays.asList(current.get(0), current.get(1), current.get(2) + 1);
            if (nextCandidate.get(2) < c.length && visited.add(nextCandidate)) {
                minHeap.offer(nextCandidate);
            }

        }
        current.set(0, a[current.get(0)]);
        current.set(1, a[current.get(1)]);
        current.set(2, a[current.get(2)]);
        return current;

    }
    private long distance(List<Integer> point, int[] a, int[] b, int[] c){
        long dis = 0;
        dis += a[point.get(0)] * a[point.get(0)];
        dis += b[point.get(1)] * b[point.get(1)];
        dis += c[point.get(2)] * c[point.get(2)];
        return dis;
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
