package leetcode.binaryTree;

import java.util.HashMap;
import java.util.Map;

public class MaximumLevelSumofaBinaryTree_LC1161 {
        public int maxLevelSum(TreeNode root) {
            Map<Integer, Integer> levelSum = new HashMap<>();

            caculateSum(root, levelSum, 1);

            int max = levelSum.get(1);
            int maxLevel = 1;
            for (int key : levelSum.keySet()) {
                if (levelSum.get(key) > max) {
                    maxLevel = key;
                    max = levelSum.get(key);
                }
            }
            return maxLevel;
        }

        private void caculateSum(TreeNode current, Map<Integer, Integer> levelSum, int level) {
            if (current == null) {
                return;
            }

            int sum = levelSum.getOrDefault(level, 0);
            levelSum.put(level, sum + current.key);
            caculateSum(current.left, levelSum, level + 1);
            caculateSum(current.right, levelSum, level + 1);
        }

}

/**
 *
 * Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.
 *
 * Return the smallest level x such that the sum of all the values of nodes at level x is maximal.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,7,0,7,-8,null,null]
 * Output: 2
 * Explanation:
 * Level 1 sum = 1.
 * Level 2 sum = 7 + 0 = 7.
 * Level 3 sum = 7 + -8 = -1.
 * So we return the level with the maximum sum which is level 2.
 * Example 2:
 *
 * Input: root = [989,null,10250,98693,-89388,null,null,null,-32127]
 * Output: 2
 */