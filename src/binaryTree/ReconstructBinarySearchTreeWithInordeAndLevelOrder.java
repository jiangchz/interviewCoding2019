package binaryTree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ReconstructBinarySearchTreeWithInordeAndLevelOrder {
    public TreeNode reconstruct(int[] inOrder, int[] levelOrder) {
        Map<Integer, Integer> indexMap = getIndexMap(inOrder);
        List<Integer> level = new LinkedList<Integer>();
        for (int num: levelOrder) {
            level.add(num);
        }
        return recursiveConstruct(level, indexMap);
    }

    private TreeNode recursiveConstruct(List<Integer> level, Map<Integer, Integer> indexMap) {
        if (level.size() == 0) {
            return null;
        }
        TreeNode root = new TreeNode(level.remove(0));
        int rootIndex = indexMap.get(root.key);

        List<Integer> leftLevel = new LinkedList<>();
        List<Integer> rightLevel = new LinkedList<>();
        for (int num : level) {
            if (indexMap.get(num) < rootIndex) {
                leftLevel.add(num);
            } else if (indexMap.get(num) > rootIndex) {
                rightLevel.add(num);
            }
        }
        root.left = recursiveConstruct(leftLevel, indexMap);
        root.right = recursiveConstruct(rightLevel, indexMap);
        return root;
    }
    private Map<Integer, Integer> getIndexMap(int[] inOrder) {
        Map<Integer, Integer> indexMap = new HashMap<>(inOrder.length);
        for (int i = 0; i < inOrder.length; i++) {
            indexMap.put(inOrder[i], i);
        }
        return indexMap;
    }
}
