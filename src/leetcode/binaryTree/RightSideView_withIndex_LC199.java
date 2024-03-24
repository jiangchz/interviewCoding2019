package leetcode.binaryTree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RightSideView_withIndex_LC199 {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList();
        }

        List<Integer> level = new ArrayList<>();
        List<TreeNode> toVisit = new ArrayList<>();
        Set<Integer> levelFilled = new HashSet<>();
        List<Integer> result = new ArrayList<>();

        level.add(0);
        toVisit.add(root);

        while(!toVisit.isEmpty()) {
            TreeNode currentNode = toVisit.remove(0);
            int currentLevel = level.remove(0);

            if (!levelFilled.contains(currentLevel)) {
                levelFilled.add(currentLevel);
                result.add(currentNode.key);
            }

            if (currentNode.right != null) {
                toVisit.add(currentNode.right);
                level.add(currentLevel + 1);
            }

            if (currentNode.left != null) {
                toVisit.add(currentNode.left);
                level.add(currentLevel + 1);
            }
        }
        return result;
    }
}
