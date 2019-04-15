package binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraveral {
    //顺着打印
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> bfsQueue = new LinkedList<>();
        bfsQueue.add(root);
        while (bfsQueue.size() != 0) {
            int size = bfsQueue.size();
            List<Integer> currentLevelNumbers = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode current = bfsQueue.remove();
                currentLevelNumbers.add(current.key);
                if (current.left != null) {
                    bfsQueue.add(current.left);
                }
                if (current.right != null) {
                    bfsQueue.add(current.right);
                }
            }
            result.add(currentLevelNumbers);
        }
        return result;
    }

    //倒着打印
    //刚递归到某一层的时候新建一个arraylist，然后把当前层的结果加到这个array list里面
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        levelOrderHelper(result, root, 0);
        return result;
    }

    private void levelOrderHelper(List<List<Integer>> result, TreeNode current, int level) {
        if (current == null) {
            return;
        }
        if (level == result.size()) {
            List<Integer> currentLevel = new ArrayList<>();
            result.add(0, currentLevel);
        }

        List<Integer> list = result.get(result.size() - level - 1);//*关键
        levelOrderHelper(result, current.left, level + 1);
        levelOrderHelper(result, current.right, level + 1);
        list.add(current.key);
    }
}
