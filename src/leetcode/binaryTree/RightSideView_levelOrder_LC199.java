package leetcode.binaryTree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RightSideView_levelOrder_LC199 {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList();
        }

        List<TreeNode> toVisit = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        toVisit.add(root);

        while(!toVisit.isEmpty()) {
            int size = toVisit.size();
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = toVisit.remove(0);

                if (i == 0) {
                    result.add(currentNode.val);
                }

                if (currentNode.right != null) {
                    toVisit.add(currentNode.right);
                }
                if (currentNode.left != null) {
                    toVisit.add(currentNode.left);
                }
            }
        }
        return result;
    }
}
