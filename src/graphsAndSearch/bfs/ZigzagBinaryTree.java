package graphsAndSearch.bfs;

import binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class ZigzagBinaryTree {
    public List<Integer> zigZag(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> toExplore = new LinkedList<>();
        int currentLevel = 0;
        int currentLevelSize = 1;
        toExplore.add(root);
        while (toExplore.size() != 0) {
            TreeNode currentNode;
            if (currentLevel % 2 != 0) {
                currentNode = toExplore.removeLast();
                if (currentNode.left != null) {
                    toExplore.addFirst(currentNode.left);
                }
                if (currentNode.right != null) {
                    toExplore.addFirst(currentNode.right);
                }
            } else {
                currentNode = toExplore.removeFirst();
                if (currentNode.right != null) {
                    toExplore.addLast(currentNode.right);
                }
                if (currentNode.left != null) {
                    toExplore.addLast(currentNode.left);
                }
            }

            result.add(currentNode.key);
            currentLevelSize--;
            if (currentLevelSize == 0) {
                currentLevelSize = toExplore.size();
                currentLevel++;
            }
        }
        return result;
    }

    public List<Integer> zigZag1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> toExplore = new LinkedList<>();
        int currentLevel = 0;
        int currentLevelSize = 1;
        toExplore.add(root);
        while (toExplore.size() != 0) {
            TreeNode currentNode;
            if (currentLevel % 2 != 0) {
                currentNode = toExplore.removeLast();
                if (currentNode != null) {
                    toExplore.addFirst(currentNode.left);
                    toExplore.addFirst(currentNode.right);
                    result.add(currentNode.key);
                }
            } else {
                currentNode = toExplore.removeFirst();
                if (currentNode != null) {
                    toExplore.addLast(currentNode.right);
                    toExplore.addLast(currentNode.left);
                    result.add(currentNode.key);
                }
            }
            currentLevelSize--;
            if (currentLevelSize == 0) {
                currentLevelSize = toExplore.size();
                currentLevel++;
            }
        }
        return result;
    }
}

//method 1 : if current's child equal to null, not add the children node to exploring queue
//method 2: it's fine to have null in explore queue. do the explore when current is not equal to null
//key point: use current level size to mark when need to change current level. And use currentLevel % 2 to distinguish even and odd