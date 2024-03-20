package leetcode.bfs;

import leetcode.graphsAndSearch.TreeNode;
import leetcode.graphsAndSearch.TestTree;

import java.util.LinkedList;

public class IsCompleteBinaryTree {
    public static boolean isComplete(TreeNode root) {
        if (root == null) {
            return true;
        }
        LinkedList<TreeNode> toExplore = new LinkedList<>();
        toExplore.add(root);
        boolean foundBubble = false;
        while (!toExplore.isEmpty()) {
            TreeNode current = toExplore.removeFirst();

            if (foundBubble && (current.left != null || current.right != null)) {
                return false;
            } else if (current.left != null) {
                toExplore.add(current.left);
            } else  {
                foundBubble = true;
            }

            if (foundBubble && current.right != null) {
                return false;
            } else if (current.right == null) {
                foundBubble = true;
            } else {
                toExplore.add(current.right);
            }
        }
        return true;
    }

    public static void main(String args[]) {
        TestTree testTree = new TestTree();
        TreeNode testTreeNode = testTree.getSampleTestTree();
        testTreeNode.left = null;
        boolean result = isComplete(testTreeNode);
        System.out.println(result);
    }

}