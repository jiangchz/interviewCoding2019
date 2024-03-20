package leetcode.binaryTree;

import java.util.List;

public class TreeNode {
    public int key;
    public TreeNode left;
    public TreeNode right;
    public List<TreeNode> children;
    public TreeNode(int key) {
        this.key = key;
    }
}