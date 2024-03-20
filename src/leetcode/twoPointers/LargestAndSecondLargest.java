package leetcode.twoPointers;

import java.util.LinkedList;
import java.util.List;

public class LargestAndSecondLargest {
    public int[] largestAndSecond(int[] array) {
        Node maxNode = split(array, 0, array.length - 1);
        int[] results = new int[2];
        results[0] = maxNode.value;
        results[1] = findMax(maxNode.candidates);
        return results;
    }

    private Node split(int[] array, int start, int end) {
        if (start >= end) {
            return new Node(array[end]);
        } else if (start + 1 == end) {
            if (array[start] < array[end]) {
                return new Node(array[end], array[start]);
            } else {
                return new Node(array[start], array[end]);
            }
        }

        Node leftNode = split(array, start, start + (end - start) / 2);
        Node rightNode = split(array, start + (end - start) / 2 + 1, end);

        if (leftNode.value > rightNode.value) {
            leftNode.candidates.add(rightNode.value);
            return leftNode;
        } else {
            rightNode.candidates.add(leftNode.value);
            return rightNode;
        }

    }

    private static int findMax(List<Integer> candidates) {
        int max = Integer.MIN_VALUE;
        for (int current : candidates) {
            max = max > current ? max : current;
        }
        return max;
    }


    class Node {
        public int value;
        public LinkedList<Integer> candidates;

        public Node(int value) {
            this.value = value;
            this.candidates = new LinkedList<Integer>();//bug, if constructor not provide element for linkedlist,
            //we still need to initialize the linkedlist or will have NPE.
        }

        public Node(int value, int candidatesValue) {
            this.value = value;
            this.candidates = new LinkedList<Integer>();
            candidates.add(candidatesValue);
        }
    }
}
