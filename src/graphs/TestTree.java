package graphs;

import java.util.LinkedList;

public class TestTree {
    private TreeNode[] tree;

    public TreeNode getSampleTestTree() {
        int[] testArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13,14, 15, 16};
        return createTestTree(testArray);
    }
    public TreeNode createTestTree(int[] array) {
        tree = new TreeNode[array.length];
        for (int index = 0; index < array.length; index++) {
            tree[index] = new TreeNode(array[index]);
        }
        connectAllTreeNodes(0);
        return tree[0];
    }

    private void connectAllTreeNodes(int currentIndex) {
        LinkedList<Integer> toConnect = new LinkedList<Integer>() {
        };
        toConnect.add(currentIndex);
        while(!toConnect.isEmpty()) {
            connectTreeNodes(toConnect.removeFirst(), toConnect);
        }
    }
    private void connectTreeNodes(int currentIndex, LinkedList<Integer> toExplore) {
        if (currentIndex < 0) {
            return;
        }
        int leftChildIndex = getLeftChildIndex(currentIndex);
        if (leftChildIndex > 0) {
            tree[currentIndex].left = tree[leftChildIndex];
            toExplore.add(leftChildIndex);
        }

        int rightChildIndex = getRightChildIndex(currentIndex);
        if (rightChildIndex > 0) {
            tree[currentIndex].right = tree[rightChildIndex];
            toExplore.add(rightChildIndex);
        }
    }




    private int getLeftChildIndex(int currentIndex) {
        return currentIndex * 2 + 1 >= tree.length ? -1 : (currentIndex * 2 + 1);
    }
    private int getRightChildIndex(int currentIndex) {
        return currentIndex * 2 + 2 >= tree.length ? -1 : (currentIndex * 2 + 2);
    }
}