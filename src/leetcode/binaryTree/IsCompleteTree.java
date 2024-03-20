package leetcode.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class IsCompleteTree {
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> bfsQueue = new LinkedList<>();
        bfsQueue.add(root);
        boolean ended = false;
        while (bfsQueue.size() != 0) {
            int size = bfsQueue.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = bfsQueue.remove();
                if (current == null) {
                    ended = true;
                } else {
                    if (ended) {
                        return false;
                    }
                    bfsQueue.add(current.left);
                    bfsQueue.add(current.right);
                }
            }
        }
        return true;
    }
}
