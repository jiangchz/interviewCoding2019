package graphsAndSearch.bfs;

import graphsAndSearch.TestTree;
import graphsAndSearch.TreeNode;

import java.util.LinkedList;

public class GetKeysInBinaryTreeLayerByLayer {
    public static void main(String[] args) {
        TestTree testTree = new TestTree();
        TreeNode root = testTree.getSampleTestTree();
        printKeysByLevel(root);
    }

    public static void printKeysByLevel(TreeNode root) {
        if (root == null) {
            return;
        }

        LinkedList<TreeNode> toExplore = new LinkedList<>();
        toExplore.add(root);
        int currentLevelSize = 1;
        while (!toExplore.isEmpty()) {
            TreeNode current = toExplore.removeFirst();
            System.out.print(current.key + " ");
            if(current.left != null) {
                toExplore.add(current.left);
            }
            if (current.right != null) {
                toExplore.add(current.right);
            }
            if (--currentLevelSize == 0) {
                currentLevelSize = toExplore.size();
                System.out.println();
            }
        }
    }
}
