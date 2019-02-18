package heap;

import java.util.ArrayList;

public class MinHeap {
    private ArrayList<Integer> heap = new ArrayList<>();
    public void insert(int newValue) {
        heap.add(newValue);
        int currentIndex = heap.size() - 1;
        percolateUp(currentIndex);
    }

    public void update(int newValue, int index) {
        heap.set(index, newValue);
        percolateUp(index);
        percolateDown(index);
    }

    public int top() {
        if (heap.size() == 0) {
            return -1;
        }
        return heap.get(heap.size() - 1);
    }

    public int pop() {
        if(heap.size() == 0) {
            return -1;
        }
        int rootValue = heap.get(0);
        int lastNodeValue = heap.get(heap.size() - 1);
        if (rootValue != lastNodeValue) {
            heap.remove(heap.size() - 1);
            update(lastNodeValue, 0);
        }
        return rootValue;
    }

    private void percolateUp(int currentIndex) {
        int parentIndex = getParentIndex(currentIndex);
        while (parentIndex >= 0 && heap.get(currentIndex) < heap.get(parentIndex)) {
            swap(currentIndex, parentIndex);
            currentIndex = parentIndex;
            parentIndex = getParentIndex(currentIndex);
        }
    }

    private void percolateDown(int currentIndex) {
        int leftChildIndex = getLeftChildIndex(currentIndex);
        int rightChildIndex = getRightChildIndex(currentIndex);

        while (leftChildIndex > 0 && rightChildIndex > 0) {
          int currentVal = heap.get(currentIndex);
          int leftChildVal = heap.get(leftChildIndex);
          int rightChildVal = heap.get(rightChildIndex);
          if (currentVal < leftChildVal && currentVal < rightChildIndex) {
              return;
          }

          if (leftChildVal < rightChildVal) {
              swap(currentIndex, leftChildIndex);
              currentIndex = leftChildIndex;
          } else {
              swap(currentIndex, rightChildIndex);
              currentIndex = rightChildIndex;
          }
          leftChildIndex = getLeftChildIndex(currentIndex);
          rightChildIndex = getRightChildIndex(currentIndex);
        }

        if (leftChildIndex > 0 && heap.get(leftChildIndex) < heap.get(currentIndex)) {
            swap(currentIndex, leftChildIndex);
        }
    }

    private int getLeftChildIndex(int currentIndex) {
        return currentIndex * 2 + 1 >= heap.size() ? -1 : (currentIndex * 2 + 1);
    }
    private int getRightChildIndex(int currentIndex) {
        return currentIndex * 2 + 2 >= heap.size() ? -1 : (currentIndex * 2 + 2);
    }
    private static int getParentIndex(int currentIndex) {
        if (currentIndex == 0) {
            return -1;
        }
        return (currentIndex - 1) / 2;
    }
    private void swap(int swapFrom, int swapTo) {
        int tmp = heap.get(swapFrom);
        heap.set(swapFrom, heap.get(swapTo));
        heap.set(swapTo, tmp);
    }

    public static void main(String args[]) {
        MinHeap minHeap = new MinHeap();
        minHeap.insert(5);
        minHeap.insert(4);
        minHeap.insert(7);
        minHeap.insert(1);
        minHeap.insert(2);
        minHeap.insert(3);

        for (int num : minHeap.heap) {
            System.out.print(num + " ");
        }
        System.out.println();
        minHeap.update(8, 1);
        for (int num : minHeap.heap) {
            System.out.print(num + " ");
        }
        minHeap.update(9, 2);
        System.out.println();
        for (int num : minHeap.heap) {
            System.out.print(num + " ");
        }
        minHeap.update(-1, 5);
        System.out.println();
        for (int num : minHeap.heap) {
            System.out.print(num + " ");
        }
        System.out.println();
        System.out.println(minHeap.pop());
        System.out.println(minHeap.pop());
        System.out.println(minHeap.pop());
        System.out.println(minHeap.pop());
        System.out.println(minHeap.pop());
        System.out.println(minHeap.pop());
    }

}
