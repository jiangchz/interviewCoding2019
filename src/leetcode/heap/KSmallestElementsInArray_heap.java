package leetcode.heap;

import java.util.PriorityQueue;
import java.util.Random;

public class KSmallestElementsInArray_heap {
    public int[] findKSmallestElements_minHeap(int[] numbers, int k) {
       MinHeap minHeap = new MinHeap();
       for (int number : numbers) {
           minHeap.insert(number);
       }
       int[] result = new int[k];
       for (int index = 0; index < k; index++) {
           result[index] = minHeap.pop();
       }
       return result;
    }

    public int findKthLargest_minHeap(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k, (n1, n2) -> n1 - n2);
        for (int num : nums) {
            if (minHeap.size() == k) {
                if (minHeap.peek() > num) {
                    continue;
                }
                minHeap.poll();
                minHeap.add(num);
            } else {
                minHeap.add(num);
            }
        }
        return minHeap.peek();
    }
    int [] nums;
}