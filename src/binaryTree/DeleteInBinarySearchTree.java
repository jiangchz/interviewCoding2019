package binaryTree;


public class DeleteInBinarySearchTree {
    public TreeNode deleteTree(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.key < key) {
            root.right = deleteTree(root.right, key);
        } else if (root.key > key) {
            root.left = deleteTree(root.left, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                root.key = findSmallest(root.right);
                root.right = deleteTree(root.right, root.key);
            }
        }
        return root;
    }
    public int findSmallest(TreeNode root) {
        int minv = root.key;
        while (root.left != null) {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }
}
