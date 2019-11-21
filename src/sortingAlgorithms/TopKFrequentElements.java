package sortingAlgorithms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numberFrequencyMapping = new HashMap<>();
        PriorityQueue<Node> maxHeap = new PriorityQueue<Node> (k, new Comparator<Node>() {
            @Override
            public int compare(Node node1, Node node2) {
                if (node1.times == node2.times) {
                    return node1.value - node2.value;
                }
                return node2.times - node1.times;
            }
        });

        countFrequency(nums, numberFrequencyMapping);
        storeNodesToHeap(numberFrequencyMapping, maxHeap);
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(maxHeap.poll().value);
        }
        return result;
    }

    private void countFrequency(int[] nums,
                                Map<Integer, Integer> numberFrequenceMapping) {
        for (int num : nums) {
            int times = 1;
            if (numberFrequenceMapping.containsKey(num)) {
                times = numberFrequenceMapping.get(num) + 1;
            }
            numberFrequenceMapping.put(num, times);
        }
    }
    private void storeNodesToHeap(Map<Integer, Integer> numberFrequenceMapping,
                                  PriorityQueue<Node> maxHeap) {
        for (int num : numberFrequenceMapping.keySet()) {
            Node current = new Node(num, numberFrequenceMapping.get(num));
            maxHeap.add(current);
        }
    }

    class Node {
        public int times;
        public int value;
        public Node (int value, int times) {
            this.times = times;
            this.value = value;
        }

    }
}
