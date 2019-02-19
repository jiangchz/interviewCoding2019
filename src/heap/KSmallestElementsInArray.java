package heap;

public class KSmallestElementsInArray {
    public int[] findKSmallestElements(int[] numbers, int k) {
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

    public int[] findKSmallestElements2(int[] numbers, int k) {
        MaxHeap maxHeap = new MaxHeap(k);
        for (int num : numbers) {
            maxHeap.insert(num);
        }
        //return maxHeap.getHeap();
        return null;
    }
}
