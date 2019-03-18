package binaryTree;

import java.util.HashMap;
import java.util.Map;

public class ReconstructBinaryTreeWithPreorderAndInorder {
    public TreeNode reconstruct(int[] inOrder, int[] preOrder) {
        Map<Integer, Integer> indexMap = getIndexMap(inOrder);
        return recursiveContruct(preOrder, indexMap, 0, inOrder.length - 1, 0, preOrder.length - 1);
    }

    private Map<Integer, Integer> getIndexMap(int[] inOrder) {
        HashMap<Integer, Integer> indexMap = new HashMap<>(inOrder.length);
        for (int i = 0; i < inOrder.length; i++) {
            indexMap.put(inOrder[i], i);
        }
        return indexMap;
    }

    private TreeNode recursiveContruct(int[] preOrder,
                                       Map<Integer, Integer> indexMap,
                                       int inLeft,
                                       int inRight,
                                       int preLeft,
                                       int preRight){
        if (inLeft > inRight) {
            return null;
        }
        TreeNode root = new TreeNode(preOrder[preLeft]);
        int rootIndex = indexMap.get(preOrder[preLeft]);

        root.left = recursiveContruct(preOrder, indexMap, inLeft, rootIndex - 1, preLeft + 1, preLeft + rootIndex - inLeft);
        root.right = recursiveContruct(preOrder, indexMap, rootIndex + 1, inRight, preLeft + rootIndex - inLeft + 1, preRight);
        return root;
    }
}
