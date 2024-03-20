package leetcode.binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderZigzagTraveral {
    //迭代，按层遍历
    //方法1： 可以调换加入结果中insertion的方式，也可以用dequeue双向队列来addFirst， removeFirst之类的调换
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        if (root == null) {
            return results;
        }
        Queue<TreeNode> bfsQueue = new LinkedList<>();
        bfsQueue.add(root);
        int level = 0;
        while (bfsQueue.size() != 0) {
            level++;
            int size = bfsQueue.size();
            LinkedList<Integer> currentList = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode current = bfsQueue.remove();
                if (current.left != null) {
                    bfsQueue.add(current.left);
                }
                if (current.right != null) {
                    bfsQueue.add(current.right);
                }

                if (level % 2 == 1) {
                    currentList.addLast(current.key);
                } else {
                    currentList.addFirst(current.key);
                }
            }
            results.add(currentList);
        }
        return results;
    }


    //递归向下传，改变加入到当层result结果的顺序，即一层是从头开始加，下一层从尾巴开始加
    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        helper(root, result, 0);
        return result;
    }

    private void helper(TreeNode root, List<List<Integer>> result, int level) {
        if (root == null) {
            return;
        }
        if (result.size() <= level) {
            result.add(new ArrayList<Integer>());
        }
        List<Integer> currentLevel = result.get(level);

        if(level % 2 == 0) {
            currentLevel.add(root.key);
        } else {
            currentLevel.add(0, root.key);
        }

        helper(root.left, result, level + 1);
        helper(root.right, result, level + 1);
    }
}
