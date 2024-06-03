package leetcode.binaryTree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RightSideView_levelOrder_LC199 {
    public List<Integer> rightSideView_bfs(TreeNode root) {
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
                    result.add(currentNode.key);
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

    //DFS version
    public List<Integer> rightSideView2(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        rightView(root, result, 0);
        return result;
    }

    public void rightView(TreeNode curr, List<Integer> result, int currDepth){
        if(curr == null){
            return;
        }
        if(currDepth == result.size()){
            result.add(curr.key);
        }

        rightView(curr.right, result, currDepth + 1);
        rightView(curr.left, result, currDepth + 1);
    }
}
