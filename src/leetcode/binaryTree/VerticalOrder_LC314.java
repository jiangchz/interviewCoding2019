package leetcode.binaryTree;

import java.util.*;
import java.util.stream.Collectors;

public class VerticalOrder_LC314 {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        Deque<TreeNode> nodes = new LinkedList<>();
        Deque<Integer> indexs = new LinkedList<>();
        Map<Integer, List<Integer>> indexToNumbers = new HashMap<>();

        nodes.add(root);
        indexs.add(0);

        while(!nodes.isEmpty()) {
            TreeNode current = nodes.removeFirst();
            int index = indexs.removeFirst();

            indexToNumbers.putIfAbsent(index, new LinkedList<>());
            indexToNumbers.get(index).add(current.key);

            if (current.left != null) {
                nodes.addLast(current.left);
                indexs.addLast(index - 1);
            }

            if (current.right != null) {
                nodes.addLast(current.right);
                indexs.addLast(index + 1);
            }
        }

        return indexToNumbers.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }
}