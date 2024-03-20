package leetcode.binaryTree;

import java.util.*;

public class CountOfSmallerNumbersAfterSelf_LC315 {
    //Attempt1: using singular leetcode.stack, timeout
    public List<Integer> countSmaller1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<Integer>();
        }

        Deque<Integer> tempNums = new ArrayDeque<>();
        Deque<Integer> singularStack = new ArrayDeque<>();
        LinkedList<Integer> result = new LinkedList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            int currentVal = nums[i];
            while (!singularStack.isEmpty() && currentVal <= singularStack.peek()) {
                tempNums.push(singularStack.pop());
            }

            result.addFirst(singularStack.size());
            singularStack.push(currentVal);

            while (!tempNums.isEmpty()) {
                singularStack.push(tempNums.pop());
            }
        }
        return result;
    }

    /**
     * Binary search tree
     * key point1: use the property of binary tree. The left sub-tree value smaller than root
     * key point2: scan from the last number to the first to construct the tree and
     * calculate the result during the insert.
     * key point3: the node value may duplicated. introduce a duplicateCount concept
     * key point4: the termination condition of updating the tree is
     * the current node value == toInsertValue and duplicate count++
     * key point5: result = left child count from recursion + left count of duplicate termination node
     */

    public List<Integer> countSmaller(int[] nums) {
        Integer[] count = new Integer[nums.length];
        if (nums.length == 0) {
            return Arrays.asList(count);
        }
        Node root = new Node(nums[nums.length - 1]);
        for (int i = nums.length - 1; i >= 0; i--) {
            count[i] = insert(root, nums[i]);
        }
        return Arrays.asList(count);
    }

    private int insert(Node node, int toInsertNumber) {
        int sum = 0;
        while (node.value != toInsertNumber) {
            if (node.value > toInsertNumber) {
                if (node.left == null) {
                    node.left = new Node(toInsertNumber);
                }
                node.leftSum++;
                node = node.left;
            } else {
                sum += node.leftSum + node.duplicateCount;
                if (node.right == null) {
                    node.right = new Node(toInsertNumber);
                }
                node = node.right;
            }
        }
        node.duplicateCount++;
        return sum + node.leftSum;
    }

    private static class Node {
        int value;
        int leftSum;
        int duplicateCount;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }
}
